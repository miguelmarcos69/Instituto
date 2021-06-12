/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import ClasesBase.Ciclo;
import ClasesBase.Instituto;
import ClasesBase.Modulo;
import Usuarios.Alumno;
import Usuarios.Profesor;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author abili
 */
public class PruebasBaseDatos {
    
    public static void main(String args[]) {
    
        ConexionDefault.crearConexion();
        ArrayList<Modulo> modAnn = new ArrayList<>();

        ArrayList<Usuario> al = new ArrayList<>();
        ArrayList<Ciclo> c = new ArrayList<>();
        ArrayList<Modulo> mod = new ArrayList();
        ArrayList<Modulo> mod2 = new ArrayList();

        Ciclo primero = new Ciclo(mod, "DAW", 1, 1);
        Ciclo segundo = new Ciclo(mod2, "DAW", 2, 2);

        Modulo programacion = new Modulo("Programacion", "12", 2);
        Modulo entornos = new Modulo("entornos", "12", 2);
        Modulo fol = new Modulo("fol", "12", 2);
        mod.add(programacion);
        mod.add(entornos);
        mod2.add(fol);

        c.add(primero);
        c.add(segundo);
        
        Profesor ruben = new Profesor ("Ruben","ruben","876543",new Date());
        ruben.annadirModulo(fol);

        Alumno lola = new Alumno("Lola", "lola", "1254", new Date(), primero);
        Alumno miguel = new Alumno("miguel", "miguel", "1254", new Date(), primero);
        Alumno pepe = new Alumno("pepe", "pepe", "1254", new Date(), primero);
        Alumno juan = new Alumno("juan", "juan", "1254", new Date(), segundo);

        al.add(lola);
        al.add(miguel);
        al.add(pepe);
        al.add(juan);

        Instituto i = new Instituto(al, c, "camino", "la que sea", "69633245");
        DAOInstituto2.instancia().modificarContrasena("a", "camino", "pepito");
        //DaoInstituto.instancia().eliminarUsuario(juan.getNombre(), i.getNombre());
        //DaoInstituto.instancia().eliminarUsuario("Ruben", "camino");
        
        
    }
    
}
