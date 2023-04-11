/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implement;

import DomainModels.NhaCungCapDomain;
import Repository.NCCRRepository;
import Service.INCCServices;
import ViewModels.NhaCCView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tus
 */
public class NCCServices implements INCCServices{
    
    private NCCRRepository rs = new NCCRRepository();

    @Override
    public List<NhaCCView> getAll() {
      ArrayList<NhaCCView> ds = new ArrayList<>();
      List<NhaCungCapDomain> list = this.rs.getAll();
        for (NhaCungCapDomain x : list) {
            NhaCCView view = new NhaCCView(x.getId(), x.getMa(), x.getTen(), x.getTrangThai());
            ds.add(view);
        }
        return ds;
    }

    public NhaCCView getByName(String name) {
        NhaCungCapDomain x = rs.getByName(name);
        return new NhaCCView(x.getId(), x.getMa(), x.getTen(), x.getTrangThai());
    }
    
    @Override
    public boolean add(NhaCCView nv) {
     NhaCungCapDomain domain = new NhaCungCapDomain(nv.getId(), nv.getMa(), nv.getTen(), nv.getTrangthai());
     return this.rs.add(domain);
    }

    @Override
    public boolean update(NhaCCView nv) {
        NhaCungCapDomain capDomain = new NhaCungCapDomain(nv.getId(), nv.getMa(), nv.getTen(), nv.getTrangthai());
        return this.rs.update(capDomain);
    }

    @Override
    public boolean delete(NhaCCView nv) {
     NhaCungCapDomain nccd = new NhaCungCapDomain(nv.getId(), nv.getMa(), nv.getTen(), nv.getTrangthai());
     return this.rs.delete(nccd);
    }

    

    
}
