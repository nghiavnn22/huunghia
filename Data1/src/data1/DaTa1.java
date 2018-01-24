/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data1;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class DaTa1 {
    private static final String url = "//192.168.1.3/data";
    public static void main(String[] args) {
        try {
            ServerDataImpl serverDataImpl = new ServerDataImpl();
            System.out.println("Kich hoat server data 1.....");
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println(".....");
            Naming.bind(url, serverDataImpl);
            System.out.println("Server data kich hoat thanh cong.");
            System.out.println("Cho yeu cau.....");
        } catch (RemoteException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+DaTa1.class.getName()+", create serverDataImpl."+
                    "\n---------------------------");
            Logger.getLogger(DaTa1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+DaTa1.class.getName()+", create registry."+
                    "\n---------------------------");
            Logger.getLogger(DaTa1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+DaTa1.class.getName()+", create registry."+
                    "\n---------------------------");
            Logger.getLogger(DaTa1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
