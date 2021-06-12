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

    public Alumno(String nombre, String contrasenna, String DNI, Date fecha_nacimiento,Ciclo ciclo) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        this.ciclo = ciclo;
        notas = new ArrayList();
    }

    //constructor se utuliza al iniciar sesion
    public Alumno(String nombre, String contrasenna, String DNI, Date fecha_nacimiento) {
        super(nombre, contrasenna, DNI, fecha_nacimiento);
        this.notas=new ArrayList();
    }
    
    public String [][] getNotasModulos (){
    
    
        String [][] modulosNotas = new String [ciclo.getSizeModulos()][5];
        
        for (int i=0;i<ciclo.getSizeModulos();i++){
        
            modulosNotas[i][0]=ciclo.getArrayListModulos().get(i).getNombre();
            
            int nNotasModulo=0;
            int notaFinal=0;
            
            for (int j=0;j<notas.size();j++){
            
                if (notas.get(j).getModulo().equals(ciclo.getArrayListModulos().get(i).getNombre())){
                
                    modulosNotas[i][j+1]=notas.get(j).getNota()+"";                    
                    notaFinal=notaFinal+notas.get(j).getNota();
                    
                    if (nNotasModulo==3){
                    
                        modulosNotas[i][4]=(notaFinal/3)+"";
                    }
                }
            }
        }
        
        return modulosNotas;
    }

    //Metodos get
    public Ciclo getCiclo() {
        return ciclo;
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

    public boolean tieneModulo(String nombreAsignatura) {

        boolean resultado = ciclo.existeModulo(nombreAsignatura);

        return resultado;
    }

    public void annadirNotas(Nota n) {
        notas.add(n);

    }
    
    public void setCiclo (Ciclo ciclo){
        this.ciclo=ciclo;
    }

    @Override
    public String toString() {
        return nombre;
    }



}
