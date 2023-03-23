/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.HoaDon;
import DomainModels.HoaDonCT;
import Repository.BanHangRepository;
import Repository.SachRepository;
import Service.BanHangService;
import ViewModels.HoaDonThanhToan;
import ViewModels.LayIDHD;
import ViewModels.SanPhamThanhToan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class BanHangServiceImpl implements BanHangService {

    private BanHangRepository repo = new BanHangRepository();

    @Override
    public List<SanPhamThanhToan> getAll() {
        return repo.getALLSP();
    }

    @Override
    public int createHDCho(HoaDon hd) {
        return repo.createHDChoRepository(hd);
    }

    @Override
    public List<HoaDonThanhToan> getAllHD() {
        return repo.getAllHD();
    }

    @Override
    public List<LayIDHD> getIDHD() {
        return repo.getIDHD();
    }

    @Override
    public int createHDCT(HoaDonCT hd) {
        return repo.createHDCTRepository(hd);
    }

    @Override
    public int updateHD(HoaDon hd) {
        return repo.updateHDRepository(hd);
    }

    @Override
    public int updateSLSach(int i, String ma) {
        return repo.updateSLSach(i, ma);
    }

    @Override
    public List<SanPhamThanhToan> search(String ten) {
        return repo.search(ten);
    }

    @Override
    public boolean isExists(String maHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamThanhToan> TheLoai(String tl) {
        return repo.getALLSPCB(tl);
    }

    @Override
    public SanPhamThanhToan getSPBYMaSP(String maSP) {
        for (var item : repo.getALLSP()) {
            if (item.getMa().equals(maSP)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<SanPhamThanhToan> getALLSPCB(String ten) {
        return repo.getALLSPCB(ten);
    }
 
    public List<SanPhamThanhToan> searchTen(String input) {
        if (input == null) {
            return repo.getALLSP();
        }
        List<SanPhamThanhToan> sptts = new ArrayList<>();
        for (SanPhamThanhToan item : repo.getALLSP()) {
            if (item.getMa().toLowerCase().contains(input.toLowerCase()) || item.getTen().toLowerCase().contains(input.toLowerCase())) {
                sptts.add(item);
            }
        }
        return sptts;
    }
}
