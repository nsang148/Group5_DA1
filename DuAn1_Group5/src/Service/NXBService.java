/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.NXB;
import java.util.List;

/**
 *
 * @author acer
 */
public interface NXBService {
    List<NXB> getAll();
    public int createNXB(NXB nxb);
    public int updateNXB(NXB nxb);
    public int deleteNXB(String id);
}
