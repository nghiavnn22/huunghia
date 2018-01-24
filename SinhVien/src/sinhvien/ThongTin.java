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
public class ThongTin implements Serializable{
    private String masv,ho,ten,malop,phai,ngaysinh,noisinh,diachi,ghichu,nghihoc;

    public ThongTin(String masv, String ho, String ten, String malop, String phai, String ngaysinh, String noisinh, String diachi, String ghichu, String nghihoc) {
        this.masv = masv;
        this.ho = ho;
        this.ten = ten;
        this.malop = malop;
        this.phai = phai;
        this.ngaysinh = ngaysinh;
        this.noisinh = noisinh;
        this.diachi = diachi;
        this.ghichu = ghichu;
        this.nghihoc = nghihoc;
    }

    public String getMasv() {
        return masv;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getMalop() {
        return malop;
    }

    public String getPhai() {
        return phai;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public String getNghihoc() {
        return nghihoc;
    }
    @Override
    public String toString() {
        String gt="nu",nghi="khong";
        if(phai.equals(1))
            gt="nam";
        if(nghihoc.equals(1))
            nghi="nghi hoc";
        return "Ma sinh vien:\t"+masv+"\nHo:\t\t"+ho+"\nTen:\t\t"+ten+"\nMa lop:\t\t"+malop+"\nGioi tinh:\t"+gt+"\nNgay sinh:\t"+ngaysinh+"\nNoi sinh:\t"+noisinh+"\nDia chi:\t"+diachi+"\nGhi chu:\t"+ghichu+"\nNghi hoc:\t"+nghi;
    }
}
