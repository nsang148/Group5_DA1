/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.LoaiThitDomain;
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
public class LoaiThitRepo implements ILoaiThitRepo{

    @Override
    public List<LoaiThitDomain> getAll() {
      List<LoaiThitDomain> td = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM LoaiThit";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangthai = rs.getInt("TrangThai");
                LoaiThitDomain tdm = new LoaiThitDomain(id, ma, ten, trangthai);
                td.add(tdm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return td;
    }

    @Override
    public boolean add(LoaiThitDomain th) {
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO LoaiThit (Ma, Ten, TrangThai) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMa());
            ps.setString(2, th.getTen());
            ps.setInt(3, th.getTrangthai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(LoaiThitDomain th) {
        String query = "UPDATE [dbo].[LoaiThit]\n"
                + "   SET \n"
                + "      [Ma] =?\n"
                + "      ,[Ten] =? \n"
                + "      ,[TrangThai] =? \n"
                + " WHERE Id=?";
        int check = 0;
        try (java.sql.Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, th.getMa());
            ps.setObject(2, th.getTen());
            ps.setObject(3, th.getTrangthai());
            ps.setObject(4, th.getId());

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(LoaiThitDomain th) {
      try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "DELETE LoaiThit where Ma= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMa());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
}
