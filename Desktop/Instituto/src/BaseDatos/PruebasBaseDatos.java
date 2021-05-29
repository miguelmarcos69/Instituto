/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Usuarios.Alumno;

/**
 *
 * @author abili
 */
public class PruebasBaseDatos {
    
    public static void main(String args[]) {
    
        
        Alumno a = new Alumno ("abel","pito","71951546K",2001,19);
        
        DaoInstituto.instancia().annadirAlumno(a, "camino");
        
    }
    
}
