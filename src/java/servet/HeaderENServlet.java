/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author HP
 */
@WebServlet(name = "HeaderENServlet", urlPatterns = {"/HeaderENServlet"})
public class HeaderENServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<header class='header-nav'>"
        + "<nav class='navbar navbar-expand-lg bg-body-tertiary contenedor-nav'>"
        + "<div class='container-fluid nav'>"
        + "<a class='navbar-brand logo' href='../index.html'>"
        + "<img src='../Imagenes/logonav.png' alt='Logo'>"
        + "</a>"
        + "<button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarNav' "
        + "aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>"
        + "<span class='navbar-toggler-icon'></span>"
        + "</button>"
        + "<div class='collapse navbar-collapse' id='navbarNav'>"
        + "<ul class='navbar-nav mx-auto mb-2 mb-lg-0'>"
        + "<li class='nav-item'>"
        + "    <select class=\"select-idioma\" id=\"idioma\" name=\"idioma\">\n"
        + "        <option value=\"Selecciona\">Select</option>\n"
        + "        <option value=\"esp\">Spanish</option>\n"
        + "        <option value=\"en\">English</option>\n"
        + "        <option value=\"zh\">Chinese</option>\n"
        + "    </select>\n"
        + "</li>"
        + "<li class='nav-item'><a class='nav-link' href='Nosotros.html'>About Us</a></li>" // "Nosotros" -> "About Us"
        + "<li class='nav-item'><a class='nav-link' href='../faces/vista/Salas.xhtml'>Our Halls</a></li>"  // "Nuestros salones" -> "Our Halls"
        + "<li class='nav-item'><a class='nav-link' href='../ControladorDistribucion?accion=reserva'>Reservations</a></li>"  // "Reservas" -> "Reservations"
        + "<li class='nav-item'><a class='nav-link' href='Politicas.html'>Policies</a></li>"  // "Políticas" -> "Policies"
        + "</ul>"
        + "<a class='user-icon' href='../ControladorDistribucion?accion=login'><i class='fas fa-user'></i></a>"
        + "</div></div></nav>"
        + "</header>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
