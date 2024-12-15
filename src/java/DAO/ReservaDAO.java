/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.CRUD;
import modelo.Reserva;
import modelo.Sala;

/**
 *
 * @author HP
 */
public class ReservaDAO implements CRUD<Reserva> {

    Connection conexion;

    //CONSTRUCTOR
    public ReservaDAO() throws ClassNotFoundException {
        //SE CREA UN OBJETO CONEXION DEL paquete config
        Conexion cnx = new Conexion();
        //ESTABLECE UNA CONEXION A LA BD
        conexion = cnx.getConexion();
        //System.out.println("conexion procesada");
    }

    @Override
    public List<Reserva> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Reserva> listarconfirmada() {
        List<Reserva> reservas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement("SELECT \n"
                    + "    r.id_reserva,\n"
                    + "    r.duracion_sala,\n"
                    + "    r.hora_reserva,\n"
                    + "    r.hora_fin,\n"
                    + "    f.fecha_reserva, -- Traemos la fecha desde la tabla fecha_reserva\n"
                    + "    s.nombre_sala,   -- Traemos el nombre de la sala desde la tabla sala\n"
                    + "    s.id_tipo,       -- Traemos el tipo de sala\n"
                    + "    r.dni,\n"
                    + "    r.estado_reserva\n"
                    + "FROM \n"
                    + "    reserva r\n"
                    + "INNER JOIN \n"
                    + "    fecha_reserva f ON r.id_fecha = f.id_fecha -- Relación con la tabla fecha_reserva\n"
                    + "INNER JOIN \n"
                    + "    salas s ON r.id_sala = s.id_sala -- Relación con la tabla sala\n"
                    + "WHERE \n"
                    + "    r.estado_reserva = 'Confirmada';"); // Filtro por estado_reserva
            rs = ps.executeQuery();
            // ALIMENTA LISTA
            while (rs.next()) {
                String id_reserva = rs.getString("id_reserva");
                int duracion_sala = rs.getInt("duracion_sala");
                int hora_reserva = rs.getInt("hora_reserva");
                int hora_fin = rs.getInt("hora_fin");
                Date fecha_reserva = rs.getDate("fecha_reserva");
                String nombre_sala = rs.getString("nombre_sala"); // Nombre de la sala
                String id_tipo = rs.getString("id_tipo"); // Tipo de sala
                int dni = rs.getInt("dni");
                String estado_reserva = rs.getString("estado_reserva");

                // Crea objeto Reserva (Asegúrate de que tu constructor soporte todos los campos)
                Reserva reservita = new Reserva(
                        id_reserva,
                        duracion_sala,
                        hora_reserva,
                        hora_fin,
                        fecha_reserva,
                        nombre_sala,
                        id_tipo,
                        dni,
                        estado_reserva
                );

                // Añade la reserva a la lista
                reservas.add(reservita);
            }
            return reservas;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<Reserva> listarpendientes() {
        List<Reserva> reservas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement("SELECT \n"
                    + "    r.id_reserva,\n"
                    + "    r.duracion_sala,\n"
                    + "    r.hora_reserva,\n"
                    + "    r.hora_fin,\n"
                    + "    r.telefono,\n"
                    + "    f.fecha_reserva, -- Traemos la fecha desde la tabla fecha_reserva\n"
                    + "    s.nombre_sala,   -- Traemos el nombre de la sala desde la tabla sala\n"
                    + "    s.id_tipo,       -- Traemos el tipo de sala\n"
                    + "    r.dni\n"
                    + "FROM \n"
                    + "    reserva r\n"
                    + "INNER JOIN \n"
                    + "    fecha_reserva f ON r.id_fecha = f.id_fecha -- Relación con la tabla fecha_reserva\n"
                    + "INNER JOIN \n"
                    + "    salas s ON r.id_sala = s.id_sala -- Relación con la tabla sala\n"
                    + "WHERE \n"
                    + "    r.estado_reserva = 'Pendiente';"); // Filtro por estado_reserva
            rs = ps.executeQuery();
            // ALIMENTA LISTA
            while (rs.next()) {
                String id_reserva = rs.getString("id_reserva");
                int duracion_sala = rs.getInt("duracion_sala");
                int telefono = rs.getInt("telefono");
                int hora_reserva = rs.getInt("hora_reserva");
                int hora_fin = rs.getInt("hora_fin");
                Date fecha_reserva = rs.getDate("fecha_reserva");
                String nombre_sala = rs.getString("nombre_sala"); // Nombre de la sala
                String id_tipo = rs.getString("id_tipo"); // Tipo de sala
                int dni = rs.getInt("dni");

                // Crea objeto Reserva (Asegúrate de que tu constructor soporte todos los campos)
                Reserva reservita = new Reserva(
                        id_reserva,
                        duracion_sala,
                        hora_reserva,
                        hora_fin,
                        fecha_reserva,
                        nombre_sala,
                        id_tipo,
                        dni,
                        telefono
                );

                // Añade la reserva a la lista
                reservas.add(reservita);
            }
            return reservas;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<Reserva> listartotales() {
        List<Reserva> reservas = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement("SELECT \n"
                    + "    r.id_reserva,\n"
                    + "    r.duracion_sala,\n"
                    + "    r.hora_reserva,\n"
                    + "    r.hora_fin,\n"
                    + "    f.fecha_reserva, -- Traemos la fecha desde la tabla fecha_reserva\n"
                    + "    s.nombre_sala,   -- Traemos el nombre de la sala desde la tabla sala\n"
                    + "    s.id_tipo,       -- Traemos el tipo de sala\n"
                    + "    r.dni,\n"
                    + "    r.estado_reserva\n"
                    + "FROM \n"
                    + "    reserva r\n"
                    + "INNER JOIN \n"
                    + "    fecha_reserva f ON r.id_fecha = f.id_fecha -- Relación con la tabla fecha_reserva\n"
                    + "INNER JOIN \n"
                    + "    salas s ON r.id_sala = s.id_sala -- Relación con la tabla sala\n;"); // Filtro por estado_reserva
            rs = ps.executeQuery();
            // ALIMENTA LISTA
            while (rs.next()) {
                String id_reserva = rs.getString("id_reserva");
                int duracion_sala = rs.getInt("duracion_sala");
                int hora_reserva = rs.getInt("hora_reserva");
                int hora_fin = rs.getInt("hora_fin");
                Date fecha_reserva = rs.getDate("fecha_reserva");
                String nombre_sala = rs.getString("nombre_sala"); // Nombre de la sala
                String id_tipo = rs.getString("id_tipo"); // Tipo de sala
                int dni = rs.getInt("dni");
                String estado_reserva = rs.getString("estado_reserva");

                // Crea objeto Reserva (Asegúrate de que tu constructor soporte todos los campos)
                Reserva reservita = new Reserva(
                        id_reserva,
                        duracion_sala,
                        hora_reserva,
                        hora_fin,
                        fecha_reserva,
                        nombre_sala,
                        id_tipo,
                        dni,
                        estado_reserva
                );

                // Añade la reserva a la lista
                reservas.add(reservita);
            }
            return reservas;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Reserva mostrar(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertar(Reserva x) {
        //VARIABLES OBJETO PARA BD
        PreparedStatement ps;   //INSTRUCCION SQL

        try {
            //INSTRUCCIÓN DE INSERCION CON PARAMETROS PARA CADA CAMPO
            ps = conexion.prepareStatement("INSERT INTO reserva (id_reserva, duracion_sala, hora_reserva, hora_fin, id_fecha, id_sala, user, dni, telefono, estado_reserva) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            //ASIGNA LOS PARAMETROS CON EL OBJETO RECIBIDO EN EL MÉTODO
            ps.setString(1, x.getId_reserva()); // id_reserva
            ps.setInt(2, x.getDuracion_sala()); // duracion_sala
            ps.setInt(3, x.getHora_reserva()); // hora_reserva
            ps.setInt(4, x.getHora_fin()); // hora_fin
            ps.setString(5, x.getId_fecha()); // id_fecha
            ps.setString(6, x.getId_sala()); // id_sala
            ps.setString(7, x.getUser()); // user
            ps.setInt(8, x.getDni()); // dni
            ps.setInt(9, x.getTelefono()); // telefono
            ps.setString(10, x.getEstado_reserva()); // estado_reserva
            
            //EJECUTA CONSULTA Y RECIBE RESULTADO
            ps.execute();
            //RETORNA VERDADERO
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            //RETORNA FALSO
            return false;
        }
    }

    @Override
    public boolean eliminar(Reserva x) {
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("DELETE FROM reserva WHERE id_reserva = ?");

            ps.setString(1, x.getId_reserva());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean modificar(Reserva x) {
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("UPDATE reserva SET estado_reserva = ? WHERE id_reserva = ?");

            ps.setString(1, x.getEstado_reserva());
            ps.setString(2, x.getId_reserva());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

}
