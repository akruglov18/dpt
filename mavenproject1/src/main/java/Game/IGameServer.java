/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Game;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author acer
 */
public interface IGameServer extends Remote {
    public static String name = "MyServer";
    static final String host = "localhost";
    public static int port = 8080;
    
    public boolean addClient(String name) throws RemoteException;
    public boolean register(IClient client) throws RemoteException;
    public int getClientPort() throws RemoteException;
    
    public void makeTurn(Turn turn) throws RemoteException;
}
