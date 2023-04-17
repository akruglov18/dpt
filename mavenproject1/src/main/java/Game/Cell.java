/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

/**
 *
 * @author acer
 */
public class Cell {
    private boolean left, up, right, down;
    private boolean isClosed;
    public char value;
    public Cell() {
        this.left = false;
        this.up = false;
        this.right = false;
        this.down = false;
        this.isClosed = false;
        this.value = ' ';
    }
    
    public void closeLeft() {
        left = true;
    }
    
    public void closeUp() {
        up = true;
    }
    
    public void closeRight() {
        right = true;
    }
    
    public void closeDown() {
        down = true;
    }
    
    public boolean isLeftClosed() {
        return left;
    }
    
    public boolean isRightClosed() {
        return right;
    }
    
    public boolean isUpClosed() {
        return up;
    }
    
    public boolean isDownClosed() {
        return down;
    }
    
    public boolean becomeClosed() {
        if (!isClosed && left && up && right && down) {
            isClosed = true;
            return true;
        }
        return false;
    }
}
