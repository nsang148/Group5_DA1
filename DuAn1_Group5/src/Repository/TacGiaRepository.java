package Repository;

import DomainModels.TacGia;
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
public class TacGiaRepository {

    final String insert = "INSERT INTO TACGIA(MA,TEN) VALUES(?,?)";
    final String update = "UPDATE TACGIA SET MA = ? , TEN = ? WHERE ID = ?";
    final String delete = "DELETE FROM TACGIA WHERE ID = ?";

    public List<TacGia> getAll() {
        List<TacGia> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "SELECT * FROM TACGIA";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);
            while (rs.next()) {
                list.add(new TacGia(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }

    public int createTacGiaRepository(TacGia tg) {
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(insert)) {
            sttm.setString(1, tg.getMa());
            sttm.setString(2, tg.getTen());
            ketQuaTruyVan = sttm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }

    public int updateTacGiaRepository(TacGia tg) {
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(update)) {
            sttm.setString(1, tg.getMa());
            sttm.setString(2, tg.getTen());
            sttm.setString(3, tg.getId());
            ketQuaTruyVan = sttm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }

    public int deleteTacGiaRepository(String id) {
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
