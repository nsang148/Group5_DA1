/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import DomainModels.XuatXuDomain;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface IXuatXuRepo {
    List<XuatXuDomain> getAll();
    boolean add(XuatXuDomain xx);
    boolean update(XuatXuDomain xx);
    boolean delete(XuatXuDomain xx);
}
