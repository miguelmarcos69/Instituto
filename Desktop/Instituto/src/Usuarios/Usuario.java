/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.Date;

/**
 *
 * @author alumno
 */
public abstract class Usuario {

    //atributos de la clase
    private String nombre;
    private String DNI;
    private int fecha_nacimiento;
    private int edad;
    String contrasenna;

    //metodo constructor
    public Usuario(String nombre, String contrasenna, String DNI, int fecha_nacimiento, int edad) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.DNI = DNI;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
    }

    //metodos getters
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public int getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public String getContra() {
        return contrasenna;
    }

}
