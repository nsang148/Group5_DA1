/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.XuatXuDomain;
import Untility.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class XuatXuRepository implements IXuatXuRepo{

    @Override
    public List<XuatXuDomain> getAll() {
        List<XuatXuDomain> xxd = new ArrayList<>();
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM XuatXu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String id = rs.getString("ID");
                String ma = rs.getString("Ma");
                String noiXX = rs.getString("NoiXX");
                int trangthai = rs.getInt("TrangThai");
                XuatXuDomain nccDm = new XuatXuDomain(id, ma, noiXX, trangthai);
                xxd.add(nccDm);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xxd;
    }

    @Override
    public boolean add(XuatXuDomain xx) {
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO XuatXu (Ma, NoiXX,TrangThai) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xx.getMa());
            ps.setString(2, xx.getNoiXX());
            ps.setInt(3, xx.getTrangthai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }

    @Override
    public boolean update(XuatXuDomain xx) {
       String query = "UPDATE [dbo].[XuatXu]\n"
                + "   SET \n"
                + "      [Ma] =?\n"
                + "      ,[NoiXX] =? \n"
                + "      ,[TrangThai] =? \n"
                + " WHERE Id=?";
        int check = 0;
        try (java.sql.Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, xx.getMa());
            ps.setObject(2, xx.getNoiXX());
            ps.setObject(3, xx.getTrangthai());
            ps.setObject(4, xx.getId());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(XuatXuDomain xx) {
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "DELETE XuatXu where Ma= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xx.getMa());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
