/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Conexion {

    //VARIABLES
    String pro = "jdbc:mysql://";
    String ip = "127.0.0.1";
    String pue = "3306";
    String bd = "whalestudio";
    String usu = "root";
    String cla = "";

    public Connection getConexion() {
        try {
            //ELABORA CADENA DE CONEXIÓN
            String cad = pro + ip + ":" + pue + "/" + bd;
            //ESTABLECE EL DRIVER A EMPLEAR
            Class.forName("com.mysql.jdbc.Driver");
            //Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/ttenrab", "root", "");
            //CREA OBJETO CONEXIÓN
            Connection cnx = DriverManager.getConnection(cad, usu, cla);
            System.out.println("Conexion OK");
            //RETORNA EL OBJETO CONEXIÓN
            return cnx;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Conexion NOk");
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
