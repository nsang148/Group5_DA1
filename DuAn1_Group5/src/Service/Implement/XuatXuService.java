/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implement;

import DomainModels.XuatXuDomain;
import Repository.XuatXuRepository;
import Service.IXuatXuService;
import ViewModels.XuatXuView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class XuatXuService implements IXuatXuService{
    private XuatXuRepository rs = new XuatXuRepository();

    @Override
    public List<XuatXuView> getAll() {
        ArrayList<XuatXuView> ds = new ArrayList<>();
        List<XuatXuDomain> list = this.rs.getAll();
        for (XuatXuDomain x : list) {
            XuatXuView view = new XuatXuView(x.getId(), x.getMa(), x.getNoiXX(), x.getTrangthai());
            ds.add(view);
        }
        return ds;
    }

    public XuatXuView getByName(String name) {
        XuatXuDomain x = rs.getByName(name);
        return new XuatXuView(x.getId(), x.getMa(), x.getNoiXX(), x.getTrangthai());
    }
    
    @Override
    public boolean add(XuatXuView xxv) {
        XuatXuDomain domain = new XuatXuDomain(xxv.getId(), xxv.getMa(), xxv.getTen(), xxv.getTrangthai());
        return this.rs.add(domain);
    }

    @Override
    public boolean update(XuatXuView xxv) {
        XuatXuDomain xuDomain = new XuatXuDomain(xxv.getId(), xxv.getMa(), xxv.getTen(), xxv.getTrangthai());
        return this.rs.update(xuDomain);
    }

    @Override
    public boolean delete(XuatXuView xxv) {
      XuatXuDomain xxd = new XuatXuDomain(xxv.getId(), xxv.getMa(), xxv.getTen(), xxv.getTrangthai());
      return this.rs.delete(xxd);
    }
}
