package Repository;

import DomainModels.HoaDon;
import DomainModels.HoaDonCT;
import Untility.DBContext;
import ViewModels.HoaDonChiTietReponse;
import ViewModels.HoaDonReponse;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class HoaDonRepository {

    Statement st = null;
    ResultSet rs = null;
    PreparedStatement psm = null;

    private DBContext conn;

    public HoaDonRepository() {
        conn = new DBContext();
    }

    public List<HoaDonReponse> layHoaDon() {
        List<HoaDonReponse> listHD = new ArrayList<>();
        String sql = "select NGAYTAO, hd.MA, hdct.SOLUONG * hdct.DONGIA as [Tong tien], nv.TEN, hd.TINHTRANG from HOADON hd join HOADONCHITIET hdct on hd.id = hdct.ID_HOADON join NHANVIEN nv on hd.ID_NHANVIEN = nv.Id order by hd.MA asc";

        try {
            Connection con = DBContext.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listHD.add(new HoaDonReponse(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi khi lay danh sach hoa don");
        }
        return listHD;
    }

    public List<HoaDonChiTietReponse> layHoaDonCT(String ma) {
        List<HoaDonChiTietReponse> list = new ArrayList<>();
        String select = "select s.TEN, s.Gia, hdct.SOLUONG, hdct.SOLUONG * s.GIA from SACH s join HOADONCHITIET hdct on s.Id = hdct.ID_SACH join HOADON hd on hd.Id = hdct.ID_HOADON where hd.MA = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(select)) {
            sttm.setString(1, ma);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                list.add(new HoaDonChiTietReponse(rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getDouble(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDonReponse> layHoaDontuNgay(String dateBD, String dateKT) {
        List<HoaDonReponse> listHD = new ArrayList<>();
        String sql = "select NGAYTAO, hd.MA, hdct.SOLUONG * hdct.DONGIA as [Tong tien], nv.TEN, hd.TINHTRANG from HOADON hd join HOADONCHITIET hdct on hd.id = hdct.ID_HOADON join NHANVIEN nv on hd.ID_NHANVIEN = nv.Id where NGAYTAO between ? and  ? order by NGAYTAO";

        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(sql)) {
            sttm.setString(1, dateBD);
            sttm.setString(2, dateKT);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                listHD.add(new HoaDonReponse(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5)));
            }
            return listHD;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
