/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import BaseDatos.*;
import ClasesBase.*;
import Usuarios.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author alumno
 */
public class InicioSesion extends javax.swing.JFrame {

    private Instituto insti;
    int xMouse;
    int yMouse;
    

    /**
     * Creates new form InicioSesionç
     */
    public InicioSesion() {
        initComponents();
    }

    //colorines
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jPanelGardient();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTNombreInstituto = new javax.swing.JTextField();
        jTUsuario = new javax.swing.JTextField();
        jPConstrasena = new javax.swing.JPasswordField();
        ButtonEntrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setForeground(new java.awt.Color(102, 0, 102));
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

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Indica cual es tu instituto");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 682, -1));

        jTNombreInstituto.setBackground(new java.awt.Color(255, 255, 255));
        jTNombreInstituto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jTNombreInstituto.setText("Nombre de instituto");
        jTNombreInstituto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTNombreInstitutoMousePressed(evt);
            }
        });
        jTNombreInstituto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombreInstitutoKeyPressed(evt);
            }
        });
        jPanel1.add(jTNombreInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 319, -1));

        jTUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jTUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jTUsuario.setText("Usuario");
        jTUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTUsuarioFocusGained(evt);
            }
        });
        jTUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTUsuarioMousePressed(evt);
            }
        });
        jTUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTUsuarioActionPerformed(evt);
            }
        });
        jTUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTUsuarioKeyReleased(evt);
            }
        });
        jPanel1.add(jTUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 319, -1));

        jPConstrasena.setBackground(new java.awt.Color(255, 255, 255));
        jPConstrasena.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jPConstrasena.setText("jkdhasgh jkasdhasdkas");
        jPConstrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPConstrasenaFocusGained(evt);
            }
        });
        jPConstrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPConstrasenaMousePressed(evt);
            }
        });
        jPConstrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPConstrasenaKeyPressed(evt);
            }
        });
        jPanel1.add(jPConstrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 319, -1));

        ButtonEntrar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonEntrar.setText("Entrar");
        ButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEntrarActionPerformed(evt);
            }
        });
        ButtonEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ButtonEntrarKeyPressed(evt);
            }
        });
        jPanel1.add(ButtonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_student_male_50px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 228, -1, -1));

        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 6, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_user_50px_3.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_lock_50px_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(682, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEntrarActionPerformed
        // TODO add your handling code here:

        acceder();
    }//GEN-LAST:event_ButtonEntrarActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        System.exit(0);

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTUsuarioActionPerformed

    }//GEN-LAST:event_jTUsuarioActionPerformed

    private void jTNombreInstitutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNombreInstitutoMousePressed

        jTNombreInstituto.setText("");
    }//GEN-LAST:event_jTNombreInstitutoMousePressed

    private void jTUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsuarioMousePressed

        jTUsuario.setText("");


    }//GEN-LAST:event_jTUsuarioMousePressed

    private void jPConstrasenaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPConstrasenaMousePressed

        jPConstrasena.setText("");
    }//GEN-LAST:event_jPConstrasenaMousePressed

    private void jTNombreInstitutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreInstitutoKeyPressed

    }//GEN-LAST:event_jTNombreInstitutoKeyPressed


    private void jTUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTUsuarioKeyPressed

    }//GEN-LAST:event_jTUsuarioKeyPressed


    private void jPConstrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPConstrasenaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            acceder();
        }
    }//GEN-LAST:event_jPConstrasenaKeyPressed

    private void jTUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTUsuarioKeyReleased

    }//GEN-LAST:event_jTUsuarioKeyReleased

    private void jTUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTUsuarioFocusGained

        jTUsuario.setText("");


    }//GEN-LAST:event_jTUsuarioFocusGained

    private void jPConstrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPConstrasenaFocusGained
        jPConstrasena.setText("");
    }//GEN-LAST:event_jPConstrasenaFocusGained

    private void ButtonEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ButtonEntrarKeyPressed


     }//GEN-LAST:event_ButtonEntrarKeyPressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged


        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        
        this.setLocation(x - xMouse , y - yMouse);

    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

         xMouse = evt.getX();
         yMouse = evt.getY();

    }//GEN-LAST:event_jPanel1MousePressed

    /**
     * @param args the command line arguments
     */
    private void acceder() {

        try {
            String nombreInsti = jTNombreInstituto.getText();
            String nombre = jTUsuario.getText();
            String contra = jPConstrasena.getText();
            ConexionDefault.crearConexion();
            int tipo = DAOInstituto2.instancia().obtenerTipoUsuario(nombre, nombreInsti);

            insti = DAOInstituto2.instancia().obtenerInstituto(nombreInsti);

            if (insti != null) {

                switch (tipo) {

                    case 0:
                        Administrador admin = (Administrador) insti.buscarUsuario(nombre);//DAOInstituto2.instancia().obtenerAdministrador(nombre, nombreInsti);

                        if (admin != null) {
                            if (admin.getContrasenna().equals(contra)) {
                                AdministradorGrafico adm = new AdministradorGrafico(admin, insti);//Modificar
                                this.setVisible(false);
                                adm.mostrar(nombre);
                                adm.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta", "Inicio", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {

                            JOptionPane.showMessageDialog(rootPane, "El usuario no existe", "Inicio", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 1:
                        try {
                        Alumno alum = (Alumno) insti.buscarUsuario(nombre);//DAOInstituto2.instancia().obtenerAlumno(nombre, nombreInsti);
                        if (alum.getContrasenna().equals(contra)) {
                            AlumnoGrafico alG = new AlumnoGrafico(null, true, alum, insti);
                            this.setVisible(false);
                            alG.mostrar(nombre);
                            alG.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta", "Inicio", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NullPointerException e) {

                        JOptionPane.showMessageDialog(rootPane, "El usuario no existe", "Inicio", JOptionPane.WARNING_MESSAGE);
                    }

                    break;
                    case 2:
                        Profesor prof = (Profesor) insti.buscarUsuario(nombre);//DAOInstituto2.instancia().obtenerProfesor(nombre, nombreInsti);
                        if (prof.getContrasenna().equals(contra)) {
                            ProfesorGrafico pr = new ProfesorGrafico(prof, insti);
                            this.setVisible(false);
                            pr.mostrar(nombre);
                            pr.setVisible(true);
                        }

                        break;
                }
            } else {

                JOptionPane.showMessageDialog(rootPane, "El instituto no existe", "Inicio", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error con la base de datos", "Inicio", JOptionPane.WARNING_MESSAGE);

        }

    }

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPConstrasena;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTNombreInstituto;
    private javax.swing.JTextField jTUsuario;
    // End of variables declaration//GEN-END:variables

}
