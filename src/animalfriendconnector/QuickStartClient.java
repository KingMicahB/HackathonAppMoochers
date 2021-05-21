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
public class QuickStartClient {
    public static void main(String[] args){
        Beginning client=new Beginning();
        client.setIsServer(false);
        client.setCounter(5);
        client.setVisible(true);
    }
}
