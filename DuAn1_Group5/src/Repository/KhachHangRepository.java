
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhachHangModel;
import Untility.DBContext;
import ViewModels.KhachHangReponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sangh
 */
public class KhachHangRepository {

    Statement st = null;
    ResultSet rs = null;
    PreparedStatement psm = null;
    List<KhachHangReponse> kvr;

    public KhachHangRepository() {
    }

    public List<KhachHangReponse> getKH() {
        String query = "SELECT MAKH, Ten,GioiTinh,NgaySinh,DiaChi,Sdt,Email,TinhTrang FROM KhachHang ";
        kvr = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                KhachHangReponse kh = new KhachHangReponse();
                kh.setMa(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setGioiTinh(rs.getString(3));
                kh.setNgaySinh(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.setSdt(rs.getString(6));
                kh.setEmail(rs.getString(7));
//                kh.setTongDiem(rs.getInt(8));
//                kh.setSoDiemDaDung(rs.getInt(9));
//                kh.setSoDiemDaCong(rs.getInt(10));
                kh.setTinhTrang(rs.getBoolean(8));
                kvr.add(kh);
            }
        } catch (SQLException ex) {
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kvr;
    }
    public List<KhachHangReponse> getKHsapxep() {
        String query = "SELECT MAKH, Ten,GioiTinh,NgaySinh,DiaChi,Sdt,Email,TinhTrang FROM KhachHang order by Ten";
        kvr = new ArrayList<>();
        try {
            Connection con = DBContext.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                KhachHangReponse kh = new KhachHangReponse();
                kh.setMa(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setGioiTinh(rs.getString(3));
                kh.setNgaySinh(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.setSdt(rs.getString(6));
                kh.setEmail(rs.getString(7));
//                kh.setTongDiem(rs.getInt(8));
//                kh.setSoDiemDaDung(rs.getInt(9));
//                kh.setSoDiemDaCong(rs.getInt(10));
                kh.setTinhTrang(rs.getBoolean(8));
                kvr.add(kh);
            }
        } catch (SQLException ex) {
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kvr;
    }

    public String insert(KhachHangModel kh) {
        String insert = "Insert into KHACHHANG(MAKH,TEN,GIOITINH,NGAYSINH,DiaCHi,SDT,EMAIL,TINHTRANG) VALUES (?,?,?,?,?,?,?,?)";
        try {
            psm = DBContext.getConnection().prepareStatement(insert);

            psm.setObject(1, kh.getMaKH());
            psm.setObject(2, kh.getTen());
            psm.setObject(3, kh.getGioiTinh());
            psm.setObject(4, kh.getNgaySinh());
            psm.setObject(5, kh.getDiaChi());
            psm.setString(6, kh.getSdt());
            psm.setObject(7, kh.getEmail());
            psm.setObject(8, kh.getTinhTrang());
            psm.executeUpdate();
            return "Thêm thành công";
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thêm không thành công";
        }
    }

   
    public String update(KhachHangModel kh, String MaKh) {
        String query = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[TinhTrang] = ?\n"
                + " WHERE [MaKh] = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getGioiTinh());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.getDiaChi());
            ps.setString(5, kh.getSdt());
            ps.setObject(6, kh.getEmail());
            ps.setObject(7, kh.getTinhTrang());
            ps.setObject(8, kh.getMaKH());
            ps.executeUpdate();
            return "Thành công";
        } catch (Exception e) {
            return "Thất bại";
        }
    }
    public String delete(String MaKh) {
        String delete = "DELETE FROM  KhachHang WHERE MaKh = ?";
        try {
            psm = DBContext.getConnection().prepareStatement(delete);
            psm.setObject(1, MaKh);

            psm.executeUpdate();
            return "Xóa thành công";
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xóa không thành công";
        }
    }

    public boolean isExists(String maKh) {
        
        boolean isExists = false;
        String query = "SELECT * FROM [KhachHang] WHERE MAKH = '" + maKh + "'";
        Statement st;
        try {
            Connection con = DBContext.getConnection();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                isExists = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExists;
    }

    public List<KhachHangReponse> searchKH(String MaKH) {
        List<KhachHangReponse> listTemp = new ArrayList<>();
        for (KhachHangReponse d : kvr) {
            if (d.getMa().equalsIgnoreCase(MaKH)) {
                listTemp.add(d);
            }
        }
        return listTemp;
    }
}
