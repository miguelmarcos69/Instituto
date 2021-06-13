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
    
    public Profesor(String nombre, String contrasenna, String DNI, Date fecha_nacimiento) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        asignaturasDadas = new ArrayList();
    }

    public Profesor(String nombre, String contrasenna, String DNI, Date fecha_nacimiento, ArrayList<Modulo> mod){// ArrayList<Alumno> alumno) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        asignaturasDadas = mod;
      
    }


    public ArrayList<Modulo> getAsignaturasDadas() {
        return asignaturasDadas;
    }
    
    public void annadirModulo (Modulo a){
    
        asignaturasDadas.add(a);
    }
    
    public String [][] getModulosInpartidos (){
    
        String [][] modulos = new String [this.asignaturasDadas.size()][2];
        
        for (int i =0;i<asignaturasDadas.size();i++){
        
            modulos[i][0]=asignaturasDadas.get(i).getNombre();
            modulos[i][1]=asignaturasDadas.get(i).getHoras_semana()+"";
        }
        
        return modulos;
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
