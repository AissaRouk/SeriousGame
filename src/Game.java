import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;


public class Game extends JPanel {
    Cards cont;
    JLabel counterLabel;
    JPanel clickerPanel;
    JButton upgradeButton;
    JButton autoClickUpgradeButton;
    JLabel upgradeTextLabel1;
    JLabel upgradeTextLabel2;
    JLabel upgradeTextLabel3;
    JLabel upgradeTextLabel4;
    JButton clickerButton;
    JButton gambleButton;
    JButton backButton;
    boolean timerOn = false;

    int creditCounter;
    int clickValue;
    int difficulty = 15;
    Upgrades upg = new Upgrades();
    ImageIcon clickerImage;
    Timer timer;

    Game(Color color){
        clickValue = upg.getClickValue();
        clickerImage = upg.getImage();
        this.setLayout(null);
        this.setBackground(color);
        this.add(createClickerButton(color));
        this.add(createCounterPanel());
        this.add(createUpgradeButton(upg.getText1(), upg.getText2(), 440, 230));
        this.add(createAutoClickUpgradeButton(upg.getText3(), upg.getText4(), 440, 305));
        this.add(createGambleButton(440, 380));
        this.add(createBackButton());
    }
    private JPanel createClickerButton (Color color){
        clickerPanel = new JPanel();
        clickerPanel.setBounds(70, 175, 300, 300);
        clickerPanel.setOpaque(false);

        clickerButton = new JButton();
        clickerButton = new JButton();
        clickerButton.setBorder(null);
        clickerButton.setOpaque(false);
        clickerButton.setContentAreaFilled(false);
        clickerButton.setBackground(color);
        clickerButton.setIcon(clickerImage);
        clickerPanel.add(clickerButton);

        return clickerPanel;
    }
    private JPanel createCounterPanel(){
        JPanel counterPanel = new JPanel();
        counterLabel = new JLabel(String.valueOf(creditCounter), SwingConstants.CENTER);
        JLabel creditLabel = new JLabel("social credits", SwingConstants.CENTER);

        counterPanel.setBounds(70, 75, 300, 100);
        counterPanel.setOpaque(false);
        counterPanel.setLayout(new GridLayout(2, 1));

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
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
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            backButton = new JButton("Back");
            backButton.setFont(font.deriveFont(Font.BOLD, 14));
            backButton.setBackground(Color.white);
            backButton.setBounds(10, 10, 75, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return backButton;
    }
    private JButton createUpgradeButton(String str1, String str2, int x, int y){
        upgradeButton = new JButton();
        upgradeButton.setLayout(new BorderLayout());
        upgradeTextLabel1 = new JLabel(str1, SwingConstants.CENTER);
        upgradeTextLabel2 = new JLabel(str2, SwingConstants.CENTER);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            upgradeTextLabel1.setFont(font.deriveFont(Font.BOLD, 20));
            upgradeTextLabel2.setFont(font.deriveFont(Font.BOLD, 12));
            upgradeTextLabel1.setForeground(Color.black);
            upgradeTextLabel2.setForeground(Color.black);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        upgradeButton.add(BorderLayout.NORTH, upgradeTextLabel1);
        upgradeButton.add(BorderLayout.SOUTH, upgradeTextLabel2);
        upgradeButton.setBounds(x, y, 250, 50);
        upgradeButton.setBackground(Color.white);

        return upgradeButton;
    }
    private JButton createAutoClickUpgradeButton(String str1, String str2, int x, int y){
        autoClickUpgradeButton = new JButton();
        autoClickUpgradeButton.setLayout(new BorderLayout());
        upgradeTextLabel3 = new JLabel(str1, SwingConstants.CENTER);
        upgradeTextLabel4 = new JLabel(str2, SwingConstants.CENTER);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            upgradeTextLabel3.setFont(font.deriveFont(Font.BOLD, 20));
            upgradeTextLabel4.setFont(font.deriveFont(Font.BOLD, 12));
            upgradeTextLabel3.setForeground(Color.black);
            upgradeTextLabel4.setForeground(Color.black);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        autoClickUpgradeButton.add(BorderLayout.NORTH, upgradeTextLabel3);
        autoClickUpgradeButton.add(BorderLayout.SOUTH, upgradeTextLabel4);
        autoClickUpgradeButton.setBounds(x, y, 250, 50);
        autoClickUpgradeButton.setBackground(Color.white);

        return autoClickUpgradeButton;
    }
    private JButton createGambleButton(int x, int y){
        gambleButton = new JButton("Gamble");;
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            gambleButton.setFont(font.deriveFont(Font.BOLD, 20));
            gambleButton.setForeground(Color.black);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        gambleButton.setBounds(x, y, 250, 50);
        gambleButton.setBackground(Color.white);
        return gambleButton;
    }
    public void run(Cards cont){
        this.cont = cont;
        CreditHandler userClick = new CreditHandler();
        clickerButton.addActionListener(userClick);
        UpgradeHandler upgradeClick = new UpgradeHandler();
        upgradeButton.addActionListener(upgradeClick);
        upgradeButton.setActionCommand("clickUpgrade");
        autoClickUpgradeButton.addActionListener(upgradeClick);
        autoClickUpgradeButton.setActionCommand("autoClickUpgrade");
        GambleClick gambleClick = new GambleClick();
        gambleButton.addActionListener(gambleClick);
        BackButton backClick = new BackButton();
        backButton.addActionListener(backClick);
    }
    private void setTimer(int perSecond){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditCounter += perSecond;
                counterLabel.setText(String.valueOf(creditCounter));
            }
        });
    }
    private void UpdateTimer(){
        if(timerOn == false){
            timerOn = true;
        }
        else if(timerOn == true){
            timer.stop();
        }

        setTimer(upg.getPerSecondValue());
        timer.start();

    }
    public int getCreditCounter() {
        return creditCounter;
    }
    public void setCreditCounter(int creditCounter){
        this.creditCounter = creditCounter;
        counterLabel.setText(String.valueOf(creditCounter));
    }
    public class CreditHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            creditCounter += clickValue;
            counterLabel.setText(String.valueOf(creditCounter));
        }
    }
    public class UpgradeHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            switch(action){
                case "clickUpgrade":
                    if(creditCounter >= upg.getUpgradeCost()) {
                        upg.clickUpgradeManger();
                        clickValue = upg.getClickValue();
                        clickerButton.setIcon(upg.getImage());
                        creditCounter = creditCounter - upg.getUpgradeCost();
                        counterLabel.setText(String.valueOf(creditCounter));
                        upg.setUpgradeCost(upg.getUpgradeCost() * difficulty);
                        upgradeTextLabel1.setText(upg.getText1());
                        upgradeTextLabel2.setText(upg.getText2());
                    }
                    else{
                        JOptionPane.showMessageDialog(cont, "Not enough social credits :(");
                    }
                    if(upg.getUpgradeIndex() == 8){
                        upgradeButton.setEnabled(false);
                    }
                    break;
                case "autoClickUpgrade":
                    if(creditCounter >= upg.getAutoUpgradeCost()) {
                        upg.autoClickManager();
                        UpdateTimer();
                        creditCounter = creditCounter - upg.getAutoUpgradeCost();
                        counterLabel.setText(String.valueOf(creditCounter));
                        upg.setAutoUpgradeCost(upg.getAutoUpgradeCost() * difficulty);
                        upgradeTextLabel3.setText(upg.getText3());
                        upgradeTextLabel4.setText(upg.getText4());
                    }
                    else{
                        JOptionPane.showMessageDialog(cont, "Not enough social credits :(");
                    }
                    if(upg.getAutoClickUpgradeIndex() == 8){
                        autoClickUpgradeButton.setEnabled(false);
                    }
                    break;
            }
        }
    }
    public class GambleClick implements ActionListener {
        public void actionPerformed(ActionEvent gambleClick) {
            cont.gamble();
        }
    }
    public class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent backClick) {
            cont.back();
        }
    }
}
