/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Fecha;
import DAO.FechaDAO;
import DAO.LoginDAO;
import DAO.ReservaDAO;
import modelo.Sala;
import DAO.SalaDAO;
import java.util.Random;
import modelo.Login;
import modelo.Reserva;

/**
 *
 * @author HP
 */
@WebServlet(name = "ControladorDistribucion", urlPatterns = {"/ControladorDistribucion"})
public class ControladorDistribucion extends HttpServlet {

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
        /* response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDistribucion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDistribucion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
        //processRequest(request, response);

        try {
            FechaDAO fecha = new FechaDAO();
            SalaDAO sala = new SalaDAO();
            ReservaDAO reserva = new ReservaDAO();
            LoginDAO login = new LoginDAO();
            String accion = request.getParameter("accion");
            RequestDispatcher rd = null;  // Asegúrate de que rd se inicializa correctamente.

            if (accion == null) {
                accion = "default";  // Si no se pasa ningún parámetro de acción, redirige al default
            }

            switch (accion) {
                case "reserva" -> {
                    List<Fecha> ListaFechas = fecha.listar();
                    request.setAttribute("ListaFechas", ListaFechas);
                    List<Sala> ListaSalas = sala.listar();
                    request.setAttribute("ListaSalas", ListaSalas);
                    rd = request.getRequestDispatcher("vista/Reserva.jsp");
                }
                case "buscarsala" -> {
                    int duracion = Integer.parseInt(request.getParameter("duracion"));
                    String fechitaa = request.getParameter("fecha");
                    int hora = Integer.parseInt(request.getParameter("hora"));
                    String capacidad = request.getParameter("capacidad");

                    int horaFin = calculateEndTime(hora, duracion);

                    SalaDAO salaDAO = new SalaDAO();
                    List<Sala> salasDisponibles = salaDAO.buscarSalasDisponibles(fechitaa, hora, horaFin, capacidad);

                    List<Sala> ListaSalas = sala.listar();
                    request.setAttribute("ListaSalas", ListaSalas);

                    String fecha_nombre = fecha.mostrarnombrefecha(fechitaa);
                    String fecha_id = fecha.mostraridfecha(fecha_nombre);

                    request.setAttribute("fecha_nombre", fecha_nombre);
                    request.setAttribute("fecha_id", fecha_id);
                    request.setAttribute("duracion", duracion);
                    request.setAttribute("horaInicio", hora);
                    request.setAttribute("capacidad", capacidad);
                    request.setAttribute("salasDisponibles", salasDisponibles);
                    rd = request.getRequestDispatcher("vista/Reserva_1.jsp");
                    rd.forward(request, response);

                }
                case "reservarsala" -> {
                    int duracion_sala = Integer.parseInt(request.getParameter("duracion"));
                    String id_fecha = request.getParameter("fecha_id");
                    int hora_reserva = Integer.parseInt(request.getParameter("horaInicio"));
                    String user = request.getParameter("nombre");
                    int dni = Integer.parseInt(request.getParameter("dni"));
                    int telefono = Integer.parseInt(request.getParameter("telefono"));
                    String id_sala = request.getParameter("sala");

                    int hora_fin = calculateEndTime(hora_reserva, duracion_sala);
                    String estado_reserva = "Pendiente";
                    String id_reserva = generarIdReserva();

                    Reserva nuevaReserva = new Reserva(id_reserva, duracion_sala, hora_reserva, hora_fin, id_fecha, id_sala, user, dni, telefono, estado_reserva);

                    boolean registro_reserva = reserva.insertar(nuevaReserva);
                    System.out.println(registro_reserva);
                    if (registro_reserva) {
                        // Redirigir al navegador a la página de confirmación
                        response.sendRedirect("vista/Politica.html");
                    } else {
                        // Si no se pudo registrar, redirigir a una página de error (opcional)
                        response.sendRedirect("error.jsp");
                    }

                }
                case "salas_dashboard" -> {
                    List<Fecha> ListaFechas = fecha.listar();
                    request.setAttribute("ListaFechas", ListaFechas);
                    List<Sala> ListaSalas = sala.listar();
                    request.setAttribute("ListaSalas", ListaSalas);
                    rd = request.getRequestDispatcher("vista/Estado_sala_dash.jsp");
                }
                case "dashboard_e" -> {
                    List<Sala> ListaSalas = sala.listar();
                    int salasDisponibles = sala.Salas_Numero_Dashboard();
                    request.setAttribute("salasDisponibles", salasDisponibles);
                    List<Reserva> ListaReserva = reserva.listarconfirmada();
                    int totalConfirmadas = ListaReserva.size();
                    request.setAttribute("totalConfirmadas", totalConfirmadas);
                    List<Reserva> ListaReservaT = reserva.listartotales();
                    int total = ListaReservaT.size();
                    request.setAttribute("total", total);
                    List<Reserva> ListaReservaP = reserva.listarpendientes();
                    int totalPendientes = ListaReservaP.size();
                    request.setAttribute("totalPendientes", totalPendientes);

                    rd = request.getRequestDispatcher("vista/Dashboard.jsp");
                }
                case "confirmadas" -> {
                    // Listar las reservas confirmadas
                    List<Reserva> ListaReserva = reserva.listarconfirmada();
                    int totalConfirmadas = ListaReserva.size();
                    request.setAttribute("totalConfirmadas", totalConfirmadas);
                    request.setAttribute("ListaReserva", ListaReserva);
                    rd = request.getRequestDispatcher("vista/Reservas_confirmadas.jsp");
                }
                case "actualizar_confirmadas" -> {
                    // Obtener el id_reserva desde el formulario
                    String id_reserva = request.getParameter("id_reserva");
                    // Crear una nueva reserva con el estado "Atendido"
                    Reserva reservaatentida = new Reserva(id_reserva, "Atendido");
                    // Modificar el estado de la reserva
                    boolean actualizado = reserva.modificar(reservaatentida);
                    if (actualizado) {
                        // Redirigir al usuario a la lista de reservas confirmadas con la acción correspondiente
                        response.sendRedirect("ControladorDistribucion?accion=confirmadas");
                    }
                }
                case "actualizar_pendientes" -> {
                    // Obtener el id_reserva desde el formulario
                    String id_reserva = request.getParameter("id_reserva");
                    // Crear una nueva reserva con el estado "Atendido"
                    Reserva reservaatentida = new Reserva(id_reserva, "Confirmada");
                    // Modificar el estado de la reserva
                    boolean actualizado = reserva.modificar(reservaatentida);
                    if (actualizado) {
                        // Redirigir al usuario a la lista de reservas confirmadas con la acción correspondiente
                        response.sendRedirect("ControladorDistribucion?accion=pendientes");
                    }
                }
                case "eliminar_reserva" -> {

                    String id_reserva = request.getParameter("id_reserva");

                    Reserva reserva_eliminar = new Reserva();
                    reserva_eliminar.setId_reserva(id_reserva); // Asumiendo que id_reserva es un String

                    // Llamar al método eliminar de ReservaDAO
                    ReservaDAO reservaDAO = new ReservaDAO();
                    boolean eliminado = reservaDAO.eliminar(reserva_eliminar);

                    // Redirigir según el resultado de la eliminación
                    if (eliminado) {
                        response.sendRedirect("ControladorDistribucion?accion=totales");
                    }
                }
                case "pendientes" -> {
                    List<Reserva> ListaReserva = reserva.listarpendientes();
                    int totalpendientes = ListaReserva.size();
                    request.setAttribute("totalpendientes", totalpendientes);
                    request.setAttribute("ListaReserva", ListaReserva);
                    rd = request.getRequestDispatcher("vista/Reservas_pendientes.jsp");
                }
                case "totales" -> {
                    // Listar las reservas confirmadas
                    List<Reserva> ListaReserva = reserva.listartotales();
                    int total = ListaReserva.size();
                    request.setAttribute("total", total);
                    request.setAttribute("ListaReserva", ListaReserva);

                    rd = request.getRequestDispatcher("vista/Reservas_totales.jsp");
                }
                case "actualizar_estado_sala" -> {
                    String id_sala = request.getParameter("sala");
                    String estado_sala = request.getParameter("estadoSelect");

                    Sala salitas = new Sala(id_sala, estado_sala);

                    // Actualizar el estado de la sala
                    boolean actualizado = sala.modificar(salitas);

                    if (actualizado) {
                        // Redirigir al controlador con la acción de salas_dashboard
                        response.sendRedirect("ControladorDistribucion?accion=salas_dashboard");
                    }
                }
                case "actualizar_fecha" -> {
                    String id_fecha = request.getParameter("date");
                    String fecha_nueva = request.getParameter("nuevaFecha");

                    Fecha fechitas = new Fecha(id_fecha, fecha_nueva);

                    // Actualizar el estado de la sala
                    boolean actualizado = fecha.modificar(fechitas);

                    if (actualizado) {
                        response.sendRedirect("ControladorDistribucion?accion=salas_dashboard");
                    }
                }
                case "login" -> {
                    rd = request.getRequestDispatcher("faces/vista/Loginlogin.xhtml");
                }
                case "verificar_login" -> {

                    String correo = request.getParameter("email");
                    String contrasena = request.getParameter("contra");
                    System.out.println(correo);
                    System.out.println(contrasena);

                    Login loginsito = new Login(correo, contrasena);

                    boolean usuario = login.verfificar_user(loginsito);
                    System.out.println(usuario);

                    if (usuario) {
                        // Redirigir al controlador con la acción de salas_dashboard
                        rd = request.getRequestDispatcher("/ControladorDistribucion?accion=dashboard_e");
                    } else {
                        rd = request.getRequestDispatcher("faces/vista/Loginlogin.xhtml");
                    }
                }
                default -> {
                    rd = request.getRequestDispatcher("../index.xhtml");
                }
            }

            // Verifica si el RequestDispatcher es nulo antes de llamar a forward()
            if (rd != null) {
                rd.forward(request, response);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorDistribucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //login, creacionde usuario
    //reserva, salas
    //dashboard
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
        doGet(request, response);
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

    private int calculateEndTime(int startHour, int duration) {
        int endHour = (startHour + duration) % 24; // Ajuste para horas mayores a 24
        return endHour;
    }

    private String generarIdReserva() {
        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder idReserva = new StringBuilder();

        // Genera un id de 5 caracteres
        for (int i = 0; i < 5; i++) {
            int indiceAleatorio = random.nextInt(caracteresPermitidos.length());
            char caracterAleatorio = caracteresPermitidos.charAt(indiceAleatorio);
            idReserva.append(caracterAleatorio);
        }

        return idReserva.toString();
    }

}
