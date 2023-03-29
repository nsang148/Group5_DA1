/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ViDiemModel;
import Untility.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyễn Hiếu
 */
public class viDiemRepository {
    public List<ViDiemModel> getAll(){
        String query = "SELECT [Id]\n" +
"      ,[TongDiem]\n" +
"      ,[SoDiemDaDung]\n" +
"      ,[SoDiemDaCong]\n" +
"      ,[TrangThai]\n" +
"  FROM [dbo].[ViDiem]";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps =con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            List<ViDiemModel> list =new ArrayList<>();
            while(rs.next()){
                ViDiemModel kh = new ViDiemModel(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getBoolean(5));
                
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean add(ViDiemModel khachHang){
        String query = "INSERT INTO [dbo].[ViDiem]\n" +
"           ([TongDiem]\n" +
"           ,[SoDiemDaDung]\n" +
"           ,[SoDiemDaCong]\n" +
"           ,[TrangThai])\n" +
"     VALUES\n" +
"           (?,?,?,?)";
        int check = 0;
        try (Connection con  = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
           
            ps.setObject(1, khachHang.getTongDiem());
            ps.setObject(2, khachHang.getSoDiemDaDung());
            ps.setObject(3, khachHang.getSoDiemDaCong());
            ps.setObject(4, khachHang.isTrangThai());
            
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean delete(String ma){
        String query = "DELETE FROM [dbo].[ViDiem]\n" +
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
    public boolean updata(ViDiemModel khachHang, String id){
        String query = "UPDATE [dbo].[ViDiem]\n" +
"   SET [TongDiem] = ?\n" +
"      ,[SoDiemDaDung] = ?\n" +
"      ,[SoDiemDaCong] = ?\n" +
"      ,[TrangThai] = ?\n" +
" WHERE Id like ?";
        int check = 0;
        try (Connection con  = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setObject(1, khachHang.getTongDiem());
            ps.setObject(2, khachHang.getSoDiemDaDung());
            ps.setObject(3, khachHang.getSoDiemDaCong());
            ps.setObject(4, khachHang.isTrangThai());
            
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public static void main(String[] args) {
        List<ViDiemModel> getAll= new viDiemRepository().getAll();
        for (ViDiemModel x : getAll) {
            System.out.println(x);
        }
//   ViDiemModel ma  = new ViDiemModel(0, 0, 0, true);
//    boolean add = new viDiemRepository().delete("2aa14265-13fe-451d-ba6f-7ec7aad98998");
//        System.out.println(add);
    }
}
