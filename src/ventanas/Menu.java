/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;


import ventanas.Importacion.*;




public class Menu extends javax.swing.JFrame {

    String contraseña,ampm,pass,contra;
    int hora, minutos, segundos; 
    int dia,mes,año;
    
    ventanas.Conector cc = new ventanas.Conector();
    Connection cn = cc.conexion();
    
    
    public Menu() {
        initComponents();
        setResizable(false);
        setSize(1200, 700);
        setLocationRelativeTo(null);
      
    
        reloj();
               // setIconImage(new ImageIcon(getClass().getResource("/ventanas/bus.png")).getImage());

       
     // jTable1.getTableHeader().setReorderingAllowed(false) ;
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
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu");
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText(".");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, -1, -1));

        labelHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText(".");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 40, 90, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Conductor.png"))); // NOI18N
        jButton5.setText("Conductores");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 300, 180));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 300, 180));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/foco.png"))); // NOI18N
        jButton3.setText("Focos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 300, 180));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/refaccion.png"))); // NOI18N
        jButton4.setText("Refacciones");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 300, 180));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/wheel_128.png"))); // NOI18N
        jButton7.setText("Llantas");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 300, 180));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/camion.png"))); // NOI18N
        jButton9.setText("Unidades");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 300, 180));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/informacion.png"))); // NOI18N
        jButton1.setText("Informacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 300, 180));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1417782404_exit.png"))); // NOI18N
        jButton10.setText("Salir");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 580, 100, 50));

        jMenu2.setText("Sesion");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/sesion.png"))); // NOI18N
        jMenuItem1.setText("Cerrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Herramientas");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Items/importar.png"))); // NOI18N
        jMenu1.setText("Importar datos");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Items/light.png"))); // NOI18N
        jMenuItem3.setText("A focos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Items/filt.png"))); // NOI18N
        jMenuItem4.setText("A filtros");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Items/tool.png"))); // NOI18N
        jMenuItem5.setText("A herramientas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Items/bus.png"))); // NOI18N
        jMenuItem6.setText("A refacciones");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Items/llanta.png"))); // NOI18N
        jMenuItem7.setText("A llantas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/itemconduct.png"))); // NOI18N
        jMenuItem2.setText("A Conductores");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/itembus.png"))); // NOI18N
        jMenuItem11.setText("A unidades");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenu4.add(jMenu1);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/1421927738_export.png"))); // NOI18N
        jMenuItem10.setText("Exportar datos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanas/Iconos/Items/cuenta.png"))); // NOI18N
        jMenuItem8.setText("Administrar cuentas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       int x = JOptionPane.showConfirmDialog(null,"¿Deseas cerrar la sesion?","Confirmar",JOptionPane.YES_NO_OPTION);
        if( x == JOptionPane.YES_OPTION){
            
            dispose();
            Inicio init1=new Inicio();
            init1.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

 
    
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
 
         JPasswordField pf = new JPasswordField();
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
       
     
       String password = new String(pf.getPassword());
       
       if( x == JOptionPane.OK_OPTION)
       {
            
             if (password.equals("temsa2015")) 
             {
                 new Cuenta(this, true).setVisible(true);
             }else
                 {
                 JFrame frame = new JFrame();
                 JOptionPane.showMessageDialog(frame, "Contraseña invalida");
                 }
             
        }
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
     new Version(this, true).setVisible(true);
   
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
 JPasswordField pf = new JPasswordField();
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
       
     
       String password = new String(pf.getPassword());
       
       if( x == JOptionPane.OK_OPTION)
       {
            
             if (password.equals("temsa2015")) 
             {
                 new ExportaExcell(this, true).setVisible(true);
             }else
                 {
                 JFrame frame = new JFrame();
                 JOptionPane.showMessageDialog(frame, "Contraseña invalida");
                 }
             
        }
     
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      dispose();
      Conductor conduct=new Conductor();
      conduct.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();
        Herramientas herramienta=new Herramientas();
        herramienta.setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        Filtros filtro=new Filtros();
        filtro.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        dispose();
        Focos foco=new Focos();
        foco.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        Refacciones refaccion=new Refacciones();
        refaccion.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JPasswordField pf = new JPasswordField();
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

        String password = new String(pf.getPassword());

        if( x == JOptionPane.OK_OPTION)
        {

            if (password.equals("temsa2015"))
            {
                new ImportaLlanta(this, true).setVisible(true);
            }else
            {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Contraseña invalida");
            }

        }

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        JPasswordField pf = new JPasswordField();
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

        String password = new String(pf.getPassword());

        if( x == JOptionPane.OK_OPTION)
        {

            if (password.equals("temsa2015"))
            {
                new ImportaRefaccion(this, true).setVisible(true);
            }else
            {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Contraseña invalida");
            }

        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JPasswordField pf = new JPasswordField();
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

        String password = new String(pf.getPassword());

        if( x == JOptionPane.OK_OPTION)
        {

            if (password.equals("temsa2015"))
            {
                new ImportaHerramienta(this, true).setVisible(true);
            }else
            {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Contraseña invalida");
            }

        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      JPasswordField pf = new JPasswordField();
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

        String password = new String(pf.getPassword());

        if( x == JOptionPane.OK_OPTION)
        {

            if (password.equals("temsa2015"))
            {
                new ImportaFiltro(this, true).setVisible(true);
            }else
            {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Contraseña invalida");
            }

        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JPasswordField pf = new JPasswordField();
     
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

        String password = new String(pf.getPassword());

        if( x == JOptionPane.OK_OPTION){

            if (password.equals("temsa2015")) {
                new ImportaFoco(this, true).setVisible(true);
            }else{
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Contraseña invalida");
            }

        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
       Llantas llan=new Llantas();
       llan.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      dispose();
      Unidad unid = new Unidad();
      unid.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
       Relacion rel=new Relacion();
       rel.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
     int x = JOptionPane.showConfirmDialog(null,"¿Deseas salir del programa?","Confirmar",JOptionPane.YES_NO_OPTION);
      
       if( x == JOptionPane.YES_OPTION){
            
                       System.exit(0);


        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        JPasswordField pf = new JPasswordField();
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

        String password = new String(pf.getPassword());

        if( x == JOptionPane.OK_OPTION)
        {

            if (password.equals("temsa2015"))
            {
                new ImportaUnidad(this, true).setVisible(true);
            }else
            {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Contraseña invalida");
            }

        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
 JPasswordField pf = new JPasswordField();
        int x = JOptionPane.showConfirmDialog(null,pf, "Administrador -- Ingrese la contraseña", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);

        String password = new String(pf.getPassword());

        if( x == JOptionPane.OK_OPTION)
        {

            if (password.equals("temsa2015"))
            {
                new ImportaConductor(this, true).setVisible(true);
            }else
            {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Contraseña invalida");
            }

        }           
      
    }//GEN-LAST:event_jMenuItem2ActionPerformed


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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    // End of variables declaration//GEN-END:variables
}
