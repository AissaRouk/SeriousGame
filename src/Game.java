import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Game extends JPanel {
    Cards cont;
    JLabel counterLabel;
    JPanel clickerPanel;
    JButton upgradeButton;
    JLabel upgradeTextLabel1;
    JLabel upgradeTextLabel2;
    JButton clickerButton;
    JButton backButton;

    int creditCounter = 0;
    int clickValue;
    Upgrades upg = new Upgrades();
    ImageIcon clickerImage;

    Game(Color color){
        clickValue = upg.getClickValue();
        clickerImage = upg.getImage();
        this.setLayout(null);
        this.setBackground(color);
        this.add(createClickerButton(color));
        this.add(createCounterPanel());
        this.add(createUpgradeButton(upg.getText1(), upg.getText2(), 450, 200));
        this.add(createBackButton());
    }
    private JPanel createClickerButton (Color color){
        clickerPanel = new JPanel();
        clickerPanel.setBounds(100, 200, 210, 215);
        clickerPanel.setOpaque(false);

        clickerButton = new JButton();
        clickerButton = new JButton();
        clickerButton.setBorder(null);
        clickerButton.setOpaque(false);
        clickerButton.setContentAreaFilled(true);
        clickerButton.setBackground(color);
        clickerButton.setIcon(clickerImage);
        clickerPanel.add(clickerButton);

        return clickerPanel;
    }
    private JPanel createCounterPanel(){
        JPanel counterPanel = new JPanel();
        counterLabel = new JLabel(String.valueOf(creditCounter), SwingConstants.CENTER);
        JLabel creditLabel = new JLabel("social credits", SwingConstants.CENTER);

        counterPanel.setBounds(76, 100, 250, 100);
        counterPanel.setOpaque(false);
        counterPanel.setLayout(new GridLayout(2, 1));

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("font.ttf"));
            counterLabel.setForeground(Color.black);
            counterLabel.setFont(font.deriveFont(Font.BOLD, 36));
            creditLabel.setForeground(Color.black);
            creditLabel.setFont(font.deriveFont(Font.BOLD, 24));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        counterPanel.add(counterLabel);
        counterPanel.add(creditLabel);

        return counterPanel;
    }
    private JButton createBackButton(){
        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 75, 50);
        return backButton;
    }
    private JButton createUpgradeButton(String str1, String str2, int x, int y){
        upgradeButton = new JButton();
        upgradeButton.setLayout(new BorderLayout());
        upgradeTextLabel1 = new JLabel(str1, SwingConstants.CENTER);
        upgradeTextLabel2 = new JLabel(str2, SwingConstants.CENTER);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("font.ttf"));
            upgradeTextLabel1.setFont(font.deriveFont(Font.BOLD, 24));
            upgradeTextLabel2.setFont(font.deriveFont(Font.BOLD, 12));
            upgradeTextLabel1.setForeground(Color.white);
            upgradeTextLabel2.setForeground(Color.white);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        upgradeButton.add(BorderLayout.NORTH, upgradeTextLabel1);
        upgradeButton.add(BorderLayout.SOUTH, upgradeTextLabel2);
        upgradeButton.setBounds(x, y, 200, 50);
        upgradeButton.setBackground(Color.black);

        return upgradeButton;
    }
    private void changeButtonText(){
        upgradeTextLabel1.setText(upg.getText1());
        upgradeTextLabel2.setText(upg.getText2());
    }
    public void run(Cards cont){
        this.cont = cont;
        CreditHandler userClick = new CreditHandler();
        clickerButton.addActionListener(userClick);
        UpgradeHandler upgradeClick = new UpgradeHandler();
        upgradeButton.addActionListener(upgradeClick);
        BackButton backClick = new BackButton();
        backButton.addActionListener(backClick);

    }
    public class CreditHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            creditCounter += clickValue;
            counterLabel.setText(String.valueOf(creditCounter));
        }
    }
    public class UpgradeHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(creditCounter >= upg.getUpgradeCost()) {
                upg.upgradeManger();
                clickValue = upg.getClickValue();
                clickerButton.setIcon(upg.getImage());
                creditCounter = creditCounter - upg.getUpgradeCost();
                counterLabel.setText(String.valueOf(creditCounter));
                upg.setUpgradeCost(upg.getUpgradeCost() * 5);
                changeButtonText();
            }
            else{
                JOptionPane.showMessageDialog(cont, "Not enough social credits :(");
            }
        }
    }
    public class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cont.back();
        }
    }
}
