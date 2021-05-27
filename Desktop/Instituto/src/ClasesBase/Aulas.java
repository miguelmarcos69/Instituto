/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Aulas {
    //atributos de la clase
    private ArrayList <Inventario> material_aula;
    private String codigo;
    private String profesor;
    
    
    
    //metodo constructor
    public Aulas(ArrayList<Inventario> material_aula, String codigo, String profesor) {
        this.material_aula = material_aula;
        this.codigo = codigo;
        this.profesor = profesor;
    }

    
    
    
    
    
    //metodos getters
    public ArrayList<Inventario> getMaterial_aula() {
        return material_aula;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProfesor() {
        return profesor;
    }
    
    
    
    
    
    
}
