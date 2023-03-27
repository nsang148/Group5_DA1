/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;
import Service.Implement.QuanLyGiamGiaServiceImpl;
import Service.QuanLyGiamGiaService;
import java.math.BigDecimal;

/**
 *
 * @author tagot
 */
public class QuanLyGiamGiaHT {
    private String ID;
    private String IdHT;
    private String IdGiamGia;
    private BigDecimal DonGia;
    private BigDecimal SoTienConLai;
    private int TrangThai;

    public QuanLyGiamGiaHT() {
    }

    public QuanLyGiamGiaHT(String ID, String IdHT, String IdGiamGia, BigDecimal DonGia, BigDecimal SoTienConLai, int TrangThai) {
        this.ID = ID;
        this.IdHT = IdHT;
        this.IdGiamGia = IdGiamGia;
        this.DonGia = DonGia;
        this.SoTienConLai = SoTienConLai;
        this.TrangThai = TrangThai;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIdHT() {
        return IdHT;
    }

    public void setIdHT(String IdHT) {
        this.IdHT = IdHT;
    }

    public String getIdGiamGia() {
        return IdGiamGia;
    }

    public void setIdGiamGia(String IdGiamGia) {
        this.IdGiamGia = IdGiamGia;
    }

    public BigDecimal getDonGia() {
        return DonGia;
    }

    public void setDonGia(BigDecimal DonGia) {
        this.DonGia = DonGia;
    }

    public BigDecimal getSoTienConLai() {
        return SoTienConLai;
    }

    public void setSoTienConLai(BigDecimal SoTienConLai) {
        this.SoTienConLai = SoTienConLai;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "QuanLyGiamGiaHT{" + "ID=" + ID + ", IdHT=" + IdHT + ", IdGiamGia=" + IdGiamGia + ", DonGia=" + DonGia + ", SoTienConLai=" + SoTienConLai + ", TrangThai=" + TrangThai + '}';
    }
        public Object[] toDataRow() {
        return new Object[]{ID,IdHT,IdGiamGia,DonGia,SoTienConLai,TrangThai};
    }

        private QuanLyGiamGiaService service = new QuanLyGiamGiaServiceImpl();

}
