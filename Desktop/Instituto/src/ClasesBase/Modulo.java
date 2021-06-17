/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Modulo {
    //atributos de la clase

    private String nombre;
    private String codigo_aula;
    private int horas_semana;
    private ArrayList<Evento> calendario;

    //metodo constuctor
    public Modulo(String nombre, String codigo_aula, int horas_semana) {
        this.nombre = nombre;
        this.codigo_aula = codigo_aula;
        this.horas_semana = horas_semana;
        calendario=new ArrayList();
    
    }
    
    
    public Modulo(String nombre, String codigo_aula, int horas_semana,ArrayList<Evento> calendario) {
        this.nombre = nombre;
        this.codigo_aula = codigo_aula;
        this.horas_semana = horas_semana;
        this.calendario=calendario;
    }
    
    public void annnadirEvento (Evento anadir){
    
        calendario.add(anadir);
    }
    
    public void eliminarEvento (int posicion){
    
        calendario.remove(posicion);
    }
    
    public ArrayList<Evento> getCalendario(){
    
        return calendario;
    }

    //metodos getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo_aula() {
        return codigo_aula;
    }

    public int getHoras_semana() {
        return horas_semana;
    }

    public String toString() {
        return nombre;
    }
    
    //Obtener arraylist para mostrar en tabla(todos los ciclos)
    public String[] toArrayString() {
        String[] elemento = new String[2];
        elemento[0] = getNombre();
        elemento[1] = getHoras_semana() + "";

        return elemento;
    }
    
   

}
