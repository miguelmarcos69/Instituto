/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import BaseDatos.DAOInstituto2;
import ClasesBase.Curso;
import ClasesBase.Evento;
import ClasesBase.Instituto;
import ClasesBase.Modulo;
import Usuarios.Profesor;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author abilius
 */
public class jCalendarioProfesor extends javax.swing.JFrame {

    /**
     * Creates new form jCalendario
     */
    Instituto i;
    Profesor p;
    String[] cabecera = new String[5];

    public jCalendarioProfesor(Profesor p, Instituto i) {
        initComponents();
        this.i = i;
        this.p = p;
        cabecera[0] = "Modulo";
        cabecera[1] = "Curso";
        cabecera[2] = "Ano";//Que alguien cambie la n que no tengo la que va antes de la o XD
        cabecera[3] = "Fecha";
        cabecera[4] = "Mensaje";
        jTable1.setModel(new DefaultTableModel(obtenerEventos(), cabecera));
        for (Modulo m : p.getModulosDados()) {
            jComboBoxModulos.addItem(m.toString());

        }

        /*
        TableColumnModel modelo = (TableColumnModel) jTable1.getColorModel();
        modelo.getColumn(0).setWidth(100);
        modelo.getColumn(1).setWidth(100);
        modelo.getColumn(2).setWidth(30);
        modelo.getColumn(3).setWidth(100);
        modelo.getColumn(4).setWidth(170);
        jTable1.setColumnModel(modelo);
        */
        

    }

    public jCalendarioProfesor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar = new com.toedter.calendar.JCalendar();
        jComboBoxModulos = new javax.swing.JComboBox<>();
        jTextFieldMensaje = new javax.swing.JTextField();
        jButtonNuevoEvento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldMensaje.setText("Nombre del evento");

        jButtonNuevoEvento.setText("CrearNuevoEvento");
        jButtonNuevoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoEventoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Modulo", "Curso", "Ano", "Fecha", "Mensaje"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxModulos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldMensaje)
                            .addComponent(jButtonNuevoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jTextFieldMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonNuevoEvento)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoEventoActionPerformed

        Date fecha = jCalendar.getDate();//Obtenemos la fecha seleccionada por el usuario
        String mensaje = jTextFieldMensaje.getText();//Obtenemos tambien el mensaje
        Evento e = new Evento(mensaje, fecha);//Creamos el nuevo evento
        //Los cursos estan ordenados en las mismas posiciones que los modulos por lo tanto un curso corresponde a un Modulo
        ArrayList<Curso> cursos = DAOInstituto2.instancia().getCiclosdeProfesor(p.getNombre(), i);//Obtenemos los cursos de los modulos que tiene asignados un profesor
        Modulo m = i.getModuloNombre(cursos.get(jComboBoxModulos.getSelectedIndex()), p.getModulosDados().get(jComboBoxModulos.getSelectedIndex()).getNombre());//Obtenemos el modulo seleeccionado por el combo box y este lo relacionamos con su curso
        m.annnadirEvento(e);//Creamos el modulo al que annadir el evento
        DAOInstituto2.instancia().anadirEvento(e, p.getModulosDados().get(jComboBoxModulos.getSelectedIndex()).getNombre(), cursos.get(jComboBoxModulos.getSelectedIndex()), i.getNombre());
        //anadimos a la tabla eventos el vevento creado con su modulo, ciclo,fechay mensaje

        //Como mostrar los datos en la tabla
        jTable1.setModel(new DefaultTableModel(obtenerEventos(), cabecera));

    }//GEN-LAST:event_jButtonNuevoEventoActionPerformed

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
            java.util.logging.Logger.getLogger(jCalendarioProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jCalendarioProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jCalendarioProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jCalendarioProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jCalendarioProfesor().setVisible(true);
            }
        });
    }

    public String[][] obtenerEventos() {

        String eventos[][] = new String[100][5];
        int contador = 0;
        ArrayList<Curso> cursos = DAOInstituto2.instancia().getCiclosdeProfesor(p.getNombre(), i);//Obtenemos los cursos de los modulos que tiene asignados un profesor

        for (int i = 0; i < p.getModulosDados().size(); i++) {

            Modulo a = p.getModulosDados().get(i);

            for (int j = 0; j < a.getCalendario().size(); j++) {

                eventos[contador][0] = a.getNombre();
                eventos[contador][1] = cursos.get(i).getNombre();
                eventos[contador][2] = cursos.get(i).getAnno() + "";
                eventos[contador][3] = a.getCalendario().get(j).getFecha() + "";
                eventos[contador][4] = a.getCalendario().get(j).getMensaje();
                contador++;

            }
        }

        return eventos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNuevoEvento;
    private com.toedter.calendar.JCalendar jCalendar;
    private javax.swing.JComboBox<String> jComboBoxModulos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldMensaje;
    // End of variables declaration//GEN-END:variables
}
