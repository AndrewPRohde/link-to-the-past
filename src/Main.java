import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Main extends  JPanel {

    Link link = new Link(this);

    private void move() {
        link.move();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        link.paint(g2d);
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
