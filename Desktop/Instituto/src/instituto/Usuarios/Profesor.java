package instituto.Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import instituto.Usuarios.Usuario;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Profesor extends Usuario{
    
    public Profesor(String nombre, String DNI, Date fecha_nacimiento, int edad, String contrasenna) {
        super(nombre, DNI, fecha_nacimiento, edad, contrasenna);
    }
    
}
