/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author This PC
 */
public class SanPhamThanhToan {
    private String ten;
    private String ma;
    private String theLoai;
    private String tacGia;
    private String NXB;
    private int soLuongTon;
    private Double donGia;

    public SanPhamThanhToan() {
    }

    public SanPhamThanhToan(String ten, String ma, String theLoai, String tacGia, String NXB, int soLuongTon, Double donGia) {
        this.ten = ten;
        this.ma = ma;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
        this.NXB = NXB;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    
}
