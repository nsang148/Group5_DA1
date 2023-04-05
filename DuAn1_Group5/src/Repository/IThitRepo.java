/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import IRepository.*;
import DomainModels.ThitDomain;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface IThitRepo {
    List<ThitDomain> getAll();
    boolean add(ThitDomain th);
    boolean update(ThitDomain th);
    boolean delete(ThitDomain th);
}
