package anima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation_merge extends JPanel implements ActionListener{
    private Timer timer;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    public Animation_merge(int n) {
        timer = new Timer(1, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw your animation frames here
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50); // Example: Draw a red rectangle
    }

    public void actionPerformed(ActionEvent e) {
        x += dx;
        if (x > getWidth() - 50 || x < 0) {
            dx *= -1;
        }
        y += dy;
        if (y > getHeight() - 50 || y < 0) {
            dy *= -1;
        }
        repaint();
    }
}