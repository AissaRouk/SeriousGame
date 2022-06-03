import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Main {
    int creditCounter;
    int click = 1;
    String image = "smile.png";
    ImageIcon clickerImage = new ImageIcon(Main.class.getClassLoader().getResource(image));
    //Buttons
    JButton clickerButton;
    JButton upgrade1Button;
    JButton upgrade2Button;
    JButton upgrade3Button;
    //---------------------------------------------------------------------
    JLabel counterLabel;
    Font font;

    //ActionListeners
    CreditHandler userclick = new CreditHandler();
    Upgrade1Handler upgrade1click = new Upgrade1Handler();
    Upgrade2Handler upgrade2click = new Upgrade2Handler();
    Upgrade3Handler upgrade3click = new Upgrade3Handler();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        creditCounter = 0;
        createFont();
        createUI();
    }
    public void createFont(){
        font = new Font("Comic Sans MS", Font.PLAIN, 32);
    }

    private class Upgrade1 {
        String uimage = "wok.png";

        public void setClick(){
            click = 2;
        }
        public String getImage(){
            return uimage;
        }
        public void setImage(){
            image = "wok.png";
        }
    }
    private class Upgrade2 {
        String uimage = "xina.png";

        public void setClick(){
            click = 5;
        }
        public String getImage(){
            return uimage;
        }
        public void setImage(){
            image = "xina.png";
        }
    }
    private class Upgrade3 {
        String uimage = "eggman.png";

        public void setClick(){
            click = 10;
        }
        public String getImage(){
            return uimage;
        }
        public void setImage(){
            image = "eggman.png";
        }
    }

    public void createUI(){
        //Game window
        JFrame window = new JFrame("BingChilling Clicker Game 4000 LIMITED EDITION (WARNING: EMOTIONAL DAMAGE).exe");
        ImageIcon frameImage  = new ImageIcon(Main.class.getClassLoader().getResource("icon.png"));
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(204, 48, 48, 255);
        window.getContentPane().setBackground(color);
        window.setLayout(null);
        window.setIconImage(frameImage.getImage());
        //---------------------------------------------

        //Button for registering clicks
        JPanel clickerPanel = new JPanel();
        clickerPanel.setBounds(100, 200, 210, 215);
        clickerPanel.setOpaque(false);
        window.add(clickerPanel);

        clickerButton = new JButton();
        clickerButton.setBorder(null);
        clickerButton.setOpaque(false);
        clickerButton.setContentAreaFilled(true);
        clickerButton.setBackground(color);
        clickerButton.setIcon(clickerImage);
        clickerButton.addActionListener(userclick);
        clickerPanel.add(clickerButton);
        //---------------------------------------------

        //Upgrade buttons

        upgrade1Button = new JButton();
        upgrade1Button.setLayout(new BorderLayout());
        JLabel label1 = new JLabel("The Wok upgrade uwu", SwingConstants.CENTER);
        JLabel label2 = new JLabel("10 social credits", SwingConstants.CENTER);
        upgrade1Button.add(BorderLayout.NORTH,label1);
        upgrade1Button.add(BorderLayout.SOUTH,label2);
        upgrade1Button.setBounds(450, 150, 200, 50);
        upgrade1Button.addActionListener(upgrade1click);
        window.add(upgrade1Button);

        upgrade2Button = new JButton();
        upgrade2Button.setLayout(new BorderLayout());
        JLabel label3 = new JLabel("Zhong Xina upgrade owo", SwingConstants.CENTER);
        JLabel label4 = new JLabel("50 social credits", SwingConstants.CENTER);
        upgrade2Button.add(BorderLayout.NORTH,label3);
        upgrade2Button.add(BorderLayout.SOUTH,label4);
        upgrade2Button.setBounds(450, 250, 200, 50);
        upgrade2Button.addActionListener(upgrade2click);
        window.add(upgrade2Button);

        upgrade3Button = new JButton();
        upgrade3Button.setLayout(new BorderLayout());
        JLabel label5 = new JLabel("Eggman upgrade ara ara", SwingConstants.CENTER);
        JLabel label6 = new JLabel("100 social credits", SwingConstants.CENTER);
        upgrade3Button.add(BorderLayout.NORTH,label5);
        upgrade3Button.add(BorderLayout.SOUTH,label6);
        upgrade3Button.setBounds(450, 350, 200, 50);
        upgrade3Button.addActionListener(upgrade3click);
        window.add(upgrade3Button);
        //---------------------------------------------

        //Panel for seeing click count
        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(76, 100, 250, 100);
        counterPanel.setBackground(color);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);

        counterLabel = new JLabel(String.valueOf(creditCounter), SwingConstants.CENTER);
        JLabel creditLabel = new JLabel("social credits", SwingConstants.CENTER);
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font);
        creditLabel.setForeground(Color.white);
        creditLabel.setFont(font);
        counterPanel.add(counterLabel);
        counterPanel.add(creditLabel);
        //---------------------------------------------
        window.setVisible(true);
    }
    public class CreditHandler implements ActionListener {
        public void actionPerformed(ActionEvent upgrade1click) {
            creditCounter += click;
            counterLabel.setText(String.valueOf(creditCounter));
        }
    }
    public class Upgrade1Handler implements ActionListener {
        public void actionPerformed(ActionEvent upgrade1click) {
            Upgrade1 upgrade = new Upgrade1();
            if(creditCounter >= 10){
                creditCounter = creditCounter - 10;
                counterLabel.setText(String.valueOf(creditCounter));
                upgrade.setClick();
                upgrade.setImage();
                ImageIcon clickerImage = new ImageIcon(Main.class.getClassLoader().getResource(upgrade.getImage()));
                clickerButton.setIcon(clickerImage);
                upgrade1Button.setEnabled(false);
                upgrade1Button.setBackground(Color.green);
            }
        }
    }
    public class Upgrade2Handler implements ActionListener {
        public void actionPerformed(ActionEvent upgrade2click) {
            if(creditCounter >= 50) {
                creditCounter = creditCounter - 50;
                counterLabel.setText(String.valueOf(creditCounter));
                Upgrade2 upgrade = new Upgrade2();
                upgrade.setClick();
                upgrade.setImage();
                ImageIcon clickerImage = new ImageIcon(Main.class.getClassLoader().getResource(upgrade.getImage()));
                clickerButton.setIcon(clickerImage);
                upgrade2Button.setEnabled(false);
                upgrade2Button.setBackground(Color.green);
            }
        }
    }
    public class Upgrade3Handler implements ActionListener {
        public void actionPerformed(ActionEvent upgrade3click) {
            if(creditCounter >= 100) {
                creditCounter = creditCounter - 100;
                counterLabel.setText(String.valueOf(creditCounter));
                Upgrade3 upgrade = new Upgrade3();
                upgrade.setClick();
                upgrade.setImage();
                ImageIcon clickerImage = new ImageIcon(Main.class.getClassLoader().getResource(upgrade.getImage()));
                clickerButton.setIcon(clickerImage);
                upgrade3Button.setEnabled(false);
                upgrade3Button.setBackground(Color.green);
            }
        }
    }
}
