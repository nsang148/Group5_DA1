/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.NhanVienModel;
import Repository.NhanVienRepository;
import Service.NhanVienService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sangh
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository NVR = new NhanVienRepository();

    @Override
    public List<NhanVienModel> getList() {
        return (ArrayList<NhanVienModel>) this.NVR.all();
    }

    @Override
    public String insert(NhanVienModel obj) {
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
    public List<NhanVienModel> search(String timKiem) {
        List<NhanVienModel> temp = new ArrayList<>();
        for (NhanVienModel item : this.NVR.all()) {
            if ((item.getHoTen()).contains(timKiem)) {
                temp.add(item);
            } else if (item.getSdt().contains(timKiem)) {
                temp.add(item);
            } else if (item.getDiaChi().equalsIgnoreCase(timKiem)) {
                temp.add(item);
            } else if (item.getGioiTinh().equalsIgnoreCase(timKiem)) {
                temp.add(item);
            } else if (item.getChucVu().equalsIgnoreCase(timKiem)) {
                temp.add(item);
            } else if ((item.getTrangThai() == 0 ? "Đã nghỉ việc" : "Đang làm việc").equalsIgnoreCase(timKiem)) {
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
    public NhanVienModel getNVByID(String ID) {
        for (NhanVienModel item : this.NVR.all()) {
            if (item.getID().equals(ID)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<NhanVienModel> sortListNhanVien() {
        List<NhanVienModel> listSort = this.NVR.all();
        listSort.sort((NhanVienModel nv1, NhanVienModel nv2) -> nv1.getHoTen().compareToIgnoreCase(nv2.getHoTen()));
        return listSort;
    }

    @Override
    public NhanVienModel getNhanVienByMa(String maNV) {
        for (NhanVienModel item : NVR.all()) {
            if (item.getMa().equals(maNV)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String update(NhanVienModel obj, String maNv) {
        return NVR.update(obj, maNv);
    }
    }
