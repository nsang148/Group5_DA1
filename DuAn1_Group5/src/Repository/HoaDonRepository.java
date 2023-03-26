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
        String sql = "select NGAYTAO, hd.MAHD, hdct.SOLUONG * hdct.DONGIA as [Tong tien], nv.HOTEN, hd.TRANGTHAI from HOADON hd join HOADONCHITIET hdct on hd.id = hdct.IDHD join NHANVIEN nv on hd.IDNV = nv.Id order by hd.MAHD asc";

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
        String select = "select s.TEN, s.GiaBan, hdct.SOLUONG, hdct.SOLUONG * s.GIABAN from HOPTHIT s join HOADONCHITIET hdct on s.Id = hdct.IDht join HOADON hd on hd.Id = hdct.IDHD where hd.MAHD = ?";
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
        String sql = "select NGAYTAO, hd.MAHD, hdct.SOLUONG * hdct.DONGIA as [Tong tien], nv.HOTEN, hd.TRANGTHAI from HOADON hd join HOADONCHITIET hdct on hd.id = hdct.IDHD join NHANVIEN nv on hd.IDNV = nv.Id where NGAYTAO between ? and  ? order by NGAYTAO";

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
