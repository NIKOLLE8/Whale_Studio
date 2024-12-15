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
import java.util.List;
import modelo.CRUD;
import modelo.Sala;

/**
 *
 * @author HP
 */
public class SalaDAO implements CRUD<Sala> {

    Connection conexion;

    //CONSTRUCTOR
    public SalaDAO() throws ClassNotFoundException {
        //SE CREA UN OBJETO CONEXION DEL paquete config
        Conexion cnx = new Conexion();
        //ESTABLECE UNA CONEXION A LA BD
        conexion = cnx.getConexion();
        //System.out.println("conexion procesada");
    }

    @Override
    public List<Sala> listar() {
        List<Sala> salas = new ArrayList<>();
        PreparedStatement ps;   //INSTRUCCION SQL
        ResultSet rs;           //CONJUNTO RESULTADOS
        try {
            // INSTRUCCIÓN DE CONSULTA
            ps = conexion.prepareStatement("SELECT id_sala, nombre_sala,id_tipo, estado_sala FROM salas");
            // EJECUTA CONSULTA Y RECIBE RESULTADOS
            rs = ps.executeQuery();
            // ALIMENTA LISTA
            while (rs.next()) {
                String id_sala = rs.getString("id_sala");
                String nombre_sala = rs.getString("nombre_sala");
                String id_tipo = rs.getString("id_tipo");
                String estado_sala = rs.getString("estado_sala");
                Sala salitas = new Sala(id_sala, nombre_sala, id_tipo, estado_sala);
                salitas.setOcupada(estado_sala.equalsIgnoreCase("Mantenimiento"));
                //AGREGA A LISTA
                salas.add(salitas);
            }
            return salas;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Sala mostrar(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertar(Sala x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(Sala x) {
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("UPDATE salas SET estado_sala=? WHERE id_sala=?");

            ps.setString(1, x.getEstado_sala());
            ps.setString(2, x.getId_sala());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean eliminar(Sala x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int Salas_Numero_Dashboard() {
        int count = 0; // Variable para contar las salas disponibles
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conexion.prepareStatement("SELECT estado_sala FROM salas");
            rs = ps.executeQuery();

            // Recorrer los resultados de la consulta
            while (rs.next()) {
                String estado_sala = rs.getString("estado_sala");
                if (estado_sala.equalsIgnoreCase("Disponible")) {
                    count++;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return count;
    }

    public List<Sala> buscarSalasDisponibles(String fecha, int horaInicio, int horaFin, String capacidad) {
        List<Sala> salasDisponibles = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            String query = "SELECT * FROM salas WHERE id_tipo = ? AND estado_sala = 'Disponible' AND id_sala NOT IN ("
                    + "SELECT id_sala FROM reserva WHERE id_fecha = ? AND ("
                    + "(hora_reserva BETWEEN ? AND ?) OR "
                    + "(hora_fin BETWEEN ? AND ?))"
                    + ")";
            ps = conexion.prepareStatement(query);
            ps.setString(1, capacidad); // Capacidad
            ps.setString(2, fecha); // Fecha
            ps.setInt(3, horaInicio); // Hora de inicio
            ps.setInt(4, horaFin); // Hora de fin
            ps.setInt(5, horaInicio); // Hora de inicio (segunda verificación)
            ps.setInt(6, horaFin); // Hora de fin (segunda verificación)
            rs = ps.executeQuery();
            System.out.println(ps); System.out.println(rs);
            while (rs.next()) {
                Sala sala = new Sala(rs.getString("id_sala"), rs.getString("nombre_sala"),
                        rs.getString("id_tipo"), rs.getString("estado_sala"));
                salasDisponibles.add(sala);
                System.out.println(sala);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return salasDisponibles;
    }

}
