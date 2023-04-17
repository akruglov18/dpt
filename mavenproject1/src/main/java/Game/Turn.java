/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.io.Serializable;

/**
 *
 * @author acer
 */
public class Turn implements Serializable {
    public Edge edge;
    public String clientServerName;
    public Turn(Edge edge, String name) {
        this.edge = edge;
        this.clientServerName = name;
    }
}
