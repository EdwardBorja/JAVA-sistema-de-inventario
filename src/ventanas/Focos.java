/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import Busqueda.BuscaFoco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edward
 */
public class Focos extends javax.swing.JFrame {

    String contraseña,ampm;
    int hora, minutos, segundos; 
    int dia,mes,año;
    
    ventanas.Conector cc = new ventanas.Conector();
    Connection cn = cc.conexion();
    
    public Focos() {
        initComponents();
        setResizable(false);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        actualizar();
        Timer();
        reloj();
        parte.requestFocus();
        
         jTable1.getTableHeader().setReorderingAllowed(false) ;

    }

    
    public final void Timer() { 
   
    Timer timer = new Timer (1000, new ActionListener () { 
    
        public void actionPerformed(ActionEvent e){ 
         actualizar();
        } 
        
    });

timer.start(); 
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
     
       public void SumaEntradaSalida(){
     try {
        int Entrada,Salida,Total;
               
        Entrada = Integer.parseInt(entrada.getText());
        Salida = Integer.parseInt(salida.getText());
   
        
        Total=Entrada-Salida;
        
        if(Total>=0){
        // existencias.setText(""+Total);
        }else{
     
         JOptionPane.showMessageDialog(null,"No es valida la existencia \n Revise entradas y salidas");
         
        }
       
        
        } catch (Exception e) {
        }
    
    }
       
     public void ObtenerDatos(){
      int row = jTable1.getSelectedRow();
      
      String Parte=jTable1.getValueAt(row, 0).toString();
      String Descripcion=jTable1.getValueAt(row, 1).toString();
     // String Entrada=jTable1.getValueAt(row, 2).toString();
     // String Salida=jTable1.getValueAt(row, 3).toString();
      String Existencias=jTable1.getValueAt(row, 4).toString();
      String Fecha=jTable1.getValueAt(row, 5).toString();
      
       
      parte.setText(Parte);
        descripcion.setText(Descripcion);
        entrada.setText("0");
        salida.setText("0");
        Textoex.setText(Existencias);
        jLabel9.setText("Fecha : "+Fecha);
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
           rs = stmt.executeQuery("SELECT * FROM focos order by No_parte asc");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        parte = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        entrada = new javax.swing.JTextField();
        salida = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Textoex = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Focos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/lista.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 191, 230, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/foco.png"))); // NOI18N
        jLabel1.setText("Focos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 28, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 1105, 332));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1417782404_exit.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, 102, 41));

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText(".");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText(".");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 98, -1));

        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 230, -1));

        parte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parteKeyTyped(evt);
            }
        });
        jPanel1.add(parte, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 230, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripcion:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No_parte:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Entrada de producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Salida de producto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, -1));

        entrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entradaFocusGained(evt);
            }
        });
        entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                entradaKeyTyped(evt);
            }
        });
        jPanel1.add(entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 230, -1));

        salida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                salidaFocusGained(evt);
            }
        });
        salida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salidaKeyTyped(evt);
            }
        });
        jPanel1.add(salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 230, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/borrador.png"))); // NOI18N
        jButton3.setText("Borrar campos");
        jButton3.setPreferredSize(new java.awt.Dimension(200, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, -1, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/agrega32.png"))); // NOI18N
        jButton4.setText("Agregar registro");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/edita.png"))); // NOI18N
        jButton5.setText("Modificar registro");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/eliminar.png"))); // NOI18N
        jButton6.setText("Eliminar registro");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Existencias:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        Textoex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Textoex.setForeground(new java.awt.Color(255, 255, 255));
        Textoex.setText("_");
        jPanel1.add(Textoex, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 50, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/por-periodo-de-sesiones-icono-8745-32.png"))); // NOI18N
        jMenu1.setText("Sesion");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/sesion.png"))); // NOI18N
        jMenuItem1.setText("Cerrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/search.png"))); // NOI18N
        jMenu3.setText("Busqueda");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        descripcion.setText("");
        parte.setText("");
        entrada.setText("");
        salida.setText("");
        Textoex.setText("");
        jLabel9.setText("Fecha:");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(parte.getText().equals("") || descripcion.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("")){JOptionPane.showMessageDialog(null,"Hay campos vacios");
        }else{

            String Descripcion,Parte,Entrada,Salida,Existencias,Fecha;

            Parte=parte.getText();
            Descripcion=descripcion.getText();
            Entrada=entrada.getText();
            Salida=(salida.getText());
            Fecha=(labelFecha.getText());

         
            Statement  stmt = null;
            ResultSet rs;

             try {
            

            stmt = cn.createStatement();
          
            //Aqui verifica si existe
            rs = stmt.executeQuery("SELECT * FROM focos WHERE `No_parte`='" + Parte + "'");
           
            if(!rs.next()){
                
               
            stmt.executeUpdate("INSERT INTO focos VALUES ( '" + Parte + "','" + Descripcion + "','" + Entrada + "','" + Salida + "','" + Entrada + "','" + Fecha + "')");
                               JOptionPane.showMessageDialog(null,"Se agregó la informacion exitosamente");
             
             
            }else{ JOptionPane.showMessageDialog(null,"ya existe");}
             
            
        }
        catch( SQLException e) {
            e.printStackTrace();
            
        }

          
            descripcion.setText("");
            parte.setText("");
            entrada.setText("");
            salida.setText("");
            Textoex.setText("");
            jLabel9.setText("Fecha:");

            actualizar();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

         if(descripcion.getText().equals("") || parte.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("") ){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
        }else{

            DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
            //Selecciona el valor de la columna 1
            //String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));

            int x = JOptionPane.showConfirmDialog(null,"¿Estas seguro de editar?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){

                String Descripcion,Parte,Entrada,Salida,Existencias,Fecha;

                 Parte=parte.getText(); 
                 Descripcion=descripcion.getText();
                 Entrada=entrada.getText();
                 Salida=(salida.getText());
                 Existencias=Textoex.getText();
                 Fecha=(labelFecha.getText());

                Connection con = null;
                Statement  stmt = null;
                ResultSet rs;

   try {
            
         stmt = cn.createStatement();
        
         try{
         stmt.executeUpdate("UPDATE focos set `No_parte`='"+Parte+"',`descripcion`='"+Descripcion+"',`entrada`='"+Entrada+"'+`entrada`,`salida`=`salida`+'"+Salida+"',`existencias`=`existencias`+'"+Entrada+"'-'"+Salida+"',`fecha`='"+Fecha+"' WHERE( `No_parte`='"+Parte+ "')");

	JOptionPane.showMessageDialog(null,"Se editó exitosamente");

            }catch( SQLException e ){JOptionPane.showMessageDialog(null,"No se editó");}
          
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
                actualizar();

            }
           
            parte.setText("");
            descripcion.setText("");
            entrada.setText("");
            salida.setText("");
            Textoex.setText("");
            jLabel9.setText("Fecha:");
           
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         if(descripcion.getText().equals("") || parte.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("") ){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
        }else{

            DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
            //Selecciona el valor de la columna 1
            //String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
           

            int x = JOptionPane.showConfirmDialog(null,"¿Eliminar registro?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){
   Statement  stmt = null;
      
        try {
            
         stmt = cn.createStatement();
        
         try{
             stmt.executeUpdate("DELETE FROM `focos` WHERE (`No_parte`='"+parte.getText()+"')");
                                 JOptionPane.showMessageDialog(null,"Eliminado exitosamente");

            }catch( SQLException e ){}
          
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        
                actualizar();

            }
            
            parte.setText("");
            descripcion.setText("");
            entrada.setText("");
            salida.setText("");
            Textoex.setText("");
            jLabel9.setText("Fecha:");
            
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyTyped
       String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[a-z A-Z]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_descripcionKeyTyped

    private void salidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salidaKeyTyped
        String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[0-9]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_salidaKeyTyped

    private void entradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entradaKeyTyped
       String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[0-9]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_entradaKeyTyped

    private void parteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parteKeyTyped
         String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[0-9-a-zA-Z]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_parteKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
             ObtenerDatos();
        } catch (Exception e) {
        }
     
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_UP){
        ObtenerDatos();
        }

        if (evt.getKeyCode()==KeyEvent.VK_DOWN){
        ObtenerDatos();
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
      // SumaEntradaSalida();
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
      //SumaEntradaSalida();
    }//GEN-LAST:event_jButton5MouseEntered

    private void entradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_entradaFocusGained
     entrada.setText("");
     salida.setText("0");
    }//GEN-LAST:event_entradaFocusGained

    private void salidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salidaFocusGained
     entrada.setText("0");
     salida.setText("");
    }//GEN-LAST:event_salidaFocusGained

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int x = JOptionPane.showConfirmDialog(null,"¿Deseas cerrar la sesion?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){

            dispose();
            Inicio init1=new Inicio();
            init1.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        BuscaFoco bfoc=new BuscaFoco();
        bfoc.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

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
            java.util.logging.Logger.getLogger(Focos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Focos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Focos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Focos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Focos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Textoex;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField entrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JTextField parte;
    private javax.swing.JTextField salida;
    // End of variables declaration//GEN-END:variables
}
