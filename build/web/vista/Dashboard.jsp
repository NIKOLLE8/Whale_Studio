<%-- 
    Document   : Dashboard
    Created on : 3 dic. 2024, 17:31:46
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
                    <!-- Stats Cards -->
                    <div class="row g-4 mb-4 justify-content-center">
                        <div class="col-12 col-md-6 col-lg-6 d-flex justify-content-center">
                            <div class="stats-card stats-card-1">
                                <div class="d-flex justify-content-between align-items-justify">
                                    <div>
                                        <h6 class="text-muted mb-3">Reservas Totales </h6>
                                        <h3 class="mb-0">${total}</h3>
                                    </div>
                                    <div class="text-white">
                                        <i class="bi bi-calendar3"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-6 col-lg-6 d-flex justify-content-center">
                            <div class="stats-card stats-card-2">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <h6 class="text-muted mb-3">Salas disponibles</h6>
                                        <h3 class="mb-0">${salasDisponibles}/8</h3>
                                    </div>
                                    <div class="text-white">
                                        <i class="bi bi-ui-checks-grid"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Stats Cards -->
                    <div class="row g-4 mb-4 justify-content-center">
                        <div class="col-12 col-md-6 col-lg-6 d-flex justify-content-center">
                            <div class="stats-card stats-card-3">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <h6 class="text-muted mb-3">Reservas confirmadas</h6>
                                        <h3 class="mb-0">${totalConfirmadas}</h3>
                                    </div>
                                    <div class="text-white">
                                        <i class="bi bi-envelope-check-fill"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-6 col-lg-6 d-flex justify-content-center">
                            <div class="stats-card stats-card-4">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <h6 class="text-muted mb-3">Reservas pendientes</h6>
                                        <h3 class="mb-0">${totalPendientes}</h3>
                                    </div>
                                    <div class="text-white">
                                        <i class="bi bi-hourglass-split"></i>
                                    </div>
                                </div>
                            </div>
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