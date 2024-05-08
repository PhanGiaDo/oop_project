import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleAnimation extends JPanel implements ActionListener {

    private int xPosition = 0;
    private Timer timer;

    public SimpleAnimation() {
        timer = new Timer(1500, this); // Tạo timer với delay là 50ms và listener là chính đối tượng này
        timer.start(); // Bắt đầu timer
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.timer.stop();
        System.out.println("1");
        // g.setColor(Color.BLUE);
        // g.fillRect(xPosition, 100, 50, 50);
        // System.out.println("OK");  
        // if (xPosition > 50) {
        //     this.timer.stop();
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện khi timer được kích hoạt
        //xPosition += 5;
        System.out.println("2");
        repaint(); // Yêu cầu panel vẽ lại để cập nhật animation
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
