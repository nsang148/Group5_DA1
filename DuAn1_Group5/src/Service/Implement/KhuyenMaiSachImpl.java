/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.KhuyenMai;
import DomainModels.KhuyenMaiSach;
import Repository.KhuyenMaiRepository;
import Repository.KhuyenMaiSachRepository;
import Repository.SachRepository;
import Service.KhuyenMaiSachService;
import ViewModels.QLSach;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public class KhuyenMaiSachImpl implements KhuyenMaiSachService {

    KhuyenMaiSachRepository KMSR = new KhuyenMaiSachRepository();
    SachRepository SR = new SachRepository();
    KhuyenMaiRepository KMR = new KhuyenMaiRepository();

    @Override
    public ArrayList<KhuyenMaiSach> getList() {
        return (ArrayList<KhuyenMaiSach>) KMSR.getAll();
    }

    @Override
    public String them(KhuyenMaiSach obj) {
        if (KMSR.add(obj)) {
            KMSR.getAll();
            return "Them thanh cong";
        }
        return "Them that bai";
    }

    @Override
    public String xoa(KhuyenMaiSach obj) {
        if (KMSR.remove(obj)) {
            KMSR.getAll();
            return "Xoa thanh cong";
        }
        return "Xoa that bai";
    }

    @Override
    public String sua(KhuyenMaiSach obj) {
        if (KMSR.update(obj)) {
            KMSR.getAll();
            return "Sua thanh cong";
        }
        return "Sua that bai";
    }

    @Override
    public String getTrangThai(int tt) {
        if (tt == 0) {
            return "Het Han";
        } else {
            return "Con Han";
        }
    }

    @Override
    public ArrayList<KhuyenMaiSach> searchKM(String maKM) {
        ArrayList<KhuyenMaiSach> temp = new ArrayList<>();
        for (KhuyenMaiSach item : KMSR.getAll()) {
            if (this.getMaKMByID(item.getIdKM()).equals(maKM)) {
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public KhuyenMaiSach getKMSachByID(String id) {
        for (KhuyenMaiSach item : KMSR.getAll()) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String getIdSachByMa(String ma) {
        for (QLSach item : SR.getAll()) {
            if (item.getMa().equals(ma)) {
                return item.getId();
            }
        }
        return null;
    }

    @Override
    public String getIdKhuyenMaiByMa(String ma) {
        for (KhuyenMai item : KMR.getAll()) {
            if (item.getMa().equals(ma)) {
                return item.getId();
            }
        }
        return null;
    }

    @Override
    public String getMaSachByID(String id) {
        for (QLSach item : SR.getAll()) {
            if (item.getId().equals(id)) {
                return item.getMa();
            }
        }
        return null;
    }

    @Override
    public String getMaKMByID(String id) {
        for (KhuyenMai item : KMR.getAll()) {
            if (item.getId().equals(id)) {
                return item.getMa();
            }
        }
        return null;
    }

    @Override
    public String getPhanTramByIdKM(String id) {
         for (KhuyenMai item : KMR.getAll()) {
            if (item.getId().equals(id)) {
                return item.getPhanTramGiam();
            }
        }
        return null;
    }

    @Override
    public KhuyenMaiSach getKMSachByMaKMSach(String ma) {
        for (KhuyenMaiSach item : KMSR.getAll()) {
            if (this.getMaKMByID(item.getIdKM()).equals(ma)) {
                return item;
            }
        }
        return  null;
    }

}
