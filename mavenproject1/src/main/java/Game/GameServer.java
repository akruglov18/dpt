/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Game;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */

public class GameServer implements IGameServer {
    int clientPort = 8080;
    ArrayList<IClient> clients;
    Game game;
    
    public GameServer() {
        super();
        clients = new ArrayList<>();
        game = new Game(3);
    }
    
    @Override
    public int getClientPort() throws RemoteException {
        clientPort++;
        return clientPort;
    }
    
    private void drawField() throws RemoteException {
        String field = game.getField();
        for (IClient client : clients) {
            client.drawField(field);
        }
    }
    
    private void startGame() throws RemoteException {
        drawField();
    }
    
    @Override
    public void makeTurn(Turn turn) throws RemoteException {
        if (turn == null)
            return;
        if (turn.clientServerName.equals(clients.get(0).getClientName())) {
            if (game.makeTurn(0, turn.edge)) {
                drawField();
            }
        } else if(turn.clientServerName.equals(clients.get(1).getClientName())) {
            if (game.makeTurn(1, turn.edge)) {
                drawField();
            }
        }
        if (game.isGameEnded()) {
            String msg = game.getEndingMessage();
            for (IClient client : clients) {
                client.sendMessage(msg);
            }
        }
    }
    
    @Override
    public boolean addClient(String name) throws RemoteException, AccessException {
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            IClient client = (IClient)registry.lookup(name);
            if (client == null) {
                System.out.println("Can't add client: " + name);
                return false;
            }
            if (clients.size() < 2) {
                clients.add(client);
            } else {
                System.out.println("There is already 2 clients, can't add client: " + name);
                return false;
            }
            
            if (clients.size() == 2) {
                startGame();
                return true;
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean register(IClient client) throws RemoteException {
        if (client == null) {
            System.out.println("Can't add client: " + name);
            return false;
        }
        if (clients.size() < 2) {
            clients.add(client);
        } else {
            System.out.println("There is already 2 clients, can't add client: " + name);
            return false;
        }

        if (clients.size() == 2) {
            startGame();
            return true;
        }
        return false;
    }
   
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(port);
        GameServer server = new GameServer();
        Remote proxy = UnicastRemoteObject.exportObject(server, port);
        registry.rebind("MyServer",proxy);
    }
}
