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
import models.Loai;
import models.SanPham;

/**
 *
 * @author SONPC
 */
public class SanPhamDAO {

    public ArrayList<SanPham> getAll() throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "SELECT * FROM Sanpham";
        PreparedStatement ps = connection.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<SanPham> list = new ArrayList<>();
        while (rs.next()) {
            SanPham sp = new SanPham();
            sp.setMasp(rs.getString("MaSP"));
            sp.setTensp(rs.getString("TenSP"));
            sp.setGia(rs.getLong("Dongia"));
            sp.setMaloai(rs.getString("Maloai"));
            list.add(sp);
        }
        connection.close();
        return list;
    }
    public SanPham addNew(SanPham sp) throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "INSERT INTO Sanpham VALUES(?,?,?,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, sp.getMasp());
        ps.setString(2, sp.getTensp());
        ps.setLong(3, sp.getGia());
        ps.setString(4, sp.getMaloai());
        ps.executeUpdate();
        connection.close();
        return sp;
    }
    public void deleteSP(String ID) throws SQLException, ClassNotFoundException
    {
        Connection connection = Connect.getConnection();
        String sql = "Delete from Sanpham where MaSP=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, ID);
        ps.executeUpdate();
        connection.close();
    }
}
