/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

import Usuarios.Alumno;

/**
 *
 * @author abili
 */
public class Nota {
    
    //Atributos
    
    private Alumno alumno;
    private Modulo modulo;
    private int nota;
    
    //Constructor

    public Nota(Alumno alumno, Modulo modulo, int nota) {
        this.alumno = alumno;
        this.modulo = modulo;
        this.nota = nota;
    }
    
    //Metodos get

    public Alumno getAlumno() {
        return alumno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public int getNota() {
        return nota;
    }
    
    
    
}
