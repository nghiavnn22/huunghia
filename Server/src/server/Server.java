/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
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
public class Server {
    private static final String url="//192.168.1.2/server";
    
    public static void main(String[] args) {
        try {
            ClientServerImpl csi = new ClientServerImpl();
            System.out.println("Kich hoat server.....");
            
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println(".....");
            
            Naming.bind(url, csi);
            System.out.println("Server kich hoat thanh cong.");
            System.out.println("Cho client gui yeu cau.....\n\n");
        } catch (RemoteException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+Server.class.getName()+", create csi...)"+
                    "\n---------------------------");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+Server.class.getName()+", bind..."+
                    "\n---------------------------");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            System.out.println("---------------------------"
                    + "\n[Loi] "+Server.class.getName()+", bind..."+
                    "\n---------------------------");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
