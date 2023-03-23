/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhachHangModel;
import DomainModels.NXB;
import DomainModels.ViDiem;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sangh
 */
public class ViDiemRepository {
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement psm = null;
    final String insert = "INSERT INTO ViDiem(Ma,TongDiem,SoDiemDaDung,SoDiemDaCong,TinhTrang) VALUES(?,?,?,?,?)";
    final String update = "UPDATE ViDiem SET TongDiem = ? , SoDiemDaDung = ?,SoDiemDaCong = ?,TinhTrang = ?  WHERE ID = ?";
    final String delete = "DELETE FROM ViDiem WHERE Ma = ?";
    
    public List<ViDiem> getAll() {
        List<ViDiem> list = new ArrayList<>();
        String querry = "SELECT Ma,TONGDIEM,SODIEMDADUNG,SODIEMDACONG, TINHTRANG FROM ViDiem";
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(querry);
            while (rs.next()) {
                list.add(new ViDiem(rs.getString(1),rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public String insert(ViDiem viDiem) {
        try {
            psm = DBContext.getConnection().prepareStatement(insert);
            psm.setObject(1, viDiem.getMa());
            psm.setObject(2, viDiem.getTongDiem());
            psm.setObject(3, viDiem.getSoDiemDaDung());
            psm.setObject(4, viDiem.getSoDiemDaCong());
            psm.setObject(5, viDiem.getTinhTrang());
            psm.executeUpdate();
            return "Thêm thành công";
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thêm không thành công";
        }
    }
    public String update(ViDiem viDiem) {
        try {
            psm = DBContext.getConnection().prepareStatement(update);
            psm.setObject(1, viDiem.getMa());
            psm.setObject(2, viDiem.getTongDiem());
            psm.setObject(3, viDiem.getSoDiemDaDung());
            psm.setObject(4, viDiem.getSoDiemDaCong());
            psm.setObject(5, viDiem.getTinhTrang());
            psm.executeUpdate();
            return "Sửa thành công";
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sửa không thành công";
        }
    }

    public String delete(String Ma) {
        try {
            psm = DBContext.getConnection().prepareStatement(delete);
            psm.setObject(1, Ma);

            psm.executeUpdate();
            return "Xóa thành công";
        } catch (Exception ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xóa không thành công";
        }
    }
}
