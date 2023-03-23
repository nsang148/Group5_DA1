/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhuyenMaiSach;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public interface KhuyenMaiSachService {
    ArrayList<KhuyenMaiSach> getList();
    String them(KhuyenMaiSach obj);
    String xoa(KhuyenMaiSach obj);
    String sua(KhuyenMaiSach obj);
    KhuyenMaiSach getKMSachByID(String id);
    String getTrangThai(int tt);
    String getIdSachByMa(String ma);
    String getIdKhuyenMaiByMa(String ma);
    String getMaSachByID(String id);
    String getMaKMByID(String id);
    ArrayList<KhuyenMaiSach> searchKM(String maKM);
    String getPhanTramByIdKM(String id);
    KhuyenMaiSach getKMSachByMaKMSach(String ma);
}
