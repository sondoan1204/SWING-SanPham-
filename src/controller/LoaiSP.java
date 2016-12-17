/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Loai;

/**
 *
 * @author SONPC
 */
public class LoaiSP {

    public ArrayList<Loai> getAll() throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "SELECT * FROM LoaiSP";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Loai> list = new ArrayList<>();
        while (rs.next()) {
            Loai l = new Loai();
            l.setMaloai(rs.getString("Maloai"));
            l.setTenloai(rs.getString("Tenloai"));

            list.add(l);
        }
        connection.close();
        return list;
    }

    public Loai addNew(Loai loai) throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "INSERT INTO LoaiSP VALUES(?,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, loai.getMaloai());
        ps.setString(2, loai.getTenloai());
        ps.executeUpdate();
        connection.close();
        return loai;
    }
    //Update Khoa set TenKhoa=?, SDT =? where MaKhoa=?"
    public Loai update(Loai loai) throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "Update LoaiSP set Tenloai=? Where Maloai=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, loai.getTenloai());
        ps.setString(2, loai.getMaloai());
        ps.executeUpdate();
        connection.close();
        return loai;
    }
    public void deleteLoai(String ID) throws SQLException, ClassNotFoundException
    {
        Connection connection = Connect.getConnection();
        String sql = "Delete from LoaiSP where Maloai=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, ID);
        ps.executeUpdate();
        connection.close();
    }
}
