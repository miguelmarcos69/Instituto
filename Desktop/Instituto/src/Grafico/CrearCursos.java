/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import BaseDatos.ConexionDefault;
import BaseDatos.DAOInstituto2;
import BaseDatos.DaoInstituto;
import ClasesBase.Curso;
import ClasesBase.Instituto;
import ClasesBase.Modulo;
import Usuarios.Administrador;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author abili
 */
public class CrearCursos extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    //atributos
    Instituto instituto;
    Administrador admin;

    public CrearCursos() {
        initComponents();
        jPanelCrearModulos.setVisible(false);
    }

    public CrearCursos(Instituto i, Administrador admin) {
        initComponents();
        jPanelCrearModulos.setVisible(false);
        this.instituto = i;
        this.admin = admin;
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

    public CrearCursos(Instituto i) {
        this.instituto = i;
        initComponents();
        jPanelCrearModulos.setVisible(false);
        //llamamos a Dao y creamos la conexion
        ConexionDefault.crearConexion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 =  new jPanelGardient();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jNombreCurso = new javax.swing.JTextField();
        jNPlazas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCrearCursos = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jAnno = new javax.swing.JTextField();
        jPanelCrearModulos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JNombreModulo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jHorasSemana = new javax.swing.JTextField();
        jAnnadirModulo = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCodigoAula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear Cursos");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_undo_50px_1.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234)
                .addComponent(jLabel1)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Elige el nombre del curso ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero de plazas");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));
        jPanel3.add(jNombreCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 260, -1));
        jPanel3.add(jNPlazas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 260, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Escribe si es primero o segundo");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jCrearCursos.setBackground(new java.awt.Color(0, 0, 0));
        jCrearCursos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jCrearCursos.setForeground(new java.awt.Color(255, 255, 255));
        jCrearCursos.setText("Crear Curso");
        jCrearCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCrearCursosActionPerformed(evt);
            }
        });
        jPanel3.add(jCrearCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel3.add(jAnno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 690, 260));

        jPanelCrearModulos.setBackground(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel6.setText("Creacion de Modulos");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre del Modulo");

        JNombreModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JNombreModuloActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Escribe horas a la semana ");

        jAnnadirModulo.setBackground(new java.awt.Color(0, 0, 0));
        jAnnadirModulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jAnnadirModulo.setForeground(new java.awt.Color(255, 255, 255));
        jAnnadirModulo.setText("Añadir");
        jAnnadirModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAnnadirModuloActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Escribe el codigo del aula");

        javax.swing.GroupLayout jPanelCrearModulosLayout = new javax.swing.GroupLayout(jPanelCrearModulos);
        jPanelCrearModulos.setLayout(jPanelCrearModulosLayout);
        jPanelCrearModulosLayout.setHorizontalGroup(
            jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearModulosLayout.createSequentialGroup()
                .addGroup(jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCrearModulosLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel6))
                    .addGroup(jPanelCrearModulosLayout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jAnnadirModulo))
                    .addGroup(jPanelCrearModulosLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))))
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearModulosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanelCrearModulosLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JNombreModulo, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(jCodigoAula)
                            .addComponent(jHorasSemana))))
                .addGap(78, 78, 78))
        );
        jPanelCrearModulosLayout.setVerticalGroup(
            jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearModulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JNombreModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jCodigoAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCrearModulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jHorasSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(27, 27, 27)
                .addComponent(jAnnadirModulo)
                .addGap(40, 40, 40))
        );

        jPanel1.add(jPanelCrearModulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 690, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCrearCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCrearCursosActionPerformed

        //creamos el curso con los parametros dados
        Curso cursos = new Curso(jNombreCurso.getText(), Integer.parseInt(jNPlazas.getText()), Integer.parseInt(jAnno.getText()));
        //buscar si existe  el  modulo

        if (instituto.existeCuros(jNombreCurso.getText())) {
            jNombreCurso.setText("");
            jNPlazas.setText("");
            jAnno.setText("");
            JOptionPane.showMessageDialog(null, "Este curso ya exixtse");
        } else {

            //añade curso
            instituto.annadirCiclo(cursos);
            //hacemos visible la creacion de moulos
            jPanelCrearModulos.setVisible(true);
            try {
                DAOInstituto2.instancia().annadirCurso(instituto, cursos);
            } catch (SQLException ex) {
                Logger.getLogger(CrearCursos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jCrearCursosActionPerformed

    private void JNombreModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JNombreModuloActionPerformed

    }//GEN-LAST:event_JNombreModuloActionPerformed

    private void jAnnadirModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAnnadirModuloActionPerformed

        //creamos un modulo 
        Modulo modulos = new Modulo(JNombreModulo.getText(), jCodigoAula.getText(), Integer.parseInt(jHorasSemana.getText()));
        //buscamos lo que haya puesto el usuario como curso     
        Curso c = instituto.getCicloNombre(jNombreCurso.getText(), Integer.parseInt(jAnno.getText()));
        if (c.existeModulo(JNombreModulo.getText())) {

            JOptionPane.showMessageDialog(null, "Este modulo ya exixtse");
        } else {
            if (c.ContarHoras(Integer.parseInt(jHorasSemana.getText()))) {
                c.anadirModulo(modulos);
                try {
                    DAOInstituto2.instancia().annadirModulo(instituto, modulos, c);
                    JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la base de datos");
                }
                JNombreModulo.setText("");
                jCodigoAula.setText("");
                jHorasSemana.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "La suma de las horas es mayor a 30");
            }
        }

    }//GEN-LAST:event_jAnnadirModuloActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        AdministradorGrafico a = new AdministradorGrafico(this.admin, this.instituto);
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);        
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();     
    }//GEN-LAST:event_jPanel1MousePressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CrearCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JNombreModulo;
    private javax.swing.JToggleButton jAnnadirModulo;
    private javax.swing.JTextField jAnno;
    private javax.swing.JTextField jCodigoAula;
    private javax.swing.JToggleButton jCrearCursos;
    private javax.swing.JTextField jHorasSemana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNPlazas;
    private javax.swing.JTextField jNombreCurso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCrearModulos;
    // End of variables declaration//GEN-END:variables
}
