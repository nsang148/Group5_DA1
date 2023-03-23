package Service.Implement;

import DomainModels.NXB;
import DomainModels.TacGia;
import Repository.TacGiaRepository;
import Service.NXBService;
import Service.TacGiaService;
import java.util.List;

/**
 *
 * @author acer
 */
public class TacGiaBimpl implements TacGiaService {

    private TacGiaRepository tgRepo = new TacGiaRepository();

    @Override
    public List<TacGia> getAll() {
        return tgRepo.getAll();
    }

    @Override
    public int createTacGia(TacGia tg) {
        return tgRepo.createTacGiaRepository(tg);
    }

    @Override
    public int updateTacGia(TacGia tg) {
        return tgRepo.updateTacGiaRepository(tg);
    }

    @Override
    public int deleteTacGia(String id) {
        return tgRepo.deleteTacGiaRepository(id);
    }

}
