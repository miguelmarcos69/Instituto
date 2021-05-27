/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import ClasesBase.*;

/**
 *
 * @author Miguel Marcos
 */
public class DaoInstituto {

    static DaoInstituto instancia = null;

    public static DaoInstituto instancia() {
        if (instancia == null) {
            instancia = new DaoInstituto();
        }
        return instancia;
    }

    public Instituto cargarNombre(String nombreInstituto, String nombre, String contra) {

        try {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    "select idInmobiliaria, nombre, direcion from inmobiliaria  where nombre='" + nombre + "'"
            );
            if (rs.next()) {
                id = rs.getInt(1);
                i = new Inmobiliaria(rs.getInt(1), nombre, rs.getString(3));
//                System.out.println(rs.getInt(1));// id de inmobiliaria
//                System.out.println(rs.getString(2));
//                System.out.println(rs.getString(3));
                ResultSet rsi = ConexionBD.instancia().getStatement().executeQuery(
                        "select  metros, habitaciones, banos, planta "
                        + "from inmobiliaria,vivienda,piso where inmobiliaria.nombre='" + nombre + "'"
                        + "and vivienda.idInmobiliaria=inmobiliaria.idInmobiliaria and vivienda.clave=piso.clave"
                );

                while (rsi.next()) {
                    i.anadirPiso(new Piso(rsi.getInt(1), rsi.getInt(2), rsi.getInt(3), rsi.getInt(4)));
                }

                rsi = ConexionBD.instancia().getStatement().executeQuery(
                        " select metros, habitaciones, banos, metrosSolalr, numPlantas "
                        + "from inmobiliaria,vivienda,casa where inmobiliaria.nombre='" + nombre + "'"
                        + "and vivienda.idInmobiliaria=inmobiliaria.idInmobiliaria and vivienda.clave=casa.clave"
                );
                while (rsi.next()) {
                    i.anadirCasa(new Casa(rsi.getInt(1), rsi.getInt(2), rsi.getInt(3), rsi.getInt(4), rsi.getInt(4)));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

}
