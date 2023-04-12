/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;
import Service.Implement.QuanLyGiamGiaServiceImpl;
import Service.QuanLyGiamGiaService;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author tagot
 */
public class QuanLyGiamGiaHT {
 private String Ma;
private String Ten;
private BigDecimal GiaBan;
private BigDecimal GiaConLai;
private int SoLuongTon;
private Date HSD;
private int TrangThai;
private String IdGiamGia;
private int PhanTramGiamGia;
private int NgayConLai;

    public QuanLyGiamGiaHT() {
    }

    public QuanLyGiamGiaHT(String Ma, String Ten, BigDecimal GiaBan, BigDecimal GiaConLai, int SoLuongTon, Date HSD, int TrangThai, String IdGiamGia, int PhanTramGiamGia, int NgayConLai) {
        this.Ma = Ma;
        this.Ten = Ten;
        this.GiaBan = GiaBan;
        this.GiaConLai = GiaConLai;
        this.SoLuongTon = SoLuongTon;
        this.HSD = HSD;
        this.TrangThai = TrangThai;
        this.IdGiamGia = IdGiamGia;
        this.PhanTramGiamGia = PhanTramGiamGia;
        this.NgayConLai = NgayConLai;
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

    public BigDecimal getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(BigDecimal GiaBan) {
        this.GiaBan = GiaBan;
    }

    public BigDecimal getGiaConLai() {
        return GiaConLai;
    }

    public void setGiaConLai(BigDecimal GiaConLai) {
        this.GiaConLai = GiaConLai;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getIdGiamGia() {
        return IdGiamGia;
    }

    public void setIdGiamGia(String IdGiamGia) {
        this.IdGiamGia = IdGiamGia;
    }

    public int getPhanTramGiamGia() {
        return PhanTramGiamGia;
    }

    public void setPhanTramGiamGia(int PhanTramGiamGia) {
        this.PhanTramGiamGia = PhanTramGiamGia;
    }

    public int getNgayConLai() {
        return NgayConLai;
    }

    public void setNgayConLai(int NgayConLai) {
        this.NgayConLai = NgayConLai;
    }

    @Override
    public String toString() {
        return "QuanLyGiamGiaHT{" + "Ma=" + Ma + ", Ten=" + Ten + ", GiaBan=" + GiaBan + ", GiaConLai=" + GiaConLai + ", SoLuongTon=" + SoLuongTon + ", HSD=" + HSD + ", TrangThai=" + TrangThai + ", IdGiamGia=" + IdGiamGia + ", PhanTramGiamGia=" + PhanTramGiamGia + ", NgayConLai=" + NgayConLai + '}';
    }



    public String setTrangThaiS(int TrangThai){
        if(TrangThai==1){
            return "đang bán";
        } else{
            return "ngưng bán";
        }
        
    }
    



}
