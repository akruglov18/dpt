/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author acer
 */
public class Client implements IClient {

    static final String HOST = "localhost";
    static public int myPort = 8081;
    public String name;
    
    @Override
    public void drawField(String field) throws RemoteException {
        System.out.println(field);
    }
    
    @Override()
    public String getClientName() throws RemoteException {
        return name;
    }
    
    @Override
    public void sendMessage(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(HOST, IGameServer.port);
        IGameServer server = (IGameServer)registry.lookup(IGameServer.name);
        System.out.println("server=" + server);
        myPort = server.getClientPort();
        
        Client client = new Client();
        client.name = IClient.NAME + myPort;
//        Remote stub = UnicastRemoteObject.exportObject(client, myPort);
//        registry.rebind(client.name, stub);
//
//        System.out.println(myPort);
//        server.addClient(client.name);
        IClient stub = (IClient)UnicastRemoteObject.exportObject(client, myPort);

        System.out.println(myPort);
        server.register(stub);

        Interaction interaction = new Interaction(server, client.name);
        new Thread(interaction).start();
    }
}
