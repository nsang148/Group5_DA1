/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author tagot
 */
public class QuanLyGiamGia {
    private String Id;
    private String Ma;
    private String Ten;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private int MucPhanTramGiamGia;
    private String DieuKienGiamGia;
    private int TrangThai;

    public QuanLyGiamGia() {
    }

    public QuanLyGiamGia(String Id, String Ma, String Ten, Date NgayBatDau, Date NgayKetThuc, int MucPhanTramGiamGia, String DieuKienGiamGia, int TrangThai) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.MucPhanTramGiamGia = MucPhanTramGiamGia;
        this.DieuKienGiamGia = DieuKienGiamGia;
        this.TrangThai = TrangThai;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public int getMucPhanTramGiamGia() {
        return MucPhanTramGiamGia;
    }

    public void setMucPhanTramGiamGia(int MucPhanTramGiamGia) {
        this.MucPhanTramGiamGia = MucPhanTramGiamGia;
    }

    public String getDieuKienGiamGia() {
        return DieuKienGiamGia;
    }

    public void setDieuKienGiamGia(String DieuKienGiamGia) {
        this.DieuKienGiamGia = DieuKienGiamGia;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "QuanLyGiamGia{" + "Id=" + Id + ", Ma=" + Ma + ", Ten=" + Ten + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", MucPhanTramGiamGia=" + MucPhanTramGiamGia + ", DieuKienGiamGia=" + DieuKienGiamGia + ", TrangThai=" + TrangThai + '}';
    }
    public Object[] toDataRow() {
        return new Object[]{Id,Ma,Ten,NgayBatDau,NgayKetThuc,MucPhanTramGiamGia,DieuKienGiamGia,SetTrangThai(getTrangThai())};
    }
    public String SetTrangThai(int trangthai){
        if (TrangThai == 0) {
            return "ngưng chạy";    
        } else {return "đang chạy";}
}
}
