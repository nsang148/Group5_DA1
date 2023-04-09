/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.ThongKeDT;
import DomainModels.ThongKeSP;
import Repository.ThongKeRepository;
import Service.ThongKeService;
import java.util.List;
import Service.IThongKe;

/**
 *
 * @author tagot
 */
public class ThongKeServiceImpl implements ThongKeService{
    private IThongKe thongke = null;

    public ThongKeServiceImpl() {
        this.thongke = new ThongKeRepository();
    }
    
    @Override
    public List<ThongKeDT> getListTK() {
      return  thongke.getListTK();
    }

    @Override
    public List<ThongKeSP> getListSP() {
        return  thongke.getListSP();
    
}
}
