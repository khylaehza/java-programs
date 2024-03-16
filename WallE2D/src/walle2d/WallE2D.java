/*
 * Name: Khyla Ehza Hondrade
 * Activity: 09 Hands-on Activity 1
 * Description: Java Drawing with lines and shapes
 * Date Submitted: 2/1/2022
 */
package walle2d;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class WallE2D extends JFrame{

    Font font = new Font("Monospaced", Font.BOLD, 15);
    String character = "WALL - E";
    
    public static void main(String[] args) {
        WallE2D frame = new WallE2D();
        frame.setSize(800, 800);
        frame.setTitle("Wall-E from Disney and PIXAR");
        frame.setVisible(true);
    }
    
    @Override
    public void paint(Graphics draw) {
        super.paint(draw);
        
        // neck
        draw.setColor(new Color(123,84,59));
        draw.fillRoundRect(350, 320, 30, 30, 5, 5);
        draw.fillRect(360, 260, 10, 60);
        draw.setColor(Color.BLACK);
        draw.drawRoundRect(350, 320, 30, 30, 5, 5);
        draw.drawRect(360, 260, 10, 60);
        draw.drawRect(345, 252, 45, 30); 
        draw.setColor(new Color(85,60,43));
        draw.fillRect(345, 252, 45, 30);
        
        // eyes
        Graphics2D rightEye = (Graphics2D) draw.create();
        rightEye.setColor(new Color(183,199,210));       
        rightEye.rotate(-60, 320, 270);
        rightEye.fillRoundRect(290, 250, 60, 40, 10, 10);
        rightEye.setColor(Color.BLACK); 
        rightEye.drawRoundRect(290, 250, 60, 40, 10, 10);
        
        Graphics2D leftEye = (Graphics2D) draw.create();
        leftEye.setColor(new Color(183,199,210));
        leftEye.rotate(60, 413, 270);
        leftEye.fillRoundRect(383, 250, 60, 40, 10, 10);
        leftEye.setColor(Color.BLACK);
        leftEye.drawRoundRect(383, 250, 60, 40, 10, 10);
        
        draw.setColor(Color.BLACK);
        draw.drawArc(303, 250, 38, 38, 200, 360);
        draw.drawArc(392, 250, 38, 38, 200, 360);
        draw.fillArc(307, 254, 30, 30, 200, 360);
        draw.fillArc(396, 254, 30, 30, 200, 360);
        
        // shoulders
        Path2D rightShoulder = new Path2D.Double();
        rightShoulder.moveTo(273, 350);
        rightShoulder.lineTo(240, 388);
        rightShoulder.lineTo(290, 388);
        rightShoulder.closePath();
        
        Path2D leftShoulder = new Path2D.Double();
        leftShoulder.moveTo(467, 350);
        leftShoulder.lineTo(240, 388);
        leftShoulder.lineTo(500, 388);
        leftShoulder.closePath();
        
        Graphics2D shoulder = (Graphics2D) draw.create();
        draw.setColor(Color.BLACK);
        shoulder.draw(rightShoulder);
        shoulder.draw(leftShoulder);
        shoulder.setColor(new Color(120,153,164));
        shoulder.fill(rightShoulder);
        shoulder.fill(leftShoulder);            
        
        //body
        draw.setColor(new Color(233,183,31));
        draw.fillRoundRect(270, 350, 200, 200, 15, 15);        
        draw.setColor(Color.BLACK);
        draw.drawRoundRect(270, 350, 200, 200, 15, 15);
        draw.drawLine(270, 390, 470, 390);
        draw.drawLine(395, 360, 450, 360);
        draw.drawLine(395, 370, 450, 370);
        draw.drawLine(395, 380, 450, 380);       
        draw.fillRect(285, 358, 100, 25);
               
        // hands
        Path2D leftHand = new Path2D.Double();
        leftHand.moveTo(240, 388);
        leftHand.lineTo(240, 442);
        leftHand.lineTo(310, 442);
        leftHand.lineTo(310, 420);
        leftHand.lineTo(260, 420);
        leftHand.lineTo(260, 410);
        leftHand.lineTo(310, 410);
        leftHand.lineTo(310, 388);
        leftHand.closePath();
        
        Path2D rightHand = new Path2D.Double();
        rightHand.moveTo(500, 388);
        rightHand.lineTo(500, 442);
        rightHand.lineTo(430, 442);
        rightHand.lineTo(430, 420);
        rightHand.lineTo(480, 420);
        rightHand.lineTo(480, 410);
        rightHand.lineTo(430, 410);
        rightHand.lineTo(430, 388);
        rightHand.closePath();
        
        draw.fillRect(250, 410, 50, 10);
        draw.fillRect(440, 410, 50, 10);
            
        Graphics2D hands = (Graphics2D) draw;
        hands.setColor(new Color(183,199,210));
        hands.fill(leftHand);
        hands.fill(rightHand);
        hands.setColor(Color.BLACK);
        hands.draw(leftHand);
        hands.draw(rightHand);
        
        // wheels
        draw.setColor(new Color(127,130,133));
        draw.fillRoundRect(180, 480, 90, 150, 20, 20);
        draw.fillRoundRect(470, 480, 90, 150, 20, 20);
        draw.setColor(Color.BLACK);
        draw.drawRoundRect(180, 480, 90, 150, 20, 20);
        draw.drawRoundRect(470, 480, 90, 150, 20, 20);        
        draw.drawLine(180, 515, 270, 515);
        draw.drawLine(180, 555, 270, 555);
        draw.drawLine(180, 595, 270, 595);
        draw.drawLine(470, 515, 560, 515);
        draw.drawLine(470, 555, 560, 555);
        draw.drawLine(470, 595, 560, 595);

        // name
        draw.setColor(new Color(138,0,0));
        draw.setFont(font);
        draw.drawString(character, 383, 535);
    }
}
