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
    private int anno;

    //metodo constructor
    public Ciclo(ArrayList<Modulo> Asignatura, String nombre, int anno, int plazas) {
        this.Asignaturas = Asignatura;
        this.nombre = nombre;
        this.anno = anno;
        this.plazas = plazas;
    }

    public Ciclo(String nombre, int plazas) {
        this.nombre = nombre;
        this.plazas = plazas;
    }
    
    //metodos getters

    public int getAnno() {
        return anno;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre;
    }

    
    public int getSizeModulos(){
        return Asignaturas.size();
    }
    
    public void anadirModulo (Modulo e){
    
        Asignaturas.add(e);
    }

    public boolean existeModulo(String nombre) {
        boolean resultado = false;

        for (int i = 0; i < Asignaturas.size(); i++) {

            if (Asignaturas.get(i).getNombre().equals(nombre)) {
               // System.out.println(Asignaturas.get(i).getNombre());

                resultado = true;
            }
        }

        return resultado;
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
        String[][] arrayAsignaturas = new String[Asignaturas.size()][10];
        for (int i = 0; i < Asignaturas.size(); i++) {

            Modulo m = (Modulo) Asignaturas.get(i);
            arrayAsignaturas[i] = m.toArrayString();
        }

        return arrayAsignaturas;
    }
    
    public ArrayList<Modulo> concatenarModulos (ArrayList<Modulo> a){
        
        for (int i =0 ;i< this.Asignaturas.size();i++){
        
            a.add(this.Asignaturas.get(i));
        
        }
        
        return a; 
    }
    
    
}
