/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author acer
 */
public class Sach {
    private String id;
    private String ma;
    private String ten;
    private int soLuongTon;
    private String moTa;
    private int tinhTrang;
    private String id_theLoai;
    private String id_NXB;
    private String id_tacGia;
    private Double gia;
    private String anh;

    public Sach() {
    }

    public Sach(String id, String ma, String ten, int soLuongTon, String moTa, int tinhTrang, String id_theLoai, String id_NXB, String id_tacGia, Double gia, String anh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.soLuongTon = soLuongTon;
        this.moTa = moTa;
        this.tinhTrang = tinhTrang;
        this.id_theLoai = id_theLoai;
        this.id_NXB = id_NXB;
        this.id_tacGia = id_tacGia;
        this.gia = gia;
        this.anh = anh;
    }

    public Sach(String ma, String ten, int soLuongTon, String moTa, int tinhTrang, String id_theLoai, String id_NXB, String id_tacGia, Double gia, String anh) {
        this.ma = ma;
        this.ten = ten;
        this.soLuongTon = soLuongTon;
        this.moTa = moTa;
        this.tinhTrang = tinhTrang;
        this.id_theLoai = id_theLoai;
        this.id_NXB = id_NXB;
        this.id_tacGia = id_tacGia;
        this.gia = gia;
        this.anh = anh;
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

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getId_theLoai() {
        return id_theLoai;
    }

    public void setId_theLoai(String id_theLoai) {
        this.id_theLoai = id_theLoai;
    }

    public String getId_NXB() {
        return id_NXB;
    }

    public void setId_NXB(String id_NXB) {
        this.id_NXB = id_NXB;
    }

    public String getId_tacGia() {
        return id_tacGia;
    }

    public void setId_tacGia(String id_tacGia) {
        this.id_tacGia = id_tacGia;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    
}
