package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ClasesBase.Asignatura;
import ClasesBase.Ciclo;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Alumno extends Usuario {
    //Atributos
    
    //private ArrayList <Asignatura> asignaturasCursadas;
    private Ciclo ciclo;

    public Alumno(String nombre, String contrasenna, String DNI, int fecha_nacimiento, int edad, Ciclo ciclo) {
        super(nombre, contrasenna, DNI, fecha_nacimiento, edad);
        //asignaturasCursadas = new ArrayList();
    }
    
    

}
