/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.HopThitDomain;
import Untility.DBContext;
import ViewModels.LayIDHT;
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
public class HopThitRepository implements IHopThitRepo {

    @Override
    public List<HopThitDomain> getall() {
        ArrayList<HopThitDomain> ht = new ArrayList<>();
        try {
            Connection cnn = DBContext.getConnection();

            String sql = "SELECT \n"
                    + "    ht.Id, \n"
                    + "    ht.Ma, \n"
                    + "    ht.Ten, \n"
                    + "    ht.GiaBan, \n"
                    + "    ht.SoLuongTon, \n"
                    + "    ht.KhoiLuong, \n"
                    + "    ht.NgayDongGoi, \n"
                    + "    ht.HSD, \n"
                    + "    ht.MoTa, \n"
                    + "    ht.TrangThai, \n"
                    + "    ht.IdThit, \n"
                    + "    ht.IdLoaiThit, \n"
                    + "    ht.IdXuatXu, \n"
                    + "    ht.IdNhaCungCap, \n"
                    + "    CASE \n"
                    + "        WHEN gg.NgayKetThuc >= GETDATE() OR (gg.NgayKetThuc IS NULL AND gg.NgayBatDau <= GETDATE()) \n"
                    + "            THEN ht.GiaBan * (100 - gg.MucPhanTramGiamGia) / 100 \n"
                    + "        ELSE ht.GiaBan \n"
                    + "    END AS GiaConLai\n"
                    + "FROM HopThit ht\n"
                    + "LEFT JOIN GiamGia gg ON ht.IdGiamGia = gg.Id";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                HopThitDomain htd = new HopThitDomain(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
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
                        rs.getDouble(15));
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
            String sql = "INSERT INTO HopThit(Id, Ma, Ten, GiaBan, SoLuongTon, KhoiLuong, NgayDongGoi, HSD, "
                    + "MoTa, TrangThai, IdThit, IdLoaiThit, IdXuatXu, IdNhaCungCap)"
                    + "VALUES (NEWID(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, ht.getMa());
            ps.setString(2, ht.getTenHopThit());
            ps.setDouble(3, ht.getGiaBan());
            ps.setInt(4, ht.getSoLuongTon());
            ps.setFloat(5, ht.getKhoiLuong());
            ps.setDate(6, new Date(ht.getNgayDongGoi().getTime()));
            ps.setDate(7, new Date(ht.getHSD().getTime()));
            ps.setString(8, ht.getMoTa());
            ps.setInt(9, ht.getTrangThai());
            ps.setString(10, ht.getIdThit());
            ps.setString(11, ht.getIdloaiThit());
            ps.setString(12, ht.getIdXuatXu());
            ps.setString(13, ht.getIdNCC());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(HopThitDomain ht) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE HopThit set Ma = ?, Ten = ?, GiaBan = ?, SoLuongTon = ?, KhoiLuong = ?,"
                    + "NgayDongGoi = ?,HSD = ?, MoTa = ?, TrangThai = ?,idThit = ?, "
                    + "idLoaiThit = ?, idXuatXu = ?, IdNhaCungCap = ? where id LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ht.getMa());
            ps.setString(2, ht.getTenHopThit());
            ps.setDouble(3, ht.getGiaBan());
            ps.setInt(4, ht.getSoLuongTon());
            ps.setFloat(5, ht.getKhoiLuong());
            ps.setDate(6, new Date(ht.getNgayDongGoi().getTime()));
            ps.setDate(7, new Date(ht.getHSD().getTime()));
            ps.setString(8, ht.getMoTa());
            ps.setInt(9, ht.getTrangThai());
            ps.setString(10, ht.getIdThit());
            ps.setString(11, ht.getIdloaiThit());
            ps.setString(12, ht.getIdXuatXu());
            ps.setString(13, ht.getIdNCC());
            ps.setString(14, ht.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(HopThitDomain ht) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE HopThit where id LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ht.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<LayIDHT> getID() {
        List<LayIDHT> listID = new ArrayList<>();
        String sql = "select ID, MA from HopThit";
        try ( Connection con = DBContext.getConnection();  PreparedStatement sttm = con.prepareStatement(sql)) {
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                listID.add(new LayIDHT(rs.getString(1), rs.getString(2)));
            }
            return listID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
