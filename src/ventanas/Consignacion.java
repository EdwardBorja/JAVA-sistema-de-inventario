/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edward
 */
public class Consignacion extends javax.swing.JFrame {

    String contraseña,ampm;
    int hora, minutos, segundos; 
    int dia,mes,año;
    
    ventanas.Conector cc = new ventanas.Conector();
    Connection cn = cc.conexion();
    
    
    public Consignacion() {
        initComponents();
        setResizable(false);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        actualizar();
        
        reloj();
        parte.requestFocus();
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
           rs = stmt.executeQuery("SELECT * FROM consignacion order by No_parte asc");
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
      String Parte=jTable1.getValueAt(row, 0).toString();
      String Descripcion=jTable1.getValueAt(row, 1).toString();
      String Marca=jTable1.getValueAt(row, 2).toString();
      String Entrada=jTable1.getValueAt(row, 3).toString();
      String Salida=jTable1.getValueAt(row, 4).toString();
      String Existencias=jTable1.getValueAt(row, 5).toString();
      String Fecha=jTable1.getValueAt(row, 6).toString();
      
        parte.setText(Parte);
        descripcion.setText(Descripcion);
        marca.setText(Marca);
        entrada.setText(Entrada);
        salida.setText(Salida);
        existencias.setText(Existencias);
        fecha.setText(Fecha);
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
        parte = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        entrada = new javax.swing.JTextField();
        salida = new javax.swing.JTextField();
        existencias = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        labelHora = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consignacion");
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/menu.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/caja.png"))); // NOI18N
        jLabel1.setText("Consignacion");

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1417782404_exit.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        parte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parteKeyTyped(evt);
            }
        });

        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });

        marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcaKeyTyped(evt);
            }
        });

        entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                entradaKeyTyped(evt);
            }
        });

        salida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salidaKeyTyped(evt);
            }
        });

        existencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                existenciasKeyTyped(evt);
            }
        });

        fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numero de parte:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripcion:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Entrada:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Salida:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Existencias:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/borrador.png"))); // NOI18N
        jButton3.setText("Borrar campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/agrega.png"))); // NOI18N
        jButton4.setText("Agregar registro");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/edita.png"))); // NOI18N
        jButton5.setText("Modificar registro");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/eliminar.png"))); // NOI18N
        jButton6.setText("Eliminar registro");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText(".");

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText(".");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelFecha)
                                .addGap(46, 46, 46)
                                .addComponent(labelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addComponent(entrada)
                                .addComponent(parte))
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(368, 368, 368))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(marca)
                                        .addComponent(existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(108, 108, 108)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(labelFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, -1));

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
        jMenuBar1.add(jMenu2);

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

    
 
    
    
    private void parteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parteKeyTyped
     String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[0-9-a-zA-Z]"))){
        evt.consume();
        getToolkit().beep();
        }    
        
    }//GEN-LAST:event_parteKeyTyped

    private void descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyTyped
    String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[a-z A-Z]"))){
        evt.consume();
        getToolkit().beep();
        }    
    }//GEN-LAST:event_descripcionKeyTyped

    private void marcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaKeyTyped
       String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[a-z A-Z]"))){
        evt.consume();
        getToolkit().beep();
        }    
    }//GEN-LAST:event_marcaKeyTyped

    private void entradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entradaKeyTyped
       String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[0-9]"))){
        evt.consume();
        getToolkit().beep();
        }    
    }//GEN-LAST:event_entradaKeyTyped

    private void salidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salidaKeyTyped
      String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[0-9]"))){
        evt.consume();
        getToolkit().beep();
        }    
    }//GEN-LAST:event_salidaKeyTyped

    private void existenciasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_existenciasKeyTyped
       String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[0-9]"))){
        evt.consume();
        getToolkit().beep();
        }    
    }//GEN-LAST:event_existenciasKeyTyped

    private void fechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaKeyTyped
      String s1=String.valueOf(evt.getKeyChar());
        
        if(!(s1.matches("[0-9/]"))){
        evt.consume();
        getToolkit().beep();
        }    
    }//GEN-LAST:event_fechaKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       if(parte.getText().equals("") || descripcion.getText().equals("")|| marca.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("")|| existencias.getText().equals("")|| fecha.getText().equals("")){JOptionPane.showMessageDialog(null,"Hay campos vacios");
          }else{
             
         
        
        String Parte,Descripcion,Marca,Entrada,Salida,Existencias,Fecha;

        Parte=parte.getText();
        Descripcion=descripcion.getText();
        Marca=marca.getText();
        Entrada=entrada.getText();
        Salida=(salida.getText());
        Existencias=existencias.getText();
        Fecha=(fecha.getText());
        
        
        
        Connection con = null;
        Statement  stmt = null;
        ResultSet rs;

        
        try {
            

            stmt = cn.createStatement();
          
            //Aqui verifica si existe
            rs = stmt.executeQuery("SELECT * FROM consignacion WHERE `No_parte`='" + Parte + "' and `marca`='" + Marca + "' ");
           
            if(!rs.next()){
            stmt.executeUpdate("INSERT INTO consignacion VALUES ( '" + Parte + "','" + Descripcion + "','" + Marca + "','" + Entrada + "','" + Salida + "','" + Existencias + "','" + Fecha + "')");
            
            
             JOptionPane.showMessageDialog(null,"Se agregó la informacion exitosamente");
             
            }else{ JOptionPane.showMessageDialog(null,"ya existe");}
             
           
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }

        parte.setText("");
        descripcion.setText("");
        marca.setText("");
        entrada.setText("");
        salida.setText("");
        existencias.setText("");
        fecha.setText("");
        
        
        actualizar();
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 ObtenerDatos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        parte.setText("");
        descripcion.setText("");
        marca.setText("");
        entrada.setText("");
        salida.setText("");
        existencias.setText("");
        fecha.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
        
        if(parte.getText().equals("") || descripcion.getText().equals("")|| marca.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("")|| existencias.getText().equals("")|| fecha.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
          }else{
        
        DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
        //Selecciona el valor de la columna 1
        String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
            
        int x = JOptionPane.showConfirmDialog(null,"¿Estas seguro de editar?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){
        
        
        String Parte,Descripcion,Marca,Entrada,Salida,Existencias,Fecha;

        Parte=parte.getText();
        Descripcion=descripcion.getText();
        Marca=marca.getText();
        Entrada=entrada.getText();
        Salida=(salida.getText());
        Existencias=existencias.getText();
        Fecha=(fecha.getText());
        
       Statement  stmt = null;
       

       try {
            
         stmt = cn.createStatement();
        
         try{
         stmt.executeUpdate("UPDATE consignacion set `No_parte`='"+Parte+"',`descripcion`='"+Descripcion+"',`marca`='"+Marca+"',`entrada`='"+Entrada+"',`salida`='"+Salida+"',`existencias`='"+Existencias+"',`fecha`='"+Fecha+"' WHERE( `No_parte`='"+valor1+ "')");
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
        marca.setText("");
        entrada.setText("");
        salida.setText("");
        existencias.setText("");
        fecha.setText("");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      if(parte.getText().equals("") || descripcion.getText().equals("")|| marca.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("")|| existencias.getText().equals("")|| fecha.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
          }else{
        
        DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
        //Selecciona el valor de la columna 1
        String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
            
        int x = JOptionPane.showConfirmDialog(null,"¿Eliminar registro?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){
        
        
     
        Statement  stmt = null;
      
        try {
            
         stmt = cn.createStatement();
        
         try{
         stmt.executeUpdate("DELETE FROM `consignacion` WHERE (`No_parte`='" + valor1 + "')");
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
        marca.setText("");
        entrada.setText("");
        salida.setText("");
        existencias.setText("");
        fecha.setText("");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int x = JOptionPane.showConfirmDialog(null,"¿Deseas cerrar la sesion?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){

            dispose();
            Inicio init1=new Inicio();
            init1.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
       
        if (evt.getKeyCode()==KeyEvent.VK_UP){
        ObtenerDatos();
        }

        if (evt.getKeyCode()==KeyEvent.VK_DOWN){
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
            java.util.logging.Logger.getLogger(Consignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consignacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField entrada;
    private javax.swing.JTextField existencias;
    private javax.swing.JTextField fecha;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField parte;
    private javax.swing.JTextField salida;
    // End of variables declaration//GEN-END:variables
}
