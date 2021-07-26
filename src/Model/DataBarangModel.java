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
public class DataBarangModel {
    private int idDataBarang;
    private String Nama_Barang;
    private int Harga_Barang;
    private int Stock_Barang;
    private int Harga_jual_barang;

    public int getIdDataBarang() {
        return idDataBarang;
    }

    public void setIdDataBarang(int idDataBarang) {
        this.idDataBarang = idDataBarang;
    }

    public String getNama_Barang() {
        return Nama_Barang;
    }

    public void setNama_Barang(String Nama_Barang) {
        this.Nama_Barang = Nama_Barang;
    }

    public int getHarga_Barang() {
        return Harga_Barang;
    }

    public void setHarga_Barang(int Harga_Barang) {
        this.Harga_Barang = Harga_Barang;
    }

    public int getStock_Barang() {
        return Stock_Barang;
    }

    public void setStock_Barang(int Stock_Barang) {
        this.Stock_Barang = Stock_Barang;
    }

    public int getHarga_jual_barang() {
        return Harga_jual_barang;
    }

    public void setHarga_jual_barang(int Harga_jual_barang) {
        this.Harga_jual_barang = Harga_jual_barang;
    }
    
    
}
