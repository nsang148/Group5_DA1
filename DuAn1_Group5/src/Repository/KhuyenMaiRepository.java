/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhuyenMai;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc
 */
public class KhuyenMaiRepository {

    public KhuyenMaiRepository() {
    }

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> lstKM = new ArrayList<>();
        String SELECT_KHUYENMAI = "SELECT * FROM KHUYENMAI";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAI);
            while (rs.next()) {
                lstKM.add(new KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return lstKM;
    }

    public boolean add(KhuyenMai obj) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String INSERT_KHUYENMAI = "INSERT INTO KHUYENMAI (MA, TEN, PHANTRAMGIAM, NGAYAPDUNG, NGAYKETTHUC, TINHTRANG) VALUES('" + obj.getMa() + "','" + obj.getTen() + "','" + obj.getPhanTramGiam() + "','" + obj.getNgayApDung() + "','" + obj.getNgayKetThuc() + "','" + obj.getTinhTrang() + "')";
            st.executeUpdate(INSERT_KHUYENMAI);
            System.out.println(INSERT_KHUYENMAI);
            st.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Loi tai add()");
            return false;
        }
    }

    public boolean remove(KhuyenMai obj) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String REMOVE_KhuyenMai = "DELETE FROM KHUYENMAI WHERE ID = '" + obj.getId() + "'";
            st.executeUpdate(REMOVE_KhuyenMai);
            st.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Loi tai remove()");
            return false;
        }
    }

    public boolean update(KhuyenMai obj) {
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            String UPDATE_KhuyenMai = "UPDATE KHUYENMAI SET MA = '" + obj.getMa() + "',Ten = '" + obj.getTen() + "',PHANTRAMGIAM = '" + obj.getPhanTramGiam() + "',NGAYAPDUNG = '" + obj.getNgayApDung() + "',NGAYKETTHUC = '" + obj.getNgayKetThuc() + "',TINHTRANG = " + obj.getTinhTrang() + " WHERE ID = '" + obj.getId() + "'";
            st.executeUpdate(UPDATE_KhuyenMai);
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi không thể kết nối vào CSDL tại update()");
            return false;
        }
    }
}
