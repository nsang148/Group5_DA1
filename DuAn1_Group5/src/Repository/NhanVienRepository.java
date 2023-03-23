/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NhanVien;
import Untility.DBContext;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tran Tuan Cuong
 */
public class NhanVienRepository {

    public NhanVienRepository() {
    }

    public List<NhanVien> all() {
        List<NhanVien> listNhanVien = new ArrayList<>();
        String SELECT_NHANVIEN = "SELECT * FROM NHANVIEN";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_NHANVIEN);
            while (rs.next()) {
                listNhanVien.add(new NhanVien(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13)));
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi tại all()");
            ex.printStackTrace();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return listNhanVien;
    }

    public boolean insert(NhanVien obj) {
        try {
            Connection conn = DBContext.getConnection();
            String INSERT_NHANVIEN = "INSERT INTO dbo.NHANVIEN(MANV,TEN,TENDEM,HO,GIOITINH,NGAYSINH,SDT,DIACHI,MATKHAU,TINHTRANG,VAITRO,ANH) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(INSERT_NHANVIEN);
            ps.setString(1, obj.getMaNV());
            ps.setString(2, obj.getTen());
            ps.setString(3, obj.getTenDem());
            ps.setString(4, obj.getHo());
            ps.setString(5, obj.getGioiTinh());
            ps.setString(6, obj.getNgaySinh());
            ps.setString(7, obj.getSdt());
            ps.setString(8, obj.getDiaChi());
            ps.setString(9, obj.getMatKhau());
            ps.setInt(10, obj.getTinhTrang());
            ps.setString(11, obj.getVaiTro());
            ps.setString(12, obj.getAnh());
            System.out.println(INSERT_NHANVIEN);
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Lỗi tại insert()");
            return false;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(String ID) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String DELETE_NHANVIEN = "DELETE FROM NHANVIEN WHERE ID = '" + ID + "'";
            System.out.println(DELETE_NHANVIEN);
            st.executeUpdate(DELETE_NHANVIEN);
            st.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Lỗi tại delete()");
            return false;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(NhanVien obj) {
        try {
            Connection conn = DBContext.getConnection();
            String UPDATE_NHANVIEN = "UPDATE NHANVIEN SET MANV = ?,"
                    + "TEN = ?,"
                    + "TENDEM = ?,"
                    + "HO = ?,"
                    + "GIOITINH = ?,"
                    + "NGAYSINH = ?,"
                    + "SDT = ?,"
                    + "DIACHI = ?,"
                    + "MATKHAU = ?,"
                    + "TINHTRANG = ?,"
                    + "VAITRO = ?,"
                    + "ANH = ? "
                    + "WHERE ID = ?";
            PreparedStatement ps = conn.prepareCall(UPDATE_NHANVIEN);
            ps.setString(1, obj.getMaNV());
            ps.setString(2, obj.getTen());
            ps.setString(3, obj.getTenDem());
            ps.setString(4, obj.getHo());
            ps.setString(5, obj.getGioiTinh());
            ps.setString(6, obj.getNgaySinh());
            ps.setString(7, obj.getSdt());
            ps.setString(8, obj.getDiaChi());
            ps.setString(9, obj.getMatKhau());
            ps.setInt(10, obj.getTinhTrang());
            ps.setString(11, obj.getVaiTro());
            ps.setString(12, obj.getAnh());
            ps.setString(13, obj.getID());
            System.out.println(UPDATE_NHANVIEN);
            ps.execute();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi tại update()");
            return false;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NhanVienRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }
}
