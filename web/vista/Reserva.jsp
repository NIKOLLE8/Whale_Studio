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
                    <form id="Reservacion" action="ControladorDistribucion?accion=actualizar_estado_sala" method="post" autocomplete="off">
                        <div class="form-section">
                            <label for="nombre">Nombre completo:</label>
                            <input type="text" id="nombre" name="nombre" required>

                            <label for="dni">DNI/CEE:</label>
                            <input type="text" id="dni" name="dni" required>

                            <label for="telefono">Teléfono:</label>
                            <input type="text" id="telefono" name="telefono" required>
                        </div>

                        <div class="form-section" method="post">
                            <label for="duracion">Duración de la sala:</label>
                            <select id="duracion" style="    width: 100%;
                                    padding: 10px;
                                    margin-bottom: 10px;
                                    border: 2px solid var(--color-morado-tono2);
                                    border-radius: 4px;
                                    box-sizing: border-box;
                                    transition: border-color 0.3s ease;" required>
                                <option value="">Selecciona</option>
                                <option value="1" id="1" name="1">1 hora</option>
                                <option value="2"id="2" name="3">2 horas</option>
                                <option value="3"id="2" name="3">3 horas</option>
                            </select>

                            <label for="capacidad">Capacidad de invitados:</label>
                            <select id="capacidad" style="    width: 100%;
                                    padding: 10px;
                                    margin-bottom: 10px;
                                    border: 2px solid var(--color-morado-tono2);
                                    border-radius: 4px;
                                    box-sizing: border-box;
                                    transition: border-color 0.3s ease;" required>
                                <option value="">Selecciona</option>
                                <option value="Group" id="Group" name="Group">Sala Group (1 a 6)</option>
                                <option value="Crew" id="Crew" name="Crew">Sala Crew (6 a 13)</option>
                            </select>


                            <label for="date">Fecha de la reserva:</label>
                            <select id="date" style="    width: 100%;
                                    padding: 10px;
                                    margin-bottom: 10px;
                                    border: 2px solid var(--color-morado-tono2);
                                    border-radius: 4px;
                                    box-sizing: border-box;
                                    transition: border-color 0.3s ease;" required>
                                <option value="">Selecciona</option>
                                <c:forEach var="fecha" items="${ListaFechas}">
                                    <option value="${fecha.id_fecha}" id="${fecha.id_fecha}" name="${fecha.id_fecha}">${fecha.fecha_reserva}</option>
                                </c:forEach>
                            </select>

                            <label for="time">Hora de la reserva:</label>
                            <select id="time" style="    width: 100%;
                                    padding: 10px;
                                    margin-bottom: 10px;
                                    border: 2px solid var(--color-morado-tono2);
                                    border-radius: 4px;
                                    box-sizing: border-box;
                                    transition: border-color 0.3s ease;" required>
                                <option value="">Selecciona</option>
                                <option value="1" id="1" name="1">1:00 PM</option>
                                <option value="2" id="2" name="2">2:00 PM</option>
                                <option value="3" id="3" name="3">3:00 PM</option>
                                <option value="4" id="4" name="4">4:00 PM</option>
                                <option value="5" id="5" name="5">5:00 PM</option>
                                <option value="6" id="6" name="6">6:00 PM</option>
                                <option value="7" id="7" name="7">7:00 PM</option>
                                <option value="8" id="8" name="8">8:00 PM</option>
                            </select>

                            <label for="sala">Seleccionar Sala:</label>
                            <select id="sala" style="    width: 100%;
                                    padding: 10px;
                                    margin-bottom: 10px;
                                    border: 2px solid var(--color-morado-tono2);
                                    border-radius: 4px;
                                    box-sizing: border-box;
                                    transition: border-color 0.3s ease;" required>
                                <option value="">Selecciona</option>
                            </select>

                            <input type="button" id="BuscarSala" value="Buscar sala">
                        </div>

                        <input type="submit" value="Enviar reserva">
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
            document.getElementById('BuscarSala').onclick = function () {
                const duracion = document.getElementById('duracion').value;
                const fecha = document.getElementById('date').value;
                const hora = document.getElementById('time').value;
                const capacidad = document.getElementById('capacidad').value;
                console.log(hora);

                if (duracion && fecha && hora && capacidad) {
                    // Si todos los campos están completos, redirige al controlador con los parámetros
                    const url = "ControladorDistribucion?accion=buscarsala&duracion=" + duracion + "&fecha=" + fecha + "&hora=" + hora + "&capacidad=" + capacidad;
                    window.location.href = url;
                } else {
                    alert("Por favor, completa todos los campos requeridos.");
                }
            };

        </script>




        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
