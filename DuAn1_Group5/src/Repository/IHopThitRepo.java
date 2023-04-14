/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.HopThitDomain;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface IHopThitRepo {
    List<HopThitDomain> getall();
    boolean add(HopThitDomain ht);
    boolean updateNCC(String TenNCC,String MaHT);
    boolean updatexx(String Tenxx,String MaHT);
    boolean updateGG(String MaGG,String MaHT);
    boolean updateThit(String TensT,String MaHT);    
    boolean delete(String Ma);
    public ArrayList<HopThitDomain> timKiem(String ma);
}
