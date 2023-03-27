/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.GiamGia;
import java.util.List;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tagot
 */
public class GiamGiaRepository {
    public List<GiamGia> getAll(){
        String query = "SELECT [Id],[Ma],[Ten],[NgayBatDau],[NgayKetThuc],[MucPhanTramGiamGia],[DieuKienGiamGia],[TrangThai] FROM [dbo].[GiamGia]";
        try(Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<GiamGia> listgg = new ArrayList<>();
            while(rs.next()){
                GiamGia gg = new GiamGia(rs.getString(1),rs.getString(2), rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getInt(6), rs.getString(7),rs.getInt(8));
                listgg.add(gg);
            }
            return listgg;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
        public boolean add(GiamGia gg) {
        int check = 0;
        String query = "INSERT INTO [dbo].[GiamGia] ([Ma],[Ten],[NgayBatDau],[NgayKetThuc],[MucPhanTramGiamGia],[DieuKienGiamGia],[TrangThai]) VALUES(?,?,?,?,?,?,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gg.getMa());
            ps.setObject(2, gg.getTen());
            ps.setObject(3, gg.getNgayBatDau());
            ps.setObject(4, gg.getNgayKetThuc());
            ps.setObject(5, gg.getMucPhanTramGiamGia());
            ps.setObject(6, gg.getDieuKienGiamGia());
            ps.setObject(7, gg.getTrangThai());            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean delete(String id) {
        int check = 0;
        String query = "DELETE FROM [dbo].[GiamGia] WHERE [Ma]= ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }        
    public boolean update(GiamGia gg, String Ma) {
        int check = 0;
        String query = "UPDATE [dbo].[GiamGia] SET [Ten] = ?,[NgayBatDau] = ?,[NgayKetThuc] = ?,[MucPhanTramGiamGia] = ?,[DieuKienGiamGia] = ?,[TrangThai] = ? WHERE [Ma] = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, gg.getTen());
            ps.setObject(2, gg.getNgayBatDau());
            ps.setObject(3, gg.getNgayKetThuc());
            ps.setObject(4, gg.getMucPhanTramGiamGia());
            ps.setObject(5, gg.getDieuKienGiamGia());
            ps.setObject(6, gg.getTrangThai());
            ps.setObject(7, Ma);            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }    
    
    
}
