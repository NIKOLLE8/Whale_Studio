/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Reserva {
    private String id_reserva;
    private int duracion_sala;
    private int hora_reserva;
    private int hora_fin;
    private String id_fecha;
    private Date fecha_reserva;
    private String nombre_sala;
    private String id_sala;
    private String id_tipo;
    private String user;
    private int dni;
    private int telefono;
    private String estado_reserva;
    
   
    public Reserva(String id_reserva, String estado_reserva) {
        this.id_reserva = id_reserva;
        this.estado_reserva = estado_reserva;
    }

    public Reserva() {
    }

    public Reserva(String id_reserva, int duracion_sala, int hora_reserva, int hora_fin, String id_fecha, Date fecha_reserva, String nombre_sala, String id_sala, String id_tipo, String user, int dni, int telefono, String estado_reserva) {
        this.id_reserva = id_reserva;
        this.duracion_sala = duracion_sala;
        this.hora_reserva = hora_reserva;
        this.hora_fin = hora_fin;
        this.id_fecha = id_fecha;
        this.fecha_reserva = fecha_reserva;
        this.nombre_sala = nombre_sala;
        this.id_sala = id_sala;
        this.id_tipo = id_tipo;
        this.user = user;
        this.dni = dni;
        this.telefono = telefono;
        this.estado_reserva = estado_reserva;
    }

    public Reserva(String id_reserva, int duracion_sala, int hora_reserva, int hora_fin, String id_fecha, Date fecha_reserva, String nombre_sala, String id_sala, String user, int dni, int telefono, String estado_reserva) {
        this.id_reserva = id_reserva;
        this.duracion_sala = duracion_sala;
        this.hora_reserva = hora_reserva;
        this.hora_fin = hora_fin;
        this.id_fecha = id_fecha;
        this.fecha_reserva = fecha_reserva;
        this.nombre_sala = nombre_sala;
        this.id_sala = id_sala;
        this.user = user;
        this.dni = dni;
        this.telefono = telefono;
        this.estado_reserva = estado_reserva;
    }
    
    
    
        public Reserva(String id_reserva, int duracion_sala, int hora_reserva, int hora_fin, Date fecha_reserva, String nombre_sala, String id_tipo, int dni, int telefono) {
        this.id_reserva = id_reserva;
        this.duracion_sala = duracion_sala;
        this.hora_reserva = hora_reserva;
        this.hora_fin = hora_fin;
        this.fecha_reserva = fecha_reserva;
        this.nombre_sala = nombre_sala;
        this.id_tipo = id_tipo;
        this.dni = dni;
        this.telefono=telefono;
    }
    
    

    public Reserva(String id_reserva, int duracion_sala, int hora_reserva, int hora_fin, Date fecha_reserva, String nombre_sala, String id_tipo, int dni, String estado_reserva) {
        this.id_reserva = id_reserva;
        this.duracion_sala = duracion_sala;
        this.hora_reserva = hora_reserva;
        this.hora_fin = hora_fin;
        this.fecha_reserva = fecha_reserva;
        this.nombre_sala = nombre_sala;
        this.id_tipo = id_tipo;
        this.dni = dni;
        this.estado_reserva = estado_reserva;
    }

    public Reserva(String id_reserva, int duracion_sala, int hora_reserva, int hora_fin, String id_fecha, String id_sala, String user, int dni, int telefono, String estado_reserva) {
        this.id_reserva = id_reserva;
        this.duracion_sala = duracion_sala;
        this.hora_reserva = hora_reserva;
        this.hora_fin = hora_fin;
        this.id_fecha = id_fecha;
        this.id_sala = id_sala;
        this.user = user;
        this.dni = dni;
        this.telefono = telefono;
        this.estado_reserva = estado_reserva;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }

    public String getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(String id_tipo) {
        this.id_tipo = id_tipo;
    }
    
    

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getDuracion_sala() {
        return duracion_sala;
    }

    public void setDuracion_sala(int duracion_sala) {
        this.duracion_sala = duracion_sala;
    }

    public int getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(int hora_reserva) {
        this.hora_reserva = hora_reserva;
    }

    public int getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getId_fecha() {
        return id_fecha;
    }

    public void setId_fecha(String id_fecha) {
        this.id_fecha = id_fecha;
    }

    public String getId_sala() {
        return id_sala;
    }

    public void setId_sala(String id_sala) {
        this.id_sala = id_sala;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }
    
}
