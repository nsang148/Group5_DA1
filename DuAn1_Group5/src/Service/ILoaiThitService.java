/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ViewModels.LoaiThitView;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface ILoaiThitService {
    List<LoaiThitView> getAll();
    boolean add(LoaiThitView tv);
    boolean update(LoaiThitView tv);
    boolean delete(LoaiThitView tv);
}
