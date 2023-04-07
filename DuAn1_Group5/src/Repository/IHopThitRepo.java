/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.HopThitDomain;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface IHopThitRepo {
    List<HopThitDomain> getall();
    boolean add(HopThitDomain ht);
    boolean update(HopThitDomain ht);
    boolean delete(HopThitDomain ht);
}
