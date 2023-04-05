/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.ThitDomain;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class ThitRepository implements IThitRepo{
    
    @Override
    public List<ThitDomain> getAll() {
     List<ThitDomain> td = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM Thit";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String theloai = rs.getString("TheLoai");
                int trangthai = rs.getInt("TrangThai");
                ThitDomain tdm = new ThitDomain(id, ma, ten, theloai, trangthai);
                td.add(tdm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return td;
        }

    @Override
    public boolean add(ThitDomain th) {
      try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO Thit (Ma, Ten, TheLoai, TrangThai) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMa());
            ps.setString(2, th.getTen());
            ps.setString(3, th.getTheloai());
            ps.setInt(4, th.getTrangthai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ThitDomain th) {
       String query = "UPDATE [dbo].[Thit]\n"
                + "   SET \n"
                + "      [Ma] =?\n"
                + "      ,[Ten] =? \n"
               + "      ,[TheLoai] =? \n"
                + "      ,[TrangThai] =? \n"
                + " WHERE Id=?";
        int check = 0;
        try (java.sql.Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, th.getMa());
            ps.setObject(2, th.getTen());
            ps.setObject(3, th.getTheloai());
            ps.setObject(4, th.getTrangthai());
            ps.setObject(5, th.getId());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(ThitDomain th) {
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "DELETE Thit where Ma= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMa());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
