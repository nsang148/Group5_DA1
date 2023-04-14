/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModels;

/**
 *
 * @author Tus
 */
public class ThitDomain {
    private String id;
    private String ma;
    private String ten;
    private String idLT;
    private int trangthai;

    public ThitDomain() {
    }

    public ThitDomain(String id, String ma, String ten,String idLT, int trangthai) {
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


    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getIdLT() {
        return idLT;
    }

    public void setIdLT(String idLT) {
        this.idLT = idLT;
    }
    
    
}
