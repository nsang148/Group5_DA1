/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author acer
 */
public class ChartThongKe {
    private Double thang;
    private Double doanhThu;

    public ChartThongKe() {
    }

    public ChartThongKe(Double thang, Double doanhThu) {
        this.thang = thang;
        this.doanhThu = doanhThu;
    }

    public Double getThang() {
        return thang;
    }

    public void setThang(Double thang) {
        this.thang = thang;
    }

    public Double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(Double doanhThu) {
        this.doanhThu = doanhThu;
    }

   
    
}
