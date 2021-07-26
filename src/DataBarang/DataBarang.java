/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBarang;

import DataMenu.DataMenu;
import java.util.logging.*;
import Model.DataBarangModel;
import java.sql.*;
import javax.swing.JOptionPane;
import Manajer.DataBarangManajer;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author Raehan Reza M
 */
public class DataBarang extends javax.swing.JFrame {
    int barangID = 0;
    DataBarangModel databarangGlobal;
    public static DefaultTableModel tableModel;
    public static List<DataBarangModel> listBarang;
    /**
     * Creates new form DataBarang
     */
    
    private void initTableBarang(){
        String[] barangColumns = new String[]{"ID", "Nama Barang", "Harga Barang", "Harga jual barang", "Stock Barang"};
        int[] columnWidth = {
            70,190,210,90,60
        };
        
        tableModel = new DefaultTableModel(barangColumns, 0);
        TabelBarang.setModel(tableModel);
        TabelBarang.setRowHeight(20);
        
        int i=0;
        for(int width : columnWidth){
            TableColumn column = TabelBarang.getColumnModel().getColumn(i++);
            column.setMaxWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
    }
    
    public static void loadBarang(){
        listBarang = new ArrayList<>();
        listBarang = DataBarangManajer.showAllBarang();
        tableModel.setRowCount(0);
        listBarang.forEach(db -> {
            tableModel.addRow(new Object[]{
                db.getIdDataBarang(),
                db.getNama_Barang(),
                db.getHarga_Barang(),
                db.getHarga_jual_barang(),
                db.getStock_Barang()
            });
        });
    }
    
    public DataBarang() {
        initComponents();
        initTableBarang();
        loadBarang();
    }
    
    
    
    public DataBarang(int id){
        initComponents();
        setLocationRelativeTo(null);
        barangID = id;
        
        try {
            setBarangToComponent(barangID);
        } catch (SQLException ex) {
            Logger.getLogger(DataBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void showMessage(String message, int type){
        if (type == 1){
            JOptionPane.showMessageDialog(this, message, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateInput() throws SQLException{
        boolean isCompleted = false;
        DataBarangModel db = new DataBarangModel();
        //kode barang
        if (awKode.getText().isEmpty()) {
            isCompleted = false;
            awKode.requestFocus();
        } else {
            db.setIdDataBarang(Integer.parseInt(awKode.getText().toString()));
            isCompleted = true;
        }
        //nama barang
        if (adNama.getText().isEmpty()) {
            isCompleted = false;
            adNama.requestFocus();
        } else {
            db.setNama_Barang(adNama.getText());
            isCompleted = true;
        }
        //harga barang
        if (akHarga.getText().isEmpty()) {
            isCompleted = false;
            akHarga.requestFocus();
        } else {
            db.setHarga_Barang(Integer.parseInt(akHarga.getText().toString()));
            isCompleted = true;
        }
        //harga jual
        if (amJual.getText().isEmpty()) {
            isCompleted = false;
            amJual.requestFocus();
        } else {
            db.setHarga_jual_barang(Integer.parseInt(amJual.getText().toString()));
            isCompleted = true;
        }
        //stock barang
        if (avStock.getText().isEmpty()) {
            isCompleted = false;
            avStock.requestFocus();
        } else {
            db.setStock_Barang(Integer.parseInt(avStock.getText().toString()));
            isCompleted = true;
        }
        
        databarangGlobal = db;
        if (!isCompleted) {
            showMessage("Data harus dilengkapi!", 2);
            return false;
        } else {            
            return true;
        }
    }
    
    private void setBarangToComponent(int barangID) throws SQLException {
        DataBarangModel db = DataBarangManajer.showBarang(barangID);
        db.setIdDataBarang(barangID);
        awKode.setText(String.valueOf(db.getIdDataBarang()));
        adNama.setText(db.getNama_Barang());
        akHarga.setText(String.valueOf(db.getHarga_Barang()));
        amJual.setText(String.valueOf(db.getHarga_jual_barang()));
        avStock.setText(String.valueOf(db.getStock_Barang()));
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelBarang = new javax.swing.JTable();
        amAdd = new javax.swing.JButton();
        aeEdit = new javax.swing.JButton();
        btBack = new javax.swing.JButton();
        awKode = new javax.swing.JTextField();
        adNama = new javax.swing.JTextField();
        akHarga = new javax.swing.JTextField();
        amJual = new javax.swing.JTextField();
        avStock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        agRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Adobe Arabic", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA BARANG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Kode Barang");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nama Barang");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Harga Barang");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Harga Jual");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Stock");

        TabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama", "Harga", "Harga Jual", "Stock"
            }
        ));
        jScrollPane2.setViewportView(TabelBarang);

        amAdd.setText("ADD");
        amAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amAddActionPerformed(evt);
            }
        });

        aeEdit.setText("EDIT");
        aeEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aeEditActionPerformed(evt);
            }
        });

        btBack.setText("< BACK");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        awKode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        adNama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        akHarga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Adobe Arabic", 3, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("APLIKASI THRIFTING JACKET");

        agRefresh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        agRefresh.setText("REFRESH");
        agRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btBack)
                                    .addGap(150, 150, 150))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(awKode)
                                            .addComponent(adNama, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(amJual)
                                            .addComponent(akHarga)
                                            .addComponent(avStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(amAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(aeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(agRefresh)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(awKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(adNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(akHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(amJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(avStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aeEdit)
                            .addComponent(amAdd))
                        .addGap(18, 18, 18)
                        .addComponent(agRefresh)
                        .addGap(61, 61, 61)
                        .addComponent(btBack))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amAddActionPerformed
        // TODO add your handling code here:
        try {
            if (validateInput()) {
                DataBarangManajer.insertBarang(databarangGlobal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_amAddActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        // TODO add your handling code here:
        dispose();
        new DataMenu().setVisible(true); 
    }//GEN-LAST:event_btBackActionPerformed

    private void aeEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aeEditActionPerformed
        // TODO add your handling code here:
        int selectedRow = TabelBarang.getSelectedRow();
        if(selectedRow == -1){
            showMessage("Pilih Baris Dulu!", 2);
        }else{
            DataBarangModel db = listBarang.get(selectedRow);
            try {
                if (validateInput()) {
                    DataBarangManajer.updateBarang(databarangGlobal);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_aeEditActionPerformed

    private void agRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agRefreshActionPerformed
        // TODO add your handling code here:
        loadBarang();
        JOptionPane.showMessageDialog(this, "Tabel berhasil direfresh");
    }//GEN-LAST:event_agRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(DataBarangModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBarangModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBarangModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBarangModel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelBarang;
    private javax.swing.JTextField adNama;
    private javax.swing.JButton aeEdit;
    private javax.swing.JButton agRefresh;
    private javax.swing.JTextField akHarga;
    private javax.swing.JButton amAdd;
    private javax.swing.JTextField amJual;
    private javax.swing.JTextField avStock;
    private javax.swing.JTextField awKode;
    private javax.swing.JButton btBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public int getIdDataBarang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNama_Barang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getHarga_Barang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getHarga_jual_barang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStock_Barang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
