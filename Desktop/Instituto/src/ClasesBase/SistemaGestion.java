/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

import BaseDatos.ConexionDefault;
import BaseDatos.DaoInstituto;
import ClasesBase.*;

/**
 *
 * @author Miguel Marcos
 */
public class SistemaGestion {

    public SistemaGestion() {
        ConexionDefault.crearConexion();
    }

//    public Instituto cargarNombre(String nombreInstituto, String nombre, String contra) {
//        return DaoInstituto.instancia().cargarNombre(nombreInstituto, nombre, contra);
//    }

}
