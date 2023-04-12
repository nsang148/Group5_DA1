/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.GiamGiaHT;
import DomainModels.HopThitDomain;
import java.util.ArrayList;
import java.util.List;
import Repository.GiamGiaHTrepository;
import Repository.HopThitRepository;
import Service.QuanLyGiamGiaHTService;
import ViewModels.HopThitView;
import ViewModels.QuanLyGiamGiaHT;

/**
 *
 * @author tagot
 */
public class QuanLyGiamGiaHTServiceImpl implements QuanLyGiamGiaHTService{
 
        private GiamGiaHTrepository gghtr = new GiamGiaHTrepository();
        private HopThitRepository rs = new HopThitRepository();
    
    
    @Override
    public List<QuanLyGiamGiaHT> getList() {
            List<GiamGiaHT> listgght = gghtr.getAll();
        List<QuanLyGiamGiaHT> listqlgght = new ArrayList<>();
        for (GiamGiaHT gght : listgght) {
            listqlgght.add(new QuanLyGiamGiaHT(gght.getMa(), gght.getTen(),gght.getGiaBan(),gght.getGiaConLai(),gght.getSoLuongTon(),gght.getHSD(),gght.getTrangThai(),gght.getIdGiamGia(),gght.getPhanTramGiamGia(),gght.getNgayConLai()));
        }
        return listqlgght;  

    }

    @Override
    public String updateMa(String idht, String idgg) {
        boolean addCate = gghtr.updateMa(idht,idgg);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";        
    }

    @Override
    public String updatetien(String idht, String idgg) {
        boolean addCate = gghtr.updatetien(idht,idgg);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";        
    }

    @Override
    public String updatetienbyday(QuanLyGiamGiaHT gght) {
       boolean addCate;         
            if(gght.getNgayConLai()<=5){
                 addCate=true;
                 gght.setIdGiamGia("HSD5");
                if (addCate) {
                        return "Thanh cong";
                             }
                        return "That bai";        
                             }
            else if(gght.getNgayConLai()<=3){
                 addCate=true;
                 gght.setIdGiamGia("HSD3");
                if (addCate) {
                        return "Thanh cong";
                                        }
                       return "That bai";        
        
            }else if(gght.getNgayConLai()==1){
                 addCate=true;
                 gght.setIdGiamGia("HSD1");
                if (addCate) {
                      return "Thanh cong";
                    }
                      return "That bai";        
                    }    
        return "That bai";  
    }


    @Override
    public List<HopThitView> getall() {
            List<HopThitDomain> listht = rs.getall();
        List<HopThitView> listqlht = new ArrayList<>();
        for (HopThitDomain ht : listht) {
            listqlht.add(new HopThitView(ht.getId(), ht.getMa(),ht.getTenHopThit(),ht.getGiaBan(),ht.getSoLuongTon(),ht.getNgayDongGoi(),ht.getHSD(),ht.getMoTa(),ht.getTrangThai(),ht.getIdThit(),ht.getIdloaiThit(),ht.getIdXuatXu(),ht.getIdNCC()));
        }
        return listqlht;  
    }

}
