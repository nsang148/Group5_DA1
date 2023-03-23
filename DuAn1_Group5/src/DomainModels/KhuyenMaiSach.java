/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Duc
 */
public class KhuyenMaiSach {

    private String id;
    private String idSach;
    private String idKM;
    private Float donGia;
    private Float soTienConLai;
    private int tinhTrang;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getIdKM() {
        return idKM;
    }

    public void setIdKM(String idKM) {
        this.idKM = idKM;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public Float getSoTienConLai() {
        return soTienConLai;
    }

    public void setSoTienConLai(Float soTienConLai) {
        this.soTienConLai = soTienConLai;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public KhuyenMaiSach(String id, String idSach, String idKM, Float donGia, Float soTienConLai, int tinhTrang) {
        this.id = id;
        this.idSach = idSach;
        this.idKM = idKM;
        this.donGia = donGia;
        this.soTienConLai = soTienConLai;
        this.tinhTrang = tinhTrang;
    }

    public KhuyenMaiSach() {
    }
}
