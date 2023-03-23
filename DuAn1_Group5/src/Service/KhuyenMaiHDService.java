/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhuyenMai;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public interface KhuyenMaiHDService {
    ArrayList<KhuyenMai> getList();
    String them(KhuyenMai obj);
    String xoa(KhuyenMai obj);
    String sua(KhuyenMai obj);
    KhuyenMai getKMHDByID(String id);
    String getTrangThai(String tt);
    ArrayList<KhuyenMai> searchKM(String tk);
}
