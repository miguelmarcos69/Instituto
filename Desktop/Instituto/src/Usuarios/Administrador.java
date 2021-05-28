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

    String nombreInsti;
    String tipo;

    public Administrador(String nombre, String contrasenna, String DNI, int fecha_nacimiento, int edad, String tipo, String nombreInsti) {
        super(nombre, contrasenna, DNI, fecha_nacimiento, edad);
        this.tipo = tipo;
        this.nombreInsti = nombreInsti;
    }

    public String getNombreInsti() {
        return nombreInsti;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContra() {
        return contrasenna;
    }

}
