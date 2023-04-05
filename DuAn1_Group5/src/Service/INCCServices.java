/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ViewModels.NhaCCView;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface INCCServices {
    List<NhaCCView> getAll();
    boolean add(NhaCCView nv);
    boolean update(NhaCCView nv);
    boolean delete(NhaCCView nv);
}
