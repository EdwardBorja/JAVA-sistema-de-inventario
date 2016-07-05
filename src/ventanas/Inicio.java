/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;


import Usuario.MenuUsuario;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author edward
 */
public class Inicio extends javax.swing.JFrame {

    
    String ampm,name;
    int hora, minutos, segundos; 
    int dia,mes,año;
    ventanas.Conector cc = new ventanas.Conector();
    Connection cn = cc.conexion();
   
    
    public Inicio() {
        Archivos.carpeta();
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(900,550);
        
        Thread Hilo = new ventanas.HiloBarra(jProgressBar1);
       
        Hilo.start();
        reloj();
        
        jPasswordField1.requestFocus();
        Contenido_Combobox();
        cargarDatos();
        jPanel2.setBackground(Color.WHITE);
          
        
        setIconImage(new ImageIcon(getClass().getResource("/ventanas/bus.png")).getImage());
     
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
    
public void cargarDatos() {
             
              Object Item = jComboBox1.getSelectedItem();
              String Nombre = String.valueOf(Item);
              
              Statement  stmt = null; 
              ResultSet  rs = null; 

                try {
            

                stmt = cn.createStatement();
          
                rs = stmt.executeQuery("select imagen from cuentas where nombre='" + Nombre + "'");  

           	
	        while ( rs.next() ) { 
                      String tipo = rs.getString("imagen");
                      ImageIcon img = new ImageIcon(tipo);
                jLabel5.setIcon(new ImageIcon(img.getImage().getScaledInstance(230, 200,Image.SCALE_SMOOTH)));
                    }
             
                jPasswordField1.requestFocus();
                }
                 catch( SQLException e ) {
                 e.printStackTrace();
                 }

          
}

public void Contenido_Combobox(){
        
DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

    Statement stmt=null;
    ResultSet rs=null;
          
            try{
                
            stmt = cn.createStatement();

            rs = stmt.executeQuery("select nombre from cuentas");
          
            jComboBox1.setModel(modeloCombo);
            modeloCombo.addElement("Seleccione Usuario");

            while (rs.next()) {
                modeloCombo.addElement(rs.getObject("nombre"));
                jComboBox1.setModel(modeloCombo);
              
            }
 
            }catch(SQLException ex){}       
    }
      
public void validarUsuario(){ 

name=(String)jComboBox1.getSelectedItem();
String pass =new String(jPasswordField1.getPassword());


Statement stmt;
ResultSet rs;


try{ 

stmt = cn.createStatement();
rs = stmt.executeQuery("SELECT tipo,nombre FROM cuentas WHERE (NOMBRE ='" + name + "' and PASSWORD='" + pass +"')");


if(rs!=null){
    
if(rs.next()){
    
   // String names = rs.getString("nombre");
   // String tipo = rs.getString("Tipo");
 
   
        
    switch (rs.getString("tipo")) {
        case "administrador":
            dispose();
            Menu menu1=new Menu();
            menu1.setVisible(true);
           
            JOptionPane.showMessageDialog(null,"Bienvenido administrador"+"\n"+name);
            
             
             //Admin.jLabel1.setText(jTextField1.getText());
             
            break;
            
    
       
        case "usuario":
            
                dispose();
                MenuUsuario MeU=new MenuUsuario();
                MeU.setVisible(true);
            
            JOptionPane.showMessageDialog(null,"\t"+"bienvenido Usuario"+"\n"+name);
           
            break; 
            
        
            
            
    } 
    

}else{JOptionPane.showMessageDialog(null,"Contraseña invalida"+"\n"+"Intente de nuevo");}

}

rs.close();


       }catch(SQLException | HeadlessException ex){
       }
} 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        info = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Inicio");
        setPreferredSize(new java.awt.Dimension(900, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Usuarios:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/por-periodo-de-sesiones-icono-8745-32.png"))); // NOI18N
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 190, 100));

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 190, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/temsa.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jProgressBar1.setToolTipText("");
        jProgressBar1.setName(""); // NOI18N
        jProgressBar1.setStringPainted(true);
        jProgressBar1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jProgressBar1StateChanged(evt);
            }
        });
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 660, 20));

        info.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 150, 17));

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText(".");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 90, -1));

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText(".");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1417782404_exit.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 100, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "item1", "item2", "item3" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 190, 30));

        jPanel2.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 230, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        
        validarUsuario();
       
        
        jPasswordField1.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jProgressBar1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jProgressBar1StateChanged
        if(jProgressBar1.getValue() == 1){
            info.setText("Iniciando programa");
        }

        if(jProgressBar1.getValue() == 50){
            info.setText("Cargando datos");
        }

        if(jProgressBar1.getValue() == 100){
            info.setText("Carga finalizada");
        }
    }//GEN-LAST:event_jProgressBar1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int x = JOptionPane.showConfirmDialog(null,"¿Deseas salir del programa?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){

            System.exit(0);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
       String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[0-9 a-zA-Z]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
       if (evt.getKeyCode()==KeyEvent.VK_ENTER){
       
           validarUsuario();
           jPasswordField1.setText("");
       }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
     cargarDatos();
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    // End of variables declaration//GEN-END:variables
}
