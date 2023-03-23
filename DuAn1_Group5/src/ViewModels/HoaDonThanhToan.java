/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author acer
 */
public class HoaDonThanhToan {
    private String ma;
    private String ngay;
    private String tenNV;
    private int tinhTrang;

    public HoaDonThanhToan() {
    }

    public HoaDonThanhToan(String ma, String ngay, String tenNV, int tinhTrang) {
        this.ma = ma;
        this.ngay = ngay;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
