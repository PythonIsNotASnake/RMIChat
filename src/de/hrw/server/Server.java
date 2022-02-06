package de.hrw.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) {
        RMIChatInterface instance = new RMIChatInterfaceImpl();
        RMIChatInterface stub;
        Registry registry;

        try {
            stub = (RMIChatInterface) UnicastRemoteObject.exportObject(instance, 1099);
            registry = LocateRegistry.createRegistry(1099);
            System.out.println(registry + "");
            registry.rebind("chat", stub);
        } catch (RemoteException re) {
            re.printStackTrace();
        }

    }
}
