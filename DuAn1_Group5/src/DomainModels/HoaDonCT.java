
package DomainModels;

public class HoaDonCT {
private String id,idSach,idHD;
    private double donGia,tienThua,TienGiamGia;
    private int soLuong ,tinhTrang;
    public HoaDonCT() {
    }

    public HoaDonCT(String id, String idSach, String idHD, double donGia, double tienThua, double TienGiamGia, int soLuong, int tinhTrang) {
        this.id = id;
        this.idSach = idSach;
        this.idHD = idHD;
        this.donGia = donGia;
        this.tienThua = tienThua;
        this.TienGiamGia = TienGiamGia;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

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

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getTienThua() {
        return tienThua;
    }

    public void setTienThua(double tienThua) {
        this.tienThua = tienThua;
    }

    public double getTienGiamGia() {
        return TienGiamGia;
    }

    public void setTienGiamGia(double TienGiamGia) {
        this.TienGiamGia = TienGiamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

   
 
    
}
