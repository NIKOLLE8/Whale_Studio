<%-- 
    Document   : Reservas_totales
    Created on : 3 dic. 2024, 18:29:21
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">
        <link href="css/dashboard.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <!-- Sidebar -->
                <nav id ="nav" class="col-md-3 col-lg-2 d-md-block sidebar collapse"> </nav>

                <!-- Main Content -->
                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 main-content">
                    <!-- Reservas Activas -->
                    <div id="reservas-activas" class="card mb-4">
                        <div class="card-header">
                            <h3>Reservas Totales</h3>
                            <span class="badge-counter" id="total">${total}</span>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Cliente</th>
                                        <th>Sala</th>
                                        <th>Tipo</th>
                                        <th>Fecha</th>
                                        <th>Duración</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="reserva" items="${ListaReserva}">
                                        <tr>
                                            <td>${reserva.id_reserva}</td>
                                            <td>${reserva.dni}</td>
                                            <td>${reserva.nombre_sala}</td>
                                            <td>${reserva.id_tipo}</td>
                                            <td>${reserva.fecha_reserva}</td>
                                            <td>${reserva.duracion_sala} ${reserva.duracion_sala == 1 ? "Hora" : "Horas"}</td>

                                            <!-- Definir la clase del badge según el estado de la reserva -->
                                            <td>
                                                <span class="badge 
                                                      ${reserva.estado_reserva == 'Atendido' ? 'bg-success' : 
                                                        reserva.estado_reserva == 'Pendiente' ? 'bg-danger' : 
                                                        reserva.estado_reserva == 'Confirmada' ? 'bg-warning' : ''}">
                                                          ${reserva.estado_reserva}
                                                      </span>
                                                </td>

                                                <!-- Mostrar el botón de eliminar solo si el estado de la reserva es "Atendido" -->
                                                <td>
                                                    <c:if test="${reserva.estado_reserva == 'Atendido'}">
                                                        <form action="ControladorDistribucion?accion=eliminar_reserva" method="post">
                                                            <input type="hidden" name="id_reserva" value="${reserva.id_reserva}">
                                                            <button class="btn btn-sm btn-danger" type="submit">Eliminar</button>
                                                        </form>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </main>
                </div>
            </div>

            <script>
                fetch('Nav_Dashboard')
                        .then(response => {
                            if (!response.ok)
                                throw new Error('Network response was not ok');
                            return response.text();
                        })
                        .then(data => {
                            document.getElementById('nav').innerHTML = data;
                        })
                        .catch(error => console.error('There was a problem with the fetch operation:', error));
            </script>


            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        </body>

    </html>