/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhachHangModel;
import java.util.List;

/**
 *
 * @author Nguyễn Hiếu
 */
public interface KhachHangService {
    List<KhachHangModel> getAll();
    
    String add(KhachHangModel khachHang);
    
    String delete(String ma);
    
    String updata(KhachHangModel khachHang, String id);
}
