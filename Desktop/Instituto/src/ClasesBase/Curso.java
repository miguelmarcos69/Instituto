/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

import BaseDatos.DAOInstituto2;
import Usuarios.Profesor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Curso {

    //atributos de la clase
    private ArrayList<Modulo> modulos;
    private String nombre;
        private int anno;
    private int plazas;


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

    public int getPlazas() {

        return this.plazas;
    }

    public void anadirModulo(Modulo e) {

        modulos.add(e);
    }

    public boolean existeModulo(String nombre) {
        boolean resultado = false;

        for (int i = 0; i < modulos.size(); i++) {

            if (modulos.get(i).getNombre().equals(nombre)) {


                resultado = true;
            }
        }

        return resultado;
    }

    public Modulo buscarModulo(String nombreModulo) {
        Modulo m = null;

        for (int i = 0; i < modulos.size(); i++) {

            if (modulos.get(i).getNombre().equals(nombreModulo)) {

                m = modulos.get(i);

                i = modulos.size();
            }
        }

        return m;

    }

    public Boolean ContarHoras(int horas) {
        boolean añadido = false;
        int horasSemama = horas;
        for (int i = 0; i < modulos.size(); i++) {
            horasSemama = horasSemama+modulos.get(i).getHoras_semana();

        }
        if (horasSemama <= 30) {
            añadido = true;
        }

        return añadido;
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
        String[][] arrayAsignaturas = new String[modulos.size()][4];
        for (int i = 0; i < modulos.size(); i++) {

            Modulo m = (Modulo) modulos.get(i);
            arrayAsignaturas[i][0] = m.getNombre();
            arrayAsignaturas[i][1] = m.getHoras_semana()+"";
            arrayAsignaturas[i][2]=this.getNombre();
            arrayAsignaturas[i][3]=this.getAnno()+"";
        }

        return arrayAsignaturas;
    }

    public ArrayList<Modulo> concatenarModulos(ArrayList<Modulo> a) {

        for (int i = 0; i < this.modulos.size(); i++) {

            a.add(this.modulos.get(i));

        }

        return a;
    }
    
    
    
    public String [][] obtenerEventos (){
        
        String [][]eventos = null;
        
        try {
            eventos = new String [DAOInstituto2.instancia().getEventosCurso(this)][3];
            int contador =0;
            
            for (int i=0;i<this.modulos.size();i++){
                
                for (int j=0;j<modulos.get(i).getCalendario().size();j++){
                    
                    eventos[contador][0]=modulos.get(i).getNombre();
                    eventos[contador][1]=modulos.get(i).getCalendario().get(j).getFecha()+"";
                    eventos[contador][2]=modulos.get(i).getCalendario().get(j).getMensaje();
                    contador++;
                    
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return eventos;
    }


}
