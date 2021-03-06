import java.awt.*;
import java.awt.event.KeyEvent;
@SuppressWarnings("serial")
public class Enemy {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Main game;

    public Enemy(Main game) {
        this.game = game;
    }
    void move() {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - DIAMETER)
            game.linkDeath();
        if (y + ya > game.getHeight() - DIAMETER)
            ya = -1;
        if (collision()) {
            ya = -1;
            y = game.link.getTop() - DIAMETER;
        }

        x = x + xa;
        y = y + ya;
    }
    private boolean collision() {
        return game.link.getBounds().intersects(getBounds());
    }
    public  void paint(Graphics2D g) {
        g.fillOval(x, y, 24, 32);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}
