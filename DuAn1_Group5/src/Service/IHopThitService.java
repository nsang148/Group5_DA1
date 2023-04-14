/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ViewModels.HopThitView;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface IHopThitService {
    List<HopThitView> getal();
    String add(HopThitView ht);
    String updatencc(String TenNCC,String MaHT);
    String updatexx(String Tenxx,String MaHT);
    String updateGG(String MaGG,String MaHT);
    String update(String TensT,String MaHT);    
    String delete(String Ma);
    public List<HopThitView> search(String ma);
}
