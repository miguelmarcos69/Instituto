package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ClasesBase.Ciclo;
import ClasesBase.Modulo;
import ClasesBase.Nota;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Date;
import Grafico.*;

/**
 *
 * @author alumno
 */
public class Alumno extends Usuario {
    //Atributos

    private Ciclo ciclo;
    private ArrayList<Nota> notas;

    public Alumno(String nombre, String contrasenna, String DNI, Date fecha_nacimiento, Ciclo ciclo) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        this.ciclo = ciclo;
        notas = new ArrayList();
    }

    //constructor se utuliza al iniciar sesion
    public Alumno(String nombre, String contrasenna, String DNI, Date fecha_nacimiento) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
    }

    //Metodos get
    public Ciclo getCiclo() {
        return ciclo;
    }

    //Este metodo esta hecho para insertar las notas de un alumno en una tabla 
    public String[][] getArrayNotas() {

        String[][] retorno = new String[notas.size()][2];

        for (int i = 0; i < notas.size(); i++) {

            retorno[i][1] = notas.get(i).getModulo().getNombre();
            retorno[i][2] = notas.get(i).getNota() + "";
        }

        return retorno;
    }

    public void annadirNotas(Nota n) {
        notas.add(n);
    }

    public String toString() {
        return nombre;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public boolean tieneModulo(String nombreAsignatura) {

        boolean resultado = ciclo.existeModulo(nombreAsignatura);

        return resultado;
    }

}
