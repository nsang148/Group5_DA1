/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implement;

import DomainModels.ThitDomain;
import Repository.ThitRepository;
import ViewModels.ThitView;
import Service.IThitService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class ThitService implements IThitService{
    private ThitRepository rs = new ThitRepository();

    @Override
    public List<ThitView> getAll() {
        ArrayList<ThitView> ds = new ArrayList<>();
        List<ThitDomain> list = this.rs.getAll();
        for (ThitDomain x : list) {
            ThitView view = new ThitView(x.getId(), x.getMa(), x.getTen(),x.getTheloai(), x.getTrangthai());
            ds.add(view);
        }
        return ds;
    }

    @Override
    public boolean add(ThitView tv) {
      ThitDomain domain = new ThitDomain(tv.getId(), tv.getMa(), tv.getTen(),tv.getTheloai(), tv.getTrangthai());
        this.rs.add(domain);
        return true;
    }

    @Override
    public boolean update(ThitView tv) {
       ThitDomain domain = new ThitDomain(tv.getId(), tv.getMa(), tv.getTen(),tv.getTheloai(), tv.getTrangthai());
        this.rs.update(domain);
        return true;
    }

    @Override
    public boolean delete(ThitView tv) {
        ThitDomain xxd = new ThitDomain(tv.getId(), tv.getMa(), tv.getTen(),tv.getTheloai(), tv.getTrangthai());
      this.rs.delete(xxd);
      return true;
    }
}
