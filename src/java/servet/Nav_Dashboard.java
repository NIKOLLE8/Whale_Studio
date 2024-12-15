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
@WebServlet(name = "Nav_Dashboard", urlPatterns = {"/Nav_Dashboard"})
public class Nav_Dashboard extends HttpServlet {

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
        response.getWriter().println("<nav>"
                + "<div class='sidebar-header'>"
                + "<h3><i class='bi bi-tools me-2'></i> Administrador </h3>"
                + "</div>"
                + "<div class='position-sticky'>"
                + "<ul class='nav nav-pills flex-column'>"
                + "<li class='nav-item'>"
                + "<a class='nav-link' href='ControladorDistribucion?accion=dashboard_e'>"
                + "<i class='bi bi-house-door'></i>"
                + "<span>Dashboard</span>"
                + "</a>"
                + "</li>"
                + "<li class='nav-item'>"
                + "<a class='nav-link ' href='ControladorDistribucion?accion=confirmadas'>"
                + "<i class='bi bi-envelope-check-fill'></i>"
                + "<span>Reservas Confirmadas</span>"
                + "</a>"
                + "</li>"
                + "<li class='nav-item'>"
                + "<a class='nav-link' href='ControladorDistribucion?accion=pendientes'>"
                + "<i class='bi bi-hourglass-split'></i>"
                + "<span>Reservas pendientes</span>"
                + "</a>"
                + "</li>"
                + "<li class='nav-item'>"
                + "<a class='nav-link' href='ControladorDistribucion?accion=totales'>"
                + "<i class='bi bi-calendar3'></i>"
                + "<span>Reservas Totales</span>"
                + "</a>"
                + "</li>"
                + "<li class='nav-item'>"
                + "<a class='nav-link' href='ControladorDistribucion?accion=salas_dashboard'>"
                + "<i class='bi bi-ui-checks-grid'></i>"
                + "<span>Configuraciones</span>"
                + "</a>"
                + "</li>"
                + "<li class='nav-item mt-auto'>"
                + "<a class='nav-link' href='ControladorDistribucion?accion=login'>"
                + "<i class='bi bi-box-arrow-right'></i>"
                + "<span>Cerrar sesión</span>"
                + "</a>"
                + "</li>"
                + "</ul>"
                + "</div>"
                + "</nav>");
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
