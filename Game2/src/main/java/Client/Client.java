/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import webservice.service.*;

/**
 *
 * @author acer
 */
public class Client {

    static public int myPort = 8081;
    public String name;
    
    public String getClientName() {
        return name;
    }

    public static void main(String[] args) throws Exception {
        GameServer server = new GameServerService().getGameServerPort();
        System.out.println("server=" + server);
        
        Client client = new Client();
        client.name = server.register();

        System.out.println(client.name);

        ServerInteraction serverInteraction = new ServerInteraction(server, client.name);
        new Thread(serverInteraction).start();
        
        UserInteraction userInteraction = new UserInteraction(server, client.name);
        new Thread(userInteraction).start();
    }
}
