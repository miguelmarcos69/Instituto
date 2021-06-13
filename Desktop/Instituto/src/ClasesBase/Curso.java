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
public class Curso {

    //atributos de la clase
    private ArrayList<Modulo> modulos;
    private String nombre;
    private int plazas;
    private int anno;

    //metodo constructor
    public Curso(ArrayList<Modulo> Asignatura, String nombre, int anno, int plazas) {
        this.modulos = Asignatura;
        this.nombre = nombre;
        this.anno = anno;
        this.plazas = plazas;
    }

    public Curso(String nombre, int plazas, int ano) {
        this.nombre = nombre;
        this.modulos = new ArrayList();
        this.plazas = plazas;
        this.anno = ano;
    }

    //metodos getters
    public int getAnno() {
        return anno;
    }

    public ArrayList<Modulo> getArrayListModulos() {

        return this.modulos;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre;
    }

    public int getSizeModulos() {
        return modulos.size();
    }
    public int getPlazas (){
    
        return this.plazas;
    }

    public void anadirModulo(Modulo e) {

        modulos.add(e);
    }

    public boolean existeModulo(String nombre) {
        boolean resultado = false;

        for (int i = 0; i < modulos.size(); i++) {

            if (modulos.get(i).getNombre().equals(nombre)) {
                
                System.out.println(modulos.get(i).getNombre());

                resultado = true;
            }
        }

        return resultado;
    }

    public Modulo getModulo(String nombreModulo) {
        Modulo m = null;

        for (int i = 0; i < modulos.size(); i++) {

            if (modulos.get(i).getNombre().equals(nombreModulo)) {

                m = modulos.get(i);

                i = modulos.size();
            }
        }

        return m;

    }

    //Obtener arraylist para mostrar en tabla(todos los ciclos)
    public String[] toArrayString() {
        String[] elemento = new String[2];
        elemento[0] = getNombre();
        elemento[1] = getAnno() + "";

        return elemento;
    }

    //Obtener arraylist para mostrar en tabla(todos en funcion del año)
    public String[] toArrayString(int annoCic) {
        String[] elemento = new String[2];
        if (getAnno() == annoCic) {
            elemento[0] = getNombre();
            elemento[1] = getAnno() + "";
        }

        return elemento;
    }

    //Arraylist para obtenr todos los modulos
    public String[][] getModulos() {
        String[][] arrayAsignaturas = new String[modulos.size()][10];
        for (int i = 0; i < modulos.size(); i++) {

            Modulo m = (Modulo) modulos.get(i);
            arrayAsignaturas[i] = m.toArrayString();
        }

        return arrayAsignaturas;
    }

    public ArrayList<Modulo> concatenarModulos(ArrayList<Modulo> a) {

        for (int i = 0; i < this.modulos.size(); i++) {

            a.add(this.modulos.get(i));

        }

        return a;
    }

}