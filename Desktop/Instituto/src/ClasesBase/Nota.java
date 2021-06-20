/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

import Usuarios.Alumno;
import java.util.ArrayList;

/**
 *
 * @author abili
 */
public class Nota {

    //Atributos
    private String modulo;
    private int nota;

//Constructor
    public Nota(String modulo, int nota) {
        this.modulo = modulo;
        this.nota = nota;

    }
    //Metodos get


    public String getModulo() {
        return modulo;
    }

    public int getNota() {
        return nota;
    }

    public String toString() {
        return String.valueOf(nota);

    }
    
}
