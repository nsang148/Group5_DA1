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
public class ThitView {

    private String id;
    private String ma;
    private String ten;
    private String idLT;
    private int trangthai;

    private ArrayList<ThitView> xx = new ArrayList<>();

    public ThitView() {
    }

    public ThitView(String id, String ma, String ten, String idLT, int trangthai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.idLT = idLT;
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

    public String getIdLT() {
        return idLT;
    }

    public void setIdLT(String idLT) {
        this.idLT = idLT;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public ArrayList<ThitView> getXx() {
        return xx;
    }

    public void setXx(ArrayList<ThitView> xx) {
        this.xx = xx;
    }

    
    public ThitView getThitId(String ma) {
        for (ThitView x : xx) {
            if (x.getId().equalsIgnoreCase(ma)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final ThitView other = (ThitView) obj;
        return Objects.equals(this.id, other.id);
    }
    
    public String setTrangThaiS(int TrangThai){
        if(TrangThai==0){
            return "còn hàng";
        } else{
            return "hết";
        }
        
    }
    
}
