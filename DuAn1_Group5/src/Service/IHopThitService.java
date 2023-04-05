/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ViewModels.HopThitView;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface IHopThitService {
    List<HopThitView> getal();
    boolean add(HopThitView ht);
    boolean update(HopThitView ht);
    boolean delete(HopThitView ht);
}
