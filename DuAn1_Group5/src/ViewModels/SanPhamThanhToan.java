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
    private String loaiThit;
    private String thit;
    private String xuatXu;
    private String NCC;
    private int soLuongTon;
    private Double donGia;

    public SanPhamThanhToan() {
    }

    public SanPhamThanhToan(String ten, String ma, String loaiThit, String thit, String xuatXu, String NCC, int soLuongTon, Double donGia) {
        this.ten = ten;
        this.ma = ma;
        this.loaiThit = loaiThit;
        this.thit = thit;
        this.xuatXu = xuatXu;
        this.NCC = NCC;
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

    public String getLoaiThit() {
        return loaiThit;
    }

    public void setLoaiThit(String loaiThit) {
        this.loaiThit = loaiThit;
    }

    public String getThit() {
        return thit;
    }

    public void setThit(String thit) {
        this.thit = thit;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getNCC() {
        return NCC;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
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
