import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class Window extends JFrame{

    Window(GameMusic music) {
        this.setTitle("Bing Qi Ling Clicker.executable file.exe");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon frameImage = new ImageIcon(Objects.requireNonNull(Window.class.getClassLoader().getResource("icon.png")));
        this.setIconImage(frameImage.getImage());
        this.setBackground(Color.black);
        music.play();
        music.loop();
        this.setVisible(true);
    }
}
