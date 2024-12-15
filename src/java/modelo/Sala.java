/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Sala {
    private String id_sala;
    private String nombre_sala;
    private String id_tipo;
    private String estado_sala;
    private boolean ocupada;

    public Sala(String id_sala, String nombre_sala, String id_tipo, String estado_sala) {
        this.id_sala = id_sala;
        this.nombre_sala = nombre_sala;
        this.id_tipo = id_tipo;
        this.estado_sala = estado_sala;
    }

    public Sala(String id_sala, String estado_sala) {
        this.id_sala = id_sala;
        this.estado_sala = estado_sala;
    }
    

    public Sala(){
    }



    public String getId_sala() {
        return id_sala;
    }

    public void setId_sala(String id_sala) {
        this.id_sala = id_sala;
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

    public String getEstado_sala() {
        return estado_sala;
    }

    public void setEstado_sala(String estado_sala) {
        this.estado_sala = estado_sala;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
