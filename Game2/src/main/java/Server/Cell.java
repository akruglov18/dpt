/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell)o;
        return this.left == cell.left && this.right == cell.right && this.down == cell.down
               && this.up == cell.up && this.isClosed == cell.isClosed && this.value == cell.value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.left ? 1 : 0);
        hash = 13 * hash + (this.up ? 1 : 0);
        hash = 13 * hash + (this.right ? 1 : 0);
        hash = 13 * hash + (this.down ? 1 : 0);
        hash = 13 * hash + (this.isClosed ? 1 : 0);
        hash = 13 * hash + this.value;
        return hash;
    }
    
    public boolean becomeClosed() {
        if (!isClosed && left && up && right && down) {
            isClosed = true;
            return true;
        }
        return false;
    }
}
