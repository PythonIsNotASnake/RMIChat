package de.hrw.chat;

import de.hrw.server.RMIChatInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Globals {

    private static final Globals instanceOf = new Globals();
    private RMIChatInterface chat;

    private Globals(){
        try{
            Registry registry = LocateRegistry.getRegistry("localhost");
            this.chat = (RMIChatInterface) registry.lookup("chat");
        } catch (RemoteException re){
            re.printStackTrace();
        }catch(NotBoundException ne) {
            ne.printStackTrace();
        }
    }

    public static Globals getInstanceOf() {
        return instanceOf;
    }

    public RMIChatInterface getChat() {
        return chat;
    }
}
