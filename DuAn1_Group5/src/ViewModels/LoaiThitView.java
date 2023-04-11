/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Tus
 */
public class LoaiThitView {
    private String id;
    private String ma;
    private String ten;
    private int trangthai;
    
    private ArrayList<LoaiThitView> lt = new ArrayList<>();

    public LoaiThitView() {
    }

    public LoaiThitView(String id, String ma, String ten, int trangthai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangthai = trangthai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public ArrayList<LoaiThitView> getLt() {
        return lt;
    }

    public void setLt(ArrayList<LoaiThitView> lt) {
        this.lt = lt;
    }
    
    public LoaiThitView getLoaiThitID(String ma){
        for (LoaiThitView x : lt) {
            if (x.getId().equalsIgnoreCase(ma)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoaiThitView other = (LoaiThitView) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
