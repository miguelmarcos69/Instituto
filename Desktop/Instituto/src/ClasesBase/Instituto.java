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
import java.util.Arrays;

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
    private ArrayList<Curso> cursos;
    private String nombre;
    private String direccion;
    private String telefono; // para el manejo de datos se usa String

    public Instituto(ArrayList<Usuario> usuario, ArrayList<Curso> ciclos, String nombre, String direccion, String telefono) {
        this.usuarios = usuario;
        this.cursos = ciclos;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Instituto(String nombre, String direccion, String telefono) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuarios = new ArrayList();
        this.cursos = new ArrayList();
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

    public int getUsuariosSize() {

        return usuarios.size();
    }

    public int getCiclosSize() {

        return cursos.size();
    }

    public  Modulo buscarModuloNombre(String nombreModulo) {

        Modulo m = null;

        for (int i = 0; i < cursos.size(); i++) {

            m = cursos.get(i).getModulo(nombreModulo);

            if (m != null) {

                i = cursos.size();
            }
        }

        return m;
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
            if (usuarios.get(i) instanceof Alumno) {
                Alumno al = (Alumno) usuarios.get(i);
                if (usuarios.get(i).getNombre().equals(nomAlumn)) {

                    alum = al.getANotas(nombreMod);
                } else {

                }
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

    public void borrarNotas(String nombre, String nombreModulo) {
        try {
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Alumno) {
                    if (usuario.getNombre().equals(nombre)) {
                        System.out.println("Usuario enconrado");
                        Alumno a = (Alumno) usuario;// convertir el suauario en alumno
                        for (int i = 0; i <= a.getNotas().size(); i++) {
                            if (a.getNotas().get(i).getModulo().equals(nombreModulo)) {

                                a.getNotas().remove(i);
                                i = i - 1;

                            }

                        }

                    }

                }

            }
        } catch (IndexOutOfBoundsException nohaynotas) {

        }

    }

    public String ModificarNotas(String modulo, String alum, Nota nota1, Nota nota2, Nota nota3) {

        String al = null;

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i) instanceof Alumno) {
                Alumno a = (Alumno) usuarios.get(i);
                if (a.getNombre().equals(alum)) {

                    a.annadirNotas(nota1);
                    a.annadirNotas(nota2);
                    a.annadirNotas(nota3);

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

            } else if (u instanceof Alumno) {
                arrayUsuarios[i][0] = "Alumno";
            }else{
            
                arrayUsuarios[i][0] = "Administrador";
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

        String[][] arrayCiclos = new String[cursos.size()][10];
        for (int i = 0; i < cursos.size(); i++) {

            Curso c = (Curso) cursos.get(i);
            arrayCiclos[i] = c.toArrayString();
        }

        return arrayCiclos;
    }

    //Lo mismo pero filtrando por año
    public String[][] getCicloTot(int annoCic) {

        int nModulos = 0;

        for (int i = 0; i < cursos.size(); i++) {
            Curso c = (Curso) cursos.get(i);
            if (c.getAnno() == annoCic) {
                nModulos++;
            }
        }

        String[][] arrayCiclos = new String[nModulos][10];

        int contador = 0;

        for (int i = 0; i < cursos.size(); i++) {
            Curso c = (Curso) cursos.get(i);
            if (c.getAnno() == annoCic) {
                arrayCiclos[contador++] = c.toArrayString();
            }
        }

        return arrayCiclos;
    }

    //Encontrar un ciclo filttrando por nombre y año
    public Curso getCicloNombre(String nombre, int ano) {

        Curso buscado = null;

        for (int i = 0; i < cursos.size(); i++) {

            if (cursos.get(i).getNombre().equals(nombre) && cursos.get(i).getAnno() == ano) {

                buscado = cursos.get(i);
            }
        }

        return buscado;
    }

    //Adquirir todos los modulos
    public ArrayList<Modulo> obtenerTodosModulos() {
        ArrayList<Modulo> listaModulos = new ArrayList();

        for (int i = 0; i < cursos.size(); i++) {

            listaModulos = cursos.get(i).concatenarModulos(listaModulos);
        }

        return listaModulos;

    }

    //Encontrar un modulo filtrando por nombre y horas semanales
    public Modulo getModuloNombreHor(String nombre, int horasSem) {
        Modulo buscado = null;
        ArrayList<Modulo> listaModulos = new ArrayList();
        listaModulos = obtenerTodosModulos();
        for (int i = 0; i < listaModulos.size(); i++) {
            if (listaModulos.get(i).getNombre().equals(nombre) && listaModulos.get(i).getHoras_semana() == horasSem) {
                buscado = listaModulos.get(i);
            }
        }
        return buscado;

    }

    //Metodo para ir al ciclo seleccionado y llmar al metodo de obtener modulos
    public String[][] getModulosCic(String nombre, int ano) {
        int tamanno = 0;
        String[][] s = new String[tamanno][10];
        for (int i = 0; i < cursos.size(); i++) {

            if (cursos.get(i).getNombre().equals(nombre) && cursos.get(i).getAnno() == ano) {
                tamanno = tamanno + cursos.get(i).getSizeModulos();
                s = cursos.get(i).getModulos();
            }

        }
        return s;
    }

    //Metodo para llamar a todos los modulos y obtener sus asignaturas
    public String[][] getModulosTot() {

        ArrayList<Modulo> listaModulos = new ArrayList();

        for (int i = 0; i < cursos.size(); i++) {

            listaModulos = cursos.get(i).concatenarModulos(listaModulos);
        }

        String[][] arrayModulos = new String[listaModulos.size()][2];

        for (int i = 0; i < listaModulos.size(); i++) {

            arrayModulos[i] = listaModulos.get(i).toArrayString();
        }

        return arrayModulos;
    }
    
      public boolean existeCuros(String nombre) {
        boolean resultado = false;

        for (int i = 0; i <cursos.size(); i++) {

            if (cursos.get(i).getNombre().equals(nombre)) {
                
                System.out.println(cursos.get(i).getNombre());

                resultado = true;
            }
        }

        return resultado;
    }

    public void annadirUsuario(Usuario a) {

        usuarios.add(a);
    }

    public void annadirCiclo(Curso a) {

        cursos.add(a);
    }

    public Alumno buscarAlumno(String nombre) {

        Alumno a = null;

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getNombre().equals(nombre)) {

                a = (Alumno) usuarios.get(i);
                i = usuarios.size();
            }
        }

        return a;
    }

    public int getNAlumnosCurso(String modulo) {

        int nAlumnos = 0;

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i) instanceof Alumno) {

                if (((Alumno) usuarios.get(i)).getNombre().equals(modulo)) {

                    nAlumnos++;
                }
            }
        }

        return nAlumnos;
    }

    public Usuario buscarUsuario(String nombre) {

        Usuario buscado = null;

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getNombre().equals(nombre)) {

                buscado = usuarios.get(i);
                i = usuarios.size();
            }
        }

        return buscado;

    }

    public void eliminarUsuario(String nombre) {

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getNombre().equals(nombre)) {

                usuarios.remove(i);
                i = usuarios.size();
            }
        }
    }
    
     public Curso buscarCurso(String nombre){
    
        Curso buscado = null;
        
        for (int i=0;i<cursos.size();i++){
        
            if(cursos.get(i).getNombre().equals(nombre)){
            
                buscado=cursos.get(i);
                i=cursos.size();
            }
        }
        
        return buscado;
        
    }
    
  
}
