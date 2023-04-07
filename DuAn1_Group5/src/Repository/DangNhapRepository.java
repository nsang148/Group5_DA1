/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.TaiKhoanModel;
import Untility.DBContext;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Nguyễn Hiếu
 */
public class DangNhapRepository {
    public TaiKhoanModel dangNhap(String username, String pass){
        String query = "SELECT [Username]\n" +
"      ,[Passworld]\n" +
"      ,[ChucVu]\n" +
"  FROM [dbo].[TaiKhoan] where Username = ? and Passworld = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, username);
            ps.setObject(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new TaiKhoanModel(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args){
        TaiKhoanModel tk =  new DangNhapRepository().dangNhap("QuanLy","123");
        System.out.println(tk);
    }
}
