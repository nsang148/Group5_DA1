
package Service;

import DomainModels.TacGia;
import java.util.List;

/**
 *
 * @author acer
 */
public interface TacGiaService {
    List<TacGia> getAll();
    public int createTacGia(TacGia tg);
    public int updateTacGia(TacGia tg);
    public int deleteTacGia(String id);
}
