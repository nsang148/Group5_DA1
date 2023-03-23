package Service;

import ViewModels.HoaDonChiTietReponse;
import ViewModels.HoaDonReponse;
import java.util.List;

public interface HoaDonService {

    public List<HoaDonReponse> layHoaDons();

    public List<HoaDonChiTietReponse> layHoaDonCT(String ma);

    public List<HoaDonReponse> layHoaDontuNgay(String dateBD, String dateKT);
}
