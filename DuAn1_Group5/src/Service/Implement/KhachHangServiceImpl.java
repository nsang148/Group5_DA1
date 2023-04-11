/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.KhachHangModel;
import Repository.KhachHangRepository;
import Service.KhachHangService;
import java.util.List;

/**
 *
 * @author Nguyễn Hiếu
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangRepository repo = new KhachHangRepository();
    @Override
    public List<KhachHangModel> getAll() {
       return repo.getAll();
    }
    

    @Override
    public String add(KhachHangModel khachHang) {
        if(khachHang.getMa().isEmpty()||khachHang.getSdt().isEmpty()||khachHang.getDiaChi().isEmpty()||khachHang.getHoTen().isEmpty()){
            return "Dữ liệu còn trống!";
        }
        KhachHangModel ma = repo.checkTrung(khachHang.getMa());
        if (ma != null) {
            return "Mã KH đã tồn tại!";
        }
        boolean add = repo.add(khachHang);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }
    

    @Override
    public String delete(String ma) {
        
        boolean delete = repo.delete(ma);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String updata(KhachHangModel khachHang, String id) {
        
        boolean update = repo.updata(khachHang, id);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<KhachHangModel> searchTheoMaKH(String maKH) {
        return repo.getAllViewKH(maKH);
    }

    

  
   
}
