/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import Usuarios.*;
import java.awt.Color;
import ClasesBase.*;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author alumno
 */
public class ProfesorGrafico extends javax.swing.JFrame {

    Profesor prof;

    /**
     * Creates new form Alumno
     */
    public ProfesorGrafico(java.awt.Frame parent, boolean modal, Profesor prof) {
        initComponents();
        this.prof = prof;
        this.setBackground(Color.black);
        this.setForeground(Color.white);
    }
    
      class jPanelGardient extends JPanel{
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            
            Color color1 = new Color(221, 0, 255);
             Color color2 = new Color(255, 162, 0);
             GradientPaint gp = new GradientPaint (0,0,color1,180,height,color2);
             g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    
    Alumno a;

    private ProfesorGrafico() {
        initComponents();
        ArrayList<Alumno> al = new ArrayList<>();
        ArrayList<Ciclo> c = new ArrayList<>();
        ArrayList<Modulo> mod = new ArrayList();
        ArrayList<Modulo> mod2 = new ArrayList();

        Ciclo primero = new Ciclo(mod, "DAW", 2,1);
        Ciclo segundo = new Ciclo(mod2, "DAW", 2,2);
        c.add(primero);
        c.add(segundo);

        Alumno lola = new Alumno("Lola", "lola", "1254", 2, 3, primero);
        Alumno miguel = new Alumno("miguel", "miguel", "1254", 2, 3, segundo);
        Alumno pepe = new Alumno("pepe", "pepe", "1254", 2, 3, primero);
        Alumno juan = new Alumno("juan", "juan", "1254", 2, 3, segundo);

        al.add(lola);
        al.add(miguel);
        al.add(pepe);
        al.add(juan);
  
        Modulo programacion = new Modulo("Programacion", "12", 2, primero.getNombre());
        Modulo entornos = new Modulo("entornos", "12", 2, primero.getNombre());
        Modulo fol = new Modulo("fol", "12", 2, primero.getNombre());
        mod.add(programacion);
        mod.add(entornos);
        mod2.add(fol);

        this.prof = new Profesor("miguel", "miguel", "71972414D", 17091999, 21, mod, c, al);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jPanelGardient();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jModificarNotas = new javax.swing.JButton();
        jTablon = new javax.swing.JButton();
        jCalendario = new javax.swing.JButton();
        jSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido ");

        jNombre.setBackground(new java.awt.Color(255, 255, 255));
        jNombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jNombre.setForeground(new java.awt.Color(255, 255, 255));
        jNombre.setText("Nombre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jNombre)
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jNombre))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¿Qué quieres hacer?");

        jModificarNotas.setBackground(new java.awt.Color(0, 0, 0));
        jModificarNotas.setForeground(new java.awt.Color(255, 255, 255));
        jModificarNotas.setText("Modifar notas");
        jModificarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificarNotasActionPerformed(evt);
            }
        });

        jTablon.setBackground(new java.awt.Color(0, 0, 0));
        jTablon.setForeground(new java.awt.Color(255, 255, 255));
        jTablon.setText("Añadir al tablon");

        jCalendario.setBackground(new java.awt.Color(0, 0, 0));
        jCalendario.setForeground(new java.awt.Color(255, 255, 255));
        jCalendario.setText("calendairo");

        jSalir.setBackground(new java.awt.Color(0, 0, 0));
        jSalir.setForeground(new java.awt.Color(255, 255, 255));
        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jModificarNotas)
                        .addGap(40, 40, 40)
                        .addComponent(jCalendario)
                        .addGap(34, 34, 34)
                        .addComponent(jTablon)))
                .addGap(0, 34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jModificarNotas)
                    .addComponent(jCalendario)
                    .addComponent(jTablon))
                .addGap(55, 55, 55)
                .addComponent(jSalir)
                .addContainerGap())
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSalirActionPerformed

    private void jModificarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificarNotasActionPerformed
        ModificarNotas mod = new ModificarNotas(null, true, prof);
        mod.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_jModificarNotasActionPerformed

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
            java.util.logging.Logger.getLogger(AlumnoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfesorGrafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCalendario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jModificarNotas;
    private javax.swing.JLabel jNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jSalir;
    private javax.swing.JButton jTablon;
    // End of variables declaration//GEN-END:variables
}
