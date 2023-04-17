/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author acer
 */
public class Turn implements Serializable {
    public Edge edge;
    public String clientServerName;
    
    public Turn() {
        this.edge =  null;
        this.clientServerName = null;
    }
    
    public Turn(Edge edge, String name) {
        this.edge = edge;
        this.clientServerName = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turn turn = (Turn)o;
        return this.edge.equals(turn.edge) && this. clientServerName.equals(turn.clientServerName);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.edge);
        hash = 67 * hash + Objects.hashCode(this.clientServerName);
        return hash;
    }
}
