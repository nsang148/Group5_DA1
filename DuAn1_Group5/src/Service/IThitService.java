/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ViewModels.ThitView;
import java.util.List;

/**
 *
 * @author Tus
 */
public interface IThitService {
    List<ThitView> getAll();
    boolean add(ThitView tv);
    boolean update(ThitView tv);
    boolean delete(ThitView tv);
}
