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
public class Loai {
    private String maloai;
    private String tenloai;

    public Loai(){
        
    }
    public Loai(String maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }


    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    
}
