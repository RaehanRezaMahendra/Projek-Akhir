/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manajer;
import KoneksiHelper.Koneksi;
import java.sql.*;
import Model.DataPenggunaModel;
/**
 *
 * @author Raehan Reza M
 */
public class DataPenggunaManajer {
    public static void tambahAkun(DataPenggunaModel dp) throws SQLException{
        Connection conn = Koneksi.getConnection();
        PreparedStatement pstmn = conn.prepareStatement("insert into datapengguna (idDataPengguna , Nama_Pengguna, "
            + "Password_pengguna, Username) values (?, ?, ?, ?)");
        pstmn.setInt(1, dp.getIdDataPengguna());
        pstmn.setString(2, dp.getNama_Pengguna());
        pstmn.setString(3, dp.getPassword_pengguna());
        pstmn.setString(4, dp.getUsername());
        pstmn.execute();
    }
}
