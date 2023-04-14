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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class ThitRepository implements IThitRepo {

    private ThitDomain getThit(ResultSet rs) throws SQLException {
        String id = rs.getString(1);
        String ma = rs.getString(2);
        String ten = rs.getString(3);
        String IdLT =rs.getString(4);
        int trangthai = rs.getInt(5);
        ThitDomain tdm = new ThitDomain(id, ma, ten,IdLT, trangthai);
        return tdm;
    }

    @Override
    public List<ThitDomain> getAll() {
        List<ThitDomain> td = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT [Id]\n" +
"      ,[Ma]\n" +
"      ,[Ten]\n" +
"      ,(select Ten from LoaiThit lt where lt.Id=t.IdLoaiThit)\n" +
"      ,[TrangThai]\n" +
"  FROM Thit t";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                td.add(getThit(rs));
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
            String sql = "INSERT INTO Thit (Ma, Ten,IdLoaiThit, TrangThai) values (?,?,(select id from LoaiThit where Ma =?) ,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMa());
            ps.setString(2, th.getTen());
            ps.setString(3, th.getIdLT());
            ps.setInt(4, th.getTrangthai());
            return ps.executeUpdate() > 0;
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
                + "      ,(select id from LoaiThit where [Ma] =?) \n"
                + "      ,[TrangThai] =? \n"
                + " WHERE [MA] LIKE ?";
        try (java.sql.Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, th.getMa());
            ps.setObject(2, th.getTen());
            ps.setString(3, th.getIdLT());
            ps.setObject(4, th.getTrangthai());
            ps.setObject(5, th.getMa());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean delete(ThitDomain th) {
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "DELETE Thit where MA LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, th.getMa());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ThitDomain getByName(String name) {
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM Thit WHERE Ten LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return getThit(resultSet);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
