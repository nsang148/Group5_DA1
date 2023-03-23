/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import Repository.ThongKeRepository;
import Service.ThongKeService;
import ViewModels.BaoCaoMail;
import ViewModels.ChartThongKe;
import ViewModels.SPBanChayViewModel;
import ViewModels.TheLoaiBanChay;
import java.util.List;

/**
 *
 * @author acer
 */
public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeRepository repo = new ThongKeRepository();


    @Override
    public List<ChartThongKe> chartThongKe() {
        return repo.ChartThongKe();
    }

    @Override
    public List<SPBanChayViewModel> tblSPBanChay() {
        return repo.TableSachBanChay();
    }

    @Override
    public List<TheLoaiBanChay> tblSPTheLoai() {
        return repo.TableTheLoaiBanChay();
    }

    @Override
    public List<BaoCaoMail> BaoCao() {
        return repo.GuiMail();
    }
}
