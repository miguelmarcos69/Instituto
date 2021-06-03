/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

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
    private String nombre_ciclo;

    //metodo constuctor
    public Modulo(String nombre, String codigo_aula, int horas_semana, String nombre_ciclo) {
        this.nombre = nombre;
        this.codigo_aula = codigo_aula;
        this.horas_semana = horas_semana;
        this.nombre_ciclo = nombre_ciclo;
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

    public String getNombre_ciclo() {
        return nombre_ciclo;
    }

    public String toString() {
        return nombre;
    }

}
