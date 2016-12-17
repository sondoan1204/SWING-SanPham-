/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author SONPC
 */
public class SanPham {

    private String masp;
    private String tensp;
    private long gia;
    private String maloai;
    public SanPham(){
        
    }

    public SanPham(String masp, String tensp, long gia, String maloai) {
        this.masp = masp;
        this.tensp = tensp;
        this.gia = gia;
        this.maloai = maloai;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }
    
}
