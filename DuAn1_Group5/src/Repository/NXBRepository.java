/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NXB;
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
public class NXBRepository {
    final String insert = "INSERT INTO NXB(MA,TEN) VALUES(?,?)";
    final String update = "UPDATE NXB SET MA = ? , TEN = ? WHERE ID = ?";
    final String delete = "DELETE FROM NXB WHERE ID = ?";

    public List<NXB> getAll() {
        List<NXB> list = new ArrayList<>();
        String SELECT_KHUYENMAIHOADON = "SELECT * FROM NXB";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_KHUYENMAIHOADON);
            while (rs.next()) {
                list.add(new NXB(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception ex) {
            System.out.println("Loi tai getAll()");
        }
        return list;
    }

    public int createNXBRepository(NXB nxb) {
        int ketQuaTruyVan = -1;
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(insert)) {
            sttm.setString(1, nxb.getMa());
            sttm.setString(2, nxb.getTen());
            ketQuaTruyVan = sttm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }

    public int updateNXBRepository(NXB nxb){
        int ketQuaTruyVan = -1;
        try (Connection con = DBContext.getConnection(); PreparedStatement sttm = con.prepareStatement(update)){
            sttm.setString(1, nxb.getMa());
            sttm.setString(2, nxb.getTen());
            sttm.setString(3, nxb.getId());
            ketQuaTruyVan = sttm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQuaTruyVan;
    }

    public int deleteNSXRepository(String id) {
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
