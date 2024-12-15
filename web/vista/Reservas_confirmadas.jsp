<%-- 
    Document   : Reservas_confirmadas
    Created on : 3 dic. 2024, 18:28:42
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
                    <!-- Solicitudes Confirmadas -->
                    <div id="solicitudes-confirmadas" class="card mb-4">
                        <div class="card-header">
                            <h3>Reservas confirmadas exitosamente</h3>
                            <span class="badge-counter" id="total-confirmadas">${totalConfirmadas}</span>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Cliente</th>
                                        <th>Sala</th>
                                        <th>Fecha</th>
                                        <th>Duración</th>
                                        <th>Inicio</th>
                                        <th>Fin</th>
                                        <th>  </th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="reserva" items="${ListaReserva}">
                                        <tr>
                                            <td>${reserva.id_reserva}</td>
                                            <td>${reserva.dni}</td>
                                            <td>${reserva.nombre_sala}</td>
                                            <td>${reserva.fecha_reserva}</td>
                                            <td>
                                               ${reserva.duracion_sala} ${reserva.duracion_sala == 1 ? "Hora" : "Horas"}
                                            </td>
                                            <td>${reserva.hora_reserva}:00 PM</td>
                                            <td>${reserva.hora_fin}:00 PM</td>
                                            <td><span class="badge bg-success">Confirmada</span></td>
                                            <td>
                                                <form action="ControladorDistribucion?accion=actualizar_confirmadas" method="post" autocomplete="off">
                                                    <input type="hidden" name="id_reserva" value="${reserva.id_reserva}">
                                                    <button class="btn btn-sm btn-success" name="action" value="atendido">Atendido</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${empty ListaReserva}">
                                        <tr>
                                            <td colspan="9" class="text-center">No hay reservas confirmadas.</td>
                                        </tr>
                                    </c:if>
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
