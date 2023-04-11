/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author Tus
 */
public class HopThitDomain {

    private String id;
    private String ma;
    private String TenHopThit;
    private Double GiaBan;
    private int SoLuongTon;
    private float KhoiLuong;
    private Date NgayDongGoi;
    private Date HSD;
    private String MoTa;
    private int TrangThai;
    private String idThit;
    private String idloaiThit;
    private String idXuatXu;
    private String idNCC;
    private Double GiaConLai;

    public HopThitDomain() {
    }

    public HopThitDomain(String id, String ma, String TenHopThit, Double GiaBan, int SoLuongTon, float KhoiLuong, Date NgayDongGoi, Date HSD, String MoTa, int TrangThai, String idThit, String idloaiThit, String idXuatXu, String idNCC, Double GiaConLai) {
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
        this.idNCC = idNCC;
        this.GiaConLai = GiaConLai;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTenHopThit(String TenHopThit) {
        this.TenHopThit = TenHopThit;
    }

    public void setGiaBan(Double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public void setNgayDongGoi(Date NgayDongGoi) {
        this.NgayDongGoi = NgayDongGoi;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setIdThit(String idThit) {
        this.idThit = idThit;
    }

    public void setIdloaiThit(String idloaiThit) {
        this.idloaiThit = idloaiThit;
    }

    public void setIdXuatXu(String idXuatXu) {
        this.idXuatXu = idXuatXu;
    }

    public void setIdNCC(String idNCC) {
        this.idNCC = idNCC;
    }

    public void setGiaConLai(Double GiaConLai) {
        this.GiaConLai = GiaConLai;
    }

    public String getId() {
        return id;
    }

    public String getMa() {
        return ma;
    }

    public String getTenHopThit() {
        return TenHopThit;
    }

    public Double getGiaBan() {
        return GiaBan;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public Date getNgayDongGoi() {
        return NgayDongGoi;
    }

    public Date getHSD() {
        return HSD;
    }

    public String getMoTa() {
        return MoTa;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public String getIdThit() {
        return idThit;
    }

    public String getIdloaiThit() {
        return idloaiThit;
    }

    public String getIdXuatXu() {
        return idXuatXu;
    }

    public String getIdNCC() {
        return idNCC;
    }

    public Double getGiaConLai() {
        return GiaConLai;
    }

    public float getKhoiLuong() {
        return KhoiLuong;
    }

    public void setKhoiLuong(float KhoiLuong) {
        this.KhoiLuong = KhoiLuong;
    }

}
