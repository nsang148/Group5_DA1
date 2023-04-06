/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.NhanVienModel;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface NhanVienService {
     List<NhanVienModel> getList();
    String insert(NhanVienModel obj);
    String delete(String ID);
    String update(NhanVienModel obj,String idNv);
    List<NhanVienModel> search(String ten);
    NhanVienModel getNVByID(String ID); 
    List<NhanVienModel> sortListNhanVien();
    NhanVienModel getNhanVienByMa(String maNV);
}
