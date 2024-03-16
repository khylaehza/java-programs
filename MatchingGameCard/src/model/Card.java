package model;
import controller.CardController;
import javax.swing.*;
import java.awt.event.*;

// Card.java File
public class Card extends JLabel implements MouseListener {
    
    Icon faceIcon;
    Icon backIcon;
    boolean faceUp = false;
    int num;
    int iconWidthHalf, iconHeightHalf;
    boolean mousePressedOnMe = false;
    private final CardController controller;
    
    public Card(CardController controller, Icon face, Icon back, int num) {
        super(back);
        this.faceIcon = face;
        this.backIcon = back;
        this.num = num;
              
        this.addMouseListener(this);
        this.iconHeightHalf = back.getIconHeight() / 2;
        this.iconWidthHalf = face.getIconWidth() / 2;
        this.controller = controller;
    }
    
    public int getNum() { return num; }

    private boolean overIcon(int x, int y) {
        int distX = Math.abs(x-(this.getWidth() / 2));
        int distY = Math.abs(y-(this.getHeight() / 2));
       
        return !(distX > this.iconHeightHalf || distY > this.iconWidthHalf);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (overIcon(e.getX(), e.getY()))
            this.turnUp();
    }
    
    public void turnUp() {
        if (this.faceUp) return;
        this.faceUp = true;
        this.faceUp = this.controller.turnUp(this);
        if (this.faceUp) this.setIcon(this.faceIcon);
    }
    
    public void turnDown() {
        if (!this.faceUp) return;
        this.setIcon(this.backIcon);
        this.faceUp = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (overIcon(e.getX(), e.getY())) 
            this.mousePressedOnMe = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.mousePressedOnMe) {
            this.mousePressedOnMe = false;
            this.mouseClicked(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) {
        this.mousePressedOnMe = false;
    }
}