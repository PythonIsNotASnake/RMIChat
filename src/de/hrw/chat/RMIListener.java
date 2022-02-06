package de.hrw.chat;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class RMIListener implements NetworkListener, Runnable {

    private JTextArea textArea;
    private List<String> chatHistory = new ArrayList<>();
    private String chatMessages = "";

    public RMIListener(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void messageReceived(String msg) {
        textArea.setText(msg);
    }

    @Override
    public void run() {

        while (true) {
            try {
                String messages = "";
                chatHistory = Globals.getInstanceOf().getChat().getChatHistory();
                for (int i = 0; i < chatHistory.size(); i++) {
                    messages = messages + chatHistory.get(i) + System.getProperty("line.separator");
                }
                if (chatMessages != messages && messages != null && messages.length() > 0) {
                    chatMessages = messages;
                    messageReceived(messages);
                }

            } catch (RemoteException re) {
                re.printStackTrace();
            }


        }
    }
}
