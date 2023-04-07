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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class HopThitRepository implements IHopThitRepo{

    @Override
    public List<HopThitDomain> getall() {
        ArrayList<HopThitDomain> ht = new ArrayList<>();
        try {
            Connection cnn = DBContext.getConnection();
            String sql = "select Id, Ma, Ten, GiaNhap,GiaBan, SoLuongTon, NgayDongGoi, HSD, MoTa, TrangThai, IdThit, IdLoaiThit, IdXuatXu ,IdNhaCungCap from HopThit";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                
                HopThitDomain htd  = new HopThitDomain(
                rs.getString(1),
                rs.getString(2),   
                rs.getString(3), 
                rs.getDouble(4),
                rs.getDouble(5),
                rs.getInt(6),        
                rs.getDate(7),
                rs.getInt(8),
                rs.getString(9),
                rs.getInt(10),
                rs.getString(11),
                rs.getString(12),
                rs.getString(13),
                rs.getString(14));
                ht.add(htd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ht;
    }

    @Override
    public boolean add(HopThitDomain ht) {
        try {
        Connection cnn = DBContext.getConnection();
        String sql = "INSERT INTO HopThit(Id, Ma, Ten, GiaNhap,GiaBan, SoLuongTon, NgayDongGoi, HSD, MoTa, TrangThai, IdThit, IdLoaiThit, IdXuatXu ,IdNhaCungCap)";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1,ht.getId());
        ps.setString(2,ht.getTenHopThit());
        ps.setDouble(3,ht.getGiaNhap());
        ps.setDouble(4,ht.getGiaBan());
        ps.setInt(5,ht.getSoLuongTon());
        ps.setDate(6, (Date) ht.getNgayDongGoi());
        ps.setInt(7, ht.getHSD());
        ps.setString(8,ht.getMoTa());
        ps.setInt(9,ht.getTrangThai());
        ps.setString(10,ht.getIdThit());
        ps.setString(11,ht.getIdloaiThit());
        ps.setString(9,ht.getIdXuatXu());
        ps.setString(11,ht.getIdNCC());        
        ps.execute();
        return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
        
    }

    @Override
    public boolean update(HopThitDomain ht) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE HopThit set id = ?,TenHopThit = ?, GiaNhap = ?, GiaBan = ?, SoLuongTon = ?,NgayDongGoi = ?,HSD = ?, MoTa = ?, TrangThai=?,idThit =?,idLoaiThit =?,idXuatXu=?,idNCC=? where id =?";
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,ht.getId());
            ps.setString(2,ht.getTenHopThit());
            ps.setDouble(3,ht.getGiaNhap());
            ps.setDouble(4,ht.getGiaBan());
            ps.setInt(5,ht.getSoLuongTon());
            ps.setDate(6, (Date) ht.getNgayDongGoi());
            ps.setInt(7,ht.getHSD());
            ps.setString(8,ht.getMoTa());
            ps.setInt(9,ht.getTrangThai());
            ps.setString(10,ht.getIdThit());
            ps.setString(11,ht.getIdloaiThit());
            ps.setString(12,ht.getIdNCC());
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(HopThitDomain ht) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE * FROM HopThit where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ht.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
