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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String message;
    public static String exitMessage="close";
    private int port;
    private String response=null;
    private String selectedImage;
    private String selectedSound;

    public String getSelectedSound() {
        return selectedSound;
    }

    public void setSelectedSound(String selectedSound) {
        this.selectedSound = selectedSound;
    }
    public String getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(String selected) {
        this.selectedImage = selected;
        System.out.println("SERVER:"+selected);
    }

    
    
    public void init(int port){
        try {
            serverSocket = new ServerSocket(port);

            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.port=port;
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void start(int port) {
        System.out.println("Server Started");
        System.out.println("Waiting For Messages:");
        message = "";
        try {

            do{
                
                message = in.readLine();
                if(message.equalsIgnoreCase(exitMessage)){
                    break;
                }
                System.out.println("Received Message: "+message);
                while(getSelectedImage()==null)
                {
                    try {
                        sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                out.println(getSelectedImage().equalsIgnoreCase(message));
                setSelectedSound(message);
                setSelectedImage(null);
                /*stop();
                init(6666);*/
            }while(message !=null && !message.equalsIgnoreCase(exitMessage));
            if(message==null){
                System.out.println("nulled out");
            }
            out.println("GoodBye");
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            stop();
        }
    }

    public void stop() {
        System.out.println("closing");
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        System.out.println("Started");
        Server server = new Server();
        server.init(6666);

        server.start(6666);
    }

    
}

