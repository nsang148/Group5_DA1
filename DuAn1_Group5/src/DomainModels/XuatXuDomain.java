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
public class XuatXuDomain {
    private String id;
    private String ma;
    private String noiXX;
    private int trangthai;

    public XuatXuDomain() {
    }

    public XuatXuDomain(String id, String ma, String noiXX, int trangthai) {
        this.id = id;
        this.ma = ma;
        this.noiXX = noiXX;
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

    public String getNoiXX() {
        return noiXX;
    }

    public void setNoiXX(String noiXX) {
        this.noiXX = noiXX;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
    
}
