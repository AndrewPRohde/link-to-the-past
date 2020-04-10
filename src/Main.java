import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Main extends  JPanel {

    Enemy enemy = new Enemy(this);
    Link link = new Link(this);

    public Main() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                link.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                link.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    private void move() {
        enemy.move();
        link.move();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //enemy.paint(g2d);
        link.paint(g2d);
    }

    public void linkDeath() {
        soundHandler.LINKDIES.play();
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Link to the Past");
        Main game = new Main();
        frame.add(game);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
