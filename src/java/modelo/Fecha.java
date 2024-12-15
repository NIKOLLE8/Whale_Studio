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
public class Fecha {
    private String id_fecha;
    private String fecha_reserva;

    public Fecha(String id_fecha, String fecha_reserva) {
        this.id_fecha = id_fecha;
        this.fecha_reserva = fecha_reserva;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }


    public String getId_fecha() {
        return id_fecha;
    }

    public void setId_fecha(String id_fecha) {
        this.id_fecha = id_fecha;
    }

    
}
