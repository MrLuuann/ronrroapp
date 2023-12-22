/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Uriel
 */
public class confPalab extends javax.swing.JFrame {

    /**
     * Creates new form confPalab
     */
    public confPalab() {
        initComponents();
    }

    public void UpInfo(){
        /*
        Este metodo actualiza la informacion de las listas mostradas en la interfaz, primero las limpia por si tiene algun valor
        */
        cBxCat.removeAllItems();
        cBxEdPa.removeAllItems();
        cBxEdPaM.removeAllItems();
        cBxDelPal.removeAllItems();
        /*
        Inicia la conexion
        */
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {
            /*
            Crea la variable para contar cuantas palabras existen
            */
            int nPalabras;
            cn = conexion.conectar();
            String sql = "SELECT COUNT(*) FROM palabras;";
            /*
            Se hace la consulta y se almacena
            */
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            
            nPalabras = rs.getInt("COUNT(*)");
            /*
            Genera una consulta de todas las palabras
            */
            String sql1 = "SELECT palabra FROM palabras";
            
            pst = cn.prepareStatement(sql1);
            rs = pst.executeQuery();
            /*
            Almacena las palabras en las listas de item correspondientes
            */
            for(int i = 0; i < nPalabras; i++)
            {
                rs.next();
                
                cBxEdPa.addItem(rs.getString("palabra"));
                cBxDelPal.addItem(rs.getString("palabra"));
            }
            /*
            Cuenta cuantas palabras mal existen
            */
            int nPalabrasM;
            String sql2 = "SELECT COUNT(*) FROM palabrasm;";
            
            pst = cn.prepareStatement(sql2);
            rs = pst.executeQuery();
            rs.next();
            
            nPalabrasM = rs.getInt("COUNT(*)");
            /*
            Hace consulta de las palabras mal
            */
            String sql3 = "SELECT palabra_mal FROM palabrasm";
            pst = cn.prepareStatement(sql3);
            rs = pst.executeQuery();
            /*
            las guarda en su combo box correspondiente
            */
            for(int i = 0; i < nPalabrasM; i++)
            {
                rs.next();
                
                cBxEdPaM.addItem(rs.getString("palabra_mal"));
            }
            /*
            Hace una consulta del numero de categorias
            */
            int nCategorias;
            String sql4 = "SELECT COUNT(*) FROM categorias;";
            
            pst = cn.prepareStatement(sql4);
            rs = pst.executeQuery();
            rs.next();
            
            nCategorias = rs.getInt("COUNT(*)");
            /*
            Consulta el nombre de cada categoria
            */
            String sql5 = "SELECT nom_categoria FROM categorias";
            pst = cn.prepareStatement(sql5);  
            rs = pst.executeQuery();
            /*
            Muestra el listado de categorias
            */
            for(int i = 0; i < nCategorias; i++)
            {
                rs.next();
                
                cBxCat.addItem(rs.getString("nom_categoria"));
            }
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error: " +e);
            
        }
        
        finally
        {
            try
            {
                /*
                Se cierra la conexion
                */
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnAddPalab = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPalab1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPalab2 = new javax.swing.JTextField();
        cBxCat = new javax.swing.JComboBox<>();
        btnEdiPal = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPalab = new javax.swing.JTextField();
        cBxEdPa = new javax.swing.JComboBox<>();
        btnEdiPalM = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cBxEdPaM = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtPalabM = new javax.swing.JTextField();
        btnDelPal = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cBxDelPal = new javax.swing.JComboBox<>();
        btnHome = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 0, 36)); // NOI18N
        jLabel1.setText("Configuración");

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        btnAddPalab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton-mas.png"))); // NOI18N
        btnAddPalab.setBorder(null);
        btnAddPalab.setContentAreaFilled(false);
        btnAddPalab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPalabActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        jLabel2.setText("Add palabra");

        jLabel3.setText("Palabra:");

        txtPalab1.setText("Palabra");

        jLabel4.setText("Palabra mal:");

        txtPalab2.setText("Pabrala");

        btnEdiPal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recargar.png"))); // NOI18N
        btnEdiPal.setBorder(null);
        btnEdiPal.setContentAreaFilled(false);
        btnEdiPal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdiPalActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        jLabel6.setText("Edit palabra bien");

        jLabel7.setText("Corrección:");

        txtPalab.setText("Palabra");

        btnEdiPalM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recargar.png"))); // NOI18N
        btnEdiPalM.setBorder(null);
        btnEdiPalM.setContentAreaFilled(false);
        btnEdiPalM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdiPalMActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        jLabel8.setText("Edit palabra mal");

        jLabel9.setText("Corrección:");

        txtPalabM.setText("Palabra");

        btnDelPal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/basura.png"))); // NOI18N
        btnDelPal.setBorder(null);
        btnDelPal.setContentAreaFilled(false);
        btnDelPal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelPalActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        jLabel10.setText("Delete palabra");

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Recurso 1.png"))); // NOI18N
        btnHome.setBorder(null);
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        btnExit.setBorder(null);
        btnExit.setContentAreaFilled(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddPalab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cBxCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPalab2)
                            .addComponent(txtPalab1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelPal)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18)
                        .addComponent(cBxDelPal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnEdiPal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPalab))
                            .addComponent(cBxEdPa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(11, Short.MAX_VALUE)
                        .addComponent(btnEdiPalM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cBxEdPaM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPalabM, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHome)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1))
                    .addComponent(btnHome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPalab1)
                        .addComponent(btnAddPalab)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPalab2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(cBxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cBxEdPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPalab)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnEdiPal)))
                        .addGap(11, 11, 11)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cBxEdPaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPalabM)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdiPalM)
                        .addGap(52, 52, 52)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelPal)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cBxDelPal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(147, 147, 147))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        /*
        Este boton se regresa al login si se ha equivocado o cualquier cosa
        */
        login l = new login();
        l.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        /*
        Este boton se regresa al menu del administrador
        */
        editBD eBD = new editBD();
        eBD.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnAddPalabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPalabActionPerformed
        /*
        
        */
        String palabra1, palabra2, cat;
        int idCat, idPal;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {
            /*
            Optiene el texto de las palabras y la categoria seleccionada
            */
            palabra1 = txtPalab1.getText();
            palabra2 = txtPalab2.getText();
            cat = String.valueOf(cBxCat.getSelectedItem());
            /*
            Compara que el campo de las palabras no vaya vacio
            */
            if(!"".equals(palabra1) && !"".equals(palabra2)){
                /*
                Se conecta con la base de datos y consulta el id de la categoria seleccionada
                */
                cn = conexion.conectar();
            
                String sql = "SELECT id_categoria FROM categorias WHERE nom_categoria = '" +cat+ "';";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();

                rs.next();
                idCat = rs.getInt("id_categoria");
                
                /*
                Se insertan los datos en la tabla de palabras con la id de categoria previamente seleccionada
                */
                String sql1 = "INSERT INTO palabras(palabra, id_categoria) VALUES ('" +palabra1+ "', " +idCat+ ");";

                pst = cn.prepareStatement(sql1);
                pst.executeUpdate();

                /*
                Se guarda el ultimo id insertado
                */
                String sql2 = "SELECT LAST_INSERT_ID();";
                pst = cn.prepareStatement(sql2);
                rs = pst.executeQuery();

                rs.next();
                idPal = rs.getInt("LAST_INSERT_ID()");

                /*
                Se agrega la palabra mal de la palabra bien
                */
                String sql3 = "INSERT INTO palabrasm(palabra_mal, id_palabra) VALUES ('" +palabra2+ "', " +idPal+ ");";

                pst = cn.prepareStatement(sql3);
                pst.executeUpdate();

                /*
                Muestra el mensaje de que se han insertado las palabras y se actualiza la lista de palabras para las demas opciones
                */
                JOptionPane.showMessageDialog(null, "Palabra agregada correctamente");
                UpInfo();
            }
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error: " +e);
            
        }
        
        finally
        {
            try
            {
                /*
                Se cierra la conexion
                */
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnAddPalabActionPerformed

    private void btnEdiPalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdiPalActionPerformed
        /*
        Se inicializa la conexion
        */
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {
            /*
            Se identifica que palabra se ha seleccionado y se guarda
            */
            String itemSel;
            itemSel = String.valueOf(cBxEdPa.getSelectedItem());
            cn = conexion.conectar();
            /*
            Se comprueba que el campo no este vacio
            */
            if(!"".equals(txtPalab.getText())){
                /*
                Se actualiza la palabra a la escrita
                */
                String sql = "UPDATE palabras SET palabra='" +txtPalab.getText()+ "' WHERE palabra='" +itemSel+ "';";
                pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                /*
                Se manda un aviso de que se ha actualizado la palabra y se actualiza la lista
                */
                JOptionPane.showMessageDialog(null, "Palabra actualizado");
                UpInfo();
            }else{
                JOptionPane.showMessageDialog(null, "Algun dato esta vacio");
            }
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error: " +e);
            
        }
        
        finally
        {
            try
            {
                /*
                Se cierra la conexion
                */
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnEdiPalActionPerformed

    private void btnEdiPalMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdiPalMActionPerformed
        /*
        Se inicializa la conexion
        */
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {
            /*
            Se identifica que palabra se ha seleccionado y se guarda
            */
            String itemSel;
            itemSel = String.valueOf(cBxEdPaM.getSelectedItem());
            cn = conexion.conectar();
            if(!"".equals(txtPalabM.getText())){
                /*
                Se actualiza la palabra a la escrita
                */
                String sql = "UPDATE palabrasm SET palabra_mal='" +txtPalabM.getText()+ "' WHERE palabra_mal='" +itemSel+ "';";

                pst = cn.prepareStatement(sql);
                pst.executeUpdate();
                /*
                Se manda un aviso de que se ha actualizado la palabra y se actualiza la lista
                */
                JOptionPane.showMessageDialog(null, "Palabra actualizado");
                UpInfo();
            }else{
                JOptionPane.showMessageDialog(null, "Algun dato esta vacio");
            }
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error: " +e);
            
        }
        
        finally
        {
            try
            {
                /*
                Se cierra la conexion
                */
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnEdiPalMActionPerformed

    private void btnDelPalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelPalActionPerformed
        /*
        Se inicializa la conexion
        */
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {
            /*
            Se identifica que categoria se ha seleccionado y se guarda
            */
            String itemSel;
            int idPal;
            itemSel = String.valueOf(cBxDelPal.getSelectedItem());
            cn = conexion.conectar();
            /*
            Se identifica su id
            */
            String sql2 = "SELECT id_palabra FROM palabras WHERE palabra = '" +itemSel+ "';";
            pst = cn.prepareStatement(sql2);
            rs = pst.executeQuery();
            
            rs.next();
            
            idPal = rs.getInt("id_palabra");
            
            /*
            Se borra la palabra seleccionada en la tabla de palabras bien
            */
            String sql = "DELETE FROM palabrasm WHERE id_palabra='" +idPal+ "';";
            
            pst = cn.prepareStatement(sql);
            pst.executeUpdate();
            
            /*
            Se borra la palabra seleccionada en la tabla de palabras bien
            */
            String sql3 = "DELETE FROM palabras WHERE id_palabra='" +idPal+ "';";
            
            pst = cn.prepareStatement(sql3);
            pst.executeUpdate();
            
            /*
            Se muestra el mensaje de que la palabra se ha borrado y se actualizan las listas
            */
            JOptionPane.showMessageDialog(null, "Palabra borrada");
            UpInfo();
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error: " +e);
            
        }
        
        finally
        {
            try
            {
                /*
                Se cierra la conexion
                */
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnDelPalActionPerformed

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
            java.util.logging.Logger.getLogger(confPalab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confPalab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confPalab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confPalab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new confPalab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPalab;
    private javax.swing.JButton btnDelPal;
    private javax.swing.JButton btnEdiPal;
    private javax.swing.JButton btnEdiPalM;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHome;
    private javax.swing.JComboBox<String> cBxCat;
    private javax.swing.JComboBox<String> cBxDelPal;
    private javax.swing.JComboBox<String> cBxEdPa;
    private javax.swing.JComboBox<String> cBxEdPaM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField txtPalab;
    private javax.swing.JTextField txtPalab1;
    private javax.swing.JTextField txtPalab2;
    private javax.swing.JTextField txtPalabM;
    // End of variables declaration//GEN-END:variables
}