/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client_server.ClientServer;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sinhvien.Diem;
import sinhvien.ThongTin;

/**
 *
 * @author Administrator
 */
public class ClientServerImpl extends UnicastRemoteObject implements ClientServer{
    
    private static final String data1="//192.168.1.3/data";
    private static final String data2="//192.168.1.4/data";
    
    public ClientServerImpl() throws RemoteException {
    }

    @Override
    public ThongTin xemThongTin(String masv) {
        System.out.println("-------------------------------------------------");
        System.out.println("Nhan duoc yeu cau xem thong tin sinh vien: "+masv);
        ThongTin thongTin = null;
        try{
            
            String maKhoa=masv.substring(3, 6);
            switch(maKhoa){
                case "105":
                    thongTin=connData1(masv);
                    break;
                case "106":
                    thongTin=connData2(masv);
                    break;
            }
        }catch(Exception e){
        }
        System.out.println("Tra loi client thanh cong.\n-------------------------------------------------\n\nCho client yeu cau.....\n\n");
        return thongTin;
    }

    private ThongTin connData1(String masv) {
        System.out.println("Tim kiem thong tin tren ServerData 1...");
        ThongTin thongTin=null;
        try {
            LocateRegistry.getRegistry();
            ClientServer sv = (ClientServer)Naming.lookup(data1);
            thongTin = sv.xemThongTin(masv);
        } catch (RemoteException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", getRegistry connData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup connData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup connData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return thongTin;
    }

    private ThongTin connData2(String masv) {
        System.out.println("Tim kiem thong tin tren ServerData 2...");
        ThongTin thongTin=null;
        try {
            LocateRegistry.getRegistry();
            ClientServer sv = (ClientServer)Naming.lookup(data2);
            thongTin = sv.xemThongTin(masv);
        } catch (RemoteException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", getRegistry connData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup connData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup connData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thongTin;
    }

    @Override
    public ArrayList<Diem> xemDiem(String masv) throws RemoteException {
        System.out.println("-------------------------------------------------");
        System.out.println("Nhan duoc yeu cau xem diem sinh vien: "+masv);
        ArrayList<Diem> arr = new ArrayList<>();
        try{
            
            String maKhoa=masv.substring(3, 6);
            switch(maKhoa){
                case "105":
                    arr=getDiemData1(masv);
                    break;
                case "106":
                    arr=getDiemData2(masv);
                    break;
            }
        }catch(Exception e){
        }
        System.out.println("Tra loi client thanh cong.\n-------------------------------------------------\n\nCho client yeu cau.....\n\n");
        return arr;
    }

    private ArrayList<Diem> getDiemData1(String masv) {
        System.out.println("Tim kiem thong tin tren ServerData 1...");
        ArrayList<Diem> arr = new ArrayList<>();
        try {
            LocateRegistry.getRegistry();
            ClientServer sv = (ClientServer)Naming.lookup(data1);
            arr = sv.xemDiem(masv);
        } catch (RemoteException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", getRegistry getDiemData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup getDiemData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup getDiemData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }

    private ArrayList<Diem> getDiemData2(String masv) {
        System.out.println("Tim kiem thong tin tren ServerData 2...");
        ArrayList<Diem> arr = new ArrayList<>();
        try {
            LocateRegistry.getRegistry();
            ClientServer sv = (ClientServer)Naming.lookup(data2);
            arr = sv.xemDiem(masv);
        } catch (RemoteException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", getRegistry getDiemData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup getDiemData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup getDiemData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }

    @Override
    public String updateDiem(String masv, String mamh, String hocky, String lan, String diem) throws RemoteException {
        System.out.println("-------------------------------------------------");
        System.out.println("Nhan duoc yeu cau cap nhat diem sinh vien: "+masv+", ma mon: "+mamh+", hocky: "+hocky+",lan: "+lan+", diem: "+diem);
        String status="Ma sinh vien khong chinh xac!";
        try{
            
            String maKhoa=masv.substring(3, 6);
            switch(maKhoa){
                case "105":
                    status=updateDiemData1(masv,mamh,hocky,lan,diem);
                    break;
                case "106":
                    status=updateDiemData2(masv,mamh,hocky,lan,diem);
                    break;
            }
        }catch(Exception e){
        }
        System.out.println("Tra loi client thanh cong.\n-------------------------------------------------\n\nCho client yeu cau.....\n\n");
        return status;
    }

    private String updateDiemData1(String masv, String mamh, String hocky, String lan, String diem) {
        System.out.println("Cap nhat diem tren ServerData 1...");
        String status="Loi khong xac dinh!";
        try {
            LocateRegistry.getRegistry();
            ClientServer sv = (ClientServer)Naming.lookup(data1);
            status = sv.updateDiem(masv, mamh, hocky, lan, diem);
        } catch (RemoteException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", getRegistry updateDiemData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup updaDiemData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup updateDiemData1()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    private String updateDiemData2(String masv, String mamh, String hocky, String lan, String diem) {
        System.out.println("Cap nhat diem tren ServerData 2...");
        String status="Loi khong xac dinh!";
        try {
            LocateRegistry.getRegistry();
            ClientServer sv = (ClientServer)Naming.lookup(data2);
            status = sv.updateDiem(masv, mamh, hocky, lan, diem);
        } catch (RemoteException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", getRegistry updateDiemData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup updaDiemData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+ClientServerImpl.class.getName()+", Naming.lookup updateDiemData2()"+
                    "\n---------------------------");
            Logger.getLogger(ClientServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    
}
