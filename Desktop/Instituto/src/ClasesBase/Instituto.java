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

    public Instituto(ArrayList<Usuario> usuario, ArrayList<Ciclo> ciclos, String nombre, String direccion, String telefono) {
        this.usuarios = usuario;
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

        String[][] alumn = new String[usuarios.size()][1];
        int contador = 0;

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i) instanceof Alumno) {
                Alumno a = (Alumno) usuarios.get(i);
                if (a.tieneModulo(nombreAsignatura)) {

                    alumn[contador++][0] = a.getNombre();

                }
            }
        }

        return alumn;
    }

    public String[][] getDos(String nomAlumn, String nombreMod) {
        String[][] alum = new String[4][usuarios.size()];
        for (int i = 0; i < usuarios.size(); i++) {
            Alumno al = (Alumno) usuarios.get(i);
            if (usuarios.get(i).getNombre().equals(nomAlumn)) {

                alum = al.getANotas(nombreMod);
            } else {

            }

        }
        return alum;
    }

    public String getMombreAlumnosAsignatura(String nom, int n) {

        String al = null;
        int contador = 0;

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i) instanceof Alumno) {
                Alumno a = (Alumno) usuarios.get(i);
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
        String[][] arrayUsuarios = new String[usuarios.size()][6];
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
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

    public String[][] mostrarAlumnos() {
        String[][] arrayAlumnos = new String[usuarios.size()][7];
        for (int i = 0, j = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u instanceof Alumno) {
                Alumno a = (Alumno) u;
                arrayAlumnos[j][0] = u.getNombre();
                arrayAlumnos[j][1] = u.getDNI();
                arrayAlumnos[j][2] = u.getFecha_nacimiento();

                j++;
            }
        }
        return arrayAlumnos;
    }

    public String[][] mostrarProfesores() {
        String[][] arrayProfesores = new String[usuarios.size()][7];
        for (int i = 0, j = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            if (u instanceof Profesor) {
                Profesor f = (Profesor) u;
                arrayProfesores[j][0] = u.getNombre();
                arrayProfesores[j][1] = u.getDNI();
                arrayProfesores[j][2] = u.getFecha_nacimiento();

                j++;
            }
        }
        return arrayProfesores;
    }

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

    //Lo mismo pro filttrando por nombre y año
    public Ciclo getCicloNombre(String nombre, int ano) {

        Ciclo buscado = null;

        for (int i = 0; i < ciclos.size(); i++) {

            if (ciclos.get(i).getNombre().equals(nombre) && ciclos.get(i).getAnno() == ano) {

                buscado = ciclos.get(i);
            }
        }

        return buscado;
    }
    
    //Metodo para ir al ciclo seleccionado y llmar al metodo de obtener modulos
    public String[][] getModulosCic(String nombre, int ano) {
        int tamanno = 0;
        String[][] s = new String[tamanno][10];
        for (int i = 0; i < ciclos.get(i).getSizeModulos(); i++) {

            if (ciclos.get(i).getNombre().equals(nombre) && ciclos.get(i).getAnno() == ano) {

                s = ciclos.get(i).getModulos();
            }
            tamanno = tamanno + ciclos.get(i).getSizeModulos();
        }
        return s;
    }
    
    //Metodo para llamar a todos los modulos y obtener sus asignaturas
    public String[][] getModulosTot() {
        int tamanno = 0;
        String[][] s = new String[tamanno][10];
        for (int i = 0; i < ciclos.get(i).getSizeModulos(); i++) {
            s = ciclos.get(i).getModulos();
            tamanno = tamanno + ciclos.get(i).getSizeModulos();
        }
        return s;
    }


}
