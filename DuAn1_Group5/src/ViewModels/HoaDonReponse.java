/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author acer
 */
public class HoaDonReponse {

    private String ngayTao;
    private String maHD;
    private double tongTien;
    private String tenNV;
    private int tinhTrang;

    public HoaDonReponse() {
    }

    public HoaDonReponse(String ngayTao, String maHD, double tongTien, String tenNV, int tinhTrang) {
        this.ngayTao = ngayTao;
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
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

    public String doiTinhTrang(int tt) {
        if (tinhTrang == 0) {
            return "Chưa thanh toán";

        } else {
            return "Đã thanh toán";
        }
    }
}
