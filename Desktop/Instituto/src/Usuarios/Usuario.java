/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto.Usuarios;

import java.util.Date;

/**
 *
 * @author alumno
 */
public abstract class Usuario {
    //atributos de la clase
    private String nombre;
    private String DNI;
    private Date fecha_nacimiento;
    private int edad;
    private String contrasenna;

    
    
    
    //metodo constructor
    public Usuario(String nombre, String DNI, Date fecha_nacimiento, int edad, String contrasenna) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.contrasenna = contrasenna;
    }
    
    
    
    //metodos getters
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public String getContrasenna() {
        return contrasenna;
    }
     
    
    
    
    
}
