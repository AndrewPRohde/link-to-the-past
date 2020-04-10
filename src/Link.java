import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Link {
    int x = 0;
    int y = 0;
    private static final int WIDTH = 24;
    private static final int HEIGHT = 32;
    int xa = 0;
    int ya = 0;
    int linkHealth = 3;
    private Main game;

    public Link(Main game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - 60)
            x = x + xa;
        if (y + ya > 0 && y + ya < game.getHeight() - 60)
            y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
        ya = 0;
    }

    public void keyPressed(KeyEvent e) {
        soundHandler.WALKGRASS.play();
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
        if (e.getKeyCode() == KeyEvent.VK_UP)
            ya = -1;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            ya = 1;
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
    public int getTop() {
        return y;
    }
    public void linkDamage() {
        linkHealth -= 1;
        if (linkHealth <= 0)
            game.linkDeath();
    }

}
