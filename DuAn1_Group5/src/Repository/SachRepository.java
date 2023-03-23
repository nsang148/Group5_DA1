/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.Sach;
import Untility.DBContext;
import ViewModels.LayIDSach;
import ViewModels.QLSach;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author acer
 */
public class SachRepository {
    public List<QLSach> getAll() {
        List<QLSach> list = new ArrayList<>();
        String SELECT = "select s.ma, s.TEN, tl.TEN, nxb.TEN, tg.TEN, s.MOTA, s.SOLUONGTON, s.Gia, s.TINHTRANG, s.ANH, s.Id from SACH s join TACGIA tg on s.ID_TACGIA = tg.Id join NXB nxb on s.ID_NXB = nxb.Id join THELOAI tl on s.ID_THELOAI = tl.Id";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT);
            while (rs.next()) {
                list.add(new QLSach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }
    
    public int createSachRepository(Sach s) {
        String insert = "insert into SACH(MA, TEN, SOLUONGTON, MOTA, TINHTRANG, ID_THELOAI, ID_NXB, ID_TACGIA, Gia, ANH) values (? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(insert)) {
            sttm.setString(1, s.getMa());
            sttm.setString(2, s.getTen());
            sttm.setInt(3, s.getSoLuongTon());
            sttm.setString(4, s.getMoTa());
            sttm.setInt(5, s.getTinhTrang());
            sttm.setString(6, s.getId_theLoai());
            sttm.setString(7, s.getId_NXB());
            sttm.setString(8, s.getId_tacGia());
            sttm.setDouble(9, s.getGia());
            sttm.setString(10, s.getAnh());
            ketQuaTruyVan = sttm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }
    
    public int updateSachRepository(Sach s, String ma) {
        String update = "update SACH set TEN = ?, MOTA = ?, SOLUONGTON = ?, ID_THELOAI = ?, ID_TACGIA = ?, ID_NXB = ?, TINHTRANG = ?, Gia = ?, ANH = ? where MA = ?";
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(update)) {
            sttm.setString(1, s.getTen());
            sttm.setString(2, s.getMoTa());
            sttm.setInt(3, s.getSoLuongTon());
            sttm.setString(4, s.getId_theLoai());
            sttm.setString(5, s.getId_tacGia());
            sttm.setString(6, s.getId_NXB());
            sttm.setInt(7, s.getTinhTrang());
            sttm.setDouble(8, s.getGia());
            sttm.setString(9, s.getAnh());
            sttm.setString(10, ma);
            ketQuaTruyVan = sttm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }
    
    public int deleteSachRepository(String ma) {
        String delete = "delete SACH where MA = ?";
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(delete)) {

            sttm.setString(1, ma);
            ketQuaTruyVan = sttm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }
    
    public List<QLSach> search(String ma) {
        List<QLSach> list = new ArrayList<>();
        String select = "select s.ma, s.TEN, tl.TEN, nxb.TEN, tg.TEN, s.MOTA, s.SOLUONGTON, s.Gia, s.TINHTRANG, s.ANH from SACH s join TACGIA tg on s.ID_TACGIA = tg.Id join NXB nxb on s.ID_NXB = nxb.Id join THELOAI tl on s.ID_THELOAI = tl.Id where s.MA = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(select)) {
            sttm.setString(1, ma);
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                list.add(new QLSach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getInt(9), rs.getString(10)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<LayIDSach> getIDHD() {
        List<LayIDSach> listID = new ArrayList<>();
        String sql = "select ID, MA from SACH";
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(sql)) {
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                listID.add(new LayIDSach(rs.getString(1), rs.getString(2)));
            }
            return listID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
