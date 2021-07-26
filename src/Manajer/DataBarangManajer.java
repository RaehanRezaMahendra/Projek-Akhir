/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manajer;
import java.util.*;
import java.sql.*;
import java.util.logging.*;
import KoneksiHelper.*;
import Model.DataBarangModel;
/**
 *
 * @author Raehan Reza M
 */
public class DataBarangManajer {
    public static List<DataBarangModel> showAllBarang(){
        List<DataBarangModel> barangList = new ArrayList<>();
        try{
            Connection conn = Koneksi.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from barang");
            while (rs.next()){
                DataBarangModel db = new DataBarangModel();
                db.setIdDataBarang(Integer.parseInt(rs.getString("idDataBarang")));
                db.setNama_Barang(rs.getString("Nama_Barang"));
                db.setHarga_Barang(Integer.parseInt(rs.getString("Harga_Barang")));
                db.setStock_Barang(Integer.parseInt(rs.getString("Stock_Barang")));
                db.setHarga_jual_barang(Integer.parseInt(rs.getString("Harga_jual_barang")));
                
                barangList.add(db);
            }
        } catch (SQLException ex){
            Logger.getLogger(CekKoneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barangList;
    }
    
    public static DataBarangModel showBarang(int id) throws SQLException {
        Connection conn = Koneksi.getConnection();
        DataBarangModel db = new DataBarangModel();
        
        PreparedStatement pstmn = conn.prepareStatement("Select * from barang where idDataBarang = ?");
        pstmn.setInt(1, id);
        ResultSet rs = pstmn.executeQuery();
        
        while (rs.next()) {
            db.setIdDataBarang(Integer.parseInt(rs.getString("idDataBarang")));
            db.setNama_Barang(rs.getString("Nama_Barang"));
            db.setHarga_Barang(Integer.parseInt(rs.getString("Harga_Barang")));
            db.setStock_Barang(Integer.parseInt(rs.getString("Stock_Barang")));
            db.setHarga_jual_barang(Integer.parseInt(rs.getString("Harga_jual_barang")));
        }
        return db;
    }
    
    public static void updateBarang(DataBarangModel db) throws SQLException {
        Connection conn = Koneksi.getConnection();
        PreparedStatement pstmn = conn.prepareStatement("UPDATE barang SET Nama_Barang =?, "
            + "Harga_Barang = ?, Stock_Barang = ?, Harga_jual_barang = ? WHERE idDataBarang = ?");
        pstmn.setString(1, db.getNama_Barang());
        pstmn.setInt(2, db.getHarga_Barang());
        pstmn.setInt(3, db.getStock_Barang());
        pstmn.setInt(4, db.getHarga_jual_barang());
        pstmn.setInt(5, db.getIdDataBarang());
        pstmn.execute();
    }
    
    public static void insertBarang(DataBarangModel db) throws SQLException {
        Connection conn = Koneksi.getConnection();
        PreparedStatement pstmn = conn.prepareStatement("insert into barang (Nama_Barang, "
            + "Harga_Barang, Stock_Barang, Harga_jual_barang) values (?, ?, ?, ?)");
        pstmn.setString(1, db.getNama_Barang());
        pstmn.setInt(2, db.getHarga_Barang());
        pstmn.setInt(3, db.getStock_Barang());
        pstmn.setInt(4, db.getHarga_jual_barang());
        pstmn.execute();
    }
}
