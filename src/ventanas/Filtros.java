/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import Busqueda.BuscaFiltro;
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
public class Filtros extends javax.swing.JFrame {

    String contraseña,ampm;
    int hora, minutos, segundos; 
    int dia,mes,año;
    
    ventanas.Conector cc = new ventanas.Conector();
    Connection cn = cc.conexion();
    
    public Filtros() {
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
        entrada.setText("0");
        salida.setText("0");
        //existencias.setText(Existencias);
        Textoex.setText(Existencias);
        jLabel8.setText("Fecha : "+Fecha);
     }
     
     public void SumaEntradaSalida(){
     try {
        int Compara1,Compara2,Total;
               
        Compara1 = Integer.parseInt(entrada.getText());
        Compara2 = Integer.parseInt(salida.getText());
   
        
        Total=Compara1-Compara2;
        
        if(Total<5){
         JOptionPane.showMessageDialog(null,"No es valido");
        }
       
        
        } catch (Exception e) {
        }
    
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
        jLabel2 = new javax.swing.JLabel();
        parte = new javax.swing.JTextField();
        entrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        salida = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        marca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        Textoex = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Filtros");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/lista.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/filtro_30.png"))); // NOI18N
        jLabel1.setText("Filtros");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No_parte:");

        parte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parteKeyTyped(evt);
            }
        });

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Entrada de producto:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Salida de producto:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripcion:");

        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Existencias:");

        marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                marcaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca:");

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

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/eliminar.png"))); // NOI18N
        jButton6.setText("Eliminar registro");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText(".");

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText(".");

        Textoex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Textoex.setForeground(new java.awt.Color(255, 255, 255));
        Textoex.setText("_");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(106, 106, 106)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(entrada)
                                    .addComponent(parte, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Textoex, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(75, 75, 75)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFecha)
                    .addComponent(labelHora))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Textoex)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(117, 117, 117))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 710));

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

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/search.png"))); // NOI18N
        jMenu2.setText("Busqueda");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
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

    private void entradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entradaKeyTyped
        String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[0-9]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_entradaKeyTyped

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

    private void marcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marcaKeyTyped
        String s1=String.valueOf(evt.getKeyChar());

        if(!(s1.matches("[a-z A-Z]"))){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_marcaKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
       
        
        
        if(parte.getText().equals("") || descripcion.getText().equals("")|| marca.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("")){JOptionPane.showMessageDialog(null,"Hay campos vacios");
        }else{
       
            
           
            String Parte,Tipo,Marca,Entrada,Salida,Fecha;
            Parte=parte.getText();
            Tipo=descripcion.getText();
            Marca=marca.getText();
            Entrada=entrada.getText();
            Salida=(salida.getText());
           
            Fecha=(labelFecha.getText());
 
           
         
            Connection con = null;
            Statement  stmt = null;
            ResultSet rs;

            try {
            

            stmt = cn.createStatement();
          
            //Aqui verifica si existe
                            rs = stmt.executeQuery("SELECT * FROM filtros WHERE `No_filtro`='" + Parte + "' and `marca`='" + Marca + "' ");

           
            if(!rs.next()){
   		 stmt.executeUpdate("INSERT INTO filtros VALUES ( '" + Parte + "','" + Tipo + "','" + Marca + "','" + Entrada + "','" + Salida + "','" + Entrada + "','" + Fecha + "')");

            
            
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
            jLabel8.setText("Fecha:");

            actualizar();
     

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        
        if(parte.getText().equals("") || descripcion.getText().equals("")|| marca.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("") ){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
        }else{

            DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
            //Selecciona el valor de la columna 1
           // String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));

            int x = JOptionPane.showConfirmDialog(null,"¿Estas seguro de editar?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){

                String Parte,Tipo,Marca,Entrada,Salida,Existencias,Fecha;

                Parte=parte.getText();
                Tipo=descripcion.getText();
                Marca=marca.getText();
                Entrada=entrada.getText();
                Salida=salida.getText();
                Existencias=Textoex.getText();
                Fecha=(labelFecha.getText());

                Statement  stmt = null;
               

                 try {
            
         stmt = cn.createStatement();
        
         try{
         stmt.executeUpdate("UPDATE filtros set `No_filtro`='"+Parte+"',`Tipo`='"+Tipo+"',`marca`='"+Marca+"',`entrada`='"+Entrada+"'+`entrada`,`salida`=`salida`+'"+Salida+"',`existencias`=`existencias`+'"+Entrada+"'-'"+Salida+"',`fecha`='"+Fecha+"' WHERE( `No_filtro`='"+Parte+ "')");

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
            Textoex.setText("");
            jLabel8.setText("Fecha:");
           
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(parte.getText().equals("") || descripcion.getText().equals("")|| marca.getText().equals("")|| entrada.getText().equals("")|| salida.getText().equals("")){JOptionPane.showMessageDialog(null,"Selecciona un registro de la tabla");
        }else{

            DefaultTableModel modelo= (DefaultTableModel)jTable1.getModel();
            //Selecciona el valor de la columna 1
           // String valor1= String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));

            int x = JOptionPane.showConfirmDialog(null,"¿Eliminar registro?","Confirmar",JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){

                Connection con = null;
                Statement  stmt = null;
                ResultSet rs;

         try {
            
         stmt = cn.createStatement();
        
         try{
         stmt.executeUpdate("DELETE FROM `filtros` WHERE (`No_filtro`='" + parte.getText() + "')");
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
            Textoex.setText("");
            jLabel8.setText("Fecha:");
            
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            ObtenerDatos();
        } catch (Exception e) {
        }
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        parte.setText("");
        descripcion.setText("");
        marca.setText("");
        entrada.setText("");
        salida.setText("");
        Textoex.setText("");
        jLabel8.setText("Fecha:");
    }//GEN-LAST:event_jButton3ActionPerformed

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
        salida.setText("");
        entrada.setText("0");
        
    }//GEN-LAST:event_salidaFocusGained

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       BuscaFiltro bf=new BuscaFiltro();
       bf.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

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
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filtros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filtros().setVisible(true);
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
