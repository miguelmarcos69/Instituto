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

    public String[][] getAlumnosAsignatura(String nombreAsignatura) {

        String[][] alumn = new String[10][2];
        int contador = 0;

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i) instanceof Alumno) {
                Alumno a = (Alumno) usuarios.get(i);
                if (a.tieneModulo(nombreAsignatura)) {

                    alumn[contador][0] = a.getNombre();
                    alumn[contador][1] = a.getDNI();
                    contador++;

                }
                
            }
        }

        return alumn;
    }

    public Modulo getModuloNombre(Curso c, String nombre) {

        Modulo buscado = null;

        for (int i = 0; i < cursos.size(); i++) {

            if (cursos.get(i).getNombre().equals(c.getNombre()) && cursos.get(i).getAnno() == c.getAnno()) {

                buscado = cursos.get(i).buscarModulo(nombre);
            }
        }

        return buscado;
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

    public String getNombreAlumnosAsignatura(String nom, int n) {

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

    //calcula la nota final del alumno
    public int calcularNotaFinal(String nombreAl, String mod) {
        int fin = 0;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Alumno) {
                if (usuario.getNombre().equals(nombreAl)) {
                    System.out.println("Usuario enconrado");
                    Alumno a = (Alumno) usuario;// convertir el suauario en alumno
                    for (int i = 0; i <= a.getNotasArray(mod).size(); i++) {
                        if (a.getNotasArray(mod).get(i).getModulo().equals(mod)) {

                            int num1 = a.getNotasArray(mod).get(0).getNota();
                            int num2 = a.getNotasArray(mod).get(1).getNota();
                            int num3 = a.getNotasArray(mod).get(2).getNota();
                            int media = a.getNotasArray(mod).size();
                            int suma = num1 + num2 + num3;
                            if (num1 >= 1 && num2 >= 1 && num3 >= 1) {
                                System.out.println("a");
                                fin = suma / media;
                                break;

                            } else {
                                fin = 0;
                            }

                        }

                    }

                }

            }

        }
        System.out.println("Media: " + fin);
        return fin;

    }

    public void borrarNotas(String nombre, String nombreModulo) {
        try {
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Alumno) {
                    if (usuario.getNombre().equals(nombre)) {
                        System.out.println("Usuario enconrado");
                        Alumno a = (Alumno) usuario;// convertir el suauario en alumno
                        for (int i = 0; i <= a.getNotasArray(nombreModulo).size(); i++) {
                            if (a.getNotasArray(nombreModulo).get(i).getModulo().equals(nombreModulo)) {

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

    public String modificarNotas(String modulo, String alum, Nota nota1, Nota nota2, Nota nota3) {

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
            } else {

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

        String[][] arrayCiclos = new String[nModulos][2];

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
        String[][] s = new String[this.buscarCurso(nombre, ano).getSizeModulos()][4];

        for (int i = 0; i < cursos.size(); i++) {

            if (cursos.get(i).getNombre().equals(nombre) && cursos.get(i).getAnno() == ano) {
                s = cursos.get(i).getModulos();
                i = cursos.size();
            }

        }
        return s;
    }

    //Metodo para llamar a todos los modulos y obtener sus asignaturas
    public String[][] getModulosTot() {
        int nModulos = 0;
        for (int i = 0; i < cursos.size(); i++) {

            nModulos += cursos.get(i).getSizeModulos();
        }
        String[][] arrayModulos = new String[nModulos][4];
        int contador = 0;

        for (int i = 0; i < cursos.size(); i++) {

            for (int j = 0; j < cursos.get(i).getArrayListModulos().size(); j++) {

                arrayModulos[contador][0] = cursos.get(i).getArrayListModulos().get(j).getNombre();
                arrayModulos[contador][1] = cursos.get(i).getArrayListModulos().get(j).getHoras_semana() + "";
                arrayModulos[contador][2] = cursos.get(i).getNombre();
                arrayModulos[contador][3] = cursos.get(i).getAnno() + "";
                contador++;

            }
        }

        return arrayModulos;
    }

    public boolean existeCuros(String nombre) {
        boolean resultado = false;

        for (int i = 0; i < cursos.size(); i++) {

            if (cursos.get(i).getNombre().equals(nombre)) {

                //System.out.println(cursos.get(i).getNombre());
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
        System.out.println(nombre);
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

    public Curso buscarCurso(String nombre, int ano) {

        Curso buscado = null;

        for (int i = 0; i < cursos.size(); i++) {

            if (cursos.get(i).getNombre().equals(nombre) && cursos.get(i).getAnno() == ano) {

                buscado = cursos.get(i);
                i = cursos.size();
            }
        }

        return buscado;

    }

}
