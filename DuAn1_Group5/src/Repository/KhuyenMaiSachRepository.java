/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhuyenMaiSach;
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
public class KhuyenMaiSachRepository {

    public KhuyenMaiSachRepository() {
    }

    public List<KhuyenMaiSach> getAll() {
        List<KhuyenMaiSach> lstKMSACH = new ArrayList<>();
        String SELECT_KHUYENMAISACH = "SELECT * FROM SACHKHUYENMAI";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAISACH);
            while (rs.next()) {
                lstKMSACH.add(new KhuyenMaiSach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getInt(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return lstKMSACH;
    }

    public boolean add(KhuyenMaiSach obj) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String INSERT_KHUYENMAISACH = "INSERT INTO SACHKHUYENMAI (ID_SACH, ID_KHUYENMAI, DONGIA, SOTIENCONLAI, TINHTRANG) VALUES('" + obj.getIdSach()+ "','" + obj.getIdKM()+ "', " + obj.getDonGia()+ " , " + obj.getSoTienConLai()+ " , " + obj.getTinhTrang() + ")";
            st.executeUpdate(INSERT_KHUYENMAISACH);
            System.out.println(INSERT_KHUYENMAISACH);
            st.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Loi tai add()");
            return false;
        }
    }

    public boolean remove(KhuyenMaiSach obj) {
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            String REMOVE_KhuyenMaiSach = "DELETE FROM SACHKHUYENMAI WHERE ID = '" + obj.getId() + "'";
            st.executeUpdate(REMOVE_KhuyenMaiSach);
            st.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Loi tai remove()");
            return false;
        }
    }

    public boolean update(KhuyenMaiSach obj) {
        try ( Connection conn = DBContext.getConnection()) {
            Statement st = conn.createStatement();
            String UPDATE_KhuyenMaiSach = "UPDATE SACHKHUYENMAI SET IDSACH = '" + obj.getIdSach()+ "',IDKHUYENMAI = '" + obj.getIdKM()+ "',DONGIA = " + obj.getDonGia()+ ",SOTIENCONLAI = " + obj.getSoTienConLai()+ " ,TINHTRANG = '" + obj.getTinhTrang() + "' WHERE ID = '" + obj.getId() + "'";
            st.executeUpdate(UPDATE_KhuyenMaiSach);
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi không thể kết nối vào CSDL tại update()");
            return false;
        }
    }
}
