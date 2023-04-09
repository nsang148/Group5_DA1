/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author tagot
 */
public class ThongKeDT {
    private String NgayThanhToan;
    private BigDecimal tongtienngay;

    public ThongKeDT() {
    }

    public ThongKeDT(String NgayThanhToan, BigDecimal tongtienngay) {
        this.NgayThanhToan = NgayThanhToan;
        this.tongtienngay = tongtienngay;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public BigDecimal getTongtienngay() {
        return tongtienngay;
    }

    public void setTongtienngay(BigDecimal tongtienngay) {
        this.tongtienngay = tongtienngay;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "NgayThanhToan=" + NgayThanhToan + ", tongtienngay=" + tongtienngay + '}';
    }


    
    
}
