/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implement;

import DomainModels.LoaiThitDomain;
import Repository.LoaiThitRepo;
import ViewModels.LoaiThitView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class LoaiThitService implements Service.ILoaiThitService{
    private LoaiThitRepo rs = new LoaiThitRepo();
    @Override
    public List<LoaiThitView> getAll() {
        ArrayList<LoaiThitView> ds = new ArrayList<>();
        List<LoaiThitDomain> list = this.rs.getAll();
        for (LoaiThitDomain x : list) {
            LoaiThitView view = new LoaiThitView(x.getId(), x.getMa(), x.getTen(), x.getTrangthai());
            ds.add(view);
        }
        return ds;
    }

    @Override
    public boolean add(LoaiThitView tv) {
       LoaiThitDomain domain = new LoaiThitDomain(tv.getId(), tv.getMa(), tv.getTen(), tv.getTrangthai());
        this.rs.add(domain);
        return true;
    }

    @Override
    public boolean update(LoaiThitView tv) {
       LoaiThitDomain domain = new LoaiThitDomain(tv.getId(), tv.getMa(), tv.getTen(), tv.getTrangthai());
        this.rs.update(domain);
        return true;
    }

    @Override
    public boolean delete(LoaiThitView tv) {
      LoaiThitDomain xxd = new LoaiThitDomain(tv.getId(), tv.getMa(), tv.getTen(), tv.getTrangthai());
      this.rs.delete(xxd);
      return true;
    }
    
}
