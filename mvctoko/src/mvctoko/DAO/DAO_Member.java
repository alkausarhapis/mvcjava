/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvctoko.DAO;
import java.sql.Connection;
import mvctoko.DAOImplement.Implement_Member;
import mvctoko.Koneksi.Koneksi_Member_DB;
import mvctoko.Model.Model_Member;

/**
 *
 * @author SMKN4
 */
public class DAO_Member implements Implement_Member {
    
    Connection connection;
    final String insert = "INSERT INTO tb_member_toko (nama, no_telp, alamat, paket) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE tb_member_toko SET nama=?, no_telp=?, alamat=?, paket=? WHERE id=?;";
    final String delete = "DELETE FROM tb_member_toko WHERE id=?;";
    final String select = "SELECT*FROM tb_member_toko;";
    final String cariNama = "SELECT*FROM tb_member_toko WHERE nama LIKE ?;";
    
    
    public DAO_Member() {
        connection = (Connection) Koneksi_Member_DB.connection();
    }
    
    @Override
    public void update(Model_Member b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
        } catch (Exception e) {
        }
    }
}
