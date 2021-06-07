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

    public Alumno(String nombre, String contrasenna, String DNI,
            Date fecha_nacimiento, Ciclo ciclo, ArrayList<Nota> not) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        //this.notas = not;
        this.ciclo = ciclo;
       // System.out.println(notas.toString());
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

    public String[][] getNotas(String nom) {
        System.out.println("Nombre Alumno:  " + nom);
        String[][] retorno = new String[notas.size()][2];
        for (int i = 0; i < notas.size(); i++) {
            Nota n = (Nota) notas.get(i);
            if (n.getAlumno().getNombre().equals(nom)) {
                System.out.println("s");
                retorno[i][1] = String.valueOf(n.getNota());

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
