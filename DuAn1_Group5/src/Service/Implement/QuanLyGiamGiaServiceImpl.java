/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.GiamGia;
import java.util.ArrayList;
import java.util.List;
import Repository.GiamGiaRepository;
import Service.QuanLyGiamGiaService;
import ViewModels.QuanLyGiamGia;

/**
 *
 * @author tagot
 */
public class QuanLyGiamGiaServiceImpl implements QuanLyGiamGiaService{

    private GiamGiaRepository ggr = new GiamGiaRepository();
    
    @Override
    public List<QuanLyGiamGia> getList() {
            List<GiamGia> listgg = ggr.getAll();
        List<QuanLyGiamGia> listqlgg = new ArrayList<>();
        for (GiamGia gg : listgg) {
            listqlgg.add(new QuanLyGiamGia(gg.getId(), gg.getMa(),gg.getTen(),gg.getNgayBatDau(),gg.getNgayKetThuc(),gg.getMucPhanTramGiamGia(),gg.getDieuKienGiamGia(),gg.getTrangThai()));
        }
        return listqlgg;    
    }

    @Override
    public String add(QuanLyGiamGia qlgg){
        GiamGia gg = new GiamGia(qlgg.getId(), qlgg.getMa(), qlgg.getTen(),qlgg.getNgayBatDau(),qlgg.getNgayKetThuc(),qlgg.getMucPhanTramGiamGia(),qlgg.getDieuKienGiamGia(),qlgg.getTrangThai());
        Boolean addCate = ggr.add(gg);
        if (addCate) {
            return "Thanh cong";
        }
            return "That bai";    }

    @Override
    public String delete(String id) {

        Boolean addCate = ggr.delete(id);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";    }

    @Override
    public String update(QuanLyGiamGia qlgg, String id) {
        GiamGia gg = new GiamGia(qlgg.getId(), qlgg.getMa(), qlgg.getTen(),qlgg.getNgayBatDau(),qlgg.getNgayKetThuc(),qlgg.getMucPhanTramGiamGia(),qlgg.getDieuKienGiamGia(),qlgg.getTrangThai());
        boolean addCate = ggr.update(gg, id);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";    }
    
}
