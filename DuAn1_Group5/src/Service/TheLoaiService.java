
package Service;

import DomainModels.TheLoai;
import java.util.List;

/**
 *
 * @author acer
 */
public interface TheLoaiService {
    List<TheLoai> getAll();
    public int createTheLoai(TheLoai tl);
    public int updateTheLoai(TheLoai tl);
    public int deleteTheLoai(String id);
}
