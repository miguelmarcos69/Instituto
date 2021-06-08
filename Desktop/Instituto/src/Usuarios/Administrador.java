package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Usuarios.Usuario;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Administrador extends Usuario {

    public Administrador(String nombre, String contrasenna, String DNI, Date fecha_nacimiento) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);

    }

    public String getContra() {
        return contrasenna;
    }

}
