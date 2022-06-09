import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class Main {
    JFrame window;
    int creditCounter = 0;
    int clickValue = 1;
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
    Color color;
    //Cards
    CardLayout cards;
    JPanel cardCont;
    JPanel mainMenu;
    JPanel game;
    JPanel options;


    //ActionListeners
    CreditHandler userclick = new CreditHandler();
    Upgrade1Handler upgrade1click = new Upgrade1Handler();
    Upgrade2Handler upgrade2click = new Upgrade2Handler();
    Upgrade3Handler upgrade3click = new Upgrade3Handler();
    PlayButton playClick = new PlayButton();
    OptionsButton optionsClick = new OptionsButton();
    ExitButton exitClick = new ExitButton();
    BackButton backClick = new BackButton();
    Color1 color1click = new Color1();
    Color2 color2click = new Color2();
    Color3 color3click = new Color3();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        createFont();
        createColor();
        createUI();
        createMainMenu();
        createOptions();
        createWindow();
    }

    public void createFont() {
        font = new Font("Comic Sans MS", Font.PLAIN, 32);
    }

    public void createColor() {
        color = new Color(204, 48, 48, 255);
    }

    private class Upgrade1 {
        String uimage = "wok.png";

        public void setClick() {
            clickValue = 2;
        }

        public String getImage() {
            return uimage;
        }

        public void setImage() {
            image = "wok.png";
        }
    }

    private class Upgrade2 {
        String uimage = "xina.png";

        public void setClick() {
            clickValue = 5;
        }

        public String getImage() {
            return uimage;
        }

        public void setImage() {
            image = "xina.png";
        }
    }

    private class Upgrade3 {
        String uimage = "eggman.png";

        public void setClick() {
            clickValue = 10;
        }

        public String getImage() {
            return uimage;
        }

        public void setImage() {
            image = "eggman.png";
        }
    }

    public void createWindow() {
        window = new JFrame("BingChilling Clicker Game 4000 LIMITED EDITION (WARNING: EMOTIONAL DAMAGE).exe");
        cardCont = new JPanel();
        cards = new CardLayout();
        cardCont.setLayout(cards);
        cardCont.add(mainMenu, "1");
        cardCont.add(game, "2");
        cardCont.add(options, "3");
        cards.show(cardCont, "1");
        ImageIcon frameImage = new ImageIcon(Main.class.getClassLoader().getResource("icon.png"));
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setIconImage(frameImage.getImage());
        window.add(cardCont);
        window.setVisible(true);

        window.add(cardCont);
    }

    public void createUI() {
        game = new JPanel();
        game.setLayout(null);
        game.setBackground(color);
        //Button for registering clicks
        JPanel clickerPanel = new JPanel();
        clickerPanel.setBounds(100, 200, 210, 215);
        clickerPanel.setOpaque(false);
        game.add(clickerPanel);

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
        upgrade1Button.add(BorderLayout.NORTH, label1);
        upgrade1Button.add(BorderLayout.SOUTH, label2);
        upgrade1Button.setBounds(450, 150, 200, 50);
        upgrade1Button.addActionListener(upgrade1click);
        game.add(upgrade1Button);

        upgrade2Button = new JButton();
        upgrade2Button.setLayout(new BorderLayout());
        JLabel label3 = new JLabel("Zhong Xina upgrade owo", SwingConstants.CENTER);
        JLabel label4 = new JLabel("50 social credits", SwingConstants.CENTER);
        upgrade2Button.add(BorderLayout.NORTH, label3);
        upgrade2Button.add(BorderLayout.SOUTH, label4);
        upgrade2Button.setBounds(450, 250, 200, 50);
        upgrade2Button.addActionListener(upgrade2click);
        game.add(upgrade2Button);

        upgrade3Button = new JButton();
        upgrade3Button.setLayout(new BorderLayout());
        JLabel label5 = new JLabel("Eggman upgrade ara ara", SwingConstants.CENTER);
        JLabel label6 = new JLabel("100 social credits", SwingConstants.CENTER);
        upgrade3Button.add(BorderLayout.NORTH, label5);
        upgrade3Button.add(BorderLayout.SOUTH, label6);
        upgrade3Button.setBounds(450, 350, 200, 50);
        upgrade3Button.addActionListener(upgrade3click);
        game.add(upgrade3Button);
        //---------------------------------------------

        //Panel for seeing click count
        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(76, 100, 250, 100);
        counterPanel.setOpaque(false);
        counterPanel.setLayout(new GridLayout(2, 1));
        game.add(counterPanel);

        counterLabel = new JLabel(String.valueOf(creditCounter), SwingConstants.CENTER);
        JLabel creditLabel = new JLabel("social credits", SwingConstants.CENTER);
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font);
        creditLabel.setForeground(Color.white);
        creditLabel.setFont(font);
        counterPanel.add(counterLabel);
        counterPanel.add(creditLabel);
        //---------------------------------------------

        //Back button
        JButton back = new JButton("Back");
        back.setBounds(10, 10, 75, 50);
        back.addActionListener(backClick);
        game.add(back);
    }

    public void createMainMenu() {
        mainMenu = new JPanel();
        mainMenu.setLayout(null);
        mainMenu.setBackground(color);

        JButton playButton = new JButton("PLAY GAME");
        playButton.setLayout(new BorderLayout());
        playButton.setBounds(300, 300, 200, 50);

        JButton optionsButton = new JButton("OPTIONS");
        optionsButton.setLayout(new BorderLayout());
        optionsButton.setBounds(300, 375, 200, 50);

        JButton exitButton = new JButton("EXIT");
        exitButton.setLayout(new BorderLayout());
        exitButton.setBounds(300, 450, 200, 50);

        playButton.addActionListener(playClick);
        optionsButton.addActionListener(optionsClick);
        exitButton.addActionListener(exitClick);

        mainMenu.add(playButton);
        mainMenu.add(optionsButton);
        mainMenu.add(exitButton);

        JLabel version = new JLabel("Version: 1.00.???");
        version.setForeground(Color.white);
        version.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        version.setBounds(10, 520, 200, 50);
        mainMenu.add(version);

    }

    public void createOptions() {
        options = new JPanel();
        options.setLayout(null);
        options.setBackground(color);

        JButton back = new JButton("Back");
        back.setBounds(10, 10, 75, 50);
        back.addActionListener(backClick);
        options.add(back);

        JButton color1button = new JButton("Set color to blue");
        color1button.setLayout(new BorderLayout());
        color1button.setBounds(300, 300, 200, 50);

        JButton color2button = new JButton("Set color to green");
        color2button.setLayout(new BorderLayout());
        color2button.setBounds(300, 375, 200, 50);

        JButton color3button = new JButton("Set color to red");
        color3button.setLayout(new BorderLayout());
        color3button.setBounds(300, 450, 200, 50);

        color1button.addActionListener(color1click);
        color2button.addActionListener(color2click);
        color3button.addActionListener(color3click);

        options.add(color1button);
        options.add(color2button);
        options.add(color3button);

    }

    public class PlayButton implements ActionListener {
        public void actionPerformed(ActionEvent playClick) {
            cards.show(cardCont, "2");
        }
    }

    public class OptionsButton implements ActionListener {
        public void actionPerformed(ActionEvent optionsClick) {
            cards.show(cardCont, "3");
        }
    }

    public class ExitButton implements ActionListener {
        public void actionPerformed(ActionEvent exitClick) {
            System.exit(0);
        }
    }

    public class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent backClick) {
            cards.show(cardCont, "1");
        }
    }

    public class Color1 implements ActionListener {
        public void actionPerformed(ActionEvent color1click) {
            mainMenu.setBackground(Color.CYAN);
            game.setBackground(Color.CYAN);
            options.setBackground(Color.CYAN);
        }
    }

    public class Color2 implements ActionListener {
        public void actionPerformed(ActionEvent color2click) {
            mainMenu.setBackground(Color.GREEN);
            game.setBackground(Color.GREEN);
            options.setBackground(Color.GREEN);
        }
    }

    public class Color3 implements ActionListener {
        public void actionPerformed(ActionEvent color3click) {
            mainMenu.setBackground(color);
            game.setBackground(color);
            options.setBackground(color);
        }
    }

    public class CreditHandler implements ActionListener {
        public void actionPerformed(ActionEvent upgrade1click) {
            creditCounter += clickValue;
            counterLabel.setText(String.valueOf(creditCounter));
        }
    }

    public class Upgrade1Handler implements ActionListener {
        public void actionPerformed(ActionEvent upgrade1click) {
            Upgrade1 upgrade = new Upgrade1();
            if (creditCounter >= 10) {
                creditCounter = creditCounter - 10;
                counterLabel.setText(String.valueOf(creditCounter));
                upgrade.setClick();
                upgrade.setImage();
                ImageIcon clickerImage = new ImageIcon(Main.class.getClassLoader().getResource(upgrade.getImage()));
                clickerButton.setIcon(clickerImage);
                upgrade1Button.setEnabled(false);
                upgrade1Button.setBackground(Color.green);
                window.setTitle("GG! 1st upgrade unlocked! You are so good at this game!");
            }
        }
    }

    public class Upgrade2Handler implements ActionListener {
        public void actionPerformed(ActionEvent upgrade2click) {
            if (creditCounter >= 50) {
                creditCounter = creditCounter - 50;
                counterLabel.setText(String.valueOf(creditCounter));
                Upgrade2 upgrade = new Upgrade2();
                upgrade.setClick();
                upgrade.setImage();
                ImageIcon clickerImage = new ImageIcon(Main.class.getClassLoader().getResource(upgrade.getImage()));
                clickerButton.setIcon(clickerImage);
                upgrade2Button.setEnabled(false);
                upgrade2Button.setBackground(Color.green);
                window.setTitle("2nd upgrade?!? Bro you are gaming warlord if you have gotten this far.");
            }
        }
    }

    public class Upgrade3Handler implements ActionListener {
        public void actionPerformed(ActionEvent upgrade3click) {
            if (creditCounter >= 100) {
                creditCounter = creditCounter - 100;
                counterLabel.setText(String.valueOf(creditCounter));
                Upgrade3 upgrade = new Upgrade3();
                upgrade.setClick();
                upgrade.setImage();
                ImageIcon clickerImage = new ImageIcon(Main.class.getClassLoader().getResource(upgrade.getImage()));
                clickerButton.setIcon(clickerImage);
                upgrade3Button.setEnabled(false);
                upgrade3Button.setBackground(Color.green);
                window.setTitle("Dude 3rd upgrade? Really!?! You got to stop otherwise you will become addicted.");
            }
        }
    }
}