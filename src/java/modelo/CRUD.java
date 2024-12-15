/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author HP
 * @param <T>
 */
public interface CRUD <T>{
    public List<T> listar(); 

    public T mostrar(int x);

    public boolean insertar(T x);

    public boolean modificar(T x);

    public boolean eliminar(T x); 
}
