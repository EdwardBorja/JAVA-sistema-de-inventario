/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Usuario;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
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
import ventanas.*;

/**
 *
 * @author edward
 */
public class ConFiltros extends javax.swing.JFrame {

    String contraseña,ampm;
    int hora, minutos, segundos; 
    int dia,mes,año;
    ventanas.Conector cc = new ventanas.Conector();
    Connection cn = cc.conexion();
    
    public ConFiltros() {
        initComponents();
        setResizable(false);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        actualizar();
      
        reloj();
        parte.requestFocus();
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
           rs = stmt.executeQuery("SELECT * FROM filtros order by No_filtro asc");
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
        Operacion();
    } 
    
    public void BuscaParte(){
     
        String Parte;
        Parte=(parte.getText());
        
         Statement stmt;
        ResultSet rs;
        ResultSetMetaData metadata;

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTable1.setModel(modelo);
           stmt = cn.createStatement();
          
	  rs = stmt.executeQuery("SELECT * FROM filtros where `No_filtro` like '%"+Parte+"%'  ");

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
        Operacion();
        parte.setText("");
    }
    
    public void BuscaDescripcion(){
     
        String Tipo;
        Tipo=(descripcion.getText());
        
       
        Statement stmt;
        ResultSet rs;
        ResultSetMetaData metadata;

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTable1.setModel(modelo);
           stmt = cn.createStatement();
          
	  rs = stmt.executeQuery("SELECT * FROM filtros where `Tipo` like '%"+Tipo+"%' ");


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
        Operacion();
        descripcion.setText("");
    }
    
     public void BuscaMarca(){
     
        String Marca;
        Marca=(marca.getText());
        
        Statement stmt;
        ResultSet rs;
        ResultSetMetaData metadata;

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTable1.setModel(modelo);
           stmt = cn.createStatement();
          
	 rs = stmt.executeQuery("SELECT * FROM filtros where `marca` like '%"+Marca+"%' ");

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
        Operacion();
        marca.setText("");
    }
   
     public void SumaExistencia() {
        //Aquí sumo los valores de la fila para colocarlos en el JTextField totalCampo
        double sumatoria;    int valor = 0;
        int fila = jTable1.getRowCount();
        fila -= 1;
        for (int i = 0; i <= (fila); i++) {
            sumatoria = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 5)));
            valor += sumatoria;
        }
        jLabel9.setText(String.valueOf(valor));
    }
    
    public void Operacion(){
            SumaExistencia();

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        parte = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
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
        setTitle("Filtros");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/lista.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 130, -1));

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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 221, 1105, 332));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1417782404_exit.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 571, 102, 41));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/buscar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/filtro_30.png"))); // NOI18N
        jLabel1.setText("Filtros");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText(".");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 98, -1));

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText(".");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        parte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                parteFocusGained(evt);
            }
        });
        parte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                parteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parteKeyTyped(evt);
            }
        });
        jPanel1.add(parte, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 210, -1));

        descripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descripcionFocusGained(evt);
            }
        });
        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 210, -1));

        marca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                marcaFocusGained(evt);
            }
        });
        marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                marcaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcaKeyTyped(evt);
            }
        });
        jPanel1.add(marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 210, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Numero de parte:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/actualizar.png"))); // NOI18N
        jButton6.setText("Actualizar datos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 160, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("piezas");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Piezas totales :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/buscar.png"))); // NOI18N
        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, 230, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, -1));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        MenuUsuario menu2=new MenuUsuario();
        menu2.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int x = JOptionPane.showConfirmDialog(null,"¿Deseas salir del programa?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){
            
                       System.exit(0);


        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
 
    
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        MessageFormat header=new MessageFormat("Reporte");

        MessageFormat footer=new MessageFormat("Page{1,number,integer}");

        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(ConFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      actualizar();
    }//GEN-LAST:event_jButton6ActionPerformed

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
            dispose();
            Inicio init1=new Inicio();
            init1.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void parteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parteKeyPressed
     if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        if(parte.getText().equals("")){JOptionPane.showMessageDialog(null,"Campo vacio");
            }else{
                  BuscaParte();
                  parte.setText("");
                 }
       }
    }//GEN-LAST:event_parteKeyPressed

    private void descripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyPressed
      if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        if(descripcion.getText().equals("")){JOptionPane.showMessageDialog(null,"Campo vacio");
            }else{
                  BuscaDescripcion();
                  descripcion.setText("");
                 }
       }
    }//GEN-LAST:event_descripcionKeyPressed

    private void marcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaKeyPressed
       if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        if(marca.getText().equals("")){JOptionPane.showMessageDialog(null,"Campo vacio");
            }else{
                  BuscaMarca();
                  marca.setText("");
                 }
       }
    }//GEN-LAST:event_marcaKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       
        if(parte.getText().equals("") && descripcion.getText().equals("") && marca.getText().equals("")){JOptionPane.showMessageDialog(null, "Ingresa Datos");
        }else{

            if(parte.getText().isEmpty() && descripcion.getText().isEmpty()){
                BuscaMarca();
            }   
            else if(descripcion.getText().isEmpty() && marca.getText().isEmpty()){
                BuscaParte();
            }
           
             else if(marca.getText().isEmpty() && parte.getText().isEmpty()){
                BuscaDescripcion();
            }

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void parteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parteFocusGained
       descripcion.setText("");
       marca.setText("");
    }//GEN-LAST:event_parteFocusGained

    private void descripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descripcionFocusGained
        parte.setText("");
        marca.setText("");
    }//GEN-LAST:event_descripcionFocusGained

    private void marcaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaFocusGained
        descripcion.setText("");
        parte.setText("");
    }//GEN-LAST:event_marcaFocusGained

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
            java.util.logging.Logger.getLogger(ConFiltros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConFiltros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConFiltros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConFiltros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConFiltros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descripcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField parte;
    // End of variables declaration//GEN-END:variables
}
