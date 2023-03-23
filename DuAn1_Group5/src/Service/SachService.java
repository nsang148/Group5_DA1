/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.Sach;
import DomainModels.TheLoai;
import ViewModels.LayIDSach;
import ViewModels.QLSach;
import java.util.List;

/**
 *
 * @author acer
 */
public interface SachService {
    List<QLSach> getAll();
    List<LayIDSach> getIDSach();
    public int createSach(Sach s);
    public int updateSach(Sach s, String ma);
    public int deleteSach(String ma);
    String getIDByTenTL(String ten);
    String getIDByTenTG(String ten);
    String getIDByTenNXB(String ten);
    List<QLSach> search(String ma);
    List<QLSach> searchTen(String input);
}
