/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Nguyễn Hiếu
 */
public class TaiKhoanModel {
    private String username;
    private String passWorld;
    private String chucVu;

    public TaiKhoanModel() {
    }

    public TaiKhoanModel(String username, String passWorld, String chucVu) {
        this.username = username;
        this.passWorld = passWorld;
        this.chucVu = chucVu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWorld() {
        return passWorld;
    }

    public void setPassWorld(String passWorld) {
        this.passWorld = passWorld;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "TaiKhoanModel{" + "username=" + username + ", passWorld=" + passWorld + ", chucVu=" + chucVu + '}';
    }
    
    
    
    
}
