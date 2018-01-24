/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data1;

import client_server.ClientServer;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sinhvien.Diem;
import sinhvien.ThongTin;

/**
 *
 * @author Administrator
 */
public class ServerDataImpl extends UnicastRemoteObject implements ClientServer{
    
    private static final String url="jdbc:sqlserver://192.168.1.3:1433;databaseName=DG;user=sa;password=123456";
    private static Connection conn = null;
    private static Statement stm = null;
    private static ResultSet rs = null;
    
    public ServerDataImpl() throws RemoteException {
    }
    
    public void conn(){
        try {
            conn=DriverManager.getConnection(url);
            stm=conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ServerDataImpl.class.getName()+", getConnect()"+
                    "\n---------------------------");
            Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ThongTin xemThongTin(String masv) throws RemoteException{
        System.out.println("\n\n---------------------------------------");
        System.out.println("Nhan duoc yeu cau xem thong tin sinh vien: "+masv);
        this.conn();
        ThongTin thongTin = null;
        String sql="select * from sinhvien where masv='"+masv+"'";
        try {
            rs=stm.executeQuery(sql);
            if(rs.next())
            thongTin = new ThongTin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            
        } catch (SQLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ServerDataImpl.class.getName()+", xemThongTin()"+
                    "\n---------------------------");
            Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
        return thongTin;
    }
    
    @Override
    public ArrayList<Diem> xemDiem(String masv) throws RemoteException {
        System.out.println("\n\n---------------------------------------");
        System.out.println("Nhan duoc yeu cau xem diem sinh vien: "+masv);
        this.conn();
        ArrayList<Diem> arr = new ArrayList<>();
        String sql="select monhoc.tenmh,diem.hocky,diem.lan,diem.diem from monhoc,diem where diem.mamh=monhoc.mamh and diem.masv='"+masv+"'";
        try {
            rs=stm.executeQuery(sql);
            while(rs.next())
            {
                arr.add(new Diem(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ServerDataImpl.class.getName()+", xemDiem()"+
                    "\n---------------------------");
            Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
        return arr;
    }

    @Override
    public String updateDiem(String masv, String mamh, String hocky, String lan, String diem) throws RemoteException {
        System.out.println("\n\n---------------------------------------");
        System.out.println("Nhan duoc yeu cau cap nhat diem sinh vien: "+masv+", ma mon: "+mamh+", hocky: "+hocky+",lan: "+lan+", diem: "+diem);
        String status="Xay ra loi, vui long nhap chinh xac";
        String sql1="select  * from monhoc where tenmh='"+mamh+"'";
        try {
            rs=stm.executeQuery(sql1);
            if(rs.next())
                mamh=rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            int d=Integer.parseInt(diem);
            if(d<0 || d>10){
                System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
                return "Diem khong chinh xac.";
            }
        }catch(Exception e){
            System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
        return "Diem khong chinh xac.";}
        int i=0;
        if(isNullMasv(masv))
        {
            System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
            return "Khong tim thay sinh vien: "+masv;
        }else if(isNullmamh(masv,mamh))
        {
            System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
            return "Sinh vien: "+masv+" khong hoc mon: "+mamh;
        }else if(isNullhocky(masv,mamh,hocky))
        {
            System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
            return "Sinh vien: "+masv+" chua hoc hoc ky: "+hocky;
        }else if(isNulllan(masv,mamh,hocky,lan))
        {
            System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
            return "Sinh vien chua tham gia lan thi thu: "+lan;
        }
        else{
            String sql="update diem set diem='"+diem+"' where masv='"+masv+"' and mamh='"+mamh+"' and hocky='"+hocky+"' and lan='"+lan+"'";
            try {
                i =  stm.executeUpdate(sql);
            } catch (SQLException ex) {
                System.out.println("---------------------------"
                    + "\n[Loi] "+ServerDataImpl.class.getName()+", update diem()"+
                    "\n---------------------------");
                Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Phan hoi yeu cau thanh cong.\n---------------------------------------\n\nCho yeu cau.....\n\n");
        if(i!=0)
            status="Cap nhat diem thanh cong.";
        return status;
    }

    private boolean isNullMasv(String masv) {
        this.conn();
        String sql = "select * from sinhvien where masv='"+masv+"'";
        try {
            rs=stm.executeQuery(sql);
            if(rs.next())
                return false;
        } catch (SQLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ServerDataImpl.class.getName()+", truy van stm, isNullMasv()()"+
                    "\n---------------------------");
            Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private boolean isNullmamh(String masv, String mamh) {
        this.conn();
        String sql = "select * from diem where mamh='"+mamh+"' and masv='"+masv+"'";
        try {
            rs=stm.executeQuery(sql);
            if(rs.next())
                return false;
        } catch (SQLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ServerDataImpl.class.getName()+", truy van stm, isNullmamh()()"+
                    "\n---------------------------");
            Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private boolean isNullhocky(String masv, String mamh, String hocky) {
        this.conn();
        String sql = "select * from diem where mamh='"+mamh+"' and masv='"+masv+"' and hocky='"+hocky+"'";
        try {
            rs=stm.executeQuery(sql);
            if(rs.next())
                return false;
        } catch (SQLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ServerDataImpl.class.getName()+", truy van stm, isNullhocky()()"+
                    "\n---------------------------");
            Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private boolean isNulllan(String masv, String mamh, String hocky, String lan) {
        this.conn();
        String sql = "select * from diem where mamh='"+mamh+"' and masv='"+masv+"' and hocky='"+hocky+"' and lan='"+lan+"'";
        try {
            rs=stm.executeQuery(sql);
            if(rs.next())
                return false;
        } catch (SQLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ServerDataImpl.class.getName()+", truy van stm, isNullhocky()()"+
                    "\n---------------------------");
            Logger.getLogger(ServerDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
