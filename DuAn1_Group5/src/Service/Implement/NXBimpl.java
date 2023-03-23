
package Service.Implement;

import DomainModels.NXB;
import Repository.NXBRepository;
import Service.NXBService;
import java.util.List;

/**
 *
 * @author acer
 */
public class NXBimpl implements NXBService{
    private NXBRepository nxbRepo = new NXBRepository();
    
    @Override
    public List<NXB> getAll() {
        return nxbRepo.getAll();
    }

    @Override
    public int createNXB(NXB nxb) {
        return nxbRepo.createNXBRepository(nxb);
    }

    @Override
    public int updateNXB(NXB nxb) {
        return nxbRepo.updateNXBRepository(nxb);
    }

    @Override
    public int deleteNXB(String id) {
        return nxbRepo.deleteNSXRepository(id);
    }
    
}
