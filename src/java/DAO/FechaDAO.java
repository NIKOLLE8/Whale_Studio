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
import modelo.Fecha;

/**
 *
 * @author HP
 */
public class FechaDAO implements CRUD<Fecha> {

    Connection conexion;

    //CONSTRUCTOR
    public FechaDAO() throws ClassNotFoundException {
        //SE CREA UN OBJETO CONEXION DEL paquete config
        Conexion cnx = new Conexion();
        //ESTABLECE UNA CONEXION A LA BD
        conexion = cnx.getConexion();
        //System.out.println("conexion procesada");
    }

    @Override
    public List<Fecha> listar() {
        List<Fecha> fechas = new ArrayList<>();
        PreparedStatement ps;   //INSTRUCCION SQL
        ResultSet rs;           //CONJUNTO RESULTADOS
        try {
            // INSTRUCCIÓN DE CONSULTA
            ps = conexion.prepareStatement("SELECT id_fecha, fecha_reserva FROM fecha_reserva");
            // EJECUTA CONSULTA Y RECIBE RESULTADOS
            rs = ps.executeQuery();
            // ALIMENTA LISTA
            while (rs.next()) {
                String id_fecha = rs.getString("id_fecha");
                String fecha_reserva = rs.getString("fecha_reserva");
                Fecha fechitas = new Fecha(id_fecha, fecha_reserva);
                //AGREGA A LISTA
                fechas.add(fechitas);
            }
            return fechas;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Fecha mostrar(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String mostrarnombrefecha(String x) {
        String fechaNombre = null; // Variable para almacenar el nombre de la fecha
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Prepara la consulta
            ps = conexion.prepareStatement("SELECT fecha_reserva FROM fecha_reserva WHERE id_fecha = ?");
            ps.setString(1, x);

            // Ejecuta la consulta
            rs = ps.executeQuery();

            // Recupera el resultado
            if (rs.next()) {
                fechaNombre = rs.getString("fecha_reserva");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la fecha: " + e.toString());
        } finally {
            // Cierra recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.toString());
            }
        }

        return fechaNombre;
    }
    
    public String mostraridfecha(String x) {
        String fechaid = null; // Variable para almacenar el nombre de la fecha
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Prepara la consulta
            ps = conexion.prepareStatement("SELECT id_fecha FROM fecha_reserva WHERE fecha_reserva = ?");
            ps.setString(1, x);

            // Ejecuta la consulta
            rs = ps.executeQuery();

            // Recupera el resultado
            if (rs.next()) {
                fechaid = rs.getString("id_fecha");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la fecha: " + e.toString());
        } finally {
            // Cierra recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.toString());
            }
        }

        return fechaid;
    }

    @Override
    public boolean insertar(Fecha x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar(Fecha x) {

        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("UPDATE fecha_reserva SET fecha_reserva=? WHERE id_fecha=?");

            ps.setString(1, x.getFecha_reserva());
            ps.setString(2, x.getId_fecha());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean eliminar(Fecha x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
