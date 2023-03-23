/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author sangh
 */
public class ViDiem {
    private String Id;
    private String Ma;
    private int tongDiem;
    private int soDiemDaDung;
    private int soDiemDaCong;
    private int tinhTrang;

    public ViDiem() {
    }

    public ViDiem(String Id, String Ma, int tongDiem, int soDiemDaDung, int soDiemDaCong, int tinhTrang) {
        this.Id = Id;
        this.Ma = Ma;
        this.tongDiem = tongDiem;
        this.soDiemDaDung = soDiemDaDung;
        this.soDiemDaCong = soDiemDaCong;
        this.tinhTrang = tinhTrang;
    }

    public ViDiem(String Ma, int tongDiem, int soDiemDaDung, int soDiemDaCong, int tinhTrang) {
        this.Ma = Ma;
        this.tongDiem = tongDiem;
        this.soDiemDaDung = soDiemDaDung;
        this.soDiemDaCong = soDiemDaCong;
        this.tinhTrang = tinhTrang;
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

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String tinhTrang(int tinhTrang){
        if (tinhTrang==1) {
            return "Đang hoạt động.";
        }
        return "Không hoạt động.";
    }

    
    
    
}
