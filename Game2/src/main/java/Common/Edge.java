/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.io.Serializable;
import java.util.Collections;

/**
 *
 * @author acer
 */
public class Edge implements Serializable, Comparable<Edge>{
    public int x1, y1, x2, y2;
    
    public Edge() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    public Edge(int x1, int y1, int x2, int y2) {
        setNormalize(x1, y1, x2 ,y2);
    }
    
    private void init(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public final void setNormalize(int x1, int y1, int x2, int y2) {
        if (x1 != x2) {
            if (x1 < x2) {
                init(x1, y1, x2, y2);
            } else {
                init(x2, y2, x1, y1);
            }
        } else if (y1 != y2) {
            if (y1 < y2) {
                init(x1, y1, x2, y2);
            } else {
                init(x2, y2, x1, y1);
            }
        } else {
            init(x1, y1, x2, y2);
        }
    }
    
    @Override
    public int compareTo(Edge other) {
        if (x1 != other.x1) {
            return Integer.compare(x1, other.x1);
        }
        if (y1 != other.y1) {
            return Integer.compare(y1, other.y1);
        }
        if (x2 != other.x2) {
            return Integer.compare(x2, other.x2);
        }
        if (y2 != other.y2) {
            return Integer.compare(y2, other.y2);
        }
        return 0;
    } 
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge)o;
        return this.x1 == edge.x1 && this.x2 == edge.x2 
                && this.y1 == edge.y1 && this.y2 == edge.y2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.x1;
        hash = 41 * hash + this.y1;
        hash = 41 * hash + this.x2;
        hash = 41 * hash + this.y2;
        return hash;
    }
}
