/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.ViDiemModel;
import Repository.viDiemRepository;
import Service.ViDiemService;
import java.util.List;

/**
 *
 * @author Nguyễn Hiếu
 */
public class ViDiemServiceImpl implements ViDiemService{
 private viDiemRepository repo = new viDiemRepository();

    @Override
    public List<ViDiemModel> getAll() {
        return repo.getAll();
    }

    @Override
    public String add(ViDiemModel khachHang) {
         boolean add = repo.add(khachHang);
        if (add) {
            return "thêm thành công";
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
    public String updata(ViDiemModel khachHang, String id) {
        boolean update = repo.updata(khachHang, id);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
    
}
