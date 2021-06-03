package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ClasesBase.*;
import Usuarios.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Profesor extends Usuario {

    private ArrayList<Modulo> asignaturasDadas;
    private ArrayList<Ciclo> ci;
    private ArrayList<Alumno> alu;

    public Profesor(String nombre, String contrasenna, String DNI, int fecha_nacimiento, int edad) {
        super(nombre, contrasenna, DNI, fecha_nacimiento, edad);
        asignaturasDadas = new ArrayList();
    }

    public Profesor(String nombre, String contrasenna, String DNI, int fecha_nacimiento, int edad, ArrayList<Modulo> mod, ArrayList<Ciclo> ciclo, ArrayList<Alumno> alumno) {
        super(nombre, contrasenna, DNI, fecha_nacimiento, edad);
        asignaturasDadas = mod;
        ci = ciclo;
        alu = alumno;
    }

    public ArrayList<Ciclo> getCi() {
        return ci;
    }

    public ArrayList<Modulo> getAsignaturasDadas() {
        return asignaturasDadas;
    }

    public ArrayList<Alumno> getAlu() {
        return alu;
    }

    public String[][] getPro() {
        String[][] arrayAlumnos = new String[alu.size()][1];

        for (int i = 0; i < alu.size(); i++) {
            Usuario u = alu.get(i);
            if (u instanceof Alumno) {
                arrayAlumnos[i][0] = u.getNombre();

            }

        }
        return arrayAlumnos;
    }

    public String[][] getEn() {
        String[][] arrayAlumnos = new String[alu.size()][1];

        for (int i = 0; i < alu.size(); i++) {
            Alumno u = alu.get(i);
            //arrayAlumnos[i][0] = u.getNombre();
            arrayAlumnos[i][0] = u.getCiclo().toString();

        }
        return arrayAlumnos;
    }

}
