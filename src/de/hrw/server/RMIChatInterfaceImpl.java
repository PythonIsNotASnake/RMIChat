package de.hrw.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class RMIChatInterfaceImpl implements RMIChatInterface {

    private static List<String> history = new ArrayList<>();

    @Override
    public List<String> remoteMethod(String par) throws RemoteException {
        System.out.println("New message: " + par);
        history.add(par);
        return history;
    }

    @Override
    public List<String> getChatHistory() throws RemoteException {
        return history;
    }
}
