package Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import DomainModels.ThongKeDT;
import DomainModels.ThongKeSP;
import Service.ThongKeService;
import java.util.List;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Service.IThongKe;

/**
 *
 * @author tagot
 */
public class ThongKeRepository implements IThongKe{

    @Override
    public List<ThongKeDT> getListTK() {
        String query = "SELECT [NgayThanhToan], SUM([TongTien]) as tongtienngay\n" +
"  FROM [dbo].[HoaDon] GROUP BY [NgayThanhToan]";
        try(Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeDT> listtk = new ArrayList<>();
            while(rs.next()){
                ThongKeDT tk = new ThongKeDT(rs.getString(1),rs.getBigDecimal(2));
                listtk.add(tk);
            }
            return listtk;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;


    }

    @Override
    public List<ThongKeSP> getListSP() {
        String query = "select HopThit.Ten , SUM(HoaDonChiTiet.SoLuong) from HoaDonChiTiet join HopThit on HoaDonChiTiet.IdHT=HopThit.Id group by HopThit.Ten";
        try(Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeSP> listsp = new ArrayList<>();
            while(rs.next()){
                ThongKeSP sp = new ThongKeSP(rs.getString(1),rs.getInt(2));
                listsp.add(sp);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
    
}
