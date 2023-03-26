package DomainModels;

public class HoaDon {

    private String id, idKH, idNV, idLichSuTieuDiem, idChinhSachDoiHang, ma, ngayTao, ngayThanhToan;
    private double tienKhachDua;
    private double tongTien;
    private int trangThai;
    private int phanTramGiamGia;
    private int soDiemSuDung;
    private double soTienQuyDoi;
    

    public HoaDon() {
    }

    public HoaDon(String id, String idKH, String idNV, String idLichSuTieuDiem, String idChinhSachDoiHang, String ma, String ngayTao, String ngayThanhToan, double tienKhachDua, double tongTien, int trangThai, int phanTramGiamGia, int soDiemSuDung, double soTienQuyDoi) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idLichSuTieuDiem = idLichSuTieuDiem;
        this.idChinhSachDoiHang = idChinhSachDoiHang;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tienKhachDua = tienKhachDua;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.phanTramGiamGia = phanTramGiamGia;
        this.soDiemSuDung = soDiemSuDung;
        this.soTienQuyDoi = soTienQuyDoi;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdLichSuTieuDiem() {
        return idLichSuTieuDiem;
    }

    public void setIdLichSuTieuDiem(String idLichSuTieuDiem) {
        this.idLichSuTieuDiem = idLichSuTieuDiem;
    }

    public String getIdChinhSachDoiHang() {
        return idChinhSachDoiHang;
    }

    public void setIdChinhSachDoiHang(String idChinhSachDoiHang) {
        this.idChinhSachDoiHang = idChinhSachDoiHang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(int phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public int getSoDiemSuDung() {
        return soDiemSuDung;
    }

    public void setSoDiemSuDung(int soDiemSuDung) {
        this.soDiemSuDung = soDiemSuDung;
    }

    public double getSoTienQuyDoi() {
        return soTienQuyDoi;
    }

    public void setSoTienQuyDoi(double soTienQuyDoi) {
        this.soTienQuyDoi = soTienQuyDoi;
    }

    

    public String tinhTrang(int tt){
        if (tt==0) {
            return "Chưa thanh toán";
        }else{
            return "Đã thanh toán";
        }
    }

}
