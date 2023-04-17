/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class Interaction implements Runnable {
    IGameServer server;
    String clientName;
    public Interaction(IGameServer server, String clientName) {
        this.server = server;
        this.clientName = clientName;
    }

    @Override
    public void run() {
        while (true) {
            Scanner in = new Scanner(System.in);
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            Edge edge = new Edge(x1, y1, x2, y2);
            Turn turn = new Turn(edge, clientName);
            try {
                server.makeTurn(turn);
            } catch (RemoteException ex) {
                Logger.getLogger(Interaction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
