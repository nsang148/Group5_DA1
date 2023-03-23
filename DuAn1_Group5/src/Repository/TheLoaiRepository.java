package Repository;

import DomainModels.NXB;
import DomainModels.TheLoai;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class TheLoaiRepository {

    final String insert = "INSERT INTO THELOAI(MA,TEN) VALUES(?,?)";
    final String update = "UPDATE THELOAI SET MA = ? , TEN = ? WHERE ID = ?";
    final String delete = "DELETE FROM THELOAI WHERE ID = ?";

    public List<TheLoai> getAll() {
        List<TheLoai> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "SELECT * FROM THELOAI";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);
            while (rs.next()) {
                list.add(new TheLoai(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }

    public int createTheLoaiRepository(TheLoai tl) {
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(insert)) {
            sttm.setString(1, tl.getMa());
            sttm.setString(2, tl.getTen());
            ketQuaTruyVan = sttm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }

    public int updateTheLoaiRepository(TheLoai tl) {
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(update)) {
            sttm.setString(1, tl.getMa());
            sttm.setString(2, tl.getTen());
            sttm.setString(3, tl.getId());
            ketQuaTruyVan = sttm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }

    public int deleteTheLoaiRepository(String id) {
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(delete)) {

            sttm.setString(1, id);
            ketQuaTruyVan = sttm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }
}
