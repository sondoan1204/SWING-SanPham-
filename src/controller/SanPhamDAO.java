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
}
