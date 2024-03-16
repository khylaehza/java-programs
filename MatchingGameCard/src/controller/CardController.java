package controller;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import model.Card;

// CardController.java File
public class CardController implements ActionListener {
    public final Vector turnedCards;
    private final Timer turnDownTimer;
    private final int turnDownDelay = 300;
    int score = 0;
    int attempts = 0;
        
    public CardController() {
        this.turnedCards = new Vector(2);
        this.turnDownTimer = new Timer(this.turnDownDelay, this);
        this.turnDownTimer.setRepeats(false);
    }
    
    public boolean turnUp(Card card) {
        if (this.turnedCards.size() < 2) return doAddCard(card);
        return false;
    }
    
    public void AllTurned() {
        //MainFrame objInside = new MainFrame();
        //objInside.setVisible(false);
        JOptionPane.showMessageDialog(null, "Congratulations "  + "! you finished the game with " + attempts + " attempts.");       
        System.exit(0);
    }    
    
    private boolean doAddCard(Card card) {
        this.turnedCards.add(card);
        if (this.turnedCards.size() == 2) {
            Card otherCard = (Card) this.turnedCards.get(0);
            if (otherCard.getNum() == card.getNum()) {
                this.turnedCards.clear();
                score++;
                if(score == 8) {
                    AllTurned();
                }
            } else {
                attempts++;
                this.turnDownTimer.start();
            }
        } 
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < turnedCards.size(); i++) {
            Card card = (Card) this.turnedCards.get(i);
            card.turnDown();
        }
        this.turnedCards.clear();
    }
}