/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.util.logging.Level;
import java.util.logging.Logger;
import webservice.service.*;

/**
 *
 * @author acer
 */

public class ServerInteraction implements Runnable {
    GameServer server;
    String clientName;
    public ServerInteraction(GameServer server, String clientName) {
        this.server = server;
        this.clientName = clientName;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                String res = server.getField(clientName);
                if (res != null)
                    System.out.println(res);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerInteraction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
