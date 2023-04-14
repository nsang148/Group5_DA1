/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tus
 */
public class HopThitView {
    private String id;
    private String ma;
    private String TenHopThit;
    private Float GiaBan;
    private int SoLuongTon;
    private Float KhoiLuong;
    private Date NgayDongGoi;
    private Date HSD;
    private String MoTa;
    private int TrangThai;
    private String idThit;
    private String idloaiThit;
    private String idXuatXu;
    private String idGiamGia;
    private String idNCC;
    private Float GiaConLai;    

    public HopThitView() {
    }

    public HopThitView(String id, String ma, String TenHopThit, Float GiaBan, int SoLuongTon, Float KhoiLuong, Date NgayDongGoi, Date HSD, String MoTa, int TrangThai) {
        this.id = id;
        this.ma = ma;
        this.TenHopThit = TenHopThit;
        this.GiaBan = GiaBan;
        this.SoLuongTon = SoLuongTon;
        this.KhoiLuong = KhoiLuong;
        this.NgayDongGoi = NgayDongGoi;
        this.HSD = HSD;
        this.MoTa = MoTa;
        this.TrangThai = TrangThai;
    }

    public HopThitView(String id, String ma, String TenHopThit, Float GiaBan, int SoLuongTon,Float KhoiLuong, Date NgayDongGoi, Date HSD, String MoTa, int TrangThai, String idThit, String idloaiThit, String idXuatXu,String idGiamGia ,String idNCC,float GiaConLai) {
        this.id = id;
        this.ma = ma;
        this.TenHopThit = TenHopThit;
        this.GiaBan = GiaBan;
        this.SoLuongTon = SoLuongTon;
        this.KhoiLuong = KhoiLuong;
        this.NgayDongGoi = NgayDongGoi;
        this.HSD = HSD;
        this.MoTa = MoTa;
        this.TrangThai = TrangThai;
        this.idThit = idThit;
        this.idloaiThit = idloaiThit;
        this.idXuatXu = idXuatXu;
        this.idGiamGia = idGiamGia;
        this.idNCC = idNCC;
        this.GiaConLai = GiaConLai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenHopThit() {
        return TenHopThit;
    }

    public void setTenHopThit(String TenHopThit) {
        this.TenHopThit = TenHopThit;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public Date getNgayDongGoi() {
        return NgayDongGoi;
    }

    public void setNgayDongGoi(Date NgayDongGoi) {
        this.NgayDongGoi = NgayDongGoi;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getIdThit() {
        return idThit;
    }

    public void setIdThit(String idThit) {
        this.idThit = idThit;
    }

    public String getIdloaiThit() {
        return idloaiThit;
    }

    public void setIdloaiThit(String idloaiThit) {
        this.idloaiThit = idloaiThit;
    }

    public String getIdXuatXu() {
        return idXuatXu;
    }

    public void setIdXuatXu(String idXuatXu) {
        this.idXuatXu = idXuatXu;
    }

    public String getIdNCC() {
        return idNCC;
    }

    public void setIdNCC(String idNCC) {
        this.idNCC = idNCC;
    }

    public Float getKhoiLuong() {
        return KhoiLuong;
    }

    public void setKhoiLuong(Float KhoiLuong) {
        this.KhoiLuong = KhoiLuong;
    }


    public String getIdGiamGia() {
        return idGiamGia;
    }

    public void setIdGiamGia(String idGiamGia) {
        this.idGiamGia = idGiamGia;
    }

    
    @Override
    public String toString() {
        return "HopThitDomain{" + "id=" + id + ", ma=" + ma + ", TenHopThit=" + TenHopThit + ", GiaBan=" + GiaBan + ", SoLuongTon=" + SoLuongTon + ", KhoiLuong=" + KhoiLuong + ", NgayDongGoi=" + NgayDongGoi + ", HSD=" + HSD + ", MoTa=" + MoTa + ", TrangThai=" + TrangThai + ", idThit=" + idThit + ", idloaiThit=" + idloaiThit + ", idXuatXu=" + idXuatXu + ", idNCC=" + idNCC + '}';
    }

    public String setTrangThaiS(int TrangThai){
        if(TrangThai==1){
            return "đang bán";
        } else{
            return "ngưng bán";
        }
        
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

    
}
