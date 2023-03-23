/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author acer
 */
public class SPBanChayViewModel {
    private int thang;
    private String tenSach;
    private int soLuong;
    private Double tongTien;

    public SPBanChayViewModel() {
    }

    public SPBanChayViewModel(int thang, String tenSach, int soLuong, Double tongTien) {
        this.thang = thang;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
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
