/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import DomainModels.GiamGiaHT;
import DomainModels.HopThitDomain;
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
        String query = "SELECT h.Ma , h.Ten , h.GiaBan , h.GiaConLai , h.SoLuongTon , h.HSD , h.TrangThai , g.ma , g.MucPhanTramGiamGia , DATEDIFF(DAY,GETDATE(),HSD) as ngayconlai FROM HopThit h join GiamGia g on h.IdGiamGia = g.Id ";
        try(Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<GiamGiaHT> listgght = new ArrayList<>();
            while(rs.next()){
                GiamGiaHT gght = new GiamGiaHT            (rs.getString(1),
                                                           rs.getString(2),
                                                           rs.getBigDecimal(3),
                                                           rs.getBigDecimal(4),
                                                           rs.getInt(5),
                                                           rs.getDate(6),
                                                           rs.getInt(7),
                                                           rs.getString(8),
                                                           rs.getInt(9),
                                                           rs.getInt(10));
                listgght.add(gght);
            }
            return listgght;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
           

    public boolean updateMa(String idht,String idgg) {
        int check = 0;
            String sql = "UPDATE [dbo].[HopThit]\n" +
                         "SET [IdGiamGia] = (Select [Id] from [dbo].[GiamGia] where [GiamGia].[Ma]=?)\n" +
                         "WHERE [Ma]= ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, idgg);
            ps.setObject(2, idht);       
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }    

    public boolean updatetien(String idht,String idgg) {
        int check = 0;
            String sql = "UPDATE [dbo].[HopThit] \n" +
                          "SET [GiaConLai] = [GiaBan] -(([GiaBan] *(SELECT [MucPhanTramGiamGia] FROM [dbo].[GiamGia] WHERE [GiamGia].[Ma]= ? ) / 100)) \n" +
                          "where [Ma] = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, idgg);
            ps.setObject(2, idht);       
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }
  
    /*    public boolean updatetien5day(String idht) {
    int check = 0;
    String sql = "UPDATE HopThit SET GiaConLai = GiaBan - ((GiaBan * 10) / 100) where Ma = ?";
    try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
    ps.setObject(1, idht);
    check = ps.executeUpdate();
    } catch (Exception e) {
    e.printStackTrace(System.out);
    }
    return check > 0;
    
    }
    public boolean updatetien3day(String idht) {
    int check = 0;
    String sql = "UPDATE HopThit SET GiaConLai = GiaBan - ((GiaBan * 30) / 100) where Ma = ?";
    try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
    ps.setObject(1, idht);
    check = ps.executeUpdate();
    } catch (Exception e) {
    e.printStackTrace(System.out);
    }
    return check > 0;
    
    }
    public boolean updatetien1day(String idht) {
    int check = 0;
    String sql = "UPDATE HopThit SET GiaConLai = GiaBan - ((GiaBan * 50) / 100) where Ma = ?";
    try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
    ps.setObject(1, idht);
    check = ps.executeUpdate();
    } catch (Exception e) {
    e.printStackTrace(System.out);
    }
    return check > 0;
    
    } */
        public List<HopThitDomain> getall() {
        ArrayList<HopThitDomain> ht = new ArrayList<>();
        try {
            Connection cnn = DBContext.getConnection();
            String sql = "select Id, Ma, Ten,GiaBan, SoLuongTon, NgayDongGoi, HSD, MoTa, TrangThai, IdThit, IdLoaiThit, IdXuatXu ,IdNhaCungCap from HopThit";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                
                HopThitDomain htd  = new HopThitDomain(
                rs.getString(1),
                rs.getString(2),   
                rs.getString(3), 
                rs.getBigDecimal(4),
                rs.getInt(5),        
                rs.getDate(6),
                rs.getDate(7),
                rs.getString(8),
                rs.getInt(9),
                rs.getString(10),
                rs.getString(11),
                rs.getString(12),
                rs.getString(13));
                ht.add(htd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ht;
    }
}
