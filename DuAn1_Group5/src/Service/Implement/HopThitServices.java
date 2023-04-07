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
        for (HopThitDomain x : list) {
            HopThitDomain domain = new HopThitDomain(x.getId(),x.getMa(), x.getTenHopThit(), x.getGiaNhap(), x.getGiaBan(), x.getSoLuongTon(),x.getNgayDongGoi(),x.getHSD(), x.getMoTa(), x.getTrangThai(), x.getIdThit(),x.getIdThit(), x.getIdXuatXu(), x.getIdNCC());
        }
        return ds;
    }

    @Override
    public boolean add(HopThitView ht) {
        HopThitDomain domain = new HopThitDomain(ht.getId(),ht.getMa(), ht.getTenHopThit(), ht.getGiaNhap(), ht.getGiaBan(), ht.getSoLuongTon(),ht.getNgayDongGoi(), ht.getHSD(), ht.getMoTa(), ht.getTrangThai(), ht.getIdThit(), ht.getIdLoaiThit(), ht.getIdXuatXu(), ht.getIdNCC());
        this.rs.add(domain);
        return true;
    }

    @Override
    public boolean update(HopThitView ht) {
        HopThitDomain domain = new HopThitDomain(ht.getId(),ht.getMa(), ht.getTenHopThit(), ht.getGiaNhap(), ht.getGiaBan(), ht.getSoLuongTon(),ht.getNgayDongGoi(), ht.getHSD(), ht.getMoTa(), ht.getTrangThai(), ht.getIdThit(), ht.getIdLoaiThit(), ht.getIdXuatXu(), ht.getIdNCC());
        this.rs.update(domain);
        return true;
    }

    @Override
    public boolean delete(HopThitView ht) {
        HopThitDomain domain = new HopThitDomain(ht.getId(),ht.getMa(), ht.getTenHopThit(), ht.getGiaNhap(), ht.getGiaBan(), ht.getSoLuongTon(),ht.getNgayDongGoi(), ht.getHSD(), ht.getMoTa(), ht.getTrangThai(), ht.getIdThit(), ht.getIdLoaiThit(), ht.getIdXuatXu(), ht.getIdNCC());
        this.rs.delete(domain);
        return true;
    }
}

 
