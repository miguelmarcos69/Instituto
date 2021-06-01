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

/**
 *
 * @author alumno
 */
public class Alumno extends Usuario {
    //Atributos
    
    
    private Ciclo ciclo;
    private ArrayList <Nota> notas;

    public Alumno(String nombre, String contrasenna, String DNI, int fecha_nacimiento, int edad, Ciclo ciclo) {
        super(nombre, contrasenna, DNI, fecha_nacimiento, edad);
        this.ciclo=ciclo;
    }
    
    //Metodos get

    public Ciclo getCiclo() {
        return ciclo;
    }
    
    
    //Este metodo esta hecho para insertart las notas de un alumno en una tabla 
    
    public String [][] getArrayNotas (){
    
        String [][] retorno=new String [notas.size()][2];
        
        for (int i=0;i<notas.size();i++){
        
            retorno[i][1]=notas.get(i).getModulo().getNombre();
            retorno[i][2]=notas.get(i).getNota()+"";
        }
        
        return retorno;
    }

}
