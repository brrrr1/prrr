package snippet;

public class Snippet {
	<!DOCTYPE html>
	<html lang="es" xmlns:th="http://www.thymeleaf.org">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Mariscos Recio - Merch</title>
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
	        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	        crossorigin="anonymous"></script>
	    <link href="../../static/css/estiloTarjetas.css" th:href="@{/css/estiloTarjetas.css}" rel="stylesheet" />
	    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
	    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
	</head>
	
	<body>
	    <header th:replace="~{fragmentos/header::header}">
	        <!-- Navbar existente -->
	        <!-- Tu código de navbar actual -->
	    </header>
	
	    <div class="container-fluid py-4">
	        <div class="container">
	            <!-- Nuevo lugar para el formulario de búsqueda -->
	            <div class="row mb-4">
	                <div class="col-md-12">
	                    <form class="d-flex justify-content-center" action="/buscar" method="GET">
	                        <input class="form-control me-2" type="search" placeholder="Buscar por nombre" aria-label="Search"
	                            name="busqueda">
	                        <button class="btn btn-outline-danger" type="submit">Buscar</button>
	                    </form>
	                </div>
	            </div>
	
	            <div class="row">
	                <aside class="col-md-3">
	                    <!-- Aside para filtros -->
	                </aside>
	                <div class="col-md-9">
	                    <h1 class="text-center mb-5">Merchandising Oficial</h1>
	                    <div class="row">
	                        <div class="col-md-4" data-aos="flip-left" th:each="merch : ${listaMerch}">
	                            <div class="card mb-4">
	                                <div class="card-body">
	                                    <img th:src="${not (#strings.isEmpty(merch.foto))} ? ${merch.foto} : 'https://llerena.org/wp-content/uploads/2017/11/imagen-no-disponible.jpg'"
	                                        class="img-responsive icono-categoria card-img-top" alt="imagen" />
	                                    <h5 class="card-title" th:text="${merch.nombre}">Taza</h5>
	
	                                    <p class="card-text" th:if="${merch.descuento > 0.00}">
	                                        <span class="text-decoration-line-through"
	                                            th:text="${#numbers.formatDecimal(merch.precio, 1, 2) + ' €'}"></span>
	                                        <span th:text="${#numbers.formatDecimal(merch.precioFinal, 1, 2) + ' €'}"
	                                            class="text-danger"></span>
	                                        <br />
	                                        <span class="badge bg-success"
	                                            th:text="'Descuento: ' + ${#numbers.formatDecimal(merch.descuento, 1, 2) + ' %'}"></span>
	                                        <div class="alert alert-info mt-2" role="alert" th:if="${merch.descuento > 0.00}">
	                                            ¡Producto con descuento!
	                                        </div>
	                                    </p>
	
	                                    <p class="card-text" th:unless="${merch.descuento > 0.00}"
	                                        th:text="${#numbers.formatDecimal(merch.precio, 1, 2) + ' €'}">
	                                    </p>
	
	                                    <div class="d-flex justify-content-between align-items-start ">
	                                        <a href="#" th:href="@{/productoMerch/{id}(id=${merch.id})}">
	                                            <button class="btn btn-danger"><i class="bi bi-cart-plus"></i>
	                                                Comprar</button>
	                                        </a>
	                                        <p class="card-text" th:text="${merch.likes} +'❤️'"></p>
	                                    </div>
	
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <footer th:replace="~{fragmentos/footer::footer}">
	    </footer>
	
	    <script>
	        AOS.init();
	    </script>
	</body>
	
	</html>
	
}

