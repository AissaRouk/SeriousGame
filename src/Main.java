import java.awt.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        Color color = new Color(254, 92, 92);
        GameMusic music = new GameMusic();
        URL musicURL = Window.class.getClassLoader().getResource("gameMusic.wav");
        music.setFile(musicURL);
        Game game = new Game(color);
        MainMenu menu = new MainMenu(color);
        Options options = new Options(color, menu, game, music);
        Cards cont = new Cards(menu, game, options);
        menu.run(cont);
        game.run(cont);
        options.run(cont);
        Window window = new Window(music);
        window.add(cont);

    }
}