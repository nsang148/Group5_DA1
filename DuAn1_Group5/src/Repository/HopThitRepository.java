/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.HopThitDomain;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor;

/**
 *
 * @author Tus
 */
public class HopThitRepository implements IHopThitRepo {

    @Override
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

    @Override
    public boolean add(HopThitDomain ht) {
        String sql = "INSERT INTO [dbo].[HopThit]\n" +
"           ([Ma]\n" +
"           ,[Ten]\n" +
"           ,[GiaBan]\n" +
"           ,[SoLuongTon]\n" +
"           ,[KhoiLuong]\n" +
"           ,[NgayDongGoi]\n" +
"           ,[HSD]\n" +
"           ,[MoTa]\n" +
"           ,[TrangThai])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?)";
        try(Connection cnn = DBContext.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);) {
            ps.setObject(1, ht.getMa());
            ps.setObject(2, ht.getTenHopThit());
            ps.setObject(3, ht.getGiaBan());
            ps.setObject(4, ht.getSoLuongTon());
            ps.setObject(5, ht.getKhoiLuong());
            ps.setObject(6, ht.getNgayDongGoi());
            ps.setObject(7, ht.getHSD());
            ps.setObject(8, ht.getMoTa());
            ps.setObject(9, ht.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }

    }

    

    @Override
    public boolean delete(String Ma) {
                int check = 0;
            String sql = "DELETE FROM [dbo].[HopThit]\n" +
"      WHERE Id like ?";
    try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, Ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    @Override
    public ArrayList<HopThitDomain> timKiem(String ma) {
        ArrayList<HopThitDomain> listht = new ArrayList<>();
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
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HopThitDomain ht = new HopThitDomain(rs.getString(1),
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
                listht.add(ht);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return listht;    
    }

    @Override
    public boolean updateNCC(String TenNCC, String MaHT) {
        int check = 0;
            String sql = "UPDATE [dbo].[HopThit]\n" +
                            "SET [IdNhaCungCap] = (Select [Id] from [dbo].[NhaCungCap] where [NhaCungCap].[Ten]=?)\n" +
                            "WHERE [Ma]= ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, TenNCC);
            ps.setObject(2, MaHT);       
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;        }

    @Override
    public boolean updatexx(String Tenxx, String MaHT) {
        int check = 0;
            String sql = "UPDATE [dbo].[HopThit]\n" +
                         "SET [IdXuatXu] = (Select [Id] from [dbo].[XuatXu] where [XuatXu].[NoiXX]=?)\n" +
                         "WHERE [Ma]= ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, Tenxx);
            ps.setObject(2, MaHT);       
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;    }

    @Override
    public boolean updateGG(String MaGG, String MaHT) {
        int check = 0;
            String sql = "UPDATE [dbo].[HopThit]\n" +
                         "SET [IdGiamGia] = (Select [Id] from [dbo].[GiamGia] where [GiamGia].[Ma]=?)\n" +
                         "WHERE [Ma]= ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, MaGG);
            ps.setObject(2, MaHT);       
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;    }

    @Override
    public boolean updateThit(String TenT, String MaHT) {
        int check = 0;
            String sql = "UPDATE [dbo].[HopThit]\n" +
                          "SET [IdThit] = (Select [Id] from [dbo].[Thit] where [Thit].[Ten]=?)\n" +
                           "WHERE [Ma]= ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, TenT);
            ps.setObject(2, MaHT);       
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;     }




}
