package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ClasesBase.Asignatura;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Profesor extends Usuario {

    private ArrayList <Asignatura> asignaturasDadas;
    
    public Profesor(String nombre, String contrasenna, String DNI, int fecha_nacimiento, int edad) {
        super(nombre, contrasenna, DNI, fecha_nacimiento, edad);
        asignaturasDadas = new ArrayList();
    }

}
