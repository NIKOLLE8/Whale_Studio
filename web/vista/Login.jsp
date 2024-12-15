<%-- 
    Document   : Login
    Created on : 17 oct. 2024, 05:24:10
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="../Imagenes/logo_pagina.png">
        <title>Whale Studio</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link href="css/Login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <main>
            <section>
            <section class="login_section">
                <div class="login_info">
                    <div class="log1">
                        <br>
                        <br>
                        <i class="fa-solid fa-address-book"></i>
                        <br>
                        <br>
                        <h2>BIENVENIDO AL MUNDO DE LOS ESPEJOS</h2>
                        <hr>
                    </div>
                    <div class="regreso">
                    <a href="faces/index.xhtml" class="btnAtras"><i class="fa-solid fa-circle-arrow-left"></i></a>
                    </div>
                </div>

                <form id="loginFormulario" class="login_formulario" method="POST" action="php/Login_registro.php">
                    <h2>¡Accede a tu cuenta!</h2>
                    <div class="login_datos">
                        <label for="email">Correo electronico</label>
                        <input type="email" name="email" id="email" placeholder="FamilyVet@gmail.com" required>
                        <label for="contrasena">Contrasena<a href=""></a> </label>
                        <input type="password" name="contra" id="contrasena" placeholder="Ingresa tu contraseña" required>
                        <input type="submit" value="Ingresar" class="ingresarbtn">
                    </div>
                </form>
            </section>
        </main>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
