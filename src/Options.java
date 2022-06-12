import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JPanel {

    BackButton backClick = new BackButton();
    Color1 color1click = new Color1();
    Color2 color2click = new Color2();
    Color3 color3click = new Color3();

    MainMenu mainMenu;
    Game game;
    Options options;
    Color color;
    Cards cont;

    Options(Color color, MainMenu mainMenu, Game game)
    {
        this.setLayout(null);
        this.setBackground(color);
        this.add(backButton());
        this.add(color1Button());
        this.add(color2Button());
        this.add(color3Button());
        this.mainMenu = mainMenu;
        this.game = game;
        options = this;
        this.color = color;
    }

    private JButton backButton()
    {
        JButton button = new JButton("Back");
        button.setLayout(new BorderLayout());
        button.setBounds(10, 10, 75, 50);
        button.addActionListener(backClick);
        return button;
    }

    private JButton color1Button()
    {
        JButton button = new JButton("Set color to cyan");
        button.setLayout(new BorderLayout());
        button.setBounds(300, 300, 200, 50);
        button.addActionListener(color1click);
        return button;
    }

    private JButton color2Button()
    {
        JButton button = new JButton("Set color to green");
        button.setLayout(new BorderLayout());
        button.setBounds(300, 375, 200, 50);
        button.addActionListener(color2click);
        return button;
    }

    private JButton color3Button()
    {
        JButton button = new JButton("Set color to red");
        button.setLayout(new BorderLayout());
        button.setBounds(300, 450, 200, 50);
        button.addActionListener(color3click);
        return button;
    }

    public void run(Cards cont){
        this.cont = cont;
        BackButton backClick = new BackButton();
        backButton().addActionListener(backClick);
        Color1 color1 = new Color1();
        color1Button().addActionListener(color1);
        Color1 color2 = new Color1();
        color1Button().addActionListener(color2);
        Color1 color3 = new Color1();
        color1Button().addActionListener(color3);
    }

    public class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent backClick) {
            cont.back();
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
}
