/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author Tran Tuan Cuong
 */
public interface NhanVienService {
    List<NhanVien> getList();
    String insert(NhanVien obj);
    String delete(String ID);
    String update(NhanVien obj);
    List<NhanVien> search(String ten);
    NhanVien getNVByID(String ID); 
    List<NhanVien> sortListNhanVien();
    NhanVien getNhanVienByMa(String maNV);
}
