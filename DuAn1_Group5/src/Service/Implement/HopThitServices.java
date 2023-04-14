/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implement;

import DomainModels.HopThitDomain;
import Repository.HopThitRepository;
import ViewModels.HopThitView;
import java.util.ArrayList;
import java.util.List;
import Service.IHopThitService;
import ViewModels.LayIDHT;


/**
 *
 * @author Tus
 */
public class HopThitServices implements IHopThitService{
   
    private HopThitRepository rs = new HopThitRepository();
    @Override
    public List<HopThitView> getal() {
        List<HopThitView> ds = new ArrayList<>();
        List<HopThitDomain> list = this.rs.getall();
        for (HopThitDomain ht : list) {
            HopThitView hopThitView = new HopThitView(ht.getId(),ht.getMa(), ht.getTenHopThit(), ht.getGiaBan(), ht.getSoLuongTon(), ht.getKhoiLuong(),ht.getNgayDongGoi(), ht.getHSD(), ht.getMoTa(), ht.getTrangThai(), ht.getIdThit(), ht.getIdloaiThit(), ht.getIdXuatXu(),ht.getIdGiamGia(), ht.getIdNCC(), ht.getGiaConLai());
            ds.add(hopThitView);
        }
        return ds;
    }

    @Override
    public String add(HopThitView qlht) {
            HopThitDomain ht = new HopThitDomain(qlht.getId(),qlht.getMa(), qlht.getTenHopThit(), qlht.getGiaBan(), qlht.getSoLuongTon(), qlht.getKhoiLuong(),qlht.getNgayDongGoi(), qlht.getHSD(), qlht.getMoTa(), qlht.getTrangThai());
            Boolean addCate = rs.add(ht);
        if (addCate) {
            return "Thanh cong";
        }
            return "That bai";
    }


    

    @Override
    public String delete(String Ma) {
        Boolean addCate = rs.delete(Ma);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";  
    }


    @Override
    public List<HopThitView> search(String ma) {
           List<HopThitDomain> listtk = rs.timKiem(ma);
                  List<HopThitView> listqlhttk = new ArrayList<>();
        for (HopThitDomain ht : listtk) {
            listqlhttk.add(new HopThitView(ht.getId(),ht.getMa(), ht.getTenHopThit(), ht.getGiaBan(), ht.getSoLuongTon(), ht.getKhoiLuong(),ht.getNgayDongGoi(), ht.getHSD(), ht.getMoTa(), ht.getTrangThai(), ht.getIdThit(), ht.getIdloaiThit(), ht.getIdXuatXu(),ht.getIdGiamGia(), ht.getIdNCC(), ht.getGiaConLai()));
        }
        return listqlhttk;    }

    @Override
    public String updatencc(String TenNCC, String MaHT) {
         boolean addCate = rs.updateNCC(TenNCC,MaHT);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";    }

    @Override
    public String updatexx(String Tenxx, String MaHT) {
        boolean addCate = rs.updatexx(Tenxx,MaHT);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";   
    }

    @Override
    public String updateGG(String MaGG, String MaHT) {
        boolean addCate = rs.updateGG(MaGG,MaHT);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";   

    }

    @Override
    public String update(String TensT, String MaHT) {
        boolean addCate = rs.updateThit(TensT,MaHT);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";   
    }
}

 
