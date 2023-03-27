/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import ViewModels.QuanLyGiamGia;

/**
 *
 * @author tagot
 */
public interface QuanLyGiamGiaService {
    
    List<QuanLyGiamGia> getList();
    
    String add(QuanLyGiamGia qlgg);
    
    String delete(String id);
    
    String update(QuanLyGiamGia qlgg,String id);    

}
