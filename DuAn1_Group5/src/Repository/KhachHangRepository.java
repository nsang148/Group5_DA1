/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhachHangModel;
import Untility.DBContext;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyễn Hiếu
 */
public class KhachHangRepository {

    public List<KhachHangModel> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[HoTen]\n"
                + "      ,[Sdt]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[GhiChu]\n"
                + "  FROM [dbo].[KhachHang]";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHangModel> list = new ArrayList<>();
            while (rs.next()) {
                KhachHangModel kh = new KhachHangModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9));

                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(KhachHangModel khachHang) {
        String query = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([Ma]\n"
                + "           ,[HoTen]\n"
                + "           ,[Sdt]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[TrangThai]\n"
                + "           ,[GhiChu])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, khachHang.getMa());
            ps.setObject(2, khachHang.getHoTen());
            ps.setObject(3, khachHang.getSdt());
            ps.setObject(4, khachHang.getNgaySinh());
            ps.setObject(5, khachHang.getDiaChi());
            ps.setObject(6, khachHang.isGioiTinh());
            ps.setObject(7, khachHang.isTrangThai());
            ps.setObject(8, khachHang.getGhiChu());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[KhachHang]\n"
                + "      WHERE Id like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updata(KhachHangModel khachHang, String id) {
        String query = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [Ma] = ?\n"
                + "      ,[HoTen] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[GhiChu] = ?\n"
                + " WHERE Id like ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, khachHang.getMa());
            ps.setObject(2, khachHang.getHoTen());
            ps.setObject(3, khachHang.getSdt());
            ps.setObject(4, khachHang.getNgaySinh());
            ps.setObject(5, khachHang.getDiaChi());
            ps.setObject(6, khachHang.isGioiTinh());
            ps.setObject(7, khachHang.isTrangThai());
            ps.setObject(8, khachHang.getGhiChu());

            ps.setObject(9, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public KhachHangModel checkTrung(String makh) {
        String query = "sSelect Ma from KhachHang where Ma=? ";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, makh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangModel sp = new KhachHangModel(rs.getString(1));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public List<KhachHangModel> getAllViewKH(String maKh) {
        String query = "SELECT [Ma]\n" +
"      ,[HoTen]\n" +
"      ,[Sdt]\n" +
"      ,[NgaySinh]\n" +
"      ,[DiaChi]\n" +
"      ,[GioiTinh]\n" +
"      ,[TrangThai]\n" +
"      ,[GhiChu]\n" +
"  FROM [dbo].[KhachHang] where Ma like ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, "%" + maKh + "%");
            ResultSet rs = ps.executeQuery();
            List<KhachHangModel> list = new ArrayList<>();
            while (rs.next()) {
               KhachHangModel hd = new KhachHangModel( rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), rs.getString(8));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
//    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), rs.getString(8)
    public static void main(String[] args) {
//        List<KhachHangModel> getAll= new KhachHangRepository().getAll();
//        for (KhachHangModel x : getAll) {
//            System.out.println(x);
//        }
//        KhachHangModel st = new KhachHangModel("PH23444", "NguyenVanS", "0184343", "2-2-2002", "NB", true, true, "null");
//        boolean add = new KhachHangRepository().add(st);
//        System.out.println(add);
        KhachHangModel st = new KhachHangModel("84194ae9-15ac-4309-8d84-62dc122dc317","PH23444", "Nguyễn Văn H", "0184343", "2-2-2002", "NB", true, true, "Khách đại gia");
        boolean add = new KhachHangRepository().updata(st, "84194ae9-15ac-4309-8d84-62dc122dc317");
        System.out.println(add);
    }
}
