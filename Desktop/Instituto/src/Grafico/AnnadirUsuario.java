package Grafico;

import BaseDatos.DAOInstituto2;
import ClasesBase.Curso;
import ClasesBase.Instituto;
import ClasesBase.Modulo;
import Usuarios.Administrador;
import Usuarios.Alumno;
import Usuarios.Profesor;
import Usuarios.Usuario;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AnnadirUsuario extends javax.swing.JDialog {

    int xMouse;
    int yMouse;
    Instituto insti;
    Administrador admin;
    boolean modificando = false;
    String cabecera[] = {"Nombre", "Curso"};
    String cabeceraModulo[] = {"Nombre", "Horas semanales", "Ciclo", "Año"};
    DefaultTableModel tabla;

    //CONSTRUCTOR (GENERACION AL INICIO)
    public AnnadirUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(false);
        jPanelAlumno.setVisible(false);
        this.setSize(567, 300);

    }

    public AnnadirUsuario(java.awt.Frame parent, boolean modal, Instituto i, Administrador a) {
        super(parent, modal);
        initComponents();
        this.admin = a;
        this.insti = i;

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(false);
        jPanelAlumno.setVisible(false);
        this.setSize(567, 300);

    }

    class jPanelGardient extends JPanel {

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(221, 0, 255);
            Color color2 = new Color(255, 162, 0);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
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

    public Date getFechaNacimiento() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;

        fecha = sdf.parse(jTextFieldFechaNacimiento.getText());//LLamar al metodo para converir String en Date

        return fecha;
    }

    public String getContrasenna() {
        return jPasswordFieldContra.getText();
    }

    public void setInstituto(Instituto i) {
        this.insti = i;
    }

    public void setAdministrador(Administrador a) {
        this.admin = a;
    }

    //CONVERTIR STRING EN DATE
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
        jCalendarTheme1 = new com.toedter.plaf.JCalendarTheme();
        jPanel1 = new jPanelGardient();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelTipoUsuario = new javax.swing.JPanel();
        jRadioButtonProfesor = new javax.swing.JRadioButton();
        jRadioButtonAlumno = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanelDatos = new jPanelGardient();
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
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 103, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Añadir Usuarios");

        jPanelTipoUsuario.setBackground(new java.awt.Color(0, 0, 0));

        buttonGroupTipoUsuario.add(jRadioButtonProfesor);
        jRadioButtonProfesor.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonProfesor.setText("Profesor");
        jRadioButtonProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonProfesorActionPerformed(evt);
            }
        });

        buttonGroupTipoUsuario.add(jRadioButtonAlumno);
        jRadioButtonAlumno.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonAlumno.setText("Alumno");
        jRadioButtonAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAlumnoActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Elija el tipo de usuario:");

        javax.swing.GroupLayout jPanelTipoUsuarioLayout = new javax.swing.GroupLayout(jPanelTipoUsuario);
        jPanelTipoUsuario.setLayout(jPanelTipoUsuarioLayout);
        jPanelTipoUsuarioLayout.setHorizontalGroup(
            jPanelTipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoUsuarioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jRadioButtonProfesor)
                .addGap(53, 53, 53)
                .addComponent(jRadioButtonAlumno)
                .addContainerGap(95, Short.MAX_VALUE))
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

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_undo_50px_1.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanelTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelDatos.setBackground(new java.awt.Color(204, 204, 255));

        jPanelDatosCoumnes.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre: ");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DNI:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Nacimiento:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contraseña:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
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

        jTextFieldFechaNacimiento.setText("yyyy-MM-dd");
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

        jPanelProfesor.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("¿Qué asignaturas desea ver?");

        buttonGroupVerAsignaturas.add(jRadioButtonTodasAsig);
        jRadioButtonTodasAsig.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonTodasAsig.setText("Todas");
        jRadioButtonTodasAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTodasAsigActionPerformed(evt);
            }
        });

        buttonGroupVerAsignaturas.add(jRadioButtonCicloAsig);
        jRadioButtonCicloAsig.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCicloAsig.setText("De un ciclo concreto");
        jRadioButtonCicloAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCicloAsigActionPerformed(evt);
            }
        });

        jPanelSeleccion.setBackground(new java.awt.Color(0, 0, 0));
        jPanelSeleccion.setForeground(new java.awt.Color(0, 0, 0));

        jPanelSeleccionCiclo.setBackground(new java.awt.Color(0, 0, 0));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("¿Qué ciclos desa ver?");

        buttonGroupVerAnno.add(jRadioButtonVerTodosP);
        jRadioButtonVerTodosP.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonVerTodosP.setText("Todos");
        jRadioButtonVerTodosP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerTodosPActionPerformed(evt);
            }
        });

        buttonGroupVerAnno.add(jRadioButtonVerA1P);
        jRadioButtonVerA1P.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonVerA1P.setText("Sólo primer año");
        jRadioButtonVerA1P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerA1PActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jTableVerCicloP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
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
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBuscarAsig, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
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
        jRadioButtonVerA2P.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGap(0, 38, Short.MAX_VALUE))
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
                        .addGap(122, 122, 122)
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

        jPanelMostrarAsig.setBackground(new java.awt.Color(0, 0, 0));

        jTableElegirAsignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGroup(jPanelMostrarAsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMostrarAsigLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelMostrarAsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addGroup(jPanelMostrarAsigLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jButtonAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))))
                    .addGroup(jPanelMostrarAsigLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMostrarAsigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfesorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfesorLayout.createSequentialGroup()
                        .addComponent(jRadioButtonTodasAsig)
                        .addGap(69, 69, 69)
                        .addComponent(jRadioButtonCicloAsig)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProfesorLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(174, 174, 174))))
            .addGroup(jPanelProfesorLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jPanelSeleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAlumno.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("¿Qué cursos desa ver?");

        buttonGroupVerAnno.add(jRadioButtonVerTodosA);
        jRadioButtonVerTodosA.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonVerTodosA.setText("Todos");
        jRadioButtonVerTodosA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerTodosAActionPerformed(evt);
            }
        });

        buttonGroupVerAnno.add(jRadioButtonVerA1A);
        jRadioButtonVerA1A.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonVerA1A.setText("Sólo primer año");
        jRadioButtonVerA1A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerA1AActionPerformed(evt);
            }
        });

        buttonGroupVerAnno.add(jRadioButtonVerA2A);
        jRadioButtonVerA2A.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonVerA2A.setText("Sólo segundo año");
        jRadioButtonVerA2A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVerA2AActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jTableVerCicloA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInscribir))
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
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonVerTodosA)
                    .addComponent(jRadioButtonVerA1A)
                    .addComponent(jRadioButtonVerA2A))
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDatosCoumnes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProfesor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanelDatosCoumnes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
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

            if (!(jTextFieldDNI.getText().length() == 0)) {

                if (jTableVerCicloA.getSelectedRow() != -1) {

                    String nombreC = jTableVerCicloA.getValueAt(jTableVerCicloA.getSelectedRow(), 0).toString();
                    int annoC = Integer.parseInt(jTableVerCicloA.getValueAt(jTableVerCicloA.getSelectedRow(), 1).toString());
                    ContrasennaValida();

                    if (ContrasennaValida() == true) {

                        if (insti.getNAlumnosCurso(nombreC) < insti.getCicloNombre(nombreC, annoC).getPlazas()) {
                            try {
                                annadir = new Alumno(getNombre(), getContrasenna(), getDNI(), getFechaNacimiento(), insti.getCicloNombre(nombreC, annoC));
                                DAOInstituto2.instancia().annadirUsuario(insti.getNombre(), annadir);

                                insti.annadirUsuario(annadir);
                                JOptionPane.showMessageDialog(null, "Inscrito con exito");

                                AnnadirUsuario an = new AnnadirUsuario(null, true, insti, admin);
                                this.setVisible(false);
                                an.setVisible(true);

                            } catch (ParseException ex) {

                                JOptionPane.showMessageDialog(getContentPane(), "Porfavor introduce una fecha con el formato especificado yyyy-MM-dd",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (SQLIntegrityConstraintViolationException s) {

                                JOptionPane.showMessageDialog(getContentPane(), "El usuario con nombre  " + annadir.getNombre() + " ya existe",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            } catch (SQLException e) {

                                JOptionPane.showMessageDialog(getContentPane(), "Error con la base de datos",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
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

                JOptionPane.showMessageDialog(getContentPane(), "Porfavor introduce un DNI",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            if (jTableVerCicloA.getSelectedRow() != -1) {
                String nombreC = jTableVerCicloA.getValueAt(jTableVerCicloA.getSelectedRow(), 0).toString();
                int annoC = Integer.parseInt(jTableVerCicloA.getValueAt(jTableVerCicloA.getSelectedRow(), 1).toString());
                ContrasennaValida();
                if (ContrasennaValida() == true) {
                    if (!(jTextFieldDNI.getText().length() == 0)) {
                        if (insti.getNAlumnosCurso(nombreC) < insti.getCicloNombre(nombreC, annoC).getPlazas()) {
                            try {
                                annadir = new Alumno(getNombre(), getDNI(), getContrasenna(), getFechaNacimiento(), insti.getCicloNombre(nombreC, annoC));
                                DAOInstituto2.instancia().modificarAlumno(insti.getNombre(), annadir);
                                this.setSize(567, 300);
                                JOptionPane.showMessageDialog(this, "Modificacion realizada con exito");

                                jManejarUsuarios an = new jManejarUsuarios(insti, admin);
                                this.setVisible(false);
                                an.setVisible(true);

                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(getContentPane(), "Porfavor introduce una fecha con el formato especificado yyyy-MM-dd",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {

                            JOptionPane.showMessageDialog(getContentPane(), "El curso esta completo",
                                    "correcto", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {

                        JOptionPane.showMessageDialog(getContentPane(), "Porfavor introduce un DNI",
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

        }

    }//GEN-LAST:event_jButtonInscribirActionPerformed

    //Ver los ciclos de segundo año
    private void jRadioButtonVerA2AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVerA2AActionPerformed

        int an = 2;
        try {
            tabla = new DefaultTableModel(insti.getCicloTot(an), cabecera);
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
            tabla = new DefaultTableModel(insti.getCicloTot(an), cabecera);
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
            tabla = new DefaultTableModel(insti.getCicloTot(), cabecera);
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

                if (!(jTextFieldDNI.getText().length() == 0)) {
                    try {
                        annadir = new Profesor(getNombre(), getContrasenna(), getDNI(), getFechaNacimiento());

                        DAOInstituto2.instancia().annadirUsuario(insti.getNombre(), annadir);

                        for (int j = 0; j < jTableAsignaturasElegidas.getModel().getRowCount(); j++) {

                            String nombreCurso = jTableAsignaturasElegidas.getModel().getValueAt(j, 2) + "";
                            int anoCurso = Integer.parseInt(jTableAsignaturasElegidas.getModel().getValueAt(j, 3) + "");
                            Curso c = insti.buscarCurso(nombreCurso, anoCurso);

                            annadir.annadirModulo(c.buscarModulo(jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + ""));
                            try {

                                DAOInstituto2.instancia().modificarprofesorModulo(annadir.getNombre(), c.buscarModulo(jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + ""), c, insti.getNombre());
                                JOptionPane.showMessageDialog(null, "Inscrito con exito");
                                AnnadirUsuario a = new AnnadirUsuario(null, true, this.insti, this.admin);
                                this.setVisible(false);
                                a.setVisible(true);

                            } catch (SQLException e) {

                                JOptionPane.showMessageDialog(getContentPane(), "Error al modificar el profesor",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        insti.annadirUsuario(annadir);
                        datosVacios();
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(getContentPane(), "Porfavor introduce una fecha con el formato especificado yyyy-MM-dd",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLIntegrityConstraintViolationException s) {

                        JOptionPane.showMessageDialog(getContentPane(), "El usuario con nombre  " + annadir.getNombre() + " ya existe",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException e) {

                        JOptionPane.showMessageDialog(getContentPane(), "Error con la base de datos",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    JOptionPane.showMessageDialog(getContentPane(), "Porfavor introduce DNI",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(getContentPane(), "Las contraseñas no coinciden",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            if (!(jTextFieldDNI.getText().length() == 0)) {

                if (ContrasennaValida() == true) {
                    try {
                        annadir = new Profesor(getNombre(), getContrasenna(), getDNI(), getFechaNacimiento());
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(getContentPane(), "Porfavor introduce una fecha con el formato especificado yyyy-MM-dd",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    insti.eliminarUsuario(annadir.getNombre());
                    insti.annadirUsuario(annadir);

                    try {

                        DAOInstituto2.instancia().eliminarModulosProfesores(jTextFieldNombre.getText(), insti.getNombre());

                        for (int j = 0; j < jTableAsignaturasElegidas.getModel().getRowCount(); j++) {

                            String nombreCurso = jTableAsignaturasElegidas.getValueAt(j, 2) + "";

                            int anno = Integer.parseInt(jTableAsignaturasElegidas.getValueAt(j, 3) + "");

                            Curso c = insti.buscarCurso(nombreCurso, anno);

                            annadir.annadirModulo(c.buscarModulo(jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + ""));

                            DAOInstituto2.instancia().modificarprofesorModulo(annadir.getNombre(), c.buscarModulo(jTableAsignaturasElegidas.getModel().getValueAt(j, 0) + ""), c, insti.getNombre());

                        }

                        JOptionPane.showMessageDialog(this, "Modificacion realizada con exito");
                        jManejarUsuarios an = new jManejarUsuarios(insti, admin);
                        this.setVisible(false);
                        an.setVisible(true);

                        datosVacios();
                    } catch (SQLException e) {

                        JOptionPane.showMessageDialog(getContentPane(), "Error al realizar la operacion ",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "Las contraseñas no coinciden",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(getContentPane(), "Porfavor introduce un DNI",
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
            tabla = new DefaultTableModel(insti.getCicloTot(an), cabecera);
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
                tabla = new DefaultTableModel(insti.getModulosCic(nombreC, annoC), cabeceraModulo);
                jTableElegirAsignaturas.setModel(tabla);

                jPanelMostrarAsig.setVisible(true);
                this.setSize(567, 950);
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
            tabla = new DefaultTableModel(insti.getCicloTot(an), cabecera);
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
            tabla = new DefaultTableModel(insti.getCicloTot(), cabecera);
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
        tabla = new DefaultTableModel(insti.getCicloTot(), cabecera);
        jTableVerCicloP.setModel(tabla);
        jRadioButtonVerTodosP.setSelected(true);
        this.setSize(567, 650);
    }//GEN-LAST:event_jRadioButtonCicloAsigActionPerformed

    //Todas
    private void jRadioButtonTodasAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTodasAsigActionPerformed

        tabla = new DefaultTableModel(insti.getModulosTot(), cabeceraModulo);
        jTableElegirAsignaturas.setModel(tabla);
        jPanelMostrarAsig.setVisible(true);
        jPanelSeleccionCiclo.setVisible(false);
        this.setSize(567, 700);
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
        jTableVerCicloA.setModel(new DefaultTableModel(insti.getCicloTot(), cabecera));

        jRadioButtonVerTodosA.setVisible(false);
        jRadioButtonVerA1A.setVisible(false);
        jRadioButtonVerA2A.setVisible(false);
        this.setSize(567, 550);

    }//GEN-LAST:event_jRadioButtonAlumnoActionPerformed

    //BOTON ELEGIR PROFESOR
    private void jRadioButtonProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonProfesorActionPerformed

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(true);
        jPanelAlumno.setVisible(false);
        jPanelMostrarAsig.setVisible(false);
        jPanelSeleccionCiclo.setVisible(false);
        this.setSize(567, 400);
    }//GEN-LAST:event_jRadioButtonProfesorActionPerformed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        jManejarUsuarios m = new jManejarUsuarios(this.insti, this.admin);
        this.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

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
            java.util.logging.Logger.getLogger(AnnadirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnnadirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnnadirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnnadirUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnnadirUsuario dialog = new AnnadirUsuario(new javax.swing.JFrame(), true);
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

        this.jPasswordFieldContra.setText(a.getContra());
        this.jPasswordFieldRepetirContra.setText(a.getContra());

        jRadioButtonVerTodosA.setSelected(true);
        jRadioButtonVerTodosA.setEnabled(false);

        jRadioButtonAlumno.setSelected(true);

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(false);
        jPanelAlumno.setVisible(true);
        jTableVerCicloA.setModel(new DefaultTableModel(insti.getCicloTot(), cabecera));

        jRadioButtonVerTodosA.setVisible(false);
        jRadioButtonVerA1A.setVisible(false);
        jRadioButtonVerA2A.setVisible(false);

        jPanelDatosCoumnes.setVisible(true);
        jPanelAlumno.setVisible(true);

        jRadioButtonAlumno.setEnabled(false);
        jRadioButtonProfesor.setEnabled(false);
        this.setSize(567, 550);

        try {

            if (a.aprobado()) {

                tabla = new DefaultTableModel(insti.getCicloTot(1), cabecera);
                String[] segundo = new String[2];
                segundo[0] = a.getCiclo().getNombre();
                segundo[1] = a.getCiclo().getAnno() + "";
                tabla.addRow(segundo);
                jTableVerCicloA.setModel(tabla);
            } else {
                jTableVerCicloA.setModel(new DefaultTableModel(insti.getCicloTot(1), cabecera));
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
        this.jPasswordFieldContra.setText(p.getContra());
        this.jPasswordFieldRepetirContra.setText(p.getContra());

        jTextFieldFechaNacimiento.setText(p.getFecha_nacimiento());
        jTextFieldFechaNacimiento.setEditable(false);

        jRadioButtonAlumno.setEnabled(false);
        jRadioButtonProfesor.setEnabled(false);

        jPanelDatosCoumnes.setVisible(true);
        jPanelProfesor.setVisible(true);

        jRadioButtonAlumno.setSelected(false);
        jRadioButtonProfesor.setSelected(true);

        jPanelProfesor.setVisible(true);
        jPanelAlumno.setVisible(false);
        jRadioButtonTodasAsig.setSelected(true);

        this.setSize(567, 400);

        jTableAsignaturasElegidas.setModel(new DefaultTableModel(p.getModulosInpartidos(insti), cabeceraModulo));

    }

    public void datosVacios() {

        jTextFieldNombre.setText("");
        jTextFieldDNI.setText("");
        jTextFieldFechaNacimiento.setText("yyyy-MM-dd");
        jPasswordFieldContra.setText("");
        jPasswordFieldRepetirContra.setText("");

        jPanelDatosCoumnes.setVisible(false);
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
    private com.toedter.plaf.JCalendarTheme jCalendarTheme1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
