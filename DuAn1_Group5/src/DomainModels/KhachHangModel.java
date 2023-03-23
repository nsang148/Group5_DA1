/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author sangh
 */
public class KhachHangModel {

    private String idKH;
    private String maKH;
    private String ten;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private Boolean tinhTrang;
    private String idViDiem;

    public KhachHangModel() {
    }

    public KhachHangModel(String idKH, String maKH, String ten, String gioiTinh, String ngaySinh, String diaChi, String sdt, String email, Boolean tinhTrang, String idViDiem) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.tinhTrang = tinhTrang;
        this.idViDiem = idViDiem;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getIdViDiem() {
        return idViDiem;
    }

    public void setIdViDiem(String idViDiem) {
        this.idViDiem = idViDiem;
    }

    

    

    
    
    
}
