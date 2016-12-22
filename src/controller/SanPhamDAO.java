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

    //Update sanpham
    public SanPham update(SanPham sp) throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "Update Sanpham set TenSP=?,Dongia=?,Maloai=? Where MaSP=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(4, sp.getMasp());
        ps.setString(1, sp.getTensp());
        ps.setLong(2, sp.getGia());
        ps.setString(3, sp.getMaloai());
        ps.executeUpdate();
        connection.close();
        return sp;
    }

    public void deleteSP(String ID) throws SQLException, ClassNotFoundException {
        Connection connection = Connect.getConnection();
        String sql = "Delete from Sanpham where MaSP=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, ID);
        ps.executeUpdate();
        connection.close();
    }

    public long chekid(String ID) throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "Select count(*) as sl from Sanpham where MaSP=?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, ID);
        ResultSet rs = ps.executeQuery();
        long count = 0;
        while (rs.next()) {
            count = rs.getLong("sl");
        }
        connection.close();
        return count;
    }
    
    //Theo trang 5sp 1 trang
    public ArrayList<SanPham> getTrang(long trang) throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "SELECT top 5 * FROM Sanpham \n"
                + "WHERE TenSP not in (SELECT top " + trang + " TenSP from Sanpham)";
        PreparedStatement ps = connection.prepareCall(sql);
        //ps.setLong(1, trang);
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

    //tìm kiếm sp theo tên
    public ArrayList<SanPham> getTen(String ten) throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "SELECT * FROM Sanpham WHERE TenSP like ?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1, "%"+ten+"%");
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
//    //Truy van du lieu trong table sanpham theo gia
//    public ResultSet ShowSPTheogia(int giatu,int giaden) throws SQLException{
//        String sql="SELECT MaSP,TenSP,Dongia,l.Maloai,Tenloai FROM Sanpham s,LoaiSP l where l.Maloai=s.Maloai and Dongia between"+giatu+"and"+giaden;
//        return cn.LoadData(sql);
//    }
    //tìm kiếm theo giá
     public ArrayList<SanPham> getGia(long tu, long den) throws SQLException {
        Connection connection = Connect.getConnection();
        String sql = "SELECT * FROM Sanpham WHERE Dongia between ? and ?";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setLong(1, tu);
        ps.setLong(2, den);
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
