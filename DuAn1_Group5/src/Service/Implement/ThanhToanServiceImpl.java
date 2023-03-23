
package Service.Implement;

import Repository.ThanhToanRepository;
import Service.ThanhToanService;
import ViewModels.ThanhToan;
import java.util.List;


public class ThanhToanServiceImpl implements ThanhToanService{
    private ThanhToanRepository ttRepo = new ThanhToanRepository();
    @Override
    public List<ThanhToan> all() {
        
        return this.ttRepo.all();
    }

    @Override
    public void insert(ThanhToan tt) {
//    this.ttRepo.insert(tt);
    }

    @Override
    public void update(ThanhToan tt, String tenKH) {
//    this.ttRepo.update(tt, tenKH);
    }

    @Override
    public void delete(String tenKH) {
//    this.ttRepo.delete(tenKH);
    }
    
}
