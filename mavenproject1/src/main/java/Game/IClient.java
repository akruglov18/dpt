/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author acer
 */
public interface IClient extends Remote {
    public static String NAME = "MyClient";
    void drawField(String field) throws RemoteException;
    public String getClientName() throws RemoteException;
    public void sendMessage(String msg) throws RemoteException;
}
