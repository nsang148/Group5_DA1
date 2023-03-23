/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.ViDiem;
import Repository.ViDiemRepository;
import Service.ViDiemService;
import java.util.List;

/**
 *
 * @author sangh
 */
public class ViDiemImplement implements ViDiemService{
    private ViDiemRepository viDiemRepository = new ViDiemRepository();

    @Override
    public List<ViDiem> getAll() {
        return viDiemRepository.getAll();
    }

    @Override
    public String add(ViDiem viDiem) {
        return viDiemRepository.insert(viDiem);
    }

    @Override
    public String update(ViDiem viDiem) {
        return viDiemRepository.update(viDiem);
    }

    @Override
    public String delete(String id) {
        return viDiemRepository.delete(id);
    }
    
}
