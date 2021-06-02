/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

import Usuarios.Profesor;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Ciclo {

    //atributos de la clase
    private ArrayList<Modulo> Asignaturas;
    private String nombre;
    private int plazas;

    //metodo constructor

    public Ciclo(ArrayList<Modulo> Asignaturas, String nombre, int plazas) {
        this.Asignaturas = Asignaturas;
        this.nombre = nombre;
        this.plazas = plazas;
    }
  

    //metodos getters
    public ArrayList<Modulo> getAsignaturas() {
        return Asignaturas;
    }

    public String getNombre() {
        return nombre;
    }


}
