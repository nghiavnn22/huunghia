/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server;
import java.rmi.*;
import java.util.ArrayList;
import sinhvien.Diem;
import sinhvien.ThongTin;
/**
 *
 * @author Administrator
 */
public interface ClientServer extends Remote{
    public ThongTin xemThongTin(String masv) throws RemoteException;
    public ArrayList<Diem> xemDiem(String masv) throws RemoteException;
    public String updateDiem(String masv,String mamh,String hocky,String lan,String diem) throws RemoteException;
    
}
