/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author tagot
 */
public class ThongKeSP {
    private String Ten;
    private int SoLuongBan;

    public ThongKeSP() {
    }

    public ThongKeSP(String Ten, int SoLuongBan) {
        this.Ten = Ten;
        this.SoLuongBan = SoLuongBan;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getSoLuongBan() {
        return SoLuongBan;
    }

    public void setSoLuongBan(int SoLuongBan) {
        this.SoLuongBan = SoLuongBan;
    }

    @Override
    public String toString() {
        return "ThongKeSP{" + "Ten=" + Ten + ", SoLuongBan=" + SoLuongBan + '}';
    }
    
}
