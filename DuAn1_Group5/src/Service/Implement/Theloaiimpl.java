package Service.Implement;

import DomainModels.NXB;
import DomainModels.TheLoai;
import Repository.NXBRepository;
import Repository.TheLoaiRepository;
import Service.TheLoaiService;
import java.util.List;

/**
 *
 * @author acer
 */
public class Theloaiimpl implements TheLoaiService {

    private TheLoaiRepository tlRepo = new TheLoaiRepository();

    public Theloaiimpl() {
        tlRepo = new TheLoaiRepository();
    }

    @Override
    public List<TheLoai> getAll() {
        return tlRepo.getAll();
    }

    @Override
    public int createTheLoai(TheLoai tl) {
        return tlRepo.createTheLoaiRepository(tl);
    }

    @Override
    public int updateTheLoai(TheLoai tl) {
        return tlRepo.updateTheLoaiRepository(tl);
    }

    @Override
    public int deleteTheLoai(String id) {
        return tlRepo.deleteTheLoaiRepository(id);
    }

}
