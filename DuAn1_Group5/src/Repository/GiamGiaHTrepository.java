/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.GiamGiaHT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Untility.DBContext;

/**
 *
 * @author tagot
 */
public class GiamGiaHTrepository {
    public List<GiamGiaHT> getAll(){
        String query = "SELECT [Id],[IdHT],[IdGiamGia],[DonGia],[SoTienConLai],[TrangThai] FROM [dbo].[GiamGiaHT]";
        try(Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<GiamGiaHT> listgg = new ArrayList<>();
            while(rs.next()){
                GiamGiaHT gght = new GiamGiaHT (rs.getString(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getBigDecimal(4),
                                                rs.getBigDecimal(5),
                                                rs.getInt(6));
                listgg.add(gght);
            }
            return listgg;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
        public boolean add(GiamGiaHT gght) {
        int check = 0;
        String query = "INSERT INTO [dbo].[GiamGiaHT] ([IdHT],[IdGiamGia],[DonGia],[SoTienConLai],[TrangThai])VALUES(?,?,?,?,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gght.getIdHT());
            ps.setObject(2, gght.getIdGiamGia());
            ps.setObject(3, gght.getDonGia());
            ps.setObject(4, gght.getSoTienConLai());
            ps.setObject(5, gght.getTrangThai());         
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean delete(String id) {
        int check = 0;
        String query = "DELETE FROM [dbo].[GiamGiaHT] WHERE [IdHT] = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }        
    public boolean update(GiamGiaHT gght, String id) {
        int check = 0;
        String query = "UPDATE [dbo].[GiamGiaHT] SET [Id] = ?,[IdHT] = ?,[IdGiamGia] = ?,[DonGia] = ?,[SoTienConLai] = ?,[TrangThai] = ? WHERE [IdHT] = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gght.getID());
            ps.setObject(2, id);
            ps.setObject(3, gght.getIdGiamGia());
            ps.setObject(4, gght.getDonGia());
            ps.setObject(5, gght.getSoTienConLai());
            ps.setObject(6, gght.getTrangThai());          
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }    
    
    
        
}
