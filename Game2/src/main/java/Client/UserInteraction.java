/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import webservice.service.*;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class UserInteraction implements Runnable {
    GameServer server;
    String clientName;
    public UserInteraction(GameServer server, String clientName) {
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

            Edge edge = new Edge();
            edge.setX1(x1);
            edge.setX2(x2);
            edge.setY1(y1);
            edge.setY2(y2);

            Turn turn = new Turn();
            turn.setEdge(edge);
            turn.setClientServerName(clientName);

            server.makeTurn(turn);
        }
    }
    
}
