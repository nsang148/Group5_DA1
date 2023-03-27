/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.GiamGiaHT;
import java.util.ArrayList;
import java.util.List;
import Repository.GiamGiaHTrepository;
import Service.QuanLyGiamGiaHTService;
import ViewModels.QuanLyGiamGiaHT;

/**
 *
 * @author tagot
 */
public class QuanLyGiamGiaHTServiceImpl implements QuanLyGiamGiaHTService{
    private GiamGiaHTrepository gghtr =new GiamGiaHTrepository();
    @Override
    public List<QuanLyGiamGiaHT> getList() {
            List<GiamGiaHT> listgght = gghtr.getAll();
        List<QuanLyGiamGiaHT> listqlgght = new ArrayList<>();
        for (GiamGiaHT gght : listgght) {
            listqlgght.add(new QuanLyGiamGiaHT(gght.getID(), gght.getIdHT(),gght.getIdGiamGia(),gght.getDonGia(),gght.getSoTienConLai(),gght.getTrangThai()));
        }
        return listqlgght;      }

    @Override
    public String add(QuanLyGiamGiaHT qlgght) {
        GiamGiaHT gght = new GiamGiaHT(qlgght.getID(), qlgght.getIdHT(), qlgght.getIdGiamGia(),qlgght.getDonGia(),qlgght.getSoTienConLai(),qlgght.getTrangThai());
        Boolean addCate = gghtr.add(gght);
        if (addCate) {
            return "Thanh cong";
        }
            return "That bai";    

    }

    @Override
    public String delete(String id) {

        Boolean addCate = gghtr.delete(id);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";            
    }

    @Override
    public String update(QuanLyGiamGiaHT qlgght, String Ma) {
        GiamGiaHT gght = new GiamGiaHT(qlgght.getID(), qlgght.getIdHT(),qlgght.getIdGiamGia(), qlgght.getDonGia(), qlgght.getSoTienConLai(),qlgght.getTrangThai());
                boolean addCate = gghtr.update(gght, Ma);
        if (addCate) {
            return "Thanh cong";
        }
        return "That bai";        }
    
}
