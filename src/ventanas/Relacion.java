/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import Busqueda.*;
import Usuario.*;
import java.awt.Image;
import ventanas.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edward
 */
public class Relacion extends javax.swing.JFrame {

    String contraseña,ampm;
    int hora, minutos, segundos; 
    int dia,mes,año;
    ventanas.Conector cc = new ventanas.Conector();
    Connection cn = cc.conexion();
    
    public Relacion() {
        initComponents();
        setResizable(false);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        actualizar();
      
        reloj();
       
        jTable1.getTableHeader().setReorderingAllowed(false) ;
          //      setIconImage(new ImageIcon(getClass().getResource("/ventanas/bus.png")).getImage());

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
       
       
     public void ObtenerDatos(){
     
      int row = jTable1.getSelectedRow();
     String ID=jTable1.getValueAt(row, 0).toString();
     String Nombre=jTable1.getValueAt(row, 1).toString();
     String Unidad=jTable1.getValueAt(row, 2).toString();
     String Tipo=jTable1.getValueAt(row, 3).toString();

      id.setText("ID : "+ID);
      name.setText("Nombre : "+Nombre);
      unidad.setText("Unidad : "+Unidad);
      tipo.setText("Tipo : "+Tipo);
     
      String IMAGEN=jTable1.getValueAt(row, 4).toString();
      ImageIcon img = new ImageIcon(IMAGEN);
      jLabel9.setIcon(new ImageIcon(img.getImage().getScaledInstance(300, 200,Image.SCALE_SMOOTH)));
      
      String IMAGEN2=jTable1.getValueAt(row, 5).toString();
      ImageIcon img2 = new ImageIcon(IMAGEN2);
      jLabel2.setIcon(new ImageIcon(img2.getImage().getScaledInstance(300, 200,Image.SCALE_SMOOTH)));
     
         if (jLabel9.getText().equals("")) {
             jLabel1.setVisible(true);
         }else{jLabel1.setVisible(false);}
         
         if (jLabel2.getText().equals("")) {
             jLabel4.setVisible(true);
         }else{jLabel4.setVisible(false);}
         
      
        
}
      
  public void actualizar(){
     //ACTUALIZA TA LABLA
        //---------------------------------------------------------------------------
        
        Statement stmt;
        ResultSet rs;
        ResultSetMetaData metadata;

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTable1.setModel(modelo);
           stmt = cn.createStatement();
           rs = stmt.executeQuery("select distinct (conductor.id_conductor),(conductor.nombre),(conductor.no_unidad), tipo ,(conductor.imagen),(unidad.imagen) from conductor inner join unidad where conductor.no_unidad=unidad.no_unidad");

            //+ "// WHERE(`nombre`='usuario')");
        //obtiene informacion de la columnas.
        metadata = rs.getMetaData();
        //cantidad de columnas que tiene la tabla.

        int cantidadColumnas = metadata.getColumnCount();
        //establece el num de columnas
        for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(metadata.getColumnLabel(i));
        }while (rs.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i]=rs.getObject(i+1);
            }

            modelo.addRow(fila);
        }rs.close();
       
        } catch (SQLException ex) {
        } 
       
      id.setText("ID :");
      name.setText("Nombre : ");
      unidad.setText("Unidad : ");
      tipo.setText("Tipo : ");
      jLabel2.setIcon(null);
      jLabel9.setIcon(null);
        
    } 
    
 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelHora = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        unidad = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Busqueda de Conductores");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 221, 1105, 332));

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText(".");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 98, -1));

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText(".");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/actualizar.png"))); // NOI18N
        jButton6.setText("Actualizar datos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 160, -1));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 270, 190));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/lista.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 170, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1417782404_exit.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, 102, 41));

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setPreferredSize(new java.awt.Dimension(300, 250));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, 190));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/informacion.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        unidad.setBackground(new java.awt.Color(255, 255, 255));
        unidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unidad.setForeground(new java.awt.Color(255, 255, 255));
        unidad.setText("Unidad :");
        jPanel1.add(unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID:");
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Nombre:");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        tipo.setBackground(new java.awt.Color(255, 255, 255));
        tipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tipo.setForeground(new java.awt.Color(255, 255, 255));
        tipo.setText("Tipo:");
        jPanel1.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Conductor.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/camion.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, -1));

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Herramientas");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/print.png"))); // NOI18N
        jMenuItem4.setText("Imprimir tabla actual");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
 
    
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        MessageFormat header=new MessageFormat("Reporte");

        MessageFormat footer=new MessageFormat("Page{1,number,integer}");

        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(Relacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      actualizar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
  ObtenerDatos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        Menu menu1=new Menu();
        menu1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int x = JOptionPane.showConfirmDialog(null,"¿Deseas salir del programa?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){

            System.exit(0);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Relacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel name;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel unidad;
    // End of variables declaration//GEN-END:variables
}
