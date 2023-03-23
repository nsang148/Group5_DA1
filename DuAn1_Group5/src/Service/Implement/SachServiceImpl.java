/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.NXB;
import Repository.SachRepository;
import DomainModels.Sach;
import DomainModels.TacGia;
import DomainModels.TheLoai;
import Repository.NXBRepository;
import Repository.TacGiaRepository;
import Repository.TheLoaiRepository;
import Service.SachService;
import ViewModels.LayIDSach;
import ViewModels.QLSach;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class SachServiceImpl implements SachService {

    private SachRepository repo = new SachRepository();
    private TheLoaiRepository repoTL = new TheLoaiRepository();
    private TacGiaRepository repoTG = new TacGiaRepository();
    private NXBRepository repoNXB = new NXBRepository();

    @Override
    public List<QLSach> getAll() {
        return repo.getAll();
    }

    @Override
    public int createSach(Sach s) {
        return repo.createSachRepository(s);
    }

    @Override
    public int updateSach(Sach s, String ma) {
        return repo.updateSachRepository(s, ma);
    }

    @Override
    public int deleteSach(String ma) {
        return repo.deleteSachRepository(ma);
    }

    @Override
    public List<QLSach> search(String ma) {
        return repo.search(ma);
    }

    @Override
    public List<LayIDSach> getIDSach() {
        return repo.getIDHD();
    }

    @Override
    public String getIDByTenTL(String ten) {
        for (TheLoai item : repoTL.getAll()) {
            if (item.getTen().equals(ten)) {
                return item.getId();
            }
        }
        return null;
    }

    @Override
    public String getIDByTenTG(String ten) {
        for (TacGia item : repoTG.getAll()) {
            if (item.getTen().equals(ten)) {
                return item.getId();
            }
        }
        return null;
    }

    @Override
    public String getIDByTenNXB(String ten) {
        for (NXB item : repoNXB.getAll()) {
            if (item.getTen().equals(ten)) {
                return item.getId();
            }
        }
        return null;
    }
    
    @Override
    public List<QLSach> searchTen(String input) {
        if (input == null) {
            return repo.getAll();
        }
        List<QLSach> s = new ArrayList<>();
        for (QLSach item : repo.getAll()) {
            if (item.getMa().toLowerCase().contains(input.toLowerCase()) || item.getTen().toLowerCase().contains(input.toLowerCase())) {
                s.add(item);
            }
        }
        return s;
    }

}
