/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Server;

import Common.Turn;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author acer
 */

@WebService
public class GameServer{
    Game game;
    int clientsCount;
    boolean isGameStarted;
    boolean isUpdated[];
    
    public GameServer() {
        super();
        this.game = new Game(3);
        this.clientsCount = 0;
        this.isGameStarted = false;
        this.isUpdated = new boolean[2];
        isUpdated[0] = isUpdated[1] = false;
    }
    
    @WebMethod
    public String getField(String name) {
        String res = null;
        if (!isGameStarted) return res;
        
        if (name.equals("0") && !isUpdated[0]) {
            res = game.getField();
            isUpdated[0] = true;
        } else if(name.equals("1") && !isUpdated[1]) {
            res = game.getField();
            isUpdated[1] = true;
        }
        
        if (game.isGameEnded()) {
            if (res != null) {
                res += '\n';
                res += game.getEndingMessage();
            }
        }
        
        return res;
    }
    
    @WebMethod
    public void makeTurn(Turn turn){
        if (!isGameStarted || game.isGameEnded() || turn == null)
            return;
        
        if (turn.clientServerName.equals("0")) {
            turn.edge.setNormalize(turn.edge.x1, turn.edge.y1, turn.edge.x2, turn.edge.y2);
            if (game.makeTurn(0, turn.edge)) {
                isUpdated[0] = false;
                isUpdated[1] = false;
            }
        } else if(turn.clientServerName.equals("1")) {
            turn.edge.setNormalize(turn.edge.x1, turn.edge.y1, turn.edge.x2, turn.edge.y2);
            if (game.makeTurn(1, turn.edge)) {
                isUpdated[0] = false;
                isUpdated[1] = false;
            }
        }
    }
    
    @WebMethod
    public String register() {
        String res = null;
        if (clientsCount < 2) {
            res = Integer.toString(clientsCount);
            clientsCount++;
        }

        if (clientsCount == 2) {
            isGameStarted = true;
        }
        return res;
    }
   
    public static void main(String[] args) {
        GameServer server = new GameServer();
        String url = "http://localhost:8080/game";
        Endpoint.publish(url, server);
    }
}
