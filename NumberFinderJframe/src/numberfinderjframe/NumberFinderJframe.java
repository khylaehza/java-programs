/*
 * Name: Khyla Ehza Hondrade
 * Activity: 07 Hands-on Activity 1
 * Description: Number Finder with JFrame and MouseListener
 * Date Submitted: 12/7/2021
 */

package numberfinderjframe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class NumberFinderJframe extends JFrame implements MouseListener{

     FlowLayout fl = new FlowLayout();
     Font font1 = new Font("Arial", Font.BOLD, 100);
     Font font2 = new Font("Century", Font.BOLD, 20);
     JLabel num[] = new JLabel[10];    
     JLabel result = new JLabel("");    
     Random randomObj = new Random();
     int randomNum = randomObj.nextInt(9) + 1;
     int userRandomNum, guessAttempt = 0;
     boolean enabled = true;
	    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (enabled) {          
            for(int i = 1; i < 10; i++) {
                boolean randEqualsLabel = num[i].getText().equals(String.valueOf(randomNum));
                if(e.getSource() == num[i] && randEqualsLabel) {
	            num[i].setForeground(Color.red);
	            result.setText("Correct! " + guessAttempt + " attempt(s)");
	            enabled = false;
	            break;
                } else if (e.getSource() == num[i] && !randEqualsLabel && num[i].isEnabled()) {
	            guessAttempt += 1;
	            num[i].setEnabled(false);
	            result.setText("Try Again.");  
	        }
	    }
        }
    }
	
    @Override
    public void mousePressed(MouseEvent e) { }
	
    @Override
    public void mouseReleased(MouseEvent e) { }
	
    @Override
    public void mouseEntered(MouseEvent e) { }
	
    @Override
    public void mouseExited(MouseEvent e) { } 
            
    public NumberFinderJframe() {
	super("Number Finder");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(fl);
	        
	for(int i = 1; i < 10; i++) {
	   num[i] = new JLabel("" + i);
	   num[i].setFont(font1);
	   num[i].addMouseListener(this);
	   add(num[i]);
	}              
	  result.setFont(font2);        
	  add(result);
    }
    
    public static void main(String[] args) {
        NumberFinderJframe NumberFinder = new NumberFinderJframe();
	NumberFinder.setVisible(true);
	NumberFinder.setSize(600, 200);
	NumberFinder.setVisible(true);
    }
}
