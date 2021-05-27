/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

/**
 *
 * @author alumno
 */
public class Inventario {
   //atributos de la clase
    private String nombre;
    private int cantidad;
    
    
    
    
    
    //metodo constructor
    public Inventario(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    
    
    
    
    //metodos getters
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
}
