import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class Options extends JPanel {

    JLabel optionsText;
    JButton backButton;
    JButton muteButton;
    int musicClick = 0;
    JButton color1button;
    JButton color2button;
    JButton color3button;

    MainMenu mainMenu;
    Game game;
    Options options;
    GameMusic music;
    Color color;
    Cards cont;

    Options(Color color, MainMenu mainMenu, Game game, GameMusic music)
    {
        this.setLayout(null);
        this.setBackground(color);
        this.add(optionsLabel());
        this.add(backButton());
        this.add(muteButton());
        this.add(color1Button());
        this.add(color2Button());
        this.add(color3Button());
        this.mainMenu = mainMenu;
        this.game = game;
        options = this;
        this.color = color;
        this.music = music;
    }

    private JLabel optionsLabel(){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            optionsText = new JLabel("OPTIONS", SwingConstants.CENTER);
            optionsText.setFont(font.deriveFont(Font.BOLD, 82));
            optionsText.setForeground(Color.white);
            optionsText.setBounds(200, 100, 400, 75);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return optionsText;
    }

    private JButton backButton()
    {
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

    private JButton muteButton(){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            muteButton = new JButton("Mute music");
            muteButton.setLayout(new BorderLayout());
            muteButton.setFont(font.deriveFont(Font.BOLD, 12));
            muteButton.setBackground(Color.white);
            muteButton.setBounds(300, 250, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return muteButton;
    }

    private JButton color1Button()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            color1button = new JButton("Set color to camel");
            color1button.setLayout(new BorderLayout());
            color1button.setFont(font.deriveFont(Font.BOLD, 12));
            color1button.setBackground(Color.white);
            color1button.setBounds(300, 325, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return color1button;
    }

    private JButton color2Button()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            color2button = new JButton("Set color to chambray");
            color2button.setLayout(new BorderLayout());
            color2button.setFont(font.deriveFont(Font.BOLD, 12));
            color2button.setBackground(Color.white);
            color2button.setBounds(300, 400, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return color2button;
    }

    private JButton color3Button()
    {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(Game.class.getClassLoader().getResourceAsStream("font.ttf")));
            color3button = new JButton("Set color to red");
            color3button.setLayout(new BorderLayout());
            color3button.setFont(font.deriveFont(Font.BOLD, 12));
            color3button.setBackground(Color.white);
            color3button.setBounds(300, 475, 200, 50);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
        return color3button;
    }

    public void run(Cards cont){
        this.cont = cont;
        BackButton backClick = new BackButton();
        backButton.addActionListener(backClick);
        MuteButton muteClick = new MuteButton();
        muteButton.addActionListener(muteClick);
        Color1 color1click = new Color1();
        color1button.addActionListener(color1click);
        Color2 color2click = new Color2();
        color2button.addActionListener(color2click);
        Color3 color3click = new Color3();
        color3button.addActionListener(color3click);
    }

    public class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent backClick) {
            cont.back();
        }
    }
    public class MuteButton implements ActionListener {
        public void actionPerformed(ActionEvent backClick) {
            music.volumeMute();
        }
    }

    public class Color1 implements ActionListener {
        public void actionPerformed(ActionEvent color1click) {
            Color color = new Color(193, 154, 107);
            mainMenu.setBackground(color);
            game.setBackground(color);
            options.setBackground(color);
        }
    }

    public class Color2 implements ActionListener {
        public void actionPerformed(ActionEvent color2click) {
            Color color = new Color(158, 180, 211);
            mainMenu.setBackground(color);
            game.setBackground(color);
            options.setBackground(color);
        }
    }

    public class Color3 implements ActionListener {
        public void actionPerformed(ActionEvent color3click) {
            mainMenu.setBackground(color);
            game.setBackground(color);
            options.setBackground(color);
        }
    }
}
