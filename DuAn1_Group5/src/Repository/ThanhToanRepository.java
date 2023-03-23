package Repository;

import Untility.DBContext;
import ViewModels.ThanhToan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bach
 */
public class ThanhToanRepository {

    public List<ThanhToan> all() {
        List<ThanhToan> listTT = new ArrayList<>();
        String sql = "SELECT A.TEN,B.TEN,C.TEN,D.TEN,A.SOLUONGTON,A.DONGIA from SACH A \n"
                + "                         inner join THELOAI B on A.ID_THELOAI = B.Id\n"
                + "                         inner join TACGIA C on A.ID_TACGIA = C.Id\n"
                + "                         inner join NXB D on A.ID_NXB = D.Id";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                ThanhToan tt = new ThanhToan();
                tt.setTenSach(rs.getString(1));
                tt.setTacGia(rs.getString(2));
                tt.setTheLoai(rs.getString(3));
                tt.setNXB(rs.getString(4));
                tt.setSoLuongTon(rs.getInt(5));
                tt.setDonGia(rs.getInt(6));
//                ThanhToan tt = new ThanhToan(tenSach, tacGia, theLoai, NXB, slTon, gia);
                listTT.add(tt);
            }
        } catch (Exception ex) {
        }

        return listTT;
    }
    final String sql = "INSERT INTO HOADON(TENKHACHHANG,TENSACH,NGAYTAO,SOLUONGSACH,TONGTIEN)" + "values(?,?,?,?,?)";

    public void insert(ThanhToan tt) {
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tt.getTenKH());
            ps.setString(2, tt.getTenSach());
            ps.setString(3, tt.getNgayMua());
            ps.setInt(4, tt.getSoLuong());
            ps.setInt(5, tt.getThanhTien());
            ps.execute();
            System.out.println("Them Thanh Cong");
        } catch (Exception ex) {
        }

    }
    final String sql1 = "UPDATE HOADON"
            + " set TENKHACHHANG = ?,"
            + " TENSACH = ?,"
            + " NGAYTAO = ?,"
            + " SOLUONGSACH = ?,"
            + " TONGTIEN = ?"
            + " WHERE TENKHACHHANG = ? ";

    public void update(ThanhToan tt, String tenKH) {
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setString(1, tt.getTenKH());
            ps.setString(2, tt.getTenSach());
            ps.setString(3, tt.getNgayMua());
            ps.setInt(4, tt.getSoLuong());
            ps.setInt(5, tt.getThanhTien());
            ps.setString(6, tenKH);
            ps.execute();
            System.out.println("Cap nhat thanh cong");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
        }
    }
    final String sql2 = "DELETE FROM HOADON WHERE TENKHACHHANG = ?";
    public void delete(String tenKH) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE FROM sinh_vien WHERE IDSV = ?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, tenKH);
            ps.execute();
            System.out.println("Xoa thanh cong");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
        }
    }
}
