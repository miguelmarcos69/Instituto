/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Ciclo {
    //atributos de la clase
    private ArrayList <Asignatura> Asignaturas;
    private int curso;
    private String nombre;
    private String nombre_instituto;
    private String tutor;

 

    
    
    
    //metodo constructor
    public Ciclo(ArrayList<Asignatura> Asignaturas, int curso, String nombre, String nombre_instituto) {
        this.Asignaturas = Asignaturas;
        this.curso = curso;
        this.nombre = nombre;
        this.nombre_instituto = nombre_instituto;
        this.tutor = tutor;
    }
    
            
    
    
    //metodos getters
       public ArrayList<Asignatura> getAsignaturas() {
        return Asignaturas;
    }

    public int getCurso() {
        return curso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre_instituto() {
        return nombre_instituto;
    }

    public String getTutor() {
        return tutor;
    }
    
}
