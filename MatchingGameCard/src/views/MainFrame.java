package views;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import controller.CardController;
import model.Card;

// MainFrame.java File
public class MainFrame extends JFrame{
    private ImageIcon cardIcon[];
    Container mainContentPane;
    ImageIcon imageArray[]; 
    
    public MainFrame() {
        super("Matching Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        mainContentPane = getContentPane();
        mainContentPane.setLayout(new BoxLayout(this.mainContentPane, BoxLayout.PAGE_AXIS));
        
        MainMenu mnObj = new MainMenu();
        mainContentPane.add(mnObj.mainMenu());
        setVisible(true);           
    }
    
    private ImageIcon[] loadCardIcons() {
        ImageIcon icon[] = new ImageIcon[9];
        for(int i = 0; i < 9; i++) {
            String fileName = "images/card" + i + ".png";
            icon[i] = new ImageIcon(fileName);
        } return icon;
    }
        
    public JPanel makeCards() {
        JPanel panel = new JPanel(new GridLayout(4, 4));
        cardIcon = loadCardIcons();
        ImageIcon backIcon = this.cardIcon[8];
        CardController controller = new CardController();
        int cardsToAdd[] = new int[16];
        
        for(int i = 0; i < 8; i++) {
            cardsToAdd[2 *i] = i;
            cardsToAdd[2 *i + 1] = i;
        }

        randomizeCardArray(cardsToAdd);       
        for (int i = 0; i < cardsToAdd.length; i++) {
            int num = cardsToAdd[i];
            Card newCard = new Card(controller, this.cardIcon[num], backIcon, num);
            panel.add(newCard);
        } return panel;
    }
        
    private void randomizeCardArray(int[] t) {
        Random randomizer = new Random();
        for (int i = 0; i < t.length; i++) {
            int d = randomizer.nextInt(t.length);
            int s = t[d];
            t[d] = t[i];
            t[i] = s;
        }
    }
            
    public class MainMenu implements MouseListener, KeyListener {
        JPanel mainPanel = new JPanel(new GridBagLayout()); 
        Font lbl1Font = new Font("Arial", Font.BOLD, 24);
        Font lbl2Font = new Font("Arial", Font.BOLD, 48);
        Font lbl3Font = new Font("Arial", Font.PLAIN, 18);
        JLabel welcomeTxt = new JLabel("WELCOME TO");
        JLabel gameTitleTxt = new JLabel("MATCHING GAME");
        public JTextField nameBox = new JTextField("Enter your name", 14);
        JLabel greetingsTxt = new JLabel();
        JLabel spaceTxt = new JLabel("                      ");
        JCheckBox checkedData = new JCheckBox("Save Data", false);
        JComboBox<String> comboPlayer = new JComboBox<>(new String[] {"Old Player", "New Player"});
        JLabel infoTxt = new JLabel("Press ENTER to continue...");
        public String name = "";    
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
        public JPanel mainMenu() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.ipady = 20;

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            mainPanel.add(welcomeTxt, gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 3;
            mainPanel.add(gameTitleTxt, gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 3;
            mainPanel.add(nameBox , gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 3;
            mainPanel.add(greetingsTxt , gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipady = 10;
            gbc.gridy = 4;
            gbc.gridx = 0;
            gbc.gridwidth  = 1;
            mainPanel.add(checkedData, gbc);        

            gbc.gridx = 1;
            gbc.gridwidth  = 1;
            mainPanel.add(spaceTxt, gbc);

            gbc.gridx = 2;
            gbc.gridwidth  = 1;
            mainPanel.add(comboPlayer, gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipady = 20;
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 3;
            mainPanel.add(infoTxt, gbc);

            welcomeTxt.setFont(lbl1Font);
            gameTitleTxt.setFont(lbl2Font);
            gameTitleTxt.setFont(lbl2Font);
            nameBox.setFont(lbl3Font);
            welcomeTxt.setHorizontalAlignment(JLabel.CENTER);
            greetingsTxt.setHorizontalAlignment(JLabel.CENTER);
            infoTxt.setHorizontalAlignment(JLabel.CENTER);
            nameBox.setHorizontalAlignment(JTextField.CENTER);

            nameBox.addMouseListener(this);
            nameBox.addKeyListener(this);
            return mainPanel;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == nameBox)
                nameBox.setText("");
         }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getSource() == nameBox)
                greetingsTxt.setText("Hi, " + nameBox.getText() + "! Enjoy the Game!");                     
         }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {               
                setName(nameBox.getText());
            }                       
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                mainContentPane.removeAll();
                mainContentPane.add(makeCards());
                setVisible(true);
            } 
        }      
    }    
}