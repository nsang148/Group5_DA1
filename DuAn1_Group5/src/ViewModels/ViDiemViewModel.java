/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Nguyễn Hiếu
 */
public class ViDiemViewModel {
     private String id;
    private int tongDiem;
    private int soDiemDaDung;
    private int soDiemDaCong;
    private boolean trangThai;

    public ViDiemViewModel(String id, int tongDiem, int soDiemDaDung, int soDiemDaCong, boolean trangThai) {
        this.id = id;
        this.tongDiem = tongDiem;
        this.soDiemDaDung = soDiemDaDung;
        this.soDiemDaCong = soDiemDaCong;
        this.trangThai = trangThai;
    }

    public ViDiemViewModel(int tongDiem, int soDiemDaDung, int soDiemDaCong, boolean trangThai) {
        this.tongDiem = tongDiem;
        this.soDiemDaDung = soDiemDaDung;
        this.soDiemDaCong = soDiemDaCong;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ViDiemModel{" + "id=" + id + ", tongDiem=" + tongDiem + ", soDiemDaDung=" + soDiemDaDung + ", soDiemDaCong=" + soDiemDaCong + ", trangThai=" + trangThai + '}';
    }
    
    
    public Object[] toRowData(){
        return new Object[]{id, tongDiem, soDiemDaDung, soDiemDaDung, trangThai};
    }
}
