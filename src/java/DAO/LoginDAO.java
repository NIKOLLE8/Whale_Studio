/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Login;

/**
 *
 * @author HP
 */
public class LoginDAO {
    
    Connection conexion;
    
     public LoginDAO() throws ClassNotFoundException {
        //SE CREA UN OBJETO CONEXION DEL paquete config
        Conexion cnx = new Conexion();
        //ESTABLECE UNA CONEXION A LA BD
        conexion= cnx.getConexion();
        //System.out.println("conexion procesada");
    }

     public boolean verfificar_user(Login x) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Utilizamos un SELECT para verificar las credenciales del usuario
            ps = conexion.prepareStatement("SELECT * FROM login WHERE correo_user = ? AND contraseña_user = ?");

            ps.setString(1, x.getCorreo_user());
            ps.setString(2, x.getContraseña_user());

            // Ejecutamos la consulta
            rs = ps.executeQuery();

            // Si rs.next() devuelve true, significa que el usuario fue encontrado
            if (rs.next()) {
                return true; // Usuario encontrado
            } else {
                return false; // Usuario no encontrado
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false; // En caso de error
        } finally {
            try {
                if (rs != null) rs.close(); // Cerramos el ResultSet
                if (ps != null) ps.close(); // Cerramos el PreparedStatement
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.toString());
            }
        }
    }
}
