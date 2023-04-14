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
private Float GiaBan;
private Float GiaConLai;
private int SoLuongTon;
private Date HSD;
private int TrangThai;
private String IdGiamGia;
private int PhanTramGiamGia;

    public QuanLyGiamGiaHT() {
    }

    public QuanLyGiamGiaHT(String Ma, String Ten, Float GiaBan, Float GiaConLai, int SoLuongTon, Date HSD, int TrangThai, String IdGiamGia, int PhanTramGiamGia) {
        this.Ma = Ma;
        this.Ten = Ten;
        this.GiaBan = GiaBan;
        this.GiaConLai = GiaConLai;
        this.SoLuongTon = SoLuongTon;
        this.HSD = HSD;
        this.TrangThai = TrangThai;
        this.IdGiamGia = IdGiamGia;
        this.PhanTramGiamGia = PhanTramGiamGia;
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

    public Float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Float getGiaConLai() {
        return GiaConLai;
    }

    public void setGiaConLai(Float GiaConLai) {
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



    public String setTrangThaiS(int TrangThai){
        if(TrangThai==1){
            return "đang bán";
        } else{
            return "ngưng bán";
        }
        
    }
    



}
