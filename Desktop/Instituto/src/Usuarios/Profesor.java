package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BaseDatos.DAOInstituto2;
import ClasesBase.*;
import Usuarios.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Profesor extends Usuario {

    private ArrayList<Modulo> modulosImpartidos;

    public Profesor(String nombre, String contrasenna, String DNI, Date fecha_nacimiento) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        modulosImpartidos = new ArrayList();
    }

    public Profesor(String nombre, String contrasenna, String DNI, Date fecha_nacimiento, ArrayList<Modulo> mod) {// ArrayList<Alumno> alumno) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        modulosImpartidos = mod;

    }

    public ArrayList<Modulo> getArrayListModulosImpartidos() {
        return modulosImpartidos;
    }

    public void annadirModulo(Modulo a) {

        modulosImpartidos.add(a);
    }

    public String[][] getModulosInpartidos(Instituto instituto) {

        String[][] impratidos = new String[this.modulosImpartidos.size()][4];
        try {

            ArrayList<Curso> cursos = DAOInstituto2.instancia().getCursosdeProfesor(nombre, instituto);

            for (int i = 0; i < this.modulosImpartidos.size(); i++) {

                impratidos[i][0] = this.modulosImpartidos.get(i).getNombre();
                impratidos[i][1] = this.modulosImpartidos.get(i).getHoras_semana() + "";
                impratidos[i][2] = cursos.get(i).getNombre();
                impratidos[i][3] = cursos.get(i).getAnno() + "";

            }

        } catch (SQLException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return impratidos;
    }

    /*
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

     */
}
