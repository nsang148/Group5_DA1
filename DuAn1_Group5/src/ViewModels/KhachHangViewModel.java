/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Nguyễn Hiếu
 */
public class KhachHangViewModel {
    private String id;
    private String ma;
    private String hoTen;
    private String sdt;
    private String ngaySinh;
    private String diaChi;
    private String gioiTinh;
    private int trangThai;
    private String ghiChu;
    private int soLanMua;
    private String idViDiem;

    public KhachHangViewModel(String id, String ma, String hoTen, String sdt, String ngaySinh, String diaChi, String gioiTinh, int trangThai, String ghiChu, int soLanMua, String idViDiem) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.soLanMua = soLanMua;
        this.idViDiem = idViDiem;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getSoLanMua() {
        return soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }

    public String getIdViDiem() {
        return idViDiem;
    }

    public void setIdViDiem(String idViDiem) {
        this.idViDiem = idViDiem;
    }

    @Override
    public String toString() {
        return "KhachHangViewModel{" + "id=" + id + ", ma=" + ma + ", hoTen=" + hoTen + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", trangThai=" + trangThai + ", ghiChu=" + ghiChu + ", soLanMua=" + soLanMua + ", idViDiem=" + idViDiem + '}';
    }
    public Object[] toRowData(){
        return new Object[]{id, ma, hoTen, sdt, ngaySinh, diaChi, gioiTinh, trangThai, ghiChu, soLanMua, idViDiem};
    }
   
}
