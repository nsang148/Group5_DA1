/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.KhachHangModel;
import Repository.KhachHangRepository;
import Service.KhachHangService;
import Untility.Untilities;
import ViewModels.KhachHangReponse;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author sangh
 */
public class KhachHangIplement implements KhachHangService {

    private final KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHangReponse> getAll() {
        return khachHangRepository.getKH();
    }

    @Override
    public void add(KhachHangModel khachHang) {
        boolean isExists = khachHangRepository.isExists(khachHang.getMaKH());
        if (!khachHang.getMaKH().startsWith("KH")) {
            JOptionPane.showMessageDialog(null, "Mã khách hàng phải bắt đầu bằng KH");
        } else {
            if (isExists) {
                JOptionPane.showMessageDialog(null, "Mã khách hàng đã tồn tại");
            } else {
                boolean isValidEmail = Untilities.validateEmail(khachHang.getEmail());
                boolean isValidPhoneNumber = Untilities.validatePhoneNumber(khachHang.getSdt());
                boolean isValidName = Untilities.validateName(khachHang.getTen());

                if (isValidName) {
                    JOptionPane.showMessageDialog(null, "Tên không được chứa số");
                } else {
                    if (!isValidEmail) {
                        JOptionPane.showMessageDialog(null, "Địa chỉ email không đúng định dạng");
                    } else {
                        if (!isValidPhoneNumber) {
                            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng");
                        } else {
                            khachHangRepository.insert(khachHang);
                            JOptionPane.showMessageDialog(null, "Thêm thành công.");
                        }
                    }
                }
            }

        }
    }

    @Override
    public String delete(String id) {
        return khachHangRepository.delete(id);
    }

    @Override
    public List<KhachHangReponse> search(String MaKH) {
        return khachHangRepository.searchKH(MaKH);
    }

    @Override
    public String update(KhachHangModel khachHang, String MaKh) {
        return khachHangRepository.update(khachHang, MaKh);
    }

    @Override
    public List<KhachHangReponse> getKHsapxep() {
return khachHangRepository.getKHsapxep();    }

}
