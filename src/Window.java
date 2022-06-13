package SeriousGame.src;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    Window() {
        this.setTitle("BingChilling Clicker Game 4000 LIMITED EDITION (WARNING: EMOTIONAL DAMAGE).exe");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon frameImage = new ImageIcon("./resources/icon.png");
        this.setIconImage(frameImage.getImage());
        this.setBackground(Color.black);
        this.setVisible(true);
    }

}
