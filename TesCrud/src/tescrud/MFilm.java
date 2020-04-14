/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tescrud;

import static com.sun.xml.internal.ws.client.ContentNegotiation.none;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author sistem
 */
public class MFilm {

    static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/kuiscrud";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;
    Statement statement;

    public MFilm() {
        try {
            Class.forName(JDBC__DRIVER);

            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void InsertFilm(String judul, String tipe, String episode, String genre, String status, String rating) {
        try {
            String query = "INSERT INTO `rekapfilm`(`judul`,`tipe`,`episode`,`genre`, `status`, `rating`) VALUES ('" + judul + "','" + tipe + "','" + episode + "','" + genre + "','" + status + "','" + rating + "')";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }

    }

    public String[][] ReadFilm() {
        try {
            int jmlData = 0;
            int a = 1;
            String data[][] = new String[getBykData()][8];
            String query = "SELECT*FROM `rekapfilm`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = Integer.toString(a++);
                data[jmlData][1] = rs.getString("id");
                data[jmlData][2] = rs.getString("judul");
                data[jmlData][3] = rs.getString("tipe");
                data[jmlData][4] = rs.getString("episode");
                data[jmlData][5] = rs.getString("genre");
                data[jmlData][6] = rs.getString("status");
                data[jmlData][7] = rs.getString("rating");
                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBykData() {
        int jmlData = 0;
        try {
            statement = (Statement) conn.createStatement();
            String query = "SELECT*FROM `rekapfilm`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return 0;
        }

    }


    public void DeleteFilm(String id) {
        try {
            String query = "DELETE FROM `rekapfilm` WHERE id = '" + id + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void UpdateFilm(String id, String judul, String tipe, String episode, String genre, String status, String rating) {
        try {
            String query = "UPDATE `rekapfilm` SET `judul` ='" + judul + "', `tipe` = '" + tipe + "', `episode` = '" + episode + "', `genre` = '" + genre + "', `status` = '" + status + "', `rating` = '" + rating + "' WHERE `id` ='" + id + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil diupdate");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public String[][] SearchFilm(String jd) {

        try {
            int jmlData = 0;
            int a =1;
            String data[][] = new String[getBykData()][8];
            String query = "SELECT*FROM `rekapfilm` WHERE `judul` LIKE '%" + jd + "%'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = Integer.toString(a++);
                data[jmlData][1] = rs.getString("id");
                data[jmlData][2] = rs.getString("judul");
                data[jmlData][3] = rs.getString("tipe");
                data[jmlData][4] = rs.getString("episode");
                data[jmlData][5] = rs.getString("genre");
                data[jmlData][6] = rs.getString("status");
                data[jmlData][7] = rs.getString("rating");
                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }

    }
}
