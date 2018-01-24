/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinhvien;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Diem implements Serializable{
    private String tenmh,hocky,lan,diem;

    public Diem(String tenmh, String hocky, String lan, String diem) {
        this.tenmh = tenmh;
        this.hocky = hocky;
        this.lan = lan;
        this.diem = diem;
    }

    public String getTenmh() {
        return tenmh;
    }

    public String getHocky() {
        return hocky;
    }

    public String getLan() {
        return lan;
    }

    public String getDiem() {
        return diem;
    }

    @Override
    public String toString() {
        return "|" + "Mon hoc: " + tenmh + " | hoc ky:" + hocky + " | lan=" + lan + " | diem=" + diem + " |";
    }
}
