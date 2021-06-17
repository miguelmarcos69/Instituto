/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBase;

import java.util.Date;

/**
 *
 * @author abilius
 */
public class Evento {
    
    private String mensaje;
    private Date fecha;
    
    public Evento (String mensaje,Date fecha){
    
        this.mensaje=mensaje;
        this.fecha=fecha;
        
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFecha() {
        return fecha;
    }
    
    
    
    
    
}
