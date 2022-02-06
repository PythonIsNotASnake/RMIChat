package de.hrw.chat;

import de.hrw.server.RMIChatInterface;

import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class KeyboardListener implements InputListener {

	private JTextArea textArea;
	private String nick;
	private List<String> chatHistory = new ArrayList<>();
	
	public KeyboardListener(JTextArea textArea, String nick) {
		this.textArea = textArea;
		this.nick = nick;
	}
	
	@Override
	public void inputReceived(String str) {
		String messages = "";

		try{
			chatHistory = Globals.getInstanceOf().getChat().remoteMethod("<" + nick + "> " + str);
			for(int i=0;i<chatHistory.size();i++){
				messages = messages + chatHistory.get(i) + System.getProperty("line.separator");
			}
		} catch(RemoteException re) {
			re.printStackTrace();
		}

		if(messages!=null && messages.length()>0) {
			textArea.setText(messages);
		}
	}

}
