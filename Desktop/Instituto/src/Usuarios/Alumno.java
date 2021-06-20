package Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ClasesBase.Curso;
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

    private Curso curso;
    private ArrayList<Nota> notas;

    public Alumno(String nombre, String contrasenna, String DNI, Date fecha_nacimiento, Curso ciclo) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        this.curso = ciclo;
        notas = new ArrayList();
    }

    //constructor se utuliza al iniciar sesion
    public Alumno(String nombre, String contrasenna, String DNI, Date fecha_nacimiento) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        this.notas = new ArrayList();
    }

    public String[][] getNotasModulos() {

        String[][] modulosNotas = new String[curso.getSizeModulos()][5];

        for (int i = 0; i < curso.getSizeModulos(); i++) {

            modulosNotas[i][0] = curso.getArrayListModulos().get(i).getNombre();

            int numeroNota = 1;

            for (int j = 0; j < notas.size(); j++) {

                if (notas.get(j).getModulo().equals(curso.getArrayListModulos().get(i).getNombre())) {

                    modulosNotas[i][numeroNota++] = notas.get(j).getNota() + "";
                }
            }
            
            if(numeroNota==4){
            
                modulosNotas[i][4]=this.notaFinal(curso.getArrayListModulos().get(i).getNombre())+"";
            }

            if (numeroNota == 4) {

                modulosNotas[i][4] = this.notaFinal(curso.getArrayListModulos().get(i).getNombre()) + "";
            }
        }

        return modulosNotas;
    }

    //Metodos get
    public Curso getCiclo() {
        return curso;
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

    //Este metodo esta hecho para insertar las notas de un alumno en una tabla 
    public String[][] getArrayNotas() {

        String[][] retorno = new String[notas.size()][10];

        for (int i = 0; i < notas.size(); i++) {

            retorno[i][1] = notas.get(i).getModulo();
            retorno[i][2] = notas.get(i).getNota() + "";
        }

        return retorno;
    }

    public String[][] getANotas(String nombreMod) {
        String[][] retorno = new String[1][notas.size()];
        int contador = 0;
        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getModulo().equals(nombreMod)) {
                retorno[0][contador++] = String.valueOf(notas.get(i).getNota());

            }

        }

        return retorno;
    }

    public ArrayList<Nota> getNotasArray(String nombreMod) {

        ArrayList<Nota> a = new ArrayList();
        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i).getModulo().equals(nombreMod)) {

                a.add(notas.get(i));

            }

        }

        return a;
    }

    public boolean tieneModulo(String nombreAsignatura) {

        boolean resultado = curso.existeModulo(nombreAsignatura);

        return resultado;
    }

    public void annadirNotas(Nota n) {
        notas.add(n);

    }

    public void setCiclo(Curso ciclo) {
        this.curso = ciclo;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public ArrayList<Nota> getNotasModulo(String modulo) {
        ArrayList<Nota> notas = new ArrayList();

        for (int i = 0; i < notas.size(); i++) {

            if (notas.get(i).getModulo().equals(modulo)) {

                notas.add(notas.get(i));
            }
        }

        return notas;
    }

    public int notaFinal(String modulo) {

        int nota = 0;
        int contador = 0;
        boolean todas = false;

        for (int i = 0; i < notas.size(); i++) {

            if (notas.get(i).getModulo().equals(modulo)) {

                nota = notas.get(i).getNota() + nota;
                contador++;
                if (contador == 3) {

                    nota = nota / 3;
                    todas = true;
                }
            }

        }
        if (todas == false) {

            nota = -1;
        }

        return nota;
    }

    public boolean aprobado() {

        boolean aprobado = true;

        for (int i = 0; i < curso.getSizeModulos(); i++) {

            if (notaFinal(curso.getArrayListModulos().get(i).getNombre()) < 5) {

                aprobado = false;
            }
        }

        return aprobado;
    }

}
