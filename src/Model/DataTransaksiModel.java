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
public class DataTransaksiModel {
    private int idDataTransaksi;
    private int idDataKonsumen;
    private int idDataBarang;
    private int pembayaran;
    private int kembalian;

    public int getIdDataTransaksi() {
        return idDataTransaksi;
    }

    public void setIdDataTransaksi(int idDataTransaksi) {
        this.idDataTransaksi = idDataTransaksi;
    }

    public int getIdDataKonsumen() {
        return idDataKonsumen;
    }

    public void setIdDataKonsumen(int idDataKonsumen) {
        this.idDataKonsumen = idDataKonsumen;
    }

    public int getIdDataBarang() {
        return idDataBarang;
    }

    public void setIdDataBarang(int idDataBarang) {
        this.idDataBarang = idDataBarang;
    }

    public int getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(int pembayaran) {
        this.pembayaran = pembayaran;
    }

    public int getKembalian() {
        return kembalian;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }
    
    
}
