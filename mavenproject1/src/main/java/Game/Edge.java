/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.io.Serializable;
import java.util.Collections;

/**
 *
 * @author acer
 */
public class Edge implements Serializable, Comparable<Edge>{
    public int x1, y1, x2, y2;

    public Edge(int x1, int y1, int x2, int y2) {
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
    
    private void init(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
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
}
