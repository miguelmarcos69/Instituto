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
    private ArrayList<Alumno> alumnos;
    private ArrayList<Ciclo> ciclos;
    private String nombre;
    private String direccion;
    //private long telefono;
    private String telefono; // para el manejo de datos se usa String

    public Instituto(ArrayList<Alumno> Alumnos, ArrayList<Ciclo> ciclos, String nombre, String direccion, String telefono) {
        this.alumnos = Alumnos;
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
    /*
    public ArrayList<Ciclo> getCiclos() {
        return ciclos;
    }*/
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String[][] getAlumnosAsignatura(String nombreAsignatura) {

        String[][] alum = new String[alumnos.size()][6];
        int contador = 0;

        for (int i = 0; i < alumnos.size(); i++) {

            if (alumnos.get(i) instanceof Alumno) {
                Alumno a = (Alumno) alumnos.get(i);
                if (a.tieneModulo(nombreAsignatura)) {
                    alum[contador++][0] = a.getNombre();

                }
            }
        }

        return alum;
    }

    public String[][] getDos(String nomAlumn, String nombreMod) {
        String[][] alum = new String[4][alumnos.size()];
        for (int i = 0; i < alumnos.size(); i++) {

            if (alumnos.get(i).getNombre().equals(nomAlumn)) {

                alum = alumnos.get(i).getANotas(nombreMod);
            } else {

            }

        }
        return alum;
    }

    public String getMombreAlumnosAsignatura(String nom, int n) {

        String al = null;
        int contador = 0;

        for (int i = 0; i < alumnos.size(); i++) {

            if (alumnos.get(i) instanceof Alumno) {
                Alumno a = (Alumno) alumnos.get(i);
                if (a.tieneModulo(nom)) {
                    if (contador == n) {
                        al = a.getNombre();

                    }
                    contador++;

                }
            }
        }

        return al;
    }

     public String[][] mostrarUsuarios() {
        String[][] arrayUsuarios = new String[alumnos.size()][6];
        for (int i = 0; i < alumnos.size(); i++) {
            Usuario u = alumnos.get(i);
            if (u instanceof Profesor) {
                arrayUsuarios[i][0] = "Profesor";

            } else {
                arrayUsuarios[i][0] = "Alumno";
            }
            arrayUsuarios[i][1] = u.getNombre();
            arrayUsuarios[i][2] = u.getDNI();
            arrayUsuarios[i][3] = u.getFecha_nacimiento();

        }
        return arrayUsuarios;

    }

//    
//     public String[][] getAlumnos() {
//     
//        String [][] arrayAlumnos = new String[usuarios.size()][7];
//        for (int i = 0, j=0;i<usuarios.size();i++){
//            Usuario u = usuarios.get(i);
//            if (u instanceof Alumno){
//                Alumno a = (Alumno)u;
//             arrayAlumnos [j][0] = 
//              arrayAlumnos [j][1] =
//            arrayAlumnos [j][2] = 
//             arrayAlumnos [j][3] = 
//                arrayAlumnos [j][4] = 
//              arrayAlumnos [j][5] = 
//          arrayAlumnos [j][6] = 
//                j++;
//            }
//        }
//        return ;
//    }
//    
    //Arralist para obtner todos los ciclos
    public String[][] getCicloTot() {

        String[][] arrayCiclos = new String[ciclos.size()][10];
        for (int i = 0; i < ciclos.size(); i++) {

            Ciclo c = (Ciclo) ciclos.get(i);
            arrayCiclos[i] = c.toArrayString();
        }

        return arrayCiclos;
    }

    //Lo mismo pero filtrando por año
    public String[][] getCicloTot(int annoCic) {

        String[][] arrayCiclos = new String[ciclos.size()][10];
        for (int i = 0; i < ciclos.size(); i++) {

            Ciclo c = (Ciclo) ciclos.get(i);
            arrayCiclos[i] = c.toArrayString(annoCic);
        }

        return arrayCiclos;
    }

    public Ciclo getCicloNombre(String nombre, int ano) {

        Ciclo buscado = null;

        for (int i = 0; i < ciclos.size(); i++) {

            if (ciclos.get(i).getNombre().equals(nombre) && ciclos.get(i).getAnno() == ano) {

                buscado = ciclos.get(i);
            }
        }

        return buscado;
    }

}
