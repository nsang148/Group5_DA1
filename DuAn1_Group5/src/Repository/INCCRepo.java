/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import IRepository.*;
import DomainModels.NhaCungCapDomain;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface INCCRepo {
    List<NhaCungCapDomain> getAll();
    boolean add(NhaCungCapDomain nc);
    boolean update(NhaCungCapDomain nc);
    boolean delete(NhaCungCapDomain nc);
}
