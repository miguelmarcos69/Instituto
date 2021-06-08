/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import ClasesBase.Nota;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alumno
 */
public abstract class Usuario {

    //atributos de la clase
    String nombre;
    private String DNI;
    private Date fecha_nacimiento;
    String contrasenna;
    

    //metodo constructor
    public Usuario(String nombre, String contrasenna, String DNI, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.DNI = DNI;
        this.fecha_nacimiento = fecha_nacimiento;
        //El atributo edad no deberia de exixtir ya que es algo variable lo podriamos hacer con un metodo que coja el año en el que estamos y le reste la fechad e nacimiento
//        this.edad = edad;
    }

    //metodos getters
    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getFecha_nacimiento() {
        return String.valueOf(fecha_nacimiento);
    }

    public Date getFecha_nacimientoNumerico() {
        return fecha_nacimiento;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public String getContra() {
        return contrasenna;
    }

}
