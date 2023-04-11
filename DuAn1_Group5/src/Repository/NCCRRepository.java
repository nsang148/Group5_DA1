/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.NhaCungCapDomain;
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
public class NCCRRepository implements INCCRepo {

    private NhaCungCapDomain getNhaCungCap(ResultSet rs) throws SQLException {
        String id = rs.getString("Id");
        String ma = rs.getString("Ma");
        String ten = rs.getString("Ten");
        int trangthai = rs.getInt("TrangThai");
        return new NhaCungCapDomain(id, ma, ten, trangthai);
    }

    @Override
    public List<NhaCungCapDomain> getAll() {
        List<NhaCungCapDomain> nc = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM NhaCungCap";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                nc.add(getNhaCungCap(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nc;
    }
    
    public NhaCungCapDomain getByName(String name) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM NhaCungCap WHERE Ten LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) 
                return getNhaCungCap(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(NhaCungCapDomain nc) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO NhaCungCap (Ma,Ten,TrangThai) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nc.getMa());
            ps.setString(2, nc.getTen());
            ps.setInt(3, nc.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(NhaCungCapDomain nc) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE NhaCungCap set Ma = ?,Ten=?,TrangThai=? where id LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nc.getMa());
            ps.setString(2, nc.getTen());
            ps.setInt(3, nc.getTrangThai());
            ps.setString(4, nc.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(NhaCungCapDomain nc) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE NhaCungCap where id LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nc.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
