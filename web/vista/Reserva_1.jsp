<%-- 
    Document   : Reserva
    Created on : 16 oct. 2024, 01:36:51
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="Imagenes/logo_pagina.png">
        <title>Whale Studio</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link href="css/reservas.css" rel="stylesheet" type="text/css"/>
        <link href="css/header_footer.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <header class="header-nav">
            <nav class="navbar navbar-expand-lg bg-body-tertiary contenedor-nav">
                <div class="container-fluid nav">
                    <a class="navbar-brand logo" href="faces/index.xhtml">
                        <img src="Imagenes/logonav.png" alt="Logo">
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link" href="vista/Nosotros.html">Nosotros</a></li>
                            <li class="nav-item"><a class="nav-link" href="faces/vista/Salas.xhtml">Nuestros salones</a></li>
                            <li class="nav-item"><a class="nav-link" href="ControladorDistribucion?accion=reserva">Reservas</a></li>
                            <li class="nav-item"><a class="nav-link" href="vista/Politicas.html">Políticas</a></li>
                        </ul>
                        <a class="user-icon" href="ControladorDistribucion?accion=login"><i class="fas fa-user"></i></a>
                    </div>
                </div>
            </nav>
        </header>

        <main>
            <div class="EspacioFormularios">
                <div class="containerform">
                    <div class="tittle">
                        <h3>FORMULARIO DE RESERVA</h3>
                    </div>
                    <form id="Reservacion" method="post">
                        <div class="form-section">
                            <label for="nombre">Nombre completo:</label>
                            <input type="text" id="nombre" name="nombre" required>

                            <label for="dni">DNI/CEE:</label>
                            <input type="text" id="dni" name="dni" required>

                            <label for="telefono">Teléfono:</label>
                            <input type="text" id="telefono" name="telefono" required>
                        </div>

                        <div class="form-section">
                            <label for="duracion">Duración de la sala:</label>
                            <select id="duracion" style="width: 100%; padding: 10px; margin-bottom: 10px; border: 2px solid var(--color-morado-tono2); border-radius: 4px;" required>
                                <option value="${duracion}">${duracion} ${duracion == 1 ? 'Hora' : 'Horas'}</option> <!-- Condición para singular/plural -->
                            </select>

                            <label for="capacidad">Capacidad de invitados:</label>
                            <select id="capacidad" style="width: 100%; padding: 10px; margin-bottom: 10px; border: 2px solid var(--color-morado-tono2); border-radius: 4px;" required>
                                <option value="${capacidad}"> Sala ${capacidad} ${capacidad == 'Crew' ? ' (1 a 6)' : ' (6 a 13)'}</option> <!-- Condición para CREW/todo -->
                            </select>


                            <label for="date">Fecha de la reserva:</label>
                            <select id="fecha_id" style="width: 100%; padding: 10px; margin-bottom: 10px; border: 2px solid var(--color-morado-tono2); border-radius: 4px;" required>
                                <option value="${fecha_id}">${fecha_nombre}</option> <!-- Muestra solo la fecha -->
                            </select>

                            <label for="time">Hora de la reserva:</label>
                            <select id="horaInicio" style="width: 100%; padding: 10px; margin-bottom: 10px; border: 2px solid var(--color-morado-tono2); border-radius: 4px;" required>
                                <option value="${horaInicio}">${horaInicio}:00 PM</option> <!-- Muestra solo la hora -->
                            </select>

                            <label for="sala">Seleccionar Sala:</label>
                            <select id="sala" style="width: 100%;
                                    padding: 10px;
                                    margin-bottom: 10px;
                                    border: 2px solid var(--color-morado-tono2);
                                    border-radius: 4px;
                                    box-sizing: border-box;
                                    transition: border-color 0.3s ease;" required>
                                <option value="">Selecciona</option>
                                <c:forEach var="salad" items="${salasDisponibles}">
                                    <option value="${salad.id_sala}">${salad.nombre_sala}</option>
                                </c:forEach>
                            </select>

                            <input type="button" id="BuscarSala" value="Buscar otra sala">
                        </div>

                        <input type="submit" value="Enviar reserva" id="Reservar_reserva">
                    </form>
                </div>

                <div class="containersalas">
                    <div class="sala-layout" id="sala-layout">
                        <c:forEach var="sala" items="${ListaSalas}">
                            <div class="sala" data-id="${sala.id_sala}">🏢🎶<br>${sala.nombre_sala}</div>
                            </c:forEach>
                        <div class="recepcion"> <strong>Área de Recepción ✨🏠</strong></div>
                    </div>
                    <div class="legenda">
                        <div class="legenda-item">
                            <span>¡Indicaciones! -></span>
                        </div>
                        <div class="legenda-item">
                            <div class="legenda-border" style="background-color: white;"></div>
                            <span>Salas</span>
                        </div>
                        <div class="legenda-item">
                            <div class="legenda-border" style="background-color: #d4edda;"></div>
                            <span>Disponible</span>
                        </div>
                        <div class="legenda-item">
                            <div class="legenda-border" style="background-color: #f8d7da;"></div>
                            <span>Ocupada</span>
                        </div>
                    </div>
                </div>
        </main>

        <footer class="text-center py-3">
            <p>
                <i class="fas fa-map-marker-alt icon"></i> Dirección: Av. José Pardo 610, 2do piso, Miraflores
                <span class="divider d-none d-sm-inline">|</span>
                <br class="d-sm-none">
                <i class="fas fa-phone-alt icon"></i> Teléfono: (+51) 920503324
                <span class="divider d-none d-sm-inline">|</span>
                <br class="d-sm-none">
                <i class="fas fa-envelope icon"></i> Email: ReservaSalas@WhaleStudio.com
            </p>
            <p>&copy; 2024 Whale Studio. Todos los derechos reservados.</p>
        </footer>

        <script>
            // Array de todas las salas
            const listaSalas = [
            <c:forEach var="sala" items="${ListaSalas}">
                {
                    id: '${sala.id_sala}', // Identificador de la sala
                            nombre: '${sala.nombre_sala}' // Nombre de la sala
                },
            </c:forEach>
            ];

            // Array de salas disponibles
            const salasDisponibles = [
            <c:forEach var="salass" items="${salasDisponibles}">
            '${salass.id_sala}', // Solo el ID de las salas disponibles
            </c:forEach>
            ];

            // Generar un array final que combine las listas
            const salas = listaSalas.map(sala => ({
                    ...sala,
                    ocupada: !salasDisponibles.includes(sala.id) // Marca como ocupada si no está en la lista de disponibles
                }));

            console.log(salas); // Verifica que el array se está generando correctamente en la consola

            // Función para renderizar las salas en el layout
            function renderizarSalas() {
                document.querySelectorAll('.sala').forEach(salaDiv => {
                    const salaId = salaDiv.getAttribute('data-id');
                    const sala = salas.find(s => s.id === salaId);

                    salaDiv.classList.remove('ocupada', 'seleccionada');

                    if (sala) {
                        if (sala.ocupada) {
                            salaDiv.classList.add('ocupada'); // Rojo
                        } else {
                            salaDiv.classList.add('seleccionada'); // Verde
                        }
                    }
                });
            }

            // Llama a la función al cargar la página
            document.addEventListener('DOMContentLoaded', () => {
                renderizarSalas();
            });

            document.getElementById('Reservar_reserva').onclick = function () {
                const nombre = document.getElementById('nombre').value;
                const dni = document.getElementById('dni').value;
                const telefono = document.getElementById('telefono').value;
                const duracion = document.getElementById('duracion').value;
                const fecha_id = document.getElementById('fecha_id').value;
                const horaInicio = document.getElementById('horaInicio').value;
                const sala = document.getElementById('sala').value;

                if (duracion && fecha_id && horaInicio && nombre && dni && telefono && sala) {
                    // Construcción de la URL con todos los parámetros
                    const url =
                            "ControladorDistribucion?accion=reservarsala" +
                            "&duracion=" + encodeURIComponent(duracion) +
                            "&fecha_id=" + encodeURIComponent(fecha_id) +
                            "&horaInicio=" + encodeURIComponent(horaInicio) +
                            "&nombre=" + encodeURIComponent(nombre) +
                            "&dni=" + encodeURIComponent(dni) +
                            "&telefono=" + encodeURIComponent(telefono) +
                            "&sala=" + encodeURIComponent(sala);

                    // Redirige al controlador con la URL construida
                    window.location.href = url;
                } else {
                    alert("Por favor, completa todos los campos requeridos.");
                }
            };
            
            document.getElementById('BuscarSala').onclick = function () {
                    const url = "ControladorDistribucion?accion=reserva";
                    window.location.href = url;
            };
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
