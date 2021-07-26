/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KoneksiHelper;
import java.sql.*;
import java.util.logging.*;
/**
 *
 * @author Raehan Reza M
 */
public class CekKoneksi {
    public static void main(String[] args) {
        cek();
    }
    
    private static boolean cek(){
        try{
            Koneksi.getConnection();
            System.out.println("Database terhubung!");
            return true;
        }catch (SQLException ex){
            Logger.getLogger(CekKoneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Database tidak terhubung!");
            return false;
        }
    }
}
