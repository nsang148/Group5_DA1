/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ViDiemModel;
import java.util.List;

/**
 *
 * @author Nguyễn Hiếu
 */
public interface ViDiemService {
    List<ViDiemModel> getAll();
    
    String add(ViDiemModel khachHang);
    
    String delete(String ma);
    
    String updata(ViDiemModel khachHang, String id);
}
