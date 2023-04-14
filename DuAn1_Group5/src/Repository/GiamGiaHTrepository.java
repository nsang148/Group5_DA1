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
        String query = "SELECT h.Ma , h.Ten , h.GiaBan , CASE \n" +
"                         WHEN g.NgayKetThuc >= GETDATE() OR (g.NgayKetThuc IS NULL AND g.NgayBatDau <= GETDATE())\n" +
"                         THEN h.GiaBan * (100 - g.MucPhanTramGiamGia) / 100\n" +
"                         ELSE h.GiaBan\n" +
"                         END AS GiaConLai , h.SoLuongTon , h.HSD , h.TrangThai , g.ma , g.MucPhanTramGiamGia FROM HopThit h join GiamGia g on h.IdGiamGia = g.Id";
        try(Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<GiamGiaHT> listgght = new ArrayList<>();
            while(rs.next()){
                GiamGiaHT gght = new GiamGiaHT            (rs.getString(1),
                                                           rs.getString(2),
                                                           rs.getFloat(3),
                                                           rs.getFloat(4),
                                                           rs.getInt(5),
                                                           rs.getDate(6),
                                                           rs.getInt(7),
                                                           rs.getString(8),
                                                           rs.getInt(9));
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

            String sql = "SELECT ht.Id\n" +
                         ",ht.Ma\n" +
                         ",ht.Ten\n" +
                         ",GiaBan\n" +
                         ",SoLuongTon\n" +
                         ",KhoiLuong\n" +
                         ",NgayDongGoi\n" +
                         ",HSD\n" +
                         ",MoTa\n" +
                         ",ht.TrangThai\n" +
                         ",(select t.Ten from Thit where t.Id= ht.IdThit) as TenThit\n" +
                         ",(select lt.Ten from LoaiThit where lt.Id= t.IdLoaiThit) as Loai\n" +
                         ",(select xx.NoiXX from XuatXu where xx.Id= ht.IdXuatXu) as XuatXu\n" +
                         ",(select gg.Ma from GiamGia where gg.Id =ht.IdGiamGia) as MaGiamGia\n" +
                         ",(select ncc.Ten from NhaCungCap where ncc.Id= ht.IdNhaCungCap) as NhaCungCap\n" +
                         ",CASE\n" +
                         "WHEN gg.NgayKetThuc >= GETDATE() OR (gg.NgayKetThuc IS NULL AND gg.NgayBatDau <= GETDATE())\n" +
                         "THEN ht.GiaBan * (100 - gg.MucPhanTramGiamGia) / 100\n" +
                         "ELSE ht.GiaBan\n" +
                         "END AS GiaConLai\n" +
                         "FROM HopThit ht join GiamGia gg on ht.IdGiamGia=gg.Id join Thit t on ht.IdThit= t.Id join LoaiThit lt on t.IdLoaiThit=lt.Id join NhaCungCap ncc on ht.IdNhaCungCap=ncc.Id join XuatXu xx on ht.IdXuatXu= xx.Id ";
            
            try(Connection cnn = DBContext.getConnection();PreparedStatement ps = cnn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            ArrayList<HopThitDomain> ht = new ArrayList<>();
            while (rs.next()) {
                HopThitDomain htd = new HopThitDomain(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getInt(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getFloat(16));
                ht.add(htd);
            }
return ht;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
            return null;
    }
}
