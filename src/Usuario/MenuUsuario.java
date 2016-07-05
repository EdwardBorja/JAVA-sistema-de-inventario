/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;

import Busqueda.BuscaRelacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import ventanas.Importacion.*;
import ventanas.Inicio;
import ventanas.Relacion;
import ventanas.Version;



public class MenuUsuario extends javax.swing.JFrame {

    String contraseña,ampm;
    int hora, minutos, segundos; 
    int dia,mes,año;
    
    
    public MenuUsuario() {
        initComponents();
        setResizable(false);
        setSize(1200, 700);
        setLocationRelativeTo(null);
       setIconImage(new ImageIcon(getClass().getResource("/ventanas/bus.png")).getImage());
       
        reloj();
       
    }
 public final void reloj() { 
Calendar calendario;


calendario = new java.util.GregorianCalendar(); 
segundos = calendario.get(Calendar.SECOND); 
@SuppressWarnings("empty-statement")
Timer timer = new Timer(1000, (ActionEvent e) -> {
    Date actual = new Date();
    calendario.setTime(actual);
    
    hora = calendario.get(Calendar.HOUR);
    minutos = calendario.get(Calendar.MINUTE);
    segundos = calendario.get(Calendar.SECOND);
    ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
    //
    dia = calendario.get(Calendar.DAY_OF_MONTH);
    mes = (calendario.get(Calendar.MONTH)+1);
    año = calendario.get(Calendar.YEAR);
    //
            
    String hour = String.format("%02d : %02d : %02d ",hora,minutos,segundos);
    String date = String.format("%02d / %02d / %02d ",dia,mes,año);
    
    labelHora.setText(hour+ampm);
    labelFecha.setText(date);
    labelHora.setToolTipText(hour+ampm+"   "+"\t"+date);
    
    
    
        
    });
timer.start(); 
}
 
 
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu");
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/camion.png"))); // NOI18N
        jButton5.setText("Unidades");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 300, 180));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/maintenance_128.png"))); // NOI18N
        jButton6.setText("Herramientas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, 180));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/filtro_30.png"))); // NOI18N
        jButton2.setText("Filtros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 300, 180));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/foco.png"))); // NOI18N
        jButton3.setText("Focos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 300, 180));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/refaccion.png"))); // NOI18N
        jButton4.setText("Refacciones");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 300, 180));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1417782404_exit.png"))); // NOI18N
        jButton7.setText("Salir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, 110, 50));

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText(".");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 100, -1));

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText(".");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 90, -1));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/wheel_128.png"))); // NOI18N
        jButton9.setText("Llantas");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 300, 180));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Conductor.png"))); // NOI18N
        jButton8.setText("Conductores");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 300, 180));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/informacion.png"))); // NOI18N
        jButton11.setText("Informacion");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 300, 180));

        jMenu4.setText("Sesion");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1421454507_Home.png"))); // NOI18N
        jMenuItem1.setText("Inicio");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Informacion");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/info.png"))); // NOI18N
        jMenuItem9.setText("Version");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        ConFiltros filtro=new ConFiltros();
        filtro.setVisible(true);       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
        dispose();
        ConFocos foco=new ConFocos();
        foco.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        ConRefaccion refaccion=new ConRefaccion();
        refaccion.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
        dispose();
        ConUnidad1 unid=new ConUnidad1();
        unid.setVisible(true);
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();
        ConHerramientas herramienta=new ConHerramientas();
        herramienta.setVisible(true);
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       int x = JOptionPane.showConfirmDialog(null,"¿Deseas salir del programa?","Confirmar",JOptionPane.YES_NO_OPTION);
      
       if( x == JOptionPane.YES_OPTION){
            
                       System.exit(0);


        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
            new Version(this, true).setVisible(true);

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        dispose();
        Inicio init1=new Inicio();
        init1.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
     dispose();
     ConLlantas collantas=new ConLlantas();
     collantas.setVisible(true);
     
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        dispose();
        ConConductor conduct=new ConConductor();
        conduct.setVisible(true);
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       dispose();
       BuscaRelacion rel=new BuscaRelacion();
       rel.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed


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
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    // End of variables declaration//GEN-END:variables
}
