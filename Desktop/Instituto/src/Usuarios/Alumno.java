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

    public Alumno(String nombre, String contrasenna, String DNI, Date fecha_nacimiento,
            Ciclo ciclo) {
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

        String[][] retorno = new String[notas.size()][10];

        for (int i = 0; i < notas.size(); i++) {

            retorno[i][1] = notas.get(i).getModulo().getNombre();
            retorno[i][2] = notas.get(i).getNota() + "";
        }

        return retorno;
    }

    public String[][] getANotas(String nombreMod) {
        String[][] retorno = new String[1][notas.size()];
        int contador = 0;
        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getModulo().getNombre().equals(nombreMod)) {
                retorno[0][contador++] = String.valueOf(notas.get(i).getNota());

            }

        }

        return retorno;
    }

    public boolean tieneModulo(String nombreAsignatura) {

        boolean resultado = ciclo.existeModulo(nombreAsignatura);

        return resultado;
    }

    public void annadirNotas(Nota n) {
        notas.add(n);

    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getContrasenna() {
        return contrasenna;
    }

}
