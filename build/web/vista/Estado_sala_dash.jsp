<%-- 
    Document   : Estado_sala_dash
    Created on : 3 dic. 2024, 17:48:27
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
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
                        <div class="row">
                            <!-- Estado de Sala 1 -->
                            <div class="col-md-6 mb-4">
                                <div class="card">
                                    <div class="card-header">
                                        Estado de Sala
                                    </div>
                                    <div class="card-body">
                                        <form id="cambiarEstadoSala1" action="ControladorDistribucion?accion=actualizar_estado_sala" method="post" autocomplete="off">
                                            <div class="mb-3">
                                                <label for="salaSelect1" class="form-label">Seleccionar Sala:</label>
                                                <select id="sala" name="sala" class="form-select" required>
                                                    <option value="">Selecciona</option>
                                                    <c:forEach var="salas" items="${ListaSalas}">
                                                        <option  id="${salas.id_sala}" value="${salas.id_sala}">${salas.nombre_sala}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="estadoSelect1" class="form-label">Cambiar Estado:</label>
                                                <select class="form-select" id="estadoSelect" name="estadoSelect" required>
                                                    <option value="">Selecciona</option>
                                                    <option value="Disponible">Disponible</option>
                                                    <option value="Mantenimiento">Mantenimiento</option>
                                                </select>
                                            </div>
                                            <button type="submit" class="btn btn-primary">Actualizar Estado</button>
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <!-- Estado de Sala 2: Cambiar Fecha -->
                            <div class="col-md-6 mb-4">
                                <div class="card">
                                    <div class="card-header">
                                        Cambiar Fecha
                                    </div>
                                    <div class="card-body">
                                        <form id="formCambiarFecha" action="ControladorDistribucion?accion=actualizar_fecha" method="post" autocomplete="off">
                                            <div class="mb-3">
                                                <label for="fechaCambiar" class="form-label">Seleccionar Fecha:</label>
                                                <select id="date" name="date" class="form-select" required>
                                                    <option value="">Selecciona</option>
                                                    <c:forEach var="fecha" items="${ListaFechas}">
                                                        <option value="${fecha.id_fecha}">${fecha.fecha_reserva}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label for="nuevaFecha" class="form-label">Seleccionar Nueva Fecha:</label>
                                                <input type="date" class="form-control" id="nuevaFecha" name="nuevaFecha">
                                            </div>
                                            <button type="submit" class="btn btn-primary">Cambiar Fecha</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="solicitudes-confirmadas" class="card mb-4">
                            <div class="card-header">
                                Configuracion de las salas
                            </div>
                            <div class="card-body">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Sala</th>
                                            <th>Tipo de Sala</th>
                                            <th>Estado</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="sala" items="${ListaSalas}">
                                            <tr>
                                                <td>${sala.id_sala}</td>
                                                <td>${sala.nombre_sala}</td>
                                                <td>Sala  ${sala.id_tipo}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${sala.estado_sala == 'Disponible'}">
                                                            <span class="badge bg-success">Disponible</span>
                                                        </c:when>
                                                        <c:when test="${sala.estado_sala == 'Mantenimiento'}">
                                                            <span class="badge bg-warning">Mantenimiento</span>
                                                        </c:when>
                                                    </c:choose>
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
</f:view>
