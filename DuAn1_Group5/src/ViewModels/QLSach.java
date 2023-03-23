/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author acer
 */
public class QLSach {
    private String ma;
    private String ten;
    private String theLoai;
    private String NXB;
    private String tacGia;
    private String moTa;
    private int soLuongTon;
    private Double gia;
    private int tinhTrang;
    private String anh;
    private String id;

    public QLSach() {
    }

    public QLSach(String ma, String ten, String theLoai, String NXB, String tacGia, String moTa, int soLuongTon, Double gia, int tinhTrang, String anh) {
        this.ma = ma;
        this.ten = ten;
        this.theLoai = theLoai;
        this.NXB = NXB;
        this.tacGia = tacGia;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.anh = anh;
    }

    public QLSach(String ma, String ten, String theLoai, String NXB, String tacGia, String moTa, int soLuongTon, Double gia, int tinhTrang, String anh, String id) {
        this.ma = ma;
        this.ten = ten;
        this.theLoai = theLoai;
        this.NXB = NXB;
        this.tacGia = tacGia;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.anh = anh;
        this.id = id;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    
}
