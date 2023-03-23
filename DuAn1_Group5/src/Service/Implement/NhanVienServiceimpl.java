/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.NhanVien;
import Repository.NhanVienRepository;
import Service.NhanVienService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Tuan Cuong
 */
public class NhanVienServiceimpl implements NhanVienService {

    private NhanVienRepository NVR = new NhanVienRepository();

    @Override
    public List<NhanVien> getList() {
        return (ArrayList<NhanVien>) this.NVR.all();
    }

    @Override
    public String insert(NhanVien obj) {
        if (this.NVR.insert(obj)) {
            this.NVR.all();
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String delete(String ID) {
        if (this.NVR.delete(ID)) {
            this.NVR.all();
            return "Xoá thành công";
        }
        return "Xoá thất bại";
    }

    @Override
    public String update(NhanVien obj) {
        if (this.NVR.update(obj)) {
            this.NVR.all();
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public List<NhanVien> search(String timKiem) {
        List<NhanVien> temp = new ArrayList<>();
        for (NhanVien item : this.NVR.all()) {
            if ((item.getHo() + " " + item.getTenDem() + " " + item.getTen()).contains(timKiem)) {
                temp.add(item);
            } else if (item.getSdt().contains(timKiem)) {
                temp.add(item);
            } else if (item.getDiaChi().equalsIgnoreCase(timKiem)) {
                temp.add(item);
            } else if (item.getGioiTinh().equalsIgnoreCase(timKiem)) {
                temp.add(item);
            } else if (item.getVaiTro().equalsIgnoreCase(timKiem)) {
                temp.add(item);
            } else if ((item.getTinhTrang() == 0 ? "Đang làm việc" : "Đã nghỉ việc").equalsIgnoreCase(timKiem)) {
                temp.add(item);
            } else if (item.getID().contains(timKiem)) {
                temp.add(item);
            } else if (item.getNgaySinh().contains(timKiem)) {
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public List<NhanVien> sortListNhanVien() {
        List<NhanVien> listSort = this.NVR.all();
        listSort.sort((NhanVien nv1, NhanVien nv2) -> nv1.getTen().compareToIgnoreCase(nv2.getTen()));
        return listSort;
    }

    @Override
    public NhanVien getNVByID(String ID) {
        for (NhanVien item : this.NVR.all()) {
            if (item.getID().equals(ID)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public NhanVien getNhanVienByMa(String maNV) {
        for (NhanVien item : NVR.all()) {
            if (item.getMaNV().equals(maNV)) {
                return item;
            }
        }
        return null;
    }
}
