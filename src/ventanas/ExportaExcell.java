/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ExportaExcell extends javax.swing.JDialog {

    
String tabla;   
    
ventanas.Conector cc = new ventanas.Conector();
static Connection cn = Conector.conexion();


    public ExportaExcell(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        Actualizar();

    }

 public static void Actualizar(){
    String sql = "SHOW TABLES"; //WHERE 'TABLES_IN_ESTETICA' NOT LIKE 'users'";
    DefaultTableModel model = new DefaultTableModel();
    


    try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metadata = rs.getMetaData();   
            while(rs.next()){ 
               int cantidadColumnas = metadata.getColumnCount();
            for (int i = 1; i <= cantidadColumnas; i++) {
                model.addColumn(metadata.getColumnLabel(i));
            }while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }model.addRow(fila);
            }
            }jTable.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
}
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exportar");

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/exporta.png"))); // NOI18N
        jButton1.setText("Exportar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Selecciona elemento a exportar");

        jTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);

        jLabel2.setText("Se guardará en la siguiente ruta:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/cancelar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      

        if(jTextField2.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona una tabla");}
        else{
            
            int row = jTable.getSelectedRow();
            tabla=jTable.getValueAt(row, 0).toString();

            int x = JOptionPane.showConfirmDialog(null,"\t"+"Deseas exportar  "+tabla+"?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){

                Archivos.carpeta();
                String Tabla=String.valueOf(jTable.getModel().getValueAt(jTable.getSelectedRow(),0));
                String Ruta = jTextField2.getText();
                
                File Archivo=new File(Ruta);
                
                if(Archivo.exists()){
                    
                int y = JOptionPane.showConfirmDialog(null,"El archivo"+tabla+" ya existe \n deseas sobreescribirlo?","Confirmar",JOptionPane.YES_NO_OPTION);
                if( y == JOptionPane.YES_OPTION){
                    
               
                   Archivo.delete();
                  
                   
                 try{
                        String sql = "select * from "+Tabla+" into outfile '"+Ruta+"' fields terminated by ','  lines terminated by '\n'";

                       // String sql = "select * from "+Tabla+" into outfile '"+Ruta+"' fields terminated by ',' enclosed by '\"' lines terminated by '\n'";
                        Statement stmt;
                        stmt = cn.prepareStatement(sql);
                        stmt.executeQuery(sql);
                        JOptionPane.showMessageDialog(null,"Archivo sobreescrito en:"+"\n '"+Ruta+"'");

                    } catch (SQLException ex) {
                        // Logger.getLogger(ExportarExcel.class.getCanonicalName()).log(Level.SEVERE, null, ex);
                    }
                 
                }
                
                }else{

                try{
                     
                        String sql = "select * from "+Tabla+" into outfile '"+Ruta+"' fields terminated by ','  lines terminated by '\n'";
                        Statement stmt;
                        stmt = cn.prepareStatement(sql);
                        stmt.executeQuery(sql);
                        JOptionPane.showMessageDialog(null,"Archivo creado en:"+"\n '"+Ruta+"'");

                    } catch (SQLException ex) {
                        // Logger.getLogger(ExportarExcel.class.getCanonicalName()).log(Level.SEVERE, null, ex);
                    }
              
                }
            
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked

        int row = jTable.getSelectedRow();
        String nombre=jTable.getValueAt(row, 0).toString();

        jTextField2.setText(nombre);

        String archivo = jTextField2.getText();
        jTextField2.setText("c:/SistemaTemsa/Respaldo/"+archivo+".csv");

    }//GEN-LAST:event_jTableMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       jTextField2.setText("");
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
            java.util.logging.Logger.getLogger(ExportaExcell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportaExcell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportaExcell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportaExcell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExportaExcell dialog = new ExportaExcell(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
