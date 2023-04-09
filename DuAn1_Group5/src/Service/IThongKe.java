/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ThongKeDT;
import DomainModels.ThongKeSP;
import java.util.List;

/**
 *
 * @author tagot
 */
public interface IThongKe {
    List<ThongKeDT> getListTK();
    
    List<ThongKeSP> getListSP();
}
