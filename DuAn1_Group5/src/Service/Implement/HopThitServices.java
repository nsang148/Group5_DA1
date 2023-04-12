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
    private HopThitDomain getHopThitDomain(HopThitView ht) {
        return new HopThitDomain(ht.getId(),ht.getMa(), ht.getTenHopThit(), ht.getGiaBan(), ht.getSoLuongTon(), ht.getKhoiLuong(),ht.getNgayDongGoi(), ht.getHSD(), ht.getMoTa(), ht.getTrangThai(), ht.getIdThit(), ht.getIdloaiThit(), ht.getIdXuatXu(), ht.getIdNCC(), ht.getGiaConLai());
    }
    
    private HopThitRepository rs = new HopThitRepository();
    @Override
    public List<HopThitView> getal() {
        List<HopThitView> ds = new ArrayList<>();
        List<HopThitDomain> list = this.rs.getall();
        for (HopThitDomain ht : list) {
            HopThitView hopThitView = new HopThitView(ht.getId(),ht.getMa(), ht.getTenHopThit(), ht.getGiaBan(), ht.getSoLuongTon(), ht.getKhoiLuong(),ht.getNgayDongGoi(), ht.getHSD(), ht.getMoTa(), ht.getTrangThai(), ht.getIdThit(), ht.getIdloaiThit(), ht.getIdXuatXu(), ht.getIdNCC(), ht.getGiaConLai());
            ds.add(hopThitView);
        }
        return ds;
    }

    @Override
    public boolean add(HopThitView ht) {
        HopThitDomain domain = getHopThitDomain(ht);
        return this.rs.add(domain);
    }

    @Override
    public boolean update(HopThitView ht) {
        HopThitDomain domain = getHopThitDomain(ht);
        return this.rs.update(domain);
    }

    @Override
    public boolean delete(HopThitView ht) {
        HopThitDomain domain = getHopThitDomain(ht);
        return this.rs.delete(domain);
    }

    @Override
    public List<LayIDHT> getIDHT() {
return rs.getID();
    }
}

 
