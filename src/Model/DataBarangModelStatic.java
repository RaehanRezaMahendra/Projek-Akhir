/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Raehan Reza M
 */
public class DataBarangModelStatic {
    private static int idDataBarang;
    private static String Nama_Barang;
    private static int Harga_Barang;
    private static int Stock_Barang;
    private static int Harga_jual_barang;

    public static int getIdDataBarang() {
        return idDataBarang;
    }

    public static void setIdDataBarang(int idDataBarang) {
        DataBarangModelStatic.idDataBarang = idDataBarang;
    }

    public static String getNama_Barang() {
        return Nama_Barang;
    }

    public static void setNama_Barang(String Nama_Barang) {
        DataBarangModelStatic.Nama_Barang = Nama_Barang;
    }

    public static int getHarga_Barang() {
        return Harga_Barang;
    }

    public static void setHarga_Barang(int Harga_Barang) {
        DataBarangModelStatic.Harga_Barang = Harga_Barang;
    }

    public static int getStock_Barang() {
        return Stock_Barang;
    }

    public static void setStock_Barang(int Stock_Barang) {
        DataBarangModelStatic.Stock_Barang = Stock_Barang;
    }

    public static int getHarga_jual_barang() {
        return Harga_jual_barang;
    }

    public static void setHarga_jual_barang(int Harga_jual_barang) {
        DataBarangModelStatic.Harga_jual_barang = Harga_jual_barang;
    }
    
    
}
