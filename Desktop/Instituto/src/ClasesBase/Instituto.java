package ClasesBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Usuarios.Alumno;
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
    private ArrayList<Usuario> usuarios;
    private ArrayList<Ciclo> ciclos;
    private String nombre;
    private String direccion;
    //private long telefono;
    private String telefono; // para el manejo de datos se usa String

    public Instituto(ArrayList<Usuario> Usuarios, ArrayList<Ciclo> ciclos, String nombre, String direccion, String telefono) {
        this.usuarios = Usuarios;
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
    
    public String[][] getAlumnosAsignatura (String nombreAsignatura){
    
        String [][] alumnos = new String [1][usuarios.size()];
        
        for (int i = 0;i<usuarios.size();i++) {
            
            if (usuarios.get(i) instanceof Alumno){
                Alumno a = (Alumno) usuarios.get(i);
                if (a.tieneModulo(nombreAsignatura)){
                
                    alumnos[1][i] = a.getNombre();
                }
            }
        }
        
        return alumnos;
    }

    public String[][] mostrarUsuarios() {
        String[][] arrayUsuarios = new String[usuarios.size()][6];
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u instanceof Profesor) {
                arrayUsuarios[i][0] = "Profesor";

            } else {
                arrayUsuarios[i][0] = "Alumno";
            }
            arrayUsuarios[i][1] = u.getNombre();
            arrayUsuarios[i][2] = u.getContra();
            arrayUsuarios[i][3] = u.getDNI();
            arrayUsuarios[i][4] = u.getEdad();
            arrayUsuarios[i][5] = u.getFecha_nacimiento();

        }
        return arrayUsuarios;

    }
    
    //Arralist para obtner todos los ciclos
    public String[][] getCiclo() {

        String[][] arrayCiclos = new String[ciclos.size()][10];
        for (int i = 0; i < ciclos.size(); i++) {
            
            Ciclo c = (Ciclo) ciclos.get(i);
            arrayCiclos[i] = c.toArrayString();
            }

        return arrayCiclos;
    }
    
    //Lo mismo pero filtrando por año
    public String[][] getCiclo(int annoCic) {

        String[][] arrayCiclos = new String[ciclos.size()][10];
        for (int i = 0; i < ciclos.size(); i++) {
            
            Ciclo c = (Ciclo) ciclos.get(i);
            arrayCiclos[i] = c.toArrayString(annoCic);
            }

        return arrayCiclos;
    }
    
    
    

}
