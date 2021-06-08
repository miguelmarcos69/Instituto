/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import BaseDatos.*;
import ClasesBase.*;
import Usuarios.*;
import Grafico.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author alumno
 */
public class InicioSesion extends javax.swing.JFrame {

    private Instituto i;
    SistemaGestion sistema;

    /**
     * Creates new form InicioSesionç
     */
    public InicioSesion() {
        initComponents();
        sistema = new SistemaGestion();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jPanelGardient();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTNombreInstituto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPConstrasena = new javax.swing.JPasswordField();
        ButtonCancelar = new javax.swing.JButton();
        ButtonEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Indica cual es tu instituto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(102, 102, 102))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del instituto");

        jTNombreInstituto.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Usuario");

        jTUsuario.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Contraseña");

        jPConstrasena.setBackground(new java.awt.Color(255, 255, 255));

        ButtonCancelar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        ButtonEntrar.setBackground(new java.awt.Color(0, 0, 0));
        ButtonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        ButtonEntrar.setText("Entrar");
        ButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNombreInstituto)
                    .addComponent(jTUsuario)
                    .addComponent(jPConstrasena))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(ButtonEntrar)
                .addGap(58, 58, 58)
                .addComponent(ButtonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTNombreInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPConstrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancelar)
                    .addComponent(ButtonEntrar))
                .addGap(47, 47, 47))
        );

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

        setSize(new java.awt.Dimension(444, 415));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEntrarActionPerformed
        // TODO add your handling code here:
        String nombreInsti = jTNombreInstituto.getText();
        String nombre = jTUsuario.getText();
        String contra = jPConstrasena.getText();
        ConexionDefault.crearConexion();
        int tipo = DAOInstituto2.instancia().obtenerTipoUsuario(nombre, nombreInsti);

        switch (tipo) {

            case 0:
                Administrador admin = DAOInstituto2.instancia().obtenerAdministrador(nombre, nombreInsti);
                if (admin.getContrasenna().equals(contra)) {
                    AdministradorGrafico adm = new AdministradorGrafico(null, true, admin, this);
                    this.setVisible(false);
                    adm.mostrar(nombre);
                    adm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta", "Inicio", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 1:

                Alumno alum = DAOInstituto2.instancia().obtenerAlumno(nombre, nombreInsti);

                if (alum.getContrasenna().equals(contra)) {
                    AlumnoGrafico alG = new AlumnoGrafico(null, true, alum, this);
                    this.setVisible(false);
                    // adm.mostrar();
                    alG.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta", "Inicio", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 3:
                Profesor prof =  DAOInstituto2.instancia().obtenerProfesor(nombre, nombreInsti);
                if (prof.getContrasenna().equals(contra)){
                    //ProfesorGrafico pr = new ProfesorGrafico(null, true, prof, this);
                    this.setVisible(false);
                    //pr.mostrar();
                    //pr.setVisible(true);
                }
                
                break;
        }

        //modificar el control de la contrasena
        /*
            if (u instanceof Administrador) {
                if (u.getContra().equals(contra)) {
                    Administrador ad = (Administrador) u;
                    AdministradorGrafico adm = new AdministradorGrafico(null, true, ad, this);
                    this.setVisible(false);
                    adm.mostrar(nombre);
                    adm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta", "Inicio", JOptionPane.WARNING_MESSAGE);

                }

            }
            if (u instanceof Profesor) {
                if (u.getContra().equals(contra)) {
                    Profesor pro = (Profesor) u;
                    ProfesorGrafico pr = new ProfesorGrafico(null, true, pro, this);
                    this.setVisible(false);
                    //pr.mostrar();
                    pr.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta", "Inicio", JOptionPane.WARNING_MESSAGE);

                }

            }
            if (u instanceof Alumno) {
                if (u.getContra().equals(contra)) {
                    Alumno alu = (Alumno) u;
                    AlumnoGrafico alG = new AlumnoGrafico(null, true, alu, this);
                    this.setVisible(false);
                    // adm.mostrar();
                    alG.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta", "Inicio", JOptionPane.WARNING_MESSAGE);

                }

            }

        }
         */

    }//GEN-LAST:event_ButtonEntrarActionPerformed

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);


    }//GEN-LAST:event_ButtonCancelarActionPerformed

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
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JButton ButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPConstrasena;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTNombreInstituto;
    private javax.swing.JTextField jTUsuario;
    // End of variables declaration//GEN-END:variables

}
