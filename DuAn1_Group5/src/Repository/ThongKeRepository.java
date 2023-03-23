/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Untility.DBContext;
import ViewModels.BaoCaoMail;
import ViewModels.ChartThongKe;
import ViewModels.DoanhThuThongKe;
import ViewModels.SPBanChayViewModel;
import ViewModels.TheLoaiBanChay;
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

    
    public List<ChartThongKe> ChartThongKe() {
        List<ChartThongKe> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "select month(NGAYTHANHTOAN), sum(tongtien) from HOADON where ngaythanhtoan like '%%' group by month(NGAYTHANHTOAN) ";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);         
            while (rs.next()) {
                list.add(new ChartThongKe(rs.getDouble(1), rs.getDouble(2)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    
    public List<SPBanChayViewModel> TableSachBanChay() {
        List<SPBanChayViewModel> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "select month(hd.NGAYTHANHTOAN) ,s.TEN, count(*) as [So luong], sum(hdct.DONGIA * hdct.SOLUONG) as[Tong tien] from HOADONCHITIET hdct join SACH s on s.id = hdct.ID_SACH join HOADON hd on hdct.ID_HOADON = hd.Id group by s.TEN, month(hd.NGAYTHANHTOAN) ";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);         
            while (rs.next()) {
                list.add(new SPBanChayViewModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    
    public List<TheLoaiBanChay> TableTheLoaiBanChay() {
        List<TheLoaiBanChay> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "select month(hd.NGAYTHANHTOAN) ,tl.TEN, count(*) as [So luong], sum(hdct.DONGIA * hdct.SOLUONG) as[Tong tien] from HOADONCHITIET hdct join SACH s on s.id = hdct.ID_SACH join HOADON hd on hdct.ID_HOADON = hd.Id join THELOAI tl on s.ID_THELOAI = tl.Id group by tl.TEN, month(hd.NGAYTHANHTOAN) ";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);         
            while (rs.next()) {
                list.add(new TheLoaiBanChay(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    
    public List<BaoCaoMail> GuiMail() {
        List<BaoCaoMail> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "select hd.NGAYTHANHTOAN ,s.TEN, count(*) as [So luong], sum(hdct.DONGIA * hdct.SOLUONG) as[Tong tien] from HOADONCHITIET hdct join SACH s on s.id = hdct.ID_SACH join HOADON hd on hdct.ID_HOADON = hd.Id where DATEDIFF(DAY,NGAYTHANHTOAN ,GETDATE()) = 4 group by s.TEN, hd.NGAYTHANHTOAN";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);         
            while (rs.next()) {
                list.add(new BaoCaoMail(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
}
