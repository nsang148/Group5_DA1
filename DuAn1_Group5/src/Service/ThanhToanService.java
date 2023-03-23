
package Service;

import Repository.ThanhToanRepository;
import ViewModels.ThanhToan;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bach
 */
public interface ThanhToanService {
    List<ThanhToan> all();
    public void insert(ThanhToan tt);
    public void update(ThanhToan tt, String tenKH);
    public void delete(String tenKH);
}
