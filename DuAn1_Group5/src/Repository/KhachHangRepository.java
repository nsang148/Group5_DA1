/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhachHangModel;
import Untility.DBContext;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Nguyễn Hiếu
 */
public class KhachHangRepository {
    public List<KhachHangModel> getAll(){
        String query = "SELECT [Id]\n" +
"      ,[Ma]\n" +
"      ,[HoTen]\n" +
"      ,[Sdt]\n" +
"      ,[NgaySinh]\n" +
"      ,[DiaChi]\n" +
"      ,[GioiTinh]\n" +
"      ,[TrangThai]\n" +
"      ,[GhiChu]\n" +
"      ,[SoLanMua]\n" +
"      ,[IdViDiem]\n" +
"  FROM [dbo].[KhachHang]";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps =con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            List<KhachHangModel> list =new ArrayList<>();
            while(rs.next()){
                KhachHangModel kh = new KhachHangModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getBoolean(8), rs.getString(9), rs.getInt(10), rs.getString(11));
                
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean add(KhachHangModel khachHang){
        String query = "INSERT INTO [dbo].[KhachHang]\n" +
"           ([Ma]\n" +
"           ,[HoTen]\n" +
"           ,[Sdt]\n" +
"           ,[NgaySinh]\n" +
"           ,[DiaChi]\n" +
"           ,[GioiTinh]\n" +
"           ,[TrangThai]\n" +
"           ,[GhiChu]\n" +
"           ,[SoLanMua]\n" +
"           ,[IdViDiem])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try (Connection con  = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
           
            ps.setObject(1, khachHang.getMa());
            ps.setObject(2, khachHang.getHoTen());
            ps.setObject(3, khachHang.getSdt());
            ps.setObject(4, khachHang.getNgaySinh());
            ps.setObject(5, khachHang.getDiaChi());
            ps.setObject(6, khachHang.isGioiTinh());
            ps.setObject(7, khachHang.isTrangThai());
            ps.setObject(8, khachHang.getGhiChu());
            ps.setObject(9, khachHang.getSoLanMua());
            ps.setObject(10, khachHang.getIdViDiem());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean delete(String ma){
        String query = "DELETE FROM [dbo].[KhachHang]\n" +
"      WHERE Id like ?";
        int check = 0;
        try (Connection con  = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean updata(KhachHangModel khachHang, String id){
        String query = "UPDATE [dbo].[KhachHang]\n" +
"   SET [Ma] = ?\n" +
"      ,[HoTen] = ?\n" +
"      ,[Sdt] = ?\n" +
"      ,[NgaySinh] = ?\n" +
"      ,[DiaChi] = ?\n" +
"      ,[GioiTinh] = ?\n" +
"      ,[TrangThai] = ?\n" +
"      ,[GhiChu] = ?\n" +
"      ,[SoLanMua] = ?\n" +
"      ,[IdViDiem] = ?\n" +
" WHERE Id like ?";
        int check = 0;
        try (Connection con  = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setObject(1, khachHang.getMa());
            ps.setObject(2, khachHang.getHoTen());
            ps.setObject(3, khachHang.getSdt());
            ps.setObject(4, khachHang.getNgaySinh());
            ps.setObject(5, khachHang.getDiaChi());
            ps.setObject(6, khachHang.isGioiTinh());
            ps.setObject(7, khachHang.isTrangThai());
            ps.setObject(8, khachHang.getGhiChu());
            ps.setObject(9, khachHang.getSoLanMua());
            ps.setObject(10, khachHang.getIdViDiem());
            ps.setObject(11, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public static void main(String[] args) {
        List<KhachHangModel> getAll= new KhachHangRepository().getAll();
        for (KhachHangModel x : getAll) {
            System.out.println(x);
        }
//        KhachHangModel st = new KhachHangModel("PH23444", "NguyenVanS", "0184343", "2-2-2002", "NB", true, true, "null", 9);
//        boolean add = new KhachHangRepository().add(st);
//        System.out.println(add);
        
        
    }
}
