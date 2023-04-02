/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NhanVienModel;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sangh
 */
public class NhanVienRepository {
    public List<NhanVienModel> all() {
        List<NhanVienModel> listNhanVien = new ArrayList<>();
        String SELECT_NHANVIEN = "SELECT * FROM NHANVIEN";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_NHANVIEN);
            while (rs.next()) {
                listNhanVien.add(new NhanVienModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10)));
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
    
    public boolean insert(NhanVienModel obj) {
        try {
            Connection conn = DBContext.getConnection();
            String INSERT_NHANVIEN = "INSERT INTO dbo.NHANVIEN(MA,HOTEN,GIOITINH,NGAYSINH,DIACHI,SDT,MATKHAU,CHUCVU,TRANGTHAI) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(INSERT_NHANVIEN);
            ps.setString(1, obj.getMa());
            ps.setString(2, obj.getHoTen());
            ps.setString(3, obj.getGioiTinh());
            ps.setString(4, obj.getNgaySinh());
            ps.setString(5, obj.getDiaChi());
            ps.setString(6, obj.getSdt());
            ps.setString(7, obj.getMatKhau());
            ps.setString(8, obj.getChucVu());
            ps.setInt(9, obj.getTrangThai());
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
    
    public boolean update(NhanVienModel obj) {
        try {
            Connection conn = DBContext.getConnection();
            String UPDATE_NHANVIEN = "UPDATE NHANVIEN SET MA = ?,"
                    + "HOTEN = ?,"
                    + "GIOITINH = ?,"
                    + "NGAYSINH = ?,"
                    + "DIACHI = ?,"
                    + "SDT = ?,"
                    + "MATKHAU = ?,"
                    + "CHUCVU = ?,"
                    + "TRANGTHAI = ?,"
                    + "WHERE ID = ?";
            PreparedStatement ps = conn.prepareCall(UPDATE_NHANVIEN);
            ps.setString(1, obj.getMa());
            ps.setString(2, obj.getHoTen());
            ps.setString(3, obj.getGioiTinh());
            ps.setString(4, obj.getNgaySinh());
            ps.setString(5, obj.getDiaChi());
            ps.setString(6, obj.getSdt());
            
            ps.setString(7, obj.getMatKhau());
            ps.setString(8, obj.getChucVu());
            ps.setInt(9, obj.getTrangThai());
            ps.setString(10, obj.getID());
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
