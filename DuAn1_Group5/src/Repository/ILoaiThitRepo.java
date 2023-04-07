/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.LoaiThitDomain;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface ILoaiThitRepo {
    List<LoaiThitDomain> getAll();
    boolean add(LoaiThitDomain th);
    boolean update(LoaiThitDomain th);
    boolean delete(LoaiThitDomain th);
}
