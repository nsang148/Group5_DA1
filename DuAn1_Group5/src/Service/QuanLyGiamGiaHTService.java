/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import ViewModels.QuanLyGiamGiaHT;

/**
 *
 * @author tagot
 */
public interface QuanLyGiamGiaHTService {
    
    List<QuanLyGiamGiaHT> getList();
    
    String add(QuanLyGiamGiaHT qlgght);
    
    String delete(String id);
    
    String update(QuanLyGiamGiaHT qlgght,String id);
    
}
