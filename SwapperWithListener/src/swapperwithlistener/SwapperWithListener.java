/*
 * Name: Khyla Ehza Hondrade
 * Activity: 07 Hands-on Activity 2
 * Description: Checker and Swapper with ActionListener GUI
 * Date Submitted: 12/9/2021
 */

package swapperwithlistener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SwapperWithListener {

    public static void main(String[] args) {
        RunCheckerSwapper rcsObj = new RunCheckerSwapper();       
        rcsObj.setTitle("Checker and Swapper");
        rcsObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rcsObj.setSize(250, 200);
        rcsObj.setVisible(true);  
    }
}

class RunCheckerSwapper extends JFrame implements ActionListener {
        
    FlowLayout layout = new FlowLayout();
    JTextField txtField1 = new JTextField(13);
    JTextField txtField2 = new JTextField(13);    
    JButton btCheck = new JButton("CHECK");
    JButton btSwap = new JButton("SWAP");
    JLabel lblResult = new JLabel();
    Font font = new Font("Arial", Font.BOLD, 25);
    
    public RunCheckerSwapper() {
        setLayout(layout);
        add(txtField1);
        add(btCheck);
        add(txtField2);       
        add(btSwap);
        add(lblResult);
        lblResult.setFont(font);
        
        btCheck.addActionListener(this);
        btSwap.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String output;
        if(e.getSource() == btCheck) {
            output = txtField1.getText().equals(txtField2.getText()) ? "SAME" : "NOT THE SAME";
            lblResult.setText(output);
        } else if(e.getSource() == btSwap) {
            String input1 = txtField1.getText();
            String input2 = txtField2.getText();
            String tempInput = input1;
            txtField1.setText(input2);
            txtField2.setText(tempInput);
        }          
    }   
}