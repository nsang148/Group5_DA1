/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author acer
 */
public class TheLoaiBanChay {
    private int thang;
    private String tenTheLoai;
    private int soLuong;
    private Double tongTien;

    public TheLoaiBanChay(int thang, String tenTheLoai, int soLuong, Double tongTien) {
        this.thang = thang;
        this.tenTheLoai = tenTheLoai;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public TheLoaiBanChay() {
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
