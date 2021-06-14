package Grafico;

import BaseDatos.DAOInstituto2;
import ClasesBase.Curso;
import ClasesBase.Instituto;
import ClasesBase.Modulo;
import Usuarios.Alumno;
import Usuarios.Profesor;
import Usuarios.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class jAnnadirUsuario extends javax.swing.JDialog {

    Instituto i;
    boolean modificando = false;
    String cabecera[] = {"Nombre", "Curso"};
    String cabeceraModulo[] = {"Nombre", "Horas semanales", "Ciclo", "Año"};
    DefaultTableModel tabla;

    //CONSTRUCTOR (GENERACION AL INICIO)
    public jAnnadirUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(false);
        jPanelAlumno.setVisible(false);

        /*
        //Araylist para guardar asignaturas de forma local
        ArrayList<Modulo> modAnn = new ArrayList<>();

        ArrayList<Usuario> al = new ArrayList<>();
        ArrayList<Curso> c = new ArrayList<>();
        ArrayList<Modulo> mod = new ArrayList();
        ArrayList<Modulo> mod2 = new ArrayList();

        Curso primero = new Curso(mod, "DAW", 1, 1);
        Curso segundo = new Curso(mod2, "DAW", 2, 2);

        Modulo programacion = new Modulo("Programacion", "12", 2);
        Modulo entornos = new Modulo("entornos", "12", 2);
        Modulo fol = new Modulo("fol", "12", 2);
        mod.add(programacion);
        mod.add(entornos);
        mod2.add(fol);

        c.add(primero);
        c.add(segundo);

        Alumno lola = new Alumno("Lola", "lola", "1254", new Date(), primero);
        Alumno miguel = new Alumno("miguel", "miguel", "1254", new Date(), primero);
        Alumno pepe = new Alumno("pepe", "pepe", "1254", new Date(), primero);
        Alumno juan = new Alumno("juan", "juan", "1254", new Date(), segundo);

        al.add(lola);
        al.add(miguel);
        al.add(pepe);
        al.add(juan);

        this.i = new Instituto(al, c, "camino", "la que sea", "69633245");
         */
    }

    ///METODOS GET\\\
    public String getNombre() {
        return jTextFieldNombre.getText();
    }

    public void setModificando() {

        modificando = true;
    }

    public String getDNI() {
        return jTextFieldDNI.getText();
    }

    public Date getFechaNacimiento() {
        return ParseFecha(jTextFieldFechaNacimiento.getText());//LLamar al metodo para converir String en Date
    }

    public String getContrasenna() {
        return jPasswordFieldContra.getText();
    }

    public void setInstituto(Instituto i) {
        this.i = i;
    }

    //CONVERTIR STRING EN DATE
    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Introduzca un formato de fecha correcto",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return fechaDate;
    }

    //COMPROVAR SI LAS CONTRASEÑAS SON IGUALES
    public boolean ContrasennaValida() {

        boolean valida = false;

        if (jPasswordFieldContra.getText().equals(jPasswordFieldRepetirContra.getText())) {
            valida = true;
        }

        return valida;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoUsuario = new javax.swing.ButtonGroup();
        buttonGroupVerAnno = new javax.swing.ButtonGroup();
        buttonGroupVerAsignaturas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelTipoUsuario = new javax.swing.JPanel();
        jRadioButtonProfesor = new javax.swing.JRadioButton();
        jRadioButtonAlumno = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanelDatos = new javax.swing.JPanel();
        jPanelDatosCoumnes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldFechaNacimiento = new javax.swing.JTextField();
        jPasswordFieldContra = new javax.swing.JPasswordField();
        jPasswordFieldRepetirContra = new javax.swing.JPasswordField();
        jPanelProfesor = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jRadioButtonTodasAsig = new javax.swing.JRadioButton();
        jRadioButtonCicloAsig = new javax.swing.JRadioButton();
        jPanelSeleccion = new javax.swing.JPanel();
        jPanelSeleccionCiclo = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButtonVerTodosP = new javax.swing.JRadioButton();
        jRadioButtonVerA1P = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVerCicloP = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jButtonBuscarAsig = new javax.swing.JButton();
        jRadioButtonVerA2P = new javax.swing.JRadioButton();
        jPanelMostrarAsig = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableElegirAsignaturas = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAsignaturasElegidas = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanelAlumno = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButtonVerTodosA = new javax.swing.JRadioButton();
        jRadioButtonVerA1A = new javax.swing.JRadioButton();
        jRadioButtonVerA2A = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVerCicloA = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButtonInscribir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 103, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setText("Añadir Usuarios");

        jPanelTipoUsuario.setBackground(new java.awt.Color(204, 204, 255));

        buttonGroupTipoUsuario.add(jRadioButtonProfesor);
        jRadioButtonProfesor.setText("Profesor");
        jRadioButtonProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonProfesorActionPerformed(evt);
            }
        });

        buttonGroupTipoUsuario.add(jRadioButtonAlumno);
        jRadioButtonAlumno.setText("Alumno");
        jRadioButtonAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAlumnoActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Elija el tipo de usuario:");

        javax.swing.GroupLayout jPanelTipoUsuarioLayout = new javax.swing.GroupLayout(jPanelTipoUsuario);
        jPanelTipoUsuario.setLayout(jPanelTipoUsuarioLayout);
        jPanelTipoUsuarioLayout.setHorizontalGroup(
            jPanelTipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(79, 79, 79)
                .addComponent(jRadioButtonProfesor)
                .addGap(90, 90, 90)
                .addComponent(jRadioButtonAlumno)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelTipoUsuarioLayout.setVerticalGroup(
            jPanelTipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTipoUsuarioLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanelTipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonProfesor)
                    .addComponent(jRadioButtonAlumno)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanelTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanelTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 510, -1));

        jPanelDatos.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setText("Nombre: ");

        jLabel4.setText("DNI:");

        jLabel5.setText("Fecha Nacimiento:");

        jLabel7.setText("Contraseña:");

        jLabel8.setText("Repita la contraseña:");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIActionPerformed(evt);
            }
        });

        jTextFieldFechaNacimiento.setText("dia/mes/año");
        jTextFieldFechaNacimiento.setToolTipText("");

        javax.swing.GroupLayout jPanelDatosCoumnesLayout = new javax.swing.GroupLayout(jPanelDatosCoumnes);
        jPanelDatosCoumnes.setLayout(jPanelDatosCoumnesLayout);
        jPanelDatosCoumnesLayout.setHorizontalGroup(
            jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCoumnesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordFieldContra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldRepetirContra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosCoumnesLayout.setVerticalGroup(
            jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCoumnesLayout.createSequentialGroup()
                .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosCoumnesLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDatosCoumnesLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jPasswordFieldContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDatosCoumnesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jPasswordFieldRepetirContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("¿Qué asignaturas desea ver?");

        buttonGroupVerAsignaturas.add(jRadioButtonTodasAsig);
        jRadioButtonTodasAsig.setText("Todas");
        jRadioButtonTodasAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTodasAsigActionPerformed(evt);
            }
        });

        buttonGroupVerAsignaturas.add(jRadioButtonCicloAsig);
        jRadioButtonCicloAsig.setText("De un ciclo concreto");
        jRadioButtonCicloAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCicloAsigActionPerformed(evt);
            }
        });

        jLabel12.setText("¿Qué ciclos desa ver?");

        buttonGroupVerAnno.add(jRadioButtonVerTodosP);
        jRadioButtonVerTodosP.setText("Todos");
        jRadioButtonVerTodosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerTodosPActionPerformed(evt);
            }
        });

        buttonGroupVerAnno.add(jRadioButtonVerA1P);
        jRadioButtonVerA1P.setText("Sólo primer año");
        jRadioButtonVerA1P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerA1PActionPerformed(evt);
            }
        });

        jTableVerCicloP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Año"
            }
        ));
        jScrollPane2.setViewportView(jTableVerCicloP);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jLabel13.setText("Seleccione en la tabla el curso del que desee ver sus asignaturas");

        jButtonBuscarAsig.setText("BUSCAR");
        jButtonBuscarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAsigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarAsig)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroupVerAnno.add(jRadioButtonVerA2P);
        jRadioButtonVerA2P.setText("Sólo segundo año");
        jRadioButtonVerA2P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerA2PActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSeleccionCicloLayout = new javax.swing.GroupLayout(jPanelSeleccionCiclo);
        jPanelSeleccionCiclo.setLayout(jPanelSeleccionCicloLayout);
        jPanelSeleccionCicloLayout.setHorizontalGroup(
            jPanelSeleccionCicloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionCicloLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
            .addGroup(jPanelSeleccionCicloLayout.createSequentialGroup()
                .addGroup(jPanelSeleccionCicloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSeleccionCicloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonVerTodosP)
                        .addGap(28, 28, 28)
                        .addComponent(jRadioButtonVerA1P)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonVerA2P))
                    .addGroup(jPanelSeleccionCicloLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSeleccionCicloLayout.setVerticalGroup(
            jPanelSeleccionCicloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionCicloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanelSeleccionCicloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonVerTodosP)
                    .addComponent(jRadioButtonVerA1P)
                    .addComponent(jRadioButtonVerA2P))
                .addGap(38, 38, 38)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableElegirAsignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Horas semanales", "Curso", "Año"
            }
        ));
        jTableElegirAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableElegirAsignaturasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableElegirAsignaturas);

        jLabel14.setText("Seleccione la asignatura que desee añadir:");

        jTableAsignaturasElegidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Horas semanales", "Curso", "Año"
            }
        ));
        jTableAsignaturasElegidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAsignaturasElegidasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableAsignaturasElegidas);

        jLabel15.setText("Asignaturas añadidas:");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMostrarAsigLayout = new javax.swing.GroupLayout(jPanelMostrarAsig);
        jPanelMostrarAsig.setLayout(jPanelMostrarAsigLayout);
        jPanelMostrarAsigLayout.setHorizontalGroup(
            jPanelMostrarAsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarAsigLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelMostrarAsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addGroup(jPanelMostrarAsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanelMostrarAsigLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButtonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanelMostrarAsigLayout.setVerticalGroup(
            jPanelMostrarAsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarAsigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanelMostrarAsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButton3)))
        );

        javax.swing.GroupLayout jPanelSeleccionLayout = new javax.swing.GroupLayout(jPanelSeleccion);
        jPanelSeleccion.setLayout(jPanelSeleccionLayout);
        jPanelSeleccionLayout.setHorizontalGroup(
            jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMostrarAsig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelSeleccionCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelSeleccionLayout.setVerticalGroup(
            jPanelSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSeleccionCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMostrarAsig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelProfesorLayout = new javax.swing.GroupLayout(jPanelProfesor);
        jPanelProfesor.setLayout(jPanelProfesorLayout);
        jPanelProfesorLayout.setHorizontalGroup(
            jPanelProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfesorLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jPanelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfesorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfesorLayout.createSequentialGroup()
                        .addComponent(jRadioButtonTodasAsig)
                        .addGap(101, 101, 101)
                        .addComponent(jRadioButtonCicloAsig)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfesorLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(174, 174, 174))))
        );
        jPanelProfesorLayout.setVerticalGroup(
            jPanelProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProfesorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonTodasAsig)
                    .addComponent(jRadioButtonCicloAsig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("¿Qué cursos desa ver?");

        buttonGroupVerAnno.add(jRadioButtonVerTodosA);
        jRadioButtonVerTodosA.setText("Todos");
        jRadioButtonVerTodosA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerTodosAActionPerformed(evt);
            }
        });

        buttonGroupVerAnno.add(jRadioButtonVerA1A);
        jRadioButtonVerA1A.setText("Sólo primer año");
        jRadioButtonVerA1A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerA1AActionPerformed(evt);
            }
        });

        buttonGroupVerAnno.add(jRadioButtonVerA2A);
        jRadioButtonVerA2A.setText("Sólo segundo año");
        jRadioButtonVerA2A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerA2AActionPerformed(evt);
            }
        });

        jTableVerCicloA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Año"
            }
        ));
        jScrollPane1.setViewportView(jTableVerCicloA);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jLabel10.setText("Seleccione en la tabla el curso al que se va ha inscribir");

        jButtonInscribir.setText("INSCRIBIR");
        jButtonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInscribirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInscribir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelAlumnoLayout = new javax.swing.GroupLayout(jPanelAlumno);
        jPanelAlumno.setLayout(jPanelAlumnoLayout);
        jPanelAlumnoLayout.setHorizontalGroup(
            jPanelAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlumnoLayout.createSequentialGroup()
                .addGroup(jPanelAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAlumnoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlumnoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlumnoLayout.createSequentialGroup()
                                .addComponent(jRadioButtonVerTodosA)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonVerA1A)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonVerA2A))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlumnoLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(95, 95, 95)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAlumnoLayout.setVerticalGroup(
            jPanelAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlumnoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonVerTodosA)
                    .addComponent(jRadioButtonVerA1A)
                    .addComponent(jRadioButtonVerA2A))
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelProfesor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatosCoumnes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanelDatosCoumnes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 530, 1100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BOTON AÑADIR modulos selecconados
    private void jButtonAnnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnadirActionPerformed

        try {
            String nombreM = jTableElegirAsignaturas.getValueAt(jTableElegirAsignaturas.getSelectedRow(), 0).toString();
            int horasM = Integer.parseInt(jTableElegirAsignaturas.getValueAt(jTableElegirAsignaturas.getSelectedRow(), 1).toString());

            String[][] modulos = new String[jTableAsignaturasElegidas.getModel().getRowCount() + 1][2];

            for (int j = 0; j < jTableAsignaturasElegidas.getModel().getRowCount(); j++) {

                modulos[j][0] = jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + "";
                modulos[j][1] = jTableAsignaturasElegidas.getModel().getValueAt(j, 1) + "";
            }

            modulos[jTableAsignaturasElegidas.getModel().getRowCount()][0] = nombreM;
            modulos[jTableAsignaturasElegidas.getModel().getRowCount()][1] = horasM + "";

            jTableAsignaturasElegidas.setModel(new DefaultTableModel(modulos, cabecera));

        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(getContentPane(), "Porfavor selecciona una fila con datos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAnnadirActionPerformed

    //BOTON INSCRIBIR (da de alta un alumno)
    private void jButtonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInscribirActionPerformed
        Alumno annadir = null;

        if (modificando == false) {
            if (jTableVerCicloA.getSelectedRow() != -1) {
                String nombreC = jTableVerCicloA.getValueAt(jTableVerCicloA.getSelectedRow(), 0).toString();
                int annoC = Integer.parseInt(jTableVerCicloA.getValueAt(jTableVerCicloA.getSelectedRow(), 1).toString());
                ContrasennaValida();
                if (ContrasennaValida() == true) {
                    if (i.getNAlumnosCurso(nombreC) < i.getCicloNombre(nombreC, annoC).getPlazas()) {
                        annadir = new Alumno(getNombre(), getContrasenna(), getDNI(), getFechaNacimiento(), i.getCicloNombre(nombreC, annoC));
                        DAOInstituto2.instancia().annadirUsuario(i.getNombre(), annadir);
                        JOptionPane.showMessageDialog(null, "Inscrito con exito");
                        datosVacios();
                    } else {

                        JOptionPane.showMessageDialog(getContentPane(), "El curso esta completo",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "Las contraseñas no coinciden",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "Debe seleccionar una fila de la tabla",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            if (jTableVerCicloA.getSelectedRow() != -1) {
                String nombreC = jTableVerCicloA.getValueAt(jTableVerCicloA.getSelectedRow(), 0).toString();
                int annoC = Integer.parseInt(jTableVerCicloA.getValueAt(jTableVerCicloA.getSelectedRow(), 1).toString());
                ContrasennaValida();
                if (ContrasennaValida() == true) {
                    if (i.getNAlumnosCurso(nombreC) < i.getCicloNombre(nombreC, annoC).getPlazas()) {
                        annadir = new Alumno(getNombre(), getDNI(), getContrasenna(), getFechaNacimiento(), i.getCicloNombre(nombreC, annoC));
                        //DAOInstituto2.instancia().modificarAlumno(i.getNombre(), annadir);
                        JOptionPane.showMessageDialog(getContentPane(), "El usuario ha sido creado con exito",
                                "Error", JOptionPane.OK_OPTION);
                    } else {

                        JOptionPane.showMessageDialog(getContentPane(), "El curso esta completo",
                                "correcto", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "Las contraseñas no coinciden",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "Debe seleccionar una fila de la tabla",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_jButtonInscribirActionPerformed

    //Ver los ciclos de segundo año
    private void jRadioButtonVerA2AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVerA2AActionPerformed

        int an = 2;
        try {
            tabla = new DefaultTableModel(i.getCicloTot(an), cabecera);
            jTableVerCicloA.setModel(tabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), "No hay ciclos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jRadioButtonVerA2AActionPerformed

    //Ver los ciclos de primer año
    private void jRadioButtonVerA1AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVerA1AActionPerformed

        int an = 1;
        try {
            tabla = new DefaultTableModel(i.getCicloTot(an), cabecera);
            jTableVerCicloA.setModel(tabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), "No hay ciclos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jRadioButtonVerA1AActionPerformed

    ///BOTON GROUP ver ciclos para alumnos\\\ 
    //Ver todos los ciclos
    private void jRadioButtonVerTodosAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVerTodosAActionPerformed

        try {
            tabla = new DefaultTableModel(i.getCicloTot(), cabecera);
            jTableVerCicloA.setModel(tabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), "No hay ciclos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jRadioButtonVerTodosAActionPerformed

    //Cancelar
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Retocar esto salen todos los modulos siempre    
        int nFilas = jTableAsignaturasElegidas.getRowCount();
        for (int i = 0; i < nFilas; i++) {

            DefaultTableModel tablaSeleccionada = (DefaultTableModel) jTableAsignaturasElegidas.getModel();
            DefaultTableModel tabla = (DefaultTableModel) jTableElegirAsignaturas.getModel();
            String[] modulo = new String[4];
            modulo[0] = jTableAsignaturasElegidas.getValueAt(0, 0) + "";
            modulo[1] = jTableAsignaturasElegidas.getValueAt(0, 1) + "";
            modulo[2] = jTableAsignaturasElegidas.getValueAt(0, 2) + "";
            modulo[3] = jTableAsignaturasElegidas.getValueAt(0, 3) + "";
            tabla.addRow(modulo);

            tablaSeleccionada.removeRow(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    //AÑADIR PROFESORES
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        Profesor annadir = null;

        ArrayList modulos = new ArrayList();

        if (modificando == false) {

            if (ContrasennaValida() == true) {
                annadir = new Profesor(getNombre(), getContrasenna(), getDNI(), getFechaNacimiento());

                DAOInstituto2.instancia().annadirUsuario(i.getNombre(), annadir);

                for (int j = 0; j < jTableAsignaturasElegidas.getModel().getRowCount(); j++) {

                    annadir.annadirModulo(i.buscarModuloNombre(jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + ""));

                    String nombreCurso = jTableAsignaturasElegidas.getModel().getValueAt(j, 2) + "";
                    int anoCurso = Integer.parseInt(jTableAsignaturasElegidas.getModel().getValueAt(j, 3) + "");

                    Curso c = i.buscarCurso(nombreCurso, anoCurso);
                    DAOInstituto2.instancia().modificarprofesorModulo(annadir.getNombre(), i.buscarModuloNombre(jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + ""), c, i.getNombre());

                }
                i.annadirUsuario(annadir);
                datosVacios();
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "Las contraseñas no coinciden",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            if (ContrasennaValida() == true) {
                annadir = new Profesor(getNombre(), getContrasenna(), getDNI(), getFechaNacimiento());
                i.eliminarUsuario(annadir.getNombre());
                i.annadirUsuario(annadir);

                for (int j = 0; j < jTableAsignaturasElegidas.getModel().getRowCount(); j++) {

                    annadir.annadirModulo(i.buscarModuloNombre(jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + ""));
                    Curso c = i.buscarCurso(jTableAsignaturasElegidas.getValueAt(jTableAsignaturasElegidas.getSelectedRow(), 3) + "", Integer.parseInt(jTableAsignaturasElegidas.getValueAt(jTableAsignaturasElegidas.getSelectedRow(), 4) + ""));
                    DAOInstituto2.instancia().modificarprofesorModulo(annadir.getNombre(), i.buscarModuloNombre(jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + ""), c, i.getNombre());

                }
                i.eliminarUsuario(annadir.getNombre());
                i.annadirUsuario(annadir);

                datosVacios();
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "Las contraseñas no coinciden",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jTableAsignaturasElegidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAsignaturasElegidasMouseClicked

        DefaultTableModel tablaSeleccionada = (DefaultTableModel) jTableAsignaturasElegidas.getModel();
        DefaultTableModel tabla = (DefaultTableModel) jTableElegirAsignaturas.getModel();
        String[] modulo = new String[4];
        modulo[0] = jTableAsignaturasElegidas.getValueAt(jTableAsignaturasElegidas.getSelectedRow(), 0) + "";
        modulo[1] = jTableAsignaturasElegidas.getValueAt(jTableAsignaturasElegidas.getSelectedRow(), 1) + "";
        modulo[2] = jTableAsignaturasElegidas.getValueAt(jTableAsignaturasElegidas.getSelectedRow(), 2) + "";
        modulo[3] = jTableAsignaturasElegidas.getValueAt(jTableAsignaturasElegidas.getSelectedRow(), 3) + "";
        tabla.addRow(modulo);

        tablaSeleccionada.removeRow(jTableAsignaturasElegidas.getSelectedRow());

    }//GEN-LAST:event_jTableAsignaturasElegidasMouseClicked

    private void jTableElegirAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableElegirAsignaturasMouseClicked
        try {
            String nombreM = jTableElegirAsignaturas.getValueAt(jTableElegirAsignaturas.getSelectedRow(), 0).toString();
            int horasM = Integer.parseInt(jTableElegirAsignaturas.getValueAt(jTableElegirAsignaturas.getSelectedRow(), 1).toString());
            String nombreC = jTableElegirAsignaturas.getValueAt(jTableElegirAsignaturas.getSelectedRow(), 2).toString();
            int annoC = Integer.parseInt(jTableElegirAsignaturas.getValueAt(jTableElegirAsignaturas.getSelectedRow(), 3).toString());

            DefaultTableModel tabla = (DefaultTableModel) jTableElegirAsignaturas.getModel();
            tabla.removeRow(jTableElegirAsignaturas.getSelectedRow());

            String[][] modulos = new String[jTableAsignaturasElegidas.getModel().getRowCount() + 1][4];

            for (int j = 0; j < jTableAsignaturasElegidas.getModel().getRowCount(); j++) {

                modulos[j][0] = jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + "";
                modulos[j][1] = jTableAsignaturasElegidas.getModel().getValueAt(j, 1) + "";
                modulos[j][2] = jTableAsignaturasElegidas.getModel().getValueAt(j, 2) + "";
                modulos[j][3] = jTableAsignaturasElegidas.getModel().getValueAt(j, 3) + "";
            }

            modulos[jTableAsignaturasElegidas.getModel().getRowCount()][0] = nombreM;
            modulos[jTableAsignaturasElegidas.getModel().getRowCount()][1] = horasM + "";
            modulos[jTableAsignaturasElegidas.getModel().getRowCount()][2] = nombreC;
            modulos[jTableAsignaturasElegidas.getModel().getRowCount()][3] = annoC + "";

            jTableAsignaturasElegidas.setModel(new DefaultTableModel(modulos, cabeceraModulo));

        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(getContentPane(), "Porfavor selecciona una fila con datos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTableElegirAsignaturasMouseClicked

    //Ver los ciclos de segundo año
    private void jRadioButtonVerA2PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVerA2PActionPerformed
        int an = 2;
        try {
            tabla = new DefaultTableModel(i.getCicloTot(an), cabecera);
            jTableVerCicloP.setModel(tabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), "No hay ciclos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jRadioButtonVerA2PActionPerformed

    //BOTON BUSCAR modulos del ciclo seleccionado
    private void jButtonBuscarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAsigActionPerformed

        try {
            if (jTableVerCicloP.getSelectedRow() != -1) {
                String nombreC = jTableVerCicloP.getValueAt(jTableVerCicloP.getSelectedRow(), 0).toString();
                int annoC = Integer.parseInt(jTableVerCicloP.getValueAt(jTableVerCicloP.getSelectedRow(), 1).toString());
                tabla = new DefaultTableModel(i.getModulosCic(nombreC, annoC), cabeceraModulo);
                jTableElegirAsignaturas.setModel(tabla);

                jPanelMostrarAsig.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "Debe seleccionar una fila de la tabla",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(getContentPane(), "Porfavor selecciona una fila con datos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuscarAsigActionPerformed

    //Ver los ciclos de primer año
    private void jRadioButtonVerA1PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVerA1PActionPerformed

        int an = 1;
        try {
            tabla = new DefaultTableModel(i.getCicloTot(an), cabecera);
            jTableVerCicloP.setModel(tabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), "No hay ciclos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jRadioButtonVerA1PActionPerformed

    ///BOTON GROUP ver ciclos para profesores\\\ 
    //Ver todos los ciclos
    private void jRadioButtonVerTodosPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVerTodosPActionPerformed

        try {
            tabla = new DefaultTableModel(i.getCicloTot(), cabecera);
            jTableVerCicloP.setModel(tabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), "No hay ciclos en este centro",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jRadioButtonVerTodosPActionPerformed

    ///BOTON GROUP elegir como mostrar asignaturas\\\
    //De un ciclo concreto
    private void jRadioButtonCicloAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCicloAsigActionPerformed

        jPanelSeleccionCiclo.setVisible(true);
        jPanelMostrarAsig.setVisible(false);
        tabla = new DefaultTableModel(i.getCicloTot(), cabecera);
        jTableVerCicloP.setModel(tabla);
        jRadioButtonVerTodosP.setSelected(true);
    }//GEN-LAST:event_jRadioButtonCicloAsigActionPerformed

    //Todas
    private void jRadioButtonTodasAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTodasAsigActionPerformed

        tabla = new DefaultTableModel(i.getModulosTot(), cabeceraModulo);
        jTableElegirAsignaturas.setModel(tabla);
        jPanelMostrarAsig.setVisible(true);
        jPanelSeleccionCiclo.setVisible(false);
    }//GEN-LAST:event_jRadioButtonTodasAsigActionPerformed

    private void jTextFieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    //BOTON ELEGIR ALUMNO
    private void jRadioButtonAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAlumnoActionPerformed

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(false);
        jPanelAlumno.setVisible(true);
        jTableVerCicloA.setModel(new DefaultTableModel(i.getCicloTot(), cabecera));

        jRadioButtonVerTodosA.setVisible(false);
        jRadioButtonVerA1A.setVisible(false);
        jRadioButtonVerA2A.setVisible(false);

    }//GEN-LAST:event_jRadioButtonAlumnoActionPerformed

    //BOTON ELEGIR PROFESOR
    private void jRadioButtonProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonProfesorActionPerformed

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(true);
        jPanelAlumno.setVisible(false);
        jPanelMostrarAsig.setVisible(false);
        jPanelSeleccionCiclo.setVisible(false);
    }//GEN-LAST:event_jRadioButtonProfesorActionPerformed

    //METODO MAIN
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jAnnadirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jAnnadirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jAnnadirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jAnnadirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jAnnadirUsuario dialog = new jAnnadirUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void mostrarDatosAlumno(Alumno a) {

        jTextFieldNombre.setText(a.getNombre());
        jTextFieldNombre.setEditable(false);

        jTextFieldDNI.setText(a.getDNI());
        jTextFieldDNI.setEditable(false);

        jTextFieldFechaNacimiento.setText(a.getFecha_nacimiento());
        jTextFieldFechaNacimiento.setEditable(false);

        jRadioButtonVerTodosA.setSelected(true);
        jRadioButtonVerTodosA.setEnabled(false);

        jRadioButtonAlumno.setSelected(true);

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(false);
        jPanelAlumno.setVisible(true);
        jTableVerCicloA.setModel(new DefaultTableModel(i.getCicloTot(), cabecera));

        jRadioButtonVerTodosA.setVisible(false);
        jRadioButtonVerA1A.setVisible(false);
        jRadioButtonVerA2A.setVisible(false);

        try {

            if (a.aprobado()) {

                tabla = new DefaultTableModel(i.getCicloTot(1), cabecera);
                String[] segundo = new String[2];
                segundo[0] = a.getCiclo().getNombre();
                segundo[1] = a.getCiclo().getAnno() + "";
                tabla.addRow(segundo);
                jTableVerCicloA.setModel(tabla);
            } else {
                tabla = new DefaultTableModel(i.getCicloTot(1), cabecera);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), "No hay ciclos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mostrarDatosProfesor(Profesor p) {

        jTextFieldNombre.setText(p.getNombre());
        jTextFieldNombre.setEditable(false);

        jTextFieldDNI.setText(p.getDNI());
        jTextFieldDNI.setEditable(false);

        jTextFieldFechaNacimiento.setText(p.getFecha_nacimiento());
        jTextFieldFechaNacimiento.setEditable(false);

        jRadioButtonAlumno.setSelected(false);
        jRadioButtonProfesor.setSelected(true);

        jPanelProfesor.setVisible(true);
        jPanelAlumno.setVisible(false);

        jTableAsignaturasElegidas.setModel(new DefaultTableModel(p.getModulosInpartidos(), cabeceraModulo));

    }

    public void datosVacios() {

        jTextFieldNombre.setText("");
        jTextFieldDNI.setText("");
        jTextFieldFechaNacimiento.setText("dia/mes/año");
        jPasswordFieldContra.setText("");
        jPasswordFieldRepetirContra.setText("");

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(false);
        jPanelAlumno.setVisible(false);

        jRadioButtonVerTodosA.setVisible(false);
        jRadioButtonVerA1A.setVisible(false);
        jRadioButtonVerA2A.setVisible(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipoUsuario;
    private javax.swing.ButtonGroup buttonGroupVerAnno;
    private javax.swing.ButtonGroup buttonGroupVerAsignaturas;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBuscarAsig;
    private javax.swing.JButton jButtonInscribir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelAlumno;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelDatosCoumnes;
    private javax.swing.JPanel jPanelMostrarAsig;
    private javax.swing.JPanel jPanelProfesor;
    private javax.swing.JPanel jPanelSeleccion;
    private javax.swing.JPanel jPanelSeleccionCiclo;
    private javax.swing.JPanel jPanelTipoUsuario;
    private javax.swing.JPasswordField jPasswordFieldContra;
    private javax.swing.JPasswordField jPasswordFieldRepetirContra;
    private javax.swing.JRadioButton jRadioButtonAlumno;
    private javax.swing.JRadioButton jRadioButtonCicloAsig;
    private javax.swing.JRadioButton jRadioButtonProfesor;
    private javax.swing.JRadioButton jRadioButtonTodasAsig;
    private javax.swing.JRadioButton jRadioButtonVerA1A;
    private javax.swing.JRadioButton jRadioButtonVerA1P;
    private javax.swing.JRadioButton jRadioButtonVerA2A;
    private javax.swing.JRadioButton jRadioButtonVerA2P;
    private javax.swing.JRadioButton jRadioButtonVerTodosA;
    private javax.swing.JRadioButton jRadioButtonVerTodosP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableAsignaturasElegidas;
    private javax.swing.JTable jTableElegirAsignaturas;
    private javax.swing.JTable jTableVerCicloA;
    private javax.swing.JTable jTableVerCicloP;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldFechaNacimiento;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
