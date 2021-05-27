package ClasesBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import instituto.Usuarios.Usuario;
import java.util.ArrayList;


/**
 *
 * @author alumno
 */
public class Instituto {

    /**
     * @param args the command line arguments
     */

    //atributos de la clase
    private ArrayList <Usuario> Usuarios; 
    private ArrayList <Ciclo> ciclos; 
    private String nombre;
    private String direccion;
    private long telefono;

    
    
    
    
    //metodos getters
    public ArrayList<Ciclo> getCiclos() {
        return ciclos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public long getTelefono() {
        return telefono;
    }
    
    
    
    
    
    
    
    
    
}
