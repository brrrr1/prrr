package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pruebaproyecto.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class PedidoControlador {

	@Autowired
	private EmpleadoService servicioEmpleado;

	@GetMapping("/lista")
	public String controladorPedidos(Model model) {
		model.addAttribute("listaPedidos", servicioEmpleado.findAll());
		return "prueba";
	}

}
