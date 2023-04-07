/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.NhanVienModel;
import DomainModels.TaiKhoanModel;
import Repository.DangNhapRepository;
import Service.DangNhapService;

/**
 *
 * @author Nguyễn Hiếu
 */
public class DangNhapServiceImpl implements DangNhapService{
    private DangNhapRepository rp = new DangNhapRepository();

    @Override
    public TaiKhoanModel dangNhap(String username, String pass) {
        return rp.dangNhap(username, pass);
      

    }
}
