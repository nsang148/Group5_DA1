/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModels;

import java.util.ArrayList;

/**
 *
 * @author Tus
 */
public class ThitView {

    private String id;
    private String ma;
    private String ten;
    private int trangthai;

    private ArrayList<ThitView> xx = new ArrayList<>();

    public ThitView() {
    }

    public ThitView(String id, String ma, String ten, int trangthai) {
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

    public ThitView getThitId(String ma) {
        for (ThitView x : xx) {
            if (x.getId().equalsIgnoreCase(ma)) {
                return x;
            }
        }
        return null;
    }

}
