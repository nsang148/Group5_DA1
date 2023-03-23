/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ViDiem;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface ViDiemService {
    List<ViDiem> getAll();

    String add(ViDiem viDiem);

    String update(ViDiem viDiem);

    String delete(String id);
}
