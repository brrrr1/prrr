package com.salesianostriana.dam.pruebaproyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.pruebaproyecto.model.Empleado;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.service.EmpleadoService;
import com.salesianostriana.dam.pruebaproyecto.service.UsuarioService;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService servicioUsuario;

	@Autowired
	private EmpleadoService servicioEmpleado;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/usuarios")
	public String controladorUsuarios(Model model) {
		model.addAttribute("listaUsuarios", servicioUsuario.findAll());
		return "admin/usuarios";
	}

	@GetMapping("/listaUsuarios")
	public String listarTodos(Model model) {
		model.addAttribute("listaUsuarios", servicioUsuario.findAll());
		return "admin/usuariosIndex";
	}

	@GetMapping("/uform")
	public String showFrom(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "admin/usuarioForm";
	}

	@PostMapping("/addUsuario")
	public String submit(@ModelAttribute("usuario") Usuario usuario, Model model) {
		boolean usernameExists = servicioUsuario.buscarUsername(usuario.getUsername());

		if (usernameExists) {
			return "usernameRepetido";
		} else {
			String encodedPassword = passwordEncoder.encode(usuario.getPassword());
			usuario.setPassword(encodedPassword);

			servicioUsuario.save(usuario);
			model.addAttribute("usuario", usuario);
			return "redirect:/admin/usuarios/listaUsuarios";
		}
	}

	@GetMapping("/editarUsuario/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		if (servicioUsuario.findById(id).isPresent()) {
			model.addAttribute("usuario", servicioUsuario.findById(id).get());
			return "admin/usuarioForm";
		} else {
			return "redirect:admin/usuarios/listaUsuarios";
		}

	}

	@PostMapping("/editarUsuario/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario u) {

		Usuario usuarioExistente = servicioUsuario.buscarPorId(u.getId());


		if (u.getPassword() == null || u.getPassword().isEmpty()) {
			u.setPassword(usuarioExistente.getPassword());
		} else {
			
			String encodedPassword = passwordEncoder.encode(u.getPassword());
			u.setPassword(encodedPassword);
		}


		servicioUsuario.save(u);


		if (u.isEsEmpleado()) {
			List<Empleado> listaIguales = servicioEmpleado.buscarPorNombreYApellido(u.getNombre(), u.getApellido());
			for (Empleado e : listaIguales) {
				e.setNombre(u.getNombre());
				e.setApellido(u.getApellido());
				e.setDni(u.getDni());
				u.setEmail(u.getNombre().toLowerCase()+"recio"+u.getApellido().toLowerCase()+"@mariscosrecio.es");
				u.setUsername(u.getNombre().toLowerCase()+"mrw");
				servicioEmpleado.edit(e);
				servicioUsuario.edit(u);
			}
		}

		return "redirect:/admin/usuarios/listaUsuarios";
	}

	@GetMapping("/borrarUsuario/{id}")
	public String borrar(@PathVariable("id") long id) {
		Usuario u = servicioUsuario.buscarPorId(id);
		if (u.isEsEmpleado()) {
			List<Empleado> listaIguales = servicioEmpleado.buscarPorNombreYApellido(u.getNombre(), u.getApellido());
			for (Empleado empleado : listaIguales) {
				servicioEmpleado.delete(empleado);
			}
		}
		servicioUsuario.deleteById(id);
		return "redirect:/admin/usuarios/listaUsuarios";
	}

	@GetMapping("/buscarUsuario")
	public String buscarUsuarioPorNombre(Model model, @RequestParam("busqueda") String busqueda) {
		model.addAttribute("listaUsuarios", servicioUsuario.buscarPorNombre(busqueda));
		return "admin/usuariosIndex";
	}

}
