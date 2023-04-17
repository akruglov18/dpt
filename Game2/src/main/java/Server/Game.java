/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Common.Edge;
import java.util.TreeSet;

/**
 *
 * @author acer
 */
public class Game {
    private int cellsSize;
    private int vertexesSize;
    private Cell cells[][];
    private int whoseTurn;
    private boolean isGameStarted;
    private int scores[];
    private TreeSet<Edge> edges; 
    
    public Game(int vertexesSize) {
        this.cellsSize = vertexesSize - 1;
        this.vertexesSize = vertexesSize;
        this.cells = new Cell[cellsSize][cellsSize];
        for (int i = 0; i < cellsSize; i++) {
            for (int j = 0; j < cellsSize; j++) {
                cells[i][j] = new Cell();
            }
        }
        this.whoseTurn = 0;
        this.isGameStarted = false;
        this.scores = new int[2];
        edges = new TreeSet<>();
    }
    
    public String getField() {
        String res = "";
        for (int i = 0; i < cellsSize; i++) {
            for (int j = 0; j < cellsSize; j++) {
                res += '*';
                if (cells[i][j].isUpClosed()) {
                    res += '-';
                } else {
                    res += ' ';
                }
            }
            res += '*';
            res += "\n";
            if (cells[i][0].isLeftClosed()) {
                res += '|';
            } else {
                res += ' ';
            }
            for (int j = 0; j < cellsSize; j++) {
                res += cells[i][j].value;
                if (cells[i][j].isRightClosed()) {
                    res += '|';
                } else {
                    res += ' ';
                }
            }
            res += '\n';
        }
        for (int i = 0; i < cellsSize; i++) {
            res += '*';
            if (cells[cellsSize - 1][i].isDownClosed()) {
                res += '-';
            } else {
                res += ' ';
            }
        }
        res += "*\n";
        res += "First: " + scores[0] + "   " + "Second: " + scores[1]; 
        return res;
    }
    
    private int getDistance(Edge edge) {
        return Math.abs(edge.x2 - edge.x1) + Math.abs(edge.y2 - edge.y1);
    }
    
    private boolean checkEdgeBounds(Edge edge) {
        if (edge.x1 > vertexesSize || edge.x2 > vertexesSize 
            || edge.y1 > vertexesSize || edge.y2 > vertexesSize) {
            return false;    
        }
        if (edge.x1 < 0 || edge.x2 < 0 || edge.y1 < 0 || edge.y2 < 0) {
            return false;
        }
        return true;
    }
    
    private char getPlayerChar() {
        return (whoseTurn == 0 ? 'F' : 'S');
    }
    
    private void addEdge(Edge edge) {
        edges.add(edge);
        int res = 0;
        if (edge.y1 == edge.y2) {
            if (edge.y1 < cellsSize) {
                cells[edge.x1][edge.y1].closeLeft();
            }
            if (edge.y1 > 0) {
                cells[edge.x1][edge.y1 - 1].closeRight();
                if (cells[edge.x1][edge.y1 - 1].becomeClosed()) {
                    cells[edge.x1][edge.y1 - 1].value = getPlayerChar(); 
                    res++;
                }
            }
        } else {
            if (edge.x1 < cellsSize)
                cells[edge.x1][edge.y1].closeUp();
            if (edge.x1 > 0) {
                cells[edge.x1 - 1][edge.y1].closeDown();
                if (cells[edge.x1 - 1][edge.y1].becomeClosed()) {
                    cells[edge.x1 - 1][edge.y1].value = getPlayerChar();
                    res++;
                }
            }
        }
        if (edge.x1 < cellsSize &&  edge.y1 < cellsSize && cells[edge.x1][edge.y1].becomeClosed()) {
            cells[edge.x1][edge.y1].value = getPlayerChar();
            res++;
        }
        scores[whoseTurn] += res;
    }
    
    public boolean isGameEnded() {
        return (scores[0] + scores[1] == cellsSize * cellsSize);
    }
    
    public String getEndingMessage() {
        if (scores[0] == scores[1]) {
            return "Draw";
        }
        if (scores[0] > scores[1]) {
            return "First player wins";
        } else {
            return "Second player wins";
        }
    }
    
    public boolean makeTurn(int playerNumber, Edge edge) {
        if (playerNumber == whoseTurn) {
            if (getDistance(edge) != 1 || !checkEdgeBounds(edge) || edges.contains(edge)) {
                return false;
            }
            
            int oldScores = scores[0] + scores[1];
            addEdge(edge);
            if (oldScores == scores[0] + scores[1]) {
                whoseTurn = 1 - whoseTurn;
            }
            return true;
        }
        return false;
    }
}
