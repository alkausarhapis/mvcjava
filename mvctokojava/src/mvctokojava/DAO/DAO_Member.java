/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctokojava.DAO;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvctokojava.DAOImplement.Implement_Member;
import mvctokojava.Koneksi.Koneksi_Member_DB;
import mvctokojava.Model.Model_Member;

/**
 *
 * @author SMKN4
 */
public class DAO_Member implements Implement_Member {
     Connection connection;
    final String insert = "INSERT INTO tb_member_toko (nama,no_telp,alamat,paket) VALUES (?,?,?,?);";
    final String update = "UPDATE tb_member_toko set nama=?, no_telp=?, alamat=?, paket=? where id=? ;";
    final String delete = "DELETE FROM tb_member_toko where id=? ;";
    final String select = "SELECT * FROM tb_member_toko;";
    final String carinama = "SELECT * FROM tb_member_toko where nama like ?";

    
    
    public DAO_Member() {
        connection = (Connection) Koneksi_Member_DB.connection();
    }
    
     @Override
    public void insert(Model_Member b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getNo_telp());
            statement.setString(3, b.getAlamat());
            statement.setString(4, b.getPaket());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Model_Member b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNama());
            statement.setString(2, b.getNo_telp());
            statement.setString(3, b.getAlamat());
            statement.setString(4, b.getPaket());
            statement.setInt(5, b.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public java.util.List<Model_Member> getAll() {
        java.util.List<Model_Member> lb = null;
        try {
            lb = new ArrayList<Model_Member>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            
            while (rs.next()) {
                Model_Member b = new Model_Member();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setNo_telp(rs.getString("no_telp"));
                b.setAlamat(rs.getString("alamat"));
                b.setPaket(rs.getString("paket"));
                lb.add(b);
            }
        } catch (SQLException e) {
            Logger.getLogger(DAO_Member.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }

    @Override
    public java.util.List<Model_Member> getCariNama(String nama) {
         java.util.List<Model_Member> lb = null;
        try {
            lb = new ArrayList<Model_Member>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model_Member b = new Model_Member();
                b.setId(rs.getInt("id"));
                b.setNama(rs.getString("nama"));
                b.setNo_telp(rs.getString("no_telp"));
                b.setAlamat(rs.getString("alamat"));
                b.setPaket(rs.getString("paket"));
                lb.add(b);
            }
        } catch (SQLException e) {
            Logger.getLogger(DAO_Member.class.getName()).log(Level.SEVERE, null, e);
        }
        return lb;
    }
}
