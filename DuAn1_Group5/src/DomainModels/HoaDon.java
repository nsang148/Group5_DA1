package DomainModels;

public class HoaDon {

    private String id, idKH, idNV, idVi, ma, ngayTao, ngayThanhToan;
    private double tienKhachDua;
    private int tinhTrang;
    private double tongTien;
    private int soDiemKhacHang;

    public HoaDon() {
    }

    public HoaDon(String id, String idKH, String idNV, String idVi, String ma, String ngayTao, String ngayThanhToan, double tienKhachDua, int tinhTrang, double tongTien, int soDiemKhacHang) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idVi = idVi;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tienKhachDua = tienKhachDua;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
        this.soDiemKhacHang = soDiemKhacHang;
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

    public String getIdVi() {
        return idVi;
    }

    public void setIdVi(String idVi) {
        this.idVi = idVi;
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

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getSoDiemKhacHang() {
        return soDiemKhacHang;
    }

    public void setSoDiemKhacHang(int soDiemKhacHang) {
        this.soDiemKhacHang = soDiemKhacHang;
    }

    public String tinhTrang(int tt){
        if (tt==0) {
            return "Chưa thanh toán";
        }else{
            return "Đã thanh toán";
        }
    }

}
