/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhachHangModel;
import ViewModels.KhachHangReponse;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface KhachHangService {
     List<KhachHangReponse> getAll();

    void add(KhachHangModel khachHang);

    String update(KhachHangModel khachHang, String MaKh);

    String delete(String id);
    
    List<KhachHangReponse> search(String MaKH);
    List<KhachHangReponse> getKHsapxep();
}
