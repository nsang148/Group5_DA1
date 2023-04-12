/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.HopThitView;
import java.util.List;
import ViewModels.QuanLyGiamGiaHT;

/**
 *
 * @author tagot
 */
public interface QuanLyGiamGiaHTService {
    
    List<QuanLyGiamGiaHT> getList();
    
    String updateMa(String idht ,String idgg);
    
    String updatetien(String idht,String idgg);
    
    String updatetienbyday(QuanLyGiamGiaHT gght);
     
    List<HopThitView> getall();
    
}
