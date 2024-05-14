import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleAnimation extends JPanel implements ActionListener {
    private boolean ac = false;
    private Timer timer;

    int delay;
    public SimpleAnimation() {
        ac = true;
        timer = new Timer(1000, this); // Tạo timer với delay là 50ms và listener là chính đối tượng này
        timer.start(); // Bắt đầu timer

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);        
        System.out.println("1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (ac) {
            System.out.println("2");
        } else System.out.println("3");

        repaint(); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            SimpleAnimation animationPanel = new SimpleAnimation();
            animationPanel.setPreferredSize(new Dimension(400, 300)); // Đặt kích thước panel

            frame.add(animationPanel);
            frame.pack();
            frame.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
            frame.setVisible(true);
        });
    }
}
