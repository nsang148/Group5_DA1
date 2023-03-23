/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.BaoCaoMail;
import ViewModels.ChartThongKe;
import ViewModels.SPBanChayViewModel;
import ViewModels.TheLoaiBanChay;

import java.util.List;

/**
 *
 * @author acer
 */
public interface ThongKeService {

    List<ChartThongKe> chartThongKe();
    List<SPBanChayViewModel> tblSPBanChay();
    List<TheLoaiBanChay> tblSPTheLoai();
    List<BaoCaoMail> BaoCao();
}
