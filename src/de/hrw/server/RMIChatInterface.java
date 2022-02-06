package de.hrw.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIChatInterface extends Remote {
    public List<String> remoteMethod(String par) throws RemoteException;

    public List<String> getChatHistory() throws RemoteException;
}
