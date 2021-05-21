/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalfriendconnector;

/**
 *
 * @author kingm
 */

import java.net.*;
import java.io.*;
import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClientComm {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    
    public void startConnection(String ip, int port) {
        boolean connected=false;
        while(!connected)
        {
            try {
                
                clientSocket = new Socket(ip, port);
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                connected=true;
            } catch (IOException ex) {
                //Logger.getLogger(ClientComm.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("failed to connect");
                connected=false;
                try {
                    sleep(3000);
                } catch (InterruptedException ex1) {
                    Logger.getLogger(ClientComm.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

    public String sendMessage(String msg) {
        try {
            out.println(msg);
            String resp = in.readLine();
            return resp;
        } catch (IOException ex) {
            Logger.getLogger(ClientComm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
        clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientComm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}