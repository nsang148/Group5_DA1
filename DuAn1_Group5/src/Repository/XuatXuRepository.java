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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class XuatXuRepository implements IXuatXuRepo {

    private XuatXuDomain getXuatXu(ResultSet rs) throws SQLException {
        String id = rs.getString("Id");
        String ma = rs.getString("Ma");
        String noiXX = rs.getString("NoiXX");
        int trangthai = rs.getInt("TrangThai");
        return new XuatXuDomain(id, ma, noiXX, trangthai);
    }

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
                xxd.add(getXuatXu(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xxd;
    }
    
    public XuatXuDomain getByName(String name) {
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM XuatXu WHERE NoiXX = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                return getXuatXu(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
            return ps.executeUpdate() > 0;
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
                + " WHERE Id LIke ?";
        try (java.sql.Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, xx.getMa());
            ps.setObject(2, xx.getNoiXX());
            ps.setObject(3, xx.getTrangthai());
            ps.setObject(4, xx.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public boolean delete(XuatXuDomain xx) {
        try {
            java.sql.Connection conn = DBContext.getConnection();
            String sql = "DELETE XuatXu where ID LIEK ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xx.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
