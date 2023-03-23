/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import ViewModels.ThongKeResponse;
import Untility.DBContext;
import ViewModels.SanPhamHet;
import ViewModels.SoHoaDon;
import ViewModels.SoSanPhamTon;
import ViewModels.ThongKeSPResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class ThongKeRepository {

    public List<ThongKeResponse> getAll() {
        List<ThongKeResponse> list = new ArrayList<>();
        String SELECT = "select NGAYTHANHTOAN, sum(hdct.SOLUONG) as [So luong], sum(hdct.SOLUONG * hdct.DONGIA) as [Tong tien] from HOADON hd join HOADONCHITIET hdct on hd.Id = hdct.ID_HOADON group by NGAYTHANHTOAN";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT);
            while (rs.next()) {
                list.add(new ThongKeResponse(rs.getString(1), rs.getInt(2), rs.getDouble(3)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    
    public List<ThongKeSPResponse> getAllThongKeSP() {
        List<ThongKeSPResponse> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "select NGAYTHANHTOAN, tl.TEN, sum(hdct.SOLUONG), sum(hdct.SOLUONG) * hdct.DONGIA from HOADON hd join HOADONCHITIET hdct on hd.Id = hdct.ID_HOADON join SACH s on hdct.ID_SACH = s.Id join THELOAI tl on s.ID_THELOAI = tl.Id group by NGAYTHANHTOAN, tl.TEN, hdct.DONGIA";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);
            while (rs.next()) {
                list.add(new ThongKeSPResponse(rs.getString(1), rs.getString(2) , rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAllThongKeSP()");
        }
        return list;
    }
    public List<ThongKeResponse> HienThiDoanhThu() {
        List<ThongKeResponse> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "select SOLUONG * DONGIA from HOADON hd join HOADONCHITIET hdct on hd.Id = hdct.ID_HOADON";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);         
            while (rs.next()) {
                list.add(new ThongKeResponse(null, 0, rs.getDouble(1)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    public List<SoHoaDon> hienThiTongHoaDon() {
        List<SoHoaDon> list = new ArrayList<>();
        int hoaDon = 100;
        String SELECT_KHUYENMAIHOADON = "select count(Id) from HOADONCHITIET";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);
            while (rs.next()) {
                list.add(new SoHoaDon(rs.getInt(1)));
            }

        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    public List<SoSanPhamTon> hienThiSoLuongTon() {
        List<SoSanPhamTon> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "select sum(SOLUONGTON) from SACH";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);
            while (rs.next()) {
                list.add(new SoSanPhamTon(rs.getInt(1)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    
    public List<SanPhamHet> hienThiSoPhamHet() {
        List<SanPhamHet> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "select sum(SOLUONGTON) from SACH";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);
            while (rs.next()) {
                list.add(new SanPhamHet(rs.getInt(1)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    public List<ThongKeResponse> search(String dateBD, String dateKT) {
        List<ThongKeResponse> list = new ArrayList<>();
        String select = "select NGAYTHANHTOAN, sum(hdct.SOLUONG) as [So luong], sum(hdct.SOLUONG * hdct.DONGIA) as [Tong tien]  from HOADON hd join HOADONCHITIET hdct on hd.Id = hdct.ID_HOADON where NGAYTHANHTOAN between ? and ? group by NGAYTHANHTOAN";
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(select)) {
            sttm.setString(1, dateBD);
            sttm.setString(2, dateKT);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeResponse(rs.getString(1),rs.getInt(2), rs.getDouble(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
