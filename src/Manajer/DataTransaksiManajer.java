/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manajer;

import KoneksiHelper.CekKoneksi;
import KoneksiHelper.Koneksi;
import Model.DataTransaksiModel;
import java.util.logging.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Raehan Reza M
 */
public class DataTransaksiManajer {
    public static List<DataTransaksiModel> showAllTransaksi(){
        List<DataTransaksiModel> barangList = new ArrayList<>();
        try{
            Connection conn = Koneksi.getConnection();
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("Select * from transaksi");
            while (rs.next()){
                DataTransaksiModel dt = new DataTransaksiModel();
                dt.setIdDataBarang(Integer.parseInt(rs.getString("idDataBarang")));
                dt.setIdDataKonsumen(Integer.parseInt(rs.getString("idDataKonsumen")));
                dt.setIdDataTransaksi(Integer.parseInt(rs.getString("idDataTransaksi")));
                dt.setPembayaran(Integer.parseInt(rs.getString("Pembayaran")));
                dt.setKembalian(Integer.parseInt(rs.getString("Kembalian")));
                
                barangList.add(dt);
            }
        } catch (SQLException ex){
            Logger.getLogger(CekKoneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barangList;
    }
    
    public static DataTransaksiModel showTransaksi(int id) throws SQLException {
        Connection conn = Koneksi.getConnection();
        DataTransaksiModel dt = new DataTransaksiModel();
        
        PreparedStatement pstmn = conn.prepareStatement("Select * from barang where idDataTransaksi = ?");
        pstmn.setInt(1, id);
        ResultSet rs = pstmn.executeQuery();
        
        while (rs.next()) {
            dt.setIdDataBarang(Integer.parseInt(rs.getString("idDataBarang")));
            dt.setIdDataKonsumen(Integer.parseInt(rs.getString("idDataKonsumen")));
            dt.setIdDataTransaksi(Integer.parseInt(rs.getString("idDataTransaksi")));
            dt.setPembayaran(Integer.parseInt(rs.getString("Pembayaran")));
            dt.setKembalian(Integer.parseInt(rs.getString("Kembalian")));
        }
        return dt;
    }
    
    public static void insertPembayaran(DataTransaksiModel dt) throws SQLException {
        Connection conn = Koneksi.getConnection();
        PreparedStatement pstmn = conn.prepareStatement("insert into transaksi (idDataBarang, "
            + "Pembayaran, Kembalian) values (?, ?, ?)");
        pstmn.setInt(1, dt.getIdDataBarang());
        pstmn.setInt(2, dt.getPembayaran());
        pstmn.setInt(3, dt.getKembalian());
        pstmn.execute();
    }
}
