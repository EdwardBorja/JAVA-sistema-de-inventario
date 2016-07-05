/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edward
 */
public class Cuenta extends javax.swing.JDialog {

       ventanas.Conector cc = new ventanas.Conector();
    Connection con = cc.conexion();
    
    public Cuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ActualizaCuentas();
        setResizable(false);
        setLocationRelativeTo(null);
        user.requestFocus();
        rut.setVisible(false);

         jTable1.getTableHeader().setReorderingAllowed(false) ;
    }

   
    
   public void ActualizaCuentas(){
     //ACTUALIZA TA LABLA
        //---------------------------------------------------------------------------
        
        Statement stmt;
        ResultSet rs;
        ResultSetMetaData metadata;

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTable1.setModel(modelo);
           stmt = con.createStatement();
           rs = stmt.executeQuery("SELECT * FROM cuentas order by nombre asc");
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
    }  
   
   public void ObtenerDatos(){
    int row = jTable1.getSelectedRow();
      String Usuario=jTable1.getValueAt(row, 0).toString();
      String Contraseña=jTable1.getValueAt(row, 1).toString();
      String Tipo=jTable1.getValueAt(row, 2).toString();
      String IMAGEN=jTable1.getValueAt(row, 3).toString();
    

      
      user.setText(Usuario);
      pass.setText(Contraseña);
      rut.setText(IMAGEN);
      jComboBox1.getSelectedItem().toString();
      jComboBox1.setSelectedItem(Tipo);
      ImageIcon img = new ImageIcon(IMAGEN);
      jLabel4.setIcon(new ImageIcon(img.getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH)));
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        pass = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        rut = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cuentas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 11, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tipo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 133, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/adduser.png"))); // NOI18N
        jButton1.setText("Agregar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 34, 167, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/borrador.png"))); // NOI18N
        jButton4.setText("Borra campos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 170, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/deluser.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 65, -1, -1));

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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 0, 300, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/edita.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 95, 167, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un tipo", "administrador", "usuario" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 158, 167, 34));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setPreferredSize(new java.awt.Dimension(250, 250));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 200, 190));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/imselect.png"))); // NOI18N
        jButton5.setText("Seleccionar Imagen");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 210, -1));

        rut.setEditable(false);
        getContentPane().add(rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if(user.getText().equals("") || pass.getText().equals("")){JOptionPane.showMessageDialog(null,"Hay campos vacios");
         
        }else{

               if( jComboBox1.getSelectedItem().toString().equals("Selecciona un tipo")){JOptionPane.showMessageDialog(null,"Selecciona un tipo ");}
               else{
                String Usuario,Contraseña,Tipo,Imagen;
                

                Usuario=user.getText();
                Contraseña=pass.getText();
                Imagen=rut.getText();
                
                
                
                Tipo=(String)jComboBox1.getSelectedItem();
            
                    
                Connection con = null;
                Statement  stmt = null;
                ResultSet rs;

                try {
            

                stmt = this.con.createStatement();
          
                rs = stmt.executeQuery("SELECT * FROM cuentas WHERE `nombre`='" + Usuario + "' and `Tipo`='" + Tipo + "' ");

           
                if(!rs.next()){
   		 stmt.executeUpdate("INSERT INTO cuentas VALUES ( '" + Usuario + "','" + Contraseña + "','" + Tipo + "','" + Imagen + "')");

            
            
                JOptionPane.showMessageDialog(null,"Se agregó la informacion exitosamente");
             
                }else{ JOptionPane.showMessageDialog(null,"ya existe");}
             
           
                }
                 catch( SQLException e ) {
                 e.printStackTrace();
                 }

                 user.setText("");
                 pass.setText("");
                 rut.setText("");
                 jComboBox1.setSelectedIndex(0);
                 jLabel4.setIcon(null);
                 ActualizaCuentas();
               }
          
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
     

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if(user.getText().equals("") || pass.getText().equals("")    ){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
        }else{

         if( jComboBox1.getSelectedItem().toString().equals("Selecciona un tipo")){
             
           JOptionPane.showMessageDialog(null,"Selecciona un tipo");
           
         }else{
               int x = JOptionPane.showConfirmDialog(null,"¿Editar registro?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){
                
           
            DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
            String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
            
            
            String Usuario,Contraseña,Tipo,Imagen;

            Usuario=user.getText();
            Contraseña=pass.getText();
            Tipo=(String)jComboBox1.getSelectedItem();
            Imagen=rut.getText();

            Statement  stmt = null;
          

              try {
            
         stmt = con.createStatement();
        
         try{
         stmt.executeUpdate("UPDATE cuentas set `nombre`='"+Usuario+"',`password`='"+Contraseña+"',`tipo`='"+Tipo+"',`imagen`='"+Imagen+"' WHERE( `nombre`='"+valor1+"')");
         JOptionPane.showMessageDialog(null,"Editado exitosamente");
       
            }catch( SQLException e ){JOptionPane.showMessageDialog(null,"No se editó");}
          
        }
        catch( SQLException e ) {
           e.printStackTrace();
        }
           
            ActualizaCuentas();
             }
            
            user.setText("");
            pass.setText("");
            rut.setText("");
            jComboBox1.setSelectedIndex(0);
            jLabel4.setIcon(null);
         }
         
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      ObtenerDatos();
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(user.getText().equals("") || pass.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
        }else{

            int x = JOptionPane.showConfirmDialog(null,"¿Eliminar registro?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){
                
           
            DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
            String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0)); 
            String valor2= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),2)); 

            Statement  stmt = null;
            
          
            try {
            
         stmt = con.createStatement();
           try{
         stmt.executeUpdate("DELETE FROM `cuentas` WHERE (`nombre`='" + valor1 + "' and `tipo`='" + valor2 + "')");
                                 JOptionPane.showMessageDialog(null,"Eliminado exitosamente");

            }catch( SQLException e ){}
          
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }

            ActualizaCuentas();

            
             }
            user.setText("");
            pass.setText("");
            rut.setText("");
            jComboBox1.setSelectedIndex(0);
            jLabel4.setIcon(null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        user.setText("");
        pass.setText("");
        rut.setText("");
        jComboBox1.setSelectedIndex(0);
        jLabel4.setIcon(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
            JFileChooser chooser=new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileFilter Filtro1 = new FileNameExtensionFilter("JPG file", "jpg");
            FileFilter Filtro2 = new FileNameExtensionFilter("PNG file", "png");
           
           
            chooser.setFileFilter(Filtro1);
            chooser.addChoosableFileFilter(Filtro2);
            chooser.showOpenDialog(null);

            File Archivo=chooser.getSelectedFile();
            String filename= Archivo.getAbsolutePath();
            
          
            //aqui cambia las digonales
            rut.setText(filename.replace("\\","/"));
                // System.out.println(filename.replace("\\","/"));

      String Ruta;
      Ruta=rut.getText();
      ImageIcon img = new ImageIcon(Ruta);
      //ImageIcon img = new ImageIcon("C:\\Users\\Edward\\Desktop\\ventana.jpg");
      jLabel4.setIcon(new ImageIcon(img.getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH)));
      
                }catch(java.lang.Exception e){}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_DOWN){
          ObtenerDatos();
        
        }
        
         if (evt.getKeyCode()==KeyEvent.VK_UP){
          ObtenerDatos();
          
        }
        
    }//GEN-LAST:event_jTable1KeyPressed

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
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cuenta dialog = new Cuenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField rut;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
