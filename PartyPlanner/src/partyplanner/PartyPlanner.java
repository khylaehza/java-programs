package partyplanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PartyPlanner extends JFrame implements ActionListener{

    private final JMenuBar mainBar = new JMenuBar();
    private final JMenu menu1 = new JMenu("File");
    private final JMenu menu2 = new JMenu("Event Type");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenu adult = new JMenu("Adult");
    private final JMenu child = new JMenu("Child");
    private final JMenuItem adultBday = new JMenuItem("Birthday");
    private final JMenuItem anniv = new JMenuItem("Anniversary");
    private final JMenuItem retirement = new JMenuItem("Retirement");
    private final JMenuItem adultOther = new JMenuItem("Other");
    private final JMenuItem childBday = new JMenuItem("Birthday");
    private final JMenuItem childOther = new JMenuItem("Other");
    private JPanel currentPanel = new JPanel();
    private JPanel otherPanel = new JPanel();
    private JLabel currentLabel = new JLabel();
    private JLabel otherLabel = new JLabel("We have lots of ideas for memorable events");

    public static void main(String[] args) {
        PartyPlanner obj = new PartyPlanner();
        obj.setVisible(true);
        obj.setSize(400, 200);
    }
    
    public PartyPlanner() {
        setTitle("Party Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        composeMenus();
        addActionListener();
        layoutComponents();
    }
    
    public void composeMenus() {
        setJMenuBar(mainBar);
        mainBar.add(menu1);
        mainBar.add(menu2);
        menu1.add(exit);
        menu2.add(adult);
        menu2.add(child);
        adult.add(adultBday);
        adult.add(anniv);
        adult.add(retirement);
        adult.add(adultOther);
        child.add(childBday);
        child.add(childOther);
    }
    
    public void addActionListener() {
        exit.addActionListener(this);
        adultBday.addActionListener(this);
        anniv.addActionListener(this);
        retirement.addActionListener(this);
        adultOther.addActionListener(this);
        childBday.addActionListener(this);
        childOther.addActionListener(this);
    }
    
    public void layoutComponents() {
        currentPanel.add(currentLabel);
        otherPanel.add(otherLabel);
        add(currentPanel);
        add(otherPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == exit)
            System.exit(0);
        else if (src == adultBday) {
            currentLabel.setText("Celebrate another year!");
            currentPanel.setBackground(Color.YELLOW);
        } else if (src == anniv){
            currentLabel.setText("Look forward to golden years!");
            currentPanel.setBackground(Color.ORANGE);
        } else if (src == retirement) {
            currentLabel.setText("Cheers to hardwork!");
            currentPanel.setBackground(Color.GREEN);
        } else if (src == childBday) {
            currentLabel.setText("Throw the best birthday party!");
            currentPanel.setBackground(Color.PINK);
            otherPanel.setBackground(Color.WHITE);
        } else if (src == adultOther || src == childOther) {
            currentLabel.setText(null);
            currentPanel.setBackground(Color.WHITE);
            otherPanel.setBackground(Color.ORANGE);
        }    
    }
}
