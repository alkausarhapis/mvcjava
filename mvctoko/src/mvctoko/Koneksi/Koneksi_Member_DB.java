/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvctoko.Koneksi;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;




/**
 *
 * @author SMKN4
 */
public class Koneksi_Member_DB {
    static Connection conn;
    
    public static Connection connection() {
        if (conn == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("mvctoko");
            data.setUser("root");
            data.setPassword("");
            try {
                conn = (Connection) data.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
