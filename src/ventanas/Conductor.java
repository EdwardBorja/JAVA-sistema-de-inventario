/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;


import Busqueda.BuscaConductor;
import Busqueda.BuscaUnidad;
import Usuario.ConConductor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edward
 */
public class Conductor extends javax.swing.JFrame {

    String contraseña,ampm;
    int hora, minutos, segundos; 
    int dia,mes,año;
    
    ventanas.Conector cc = new ventanas.Conector();
    Connection cn = cc.conexion();
    
    public Conductor() {
        initComponents();
        setResizable(false);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        actualizar();
        reloj();
        conductor.requestFocus();
        rut.setVisible(false);
        

      
        jTable1.getTableHeader().setReorderingAllowed(false) ;
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
               
        Entrada = Integer.parseInt(edad.getText());
        Salida = Integer.parseInt(nombre.getText());
   
        
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
      String Conductor=jTable1.getValueAt(row, 0).toString();
      String Nombre=jTable1.getValueAt(row, 1).toString();
      String Edad =jTable1.getValueAt(row, 2).toString();
      String Ciudad =jTable1.getValueAt(row, 3).toString();
      String Telefono =jTable1.getValueAt(row, 4).toString();
      String IMAGEN=jTable1.getValueAt(row, 5).toString();
      String Unidad =jTable1.getValueAt(row, 6).toString();
      
      
      conductor.setText(Conductor);
      nombre.setText(Nombre);
      edad.setText(Edad);
      ciudad.setText(Ciudad);
      tel.setText(Telefono);
      unidad.setText(Unidad);
      
      rut.setText(IMAGEN);
  
      ImageIcon img = new ImageIcon(IMAGEN);
      jLabel6.setIcon(new ImageIcon(img.getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH)));
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
           rs = stmt.executeQuery("SELECT * FROM conductor order by id_conductor asc");
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
        ciudad = new javax.swing.JTextField();
        conductor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edad = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        rut = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tel = new javax.swing.JTextField();
        unidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Conductores");
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Conductor.png"))); // NOI18N
        jLabel1.setText("Conductores");
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

        ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ciudadKeyTyped(evt);
            }
        });
        jPanel1.add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 230, -1));

        conductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                conductorKeyTyped(evt);
            }
        });
        jPanel1.add(conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 230, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ciudad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID conductor:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edadKeyTyped(evt);
            }
        });
        jPanel1.add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 230, -1));

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 230, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/borrador.png"))); // NOI18N
        jButton3.setText("Borrar campos");
        jButton3.setPreferredSize(new java.awt.Dimension(200, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

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
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/eliminar.png"))); // NOI18N
        jButton6.setText("Eliminar registro");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setPreferredSize(new java.awt.Dimension(250, 250));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 200, 190));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/imselect.png"))); // NOI18N
        jButton7.setText("Seleccionar Imagen");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 220, -1));

        rut.setEditable(false);
        jPanel1.add(rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 160, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/actualizar.png"))); // NOI18N
        jButton5.setText("Actualizar registro");
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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/edita.png"))); // NOI18N
        jButton8.setText("Modificar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 150, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telKeyTyped(evt);
            }
        });
        jPanel1.add(tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 230, -1));

        unidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unidadKeyTyped(evt);
            }
        });
        jPanel1.add(unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 230, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No_unidad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

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
        conductor.setText("");
        ciudad.setText("");
        edad.setText("");
        nombre.setText("");
        tel.setText("");
        unidad.setText("");
        
        jLabel6.setIcon(null);
        
     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(conductor.getText().equals("") || nombre.getText().equals("")|| edad.getText().equals("")|| ciudad.getText().equals("")|| tel.getText().equals("")|| unidad.getText().equals("")){JOptionPane.showMessageDialog(null,"Hay campos vacios");
        }else{

            String Conductor,Nombre,Edad,Ciudad,Telefono,Imagen,Unidad;

            Conductor=conductor.getText();
            Nombre=nombre.getText();
            Edad=edad.getText();
            Ciudad=(ciudad.getText());
            Telefono=tel.getText();
            Imagen=(rut.getText());
            Unidad=unidad.getText();

         
            Statement  stmt = null;
            ResultSet rs;

             try {
            

            stmt = cn.createStatement();
          
            //Aqui verifica si existe
            rs = stmt.executeQuery("SELECT * FROM conductor WHERE `id_conductor`='" + Conductor + "'");
           
            if(!rs.next()){
                
               
            stmt.executeUpdate("INSERT INTO conductor VALUES ( '" + Conductor + "','" + Nombre + "','" + Edad + "','" + Ciudad + "','" + Telefono + "','" + Imagen + "','" + Unidad + "')");
                               JOptionPane.showMessageDialog(null,"Se agregó la informacion exitosamente");
             
             
            }else{ JOptionPane.showMessageDialog(null,"ya existe");}
             
            
        }
        catch( SQLException e) {
            e.printStackTrace();
            
        }

          
            conductor.setText("");
            nombre.setText("");
            edad.setText("");
            ciudad.setText("");
            tel.setText("");
            unidad.setText("");
           
            jLabel6.setIcon(null);
            

            actualizar();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         if(ciudad.getText().equals("") || conductor.getText().equals("")|| edad.getText().equals("")|| nombre.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
        }else{

            DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
            String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
           

            int x = JOptionPane.showConfirmDialog(null,"¿Eliminar registro?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){
   Statement  stmt = null;
      
        try {
            
         stmt = cn.createStatement();
        
         try{
             stmt.executeUpdate("DELETE FROM `conductor` WHERE (`id_conductor`='"+conductor.getText()+"')");
                                 JOptionPane.showMessageDialog(null,"Eliminado exitosamente");

            }catch( SQLException e ){}
          
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        
                actualizar();

            }
            
            conductor.setText("");
            ciudad.setText("");
            edad.setText("");
            nombre.setText("");
            tel.setText("");
            unidad.setText("");
            jLabel6.setIcon(null);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ciudadKeyTyped
       String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[a-z A-Z]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_ciudadKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[a-z A-Z]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edadKeyTyped
       String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[0-9]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_edadKeyTyped

    private void conductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conductorKeyTyped
         String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[0-9-a-zA-Z]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_conductorKeyTyped

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int x = JOptionPane.showConfirmDialog(null,"¿Deseas cerrar la sesion?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){

            dispose();
            Inicio init1=new Inicio();
            init1.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        
        BuscaConductor bconduc=new BuscaConductor();
        bconduc.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
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
                    jLabel6.setIcon(new ImageIcon(img.getImage().getScaledInstance(200, 200,Image.SCALE_SMOOTH)));

                }catch(java.lang.Exception e){}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
actualizar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(conductor.getText().equals("") || nombre.getText().equals("")|| edad.getText().equals("")|| ciudad.getText().equals("")|| tel.getText().equals("")|| unidad.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
        }else{

           
                int x = JOptionPane.showConfirmDialog(null,"¿Editar registro?","Confirmar",JOptionPane.YES_NO_OPTION);
                if( x == JOptionPane.YES_OPTION){

                    

            String Conductor,Nombre,Edad,Ciudad,Telefono,Imagen,Unidad;

            Conductor=conductor.getText();
            Nombre=nombre.getText();
            Edad=edad.getText();
            Ciudad=(ciudad.getText());
            Telefono=tel.getText();
            Imagen=(rut.getText());
            Unidad=unidad.getText();
                    
                   

                    Statement  stmt = null;

                    try {

                        stmt = cn.createStatement();

                        try{
                            stmt.executeUpdate("UPDATE conductor set `nombre`='"+Nombre+"',`edad`='"+Edad+"',`ciudad`='"+Ciudad+"',`telefono`='"+Telefono+"',`imagen`='"+Imagen+"',`no_unidad`='"+Unidad+"' WHERE( `id_conductor`='"+Conductor+"')");
                            JOptionPane.showMessageDialog(null,"Editado exitosamente");

                        }catch( SQLException e ){JOptionPane.showMessageDialog(null,"No se editó");}

                    }
                    catch( SQLException e ) {
                        e.printStackTrace();
                    }

                    actualizar();
                }

                conductor.setText("");
                ciudad.setText("");
                edad.setText("");
                nombre.setText("");
                ciudad.setText("");
                tel.setText("");
                rut.setText("");
                jLabel6.setIcon(null);
            }

        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_telKeyTyped

    private void unidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_unidadKeyTyped

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
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField conductor;
    private javax.swing.JTextField edad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField rut;
    private javax.swing.JTextField tel;
    private javax.swing.JTextField unidad;
    // End of variables declaration//GEN-END:variables
}
