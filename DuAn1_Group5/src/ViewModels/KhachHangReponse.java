/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author sangh
 */
public class KhachHangReponse {
    private String Id;
    private String Ma;
    private String HoTen;
    private String GioiTinh;
    private String NgaySinh;
    private String diaChi;
    private String Sdt;
    private String Email;
    private int tongDiem;
    private int soDiemDaDung;
    private int soDiemDaCong;
    private Boolean TinhTrang;

    public KhachHangReponse() {
    }

    public KhachHangReponse(String Id, String Ma, String HoTen, String GioiTinh, String NgaySinh, String diaChi, String Sdt, String Email, int tongDiem, int soDiemDaDung, int soDiemDaCong, Boolean TinhTrang) {
        this.Id = Id;
        this.Ma = Ma;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.diaChi = diaChi;
        this.Sdt = Sdt;
        this.Email = Email;
        this.tongDiem = tongDiem;
        this.soDiemDaDung = soDiemDaDung;
        this.soDiemDaCong = soDiemDaCong;
        this.TinhTrang = TinhTrang;
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

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(int tongDiem) {
        this.tongDiem = tongDiem;
    }

    public int getSoDiemDaDung() {
        return soDiemDaDung;
    }

    public void setSoDiemDaDung(int soDiemDaDung) {
        this.soDiemDaDung = soDiemDaDung;
    }

    public int getSoDiemDaCong() {
        return soDiemDaCong;
    }

    public void setSoDiemDaCong(int soDiemDaCong) {
        this.soDiemDaCong = soDiemDaCong;
    }

    public Boolean getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(Boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    

    

    
    
}
