package ClasesBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Usuarios.Profesor;
import Usuarios.Usuario;
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
    private ArrayList<Usuario> Usuarios;
    private ArrayList<Ciclo> ciclos;
    private String nombre;
    private String direccion;
    //private long telefono;
    private String telefono; // para el manejo de datos se usa String

    public Instituto(ArrayList<Usuario> Usuarios, ArrayList<Ciclo> ciclos, String nombre, String direccion, String telefono) {
        this.Usuarios = Usuarios;
        this.ciclos = ciclos;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Instituto(String nombre, String direccion, String telefono) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public String[][] getUsuarios(Ciclo c) {
        String[][] arrayUsuarios = new String[Usuarios.size()][4];
        for (int i = 0; i < Usuarios.size(); i++) {
            Usuario u = Usuarios.get(i);
            if (u instanceof Profesor) {
                arrayUsuarios[i][0] = "Profesor";

            } else {
                arrayUsuarios[i][0] = "Alumno";
            }
            arrayUsuarios[i][1] = u.getNombre();
            arrayUsuarios[i][2] = u.getEdad();
            arrayUsuarios[i][3] = u.getFecha_nacimiento();
            
            
        }
        return arrayUsuarios;

    }

}
