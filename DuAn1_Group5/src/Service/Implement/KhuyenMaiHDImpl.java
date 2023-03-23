/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.KhuyenMai;
import Repository.KhuyenMaiRepository;
import Service.KhuyenMaiHDService;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public class KhuyenMaiHDImpl implements KhuyenMaiHDService {

    private KhuyenMaiRepository KMHDR = new KhuyenMaiRepository();

    @Override
    public ArrayList<KhuyenMai> getList() {
        return (ArrayList<KhuyenMai>) KMHDR.getAll();
    }

    @Override
    public String them(KhuyenMai obj) {
        if (KMHDR.add(obj)) {
            KMHDR.getAll();
            return "Them thanh cong";
        }
        return "Them that bai";
    }

    @Override
    public String xoa(KhuyenMai obj) {
        if (KMHDR.remove(obj)) {
            KMHDR.getAll();
            return "Xoa thanh cong";
        }
        return "Xoa that bai";
    }

    @Override
    public String sua(KhuyenMai obj) {
        if (KMHDR.update(obj)) {
            KMHDR.getAll();
            return "Sua thanh cong";
        }
        return "Sua that bai";
    }

    @Override
    public KhuyenMai getKMHDByID(String id) {
        for (KhuyenMai item : KMHDR.getAll()) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public ArrayList<KhuyenMai> searchKM(String tk) {
        ArrayList<KhuyenMai> temp = new ArrayList<>();
        for (KhuyenMai item : KMHDR.getAll()) {
            if (item.getMa().equals(tk)) {
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public String getTrangThai(String tt) {
        if (tt.equals(tt)) {
            return "Het Han";
        } else {
            return "Con Han";
        }
    }

}
