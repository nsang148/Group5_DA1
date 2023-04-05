/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ViewModels.NhaCCView;
import ViewModels.XuatXuView;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface IXuatXuService {
    List<XuatXuView> getAll();
    boolean add(XuatXuView xxv);
    boolean update(XuatXuView xxv);
    boolean delete(XuatXuView xxv);
}
