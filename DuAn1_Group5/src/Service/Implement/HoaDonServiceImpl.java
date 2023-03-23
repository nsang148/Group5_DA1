package Service.Implement;

import Repository.HoaDonRepository;
import Service.HoaDonService;
import ViewModels.HoaDonChiTietReponse;
import ViewModels.HoaDonReponse;
import java.util.List;

public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hoaDonRepository;

    public HoaDonServiceImpl() {
        hoaDonRepository = new HoaDonRepository();

    }

    @Override
    public List<HoaDonReponse> layHoaDons() {
        return hoaDonRepository.layHoaDon();
    }

    @Override
    public List<HoaDonChiTietReponse> layHoaDonCT(String ma) {
        return hoaDonRepository.layHoaDonCT(ma);
    }

    @Override
    public List<HoaDonReponse> layHoaDontuNgay(String dateBD, String dateKT) {
        return hoaDonRepository.layHoaDontuNgay(dateBD, dateKT);
    }

}
