/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HP
 */
public class Login {
    
    private String correo_user;
    private String contraseña_user;
    private String id_user;

    public Login(String correo_user, String contraseña_user) {
        this.correo_user = correo_user;
        this.contraseña_user = contraseña_user;
    }

    public Login() {
    }
    

    public String getCorreo_user() {
        return correo_user;
    }

    public void setCorreo_user(String correo_user) {
        this.correo_user = correo_user;
    }

    public String getContraseña_user() {
        return contraseña_user;
    }

    public void setContraseña_user(String contraseña_user) {
        this.contraseña_user = contraseña_user;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    
    
}
