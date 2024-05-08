import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Lớp biểu diễn một node trong danh sách liên kết
class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

// Lớp Panel để vẽ danh sách liên kết
class LinkedListPanel extends JPanel {
    private List<ListNode> nodes; // Danh sách các node trong danh sách liên kết

    public LinkedListPanel() {
        this.nodes = new ArrayList<>();
    }

    public void setNodes(ListNode head) {
        // Đặt danh sách các node của danh sách liên kết
        nodes.clear();
        ListNode current = head;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
        repaint(); // Yêu cầu panel vẽ lại khi danh sách node thay đổi
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Vẽ các node và mũi tên nối giữa chúng
        int nodeSize = 40; // Kích thước của mỗi node (vuông)
        int startX = 50; // Vị trí bắt đầu vẽ các node
        int startY = 100;
        int arrowLength = 60; // Độ dài của mũi tên

        for (int i = 0; i < nodes.size(); i++) {
            ListNode currentNode = nodes.get(i);
            

            // Vẽ node
            g.setColor(Color.BLUE);
            g.fillRect(startX + i * 100, startY, nodeSize, nodeSize);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(currentNode.value), startX + i * 100 + nodeSize / 2 - 5, startY + nodeSize / 2 + 5);


            //Vẽ chỉ số
            g.setColor(Color.BLACK);
            if (i == 0) {
                g.drawString("head [" + i + "]" , startX + i * 100 + nodeSize / 2 - 5, startY + nodeSize / 2 + 5 + 30);
            } else if (i == nodes.size()) {
                g.drawString("tail [" + i + "]" , startX + i * 100 + nodeSize / 2 - 5, startY + nodeSize / 2 + 5 + 30);
            } else {
                g.drawString("[" + i + "]" , startX + i * 100 + nodeSize / 2 - 5, startY + nodeSize / 2 + 5 + 30);
            }


            // Vẽ mũi tên nối node tiếp theo (nếu có)
            if (currentNode.next != null) {
                arrowLength = 60;
                g.setColor(Color.BLACK);
                int nextNodeX = startX + (i + 1) * 100;
                int nextNodeY = startY + nodeSize / 2;
                int arrowX = startX + (i + 1) * 100 - arrowLength;
                int arrowY = startY + nodeSize / 2;

                int x1 = arrowX;
                int y1 = arrowY;
                int x2 = nextNodeX;
                int y2 = nextNodeY;
                arrowLength = 10;
                double angle = Math.atan2(y2 - y1, x2 - x1);
                int dx = (int) (arrowLength * Math.cos(angle));
                int dy = (int) (arrowLength * Math.sin(angle));
        
                // Vẽ đường thẳng
                g.drawLine(x1, y1, x2, y2);
        
                // Vẽ đầu mũi tên
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
            }
        }
    }
}

public class LinkedListGUI extends JFrame {
    private LinkedListPanel linkedListPanel;

    public LinkedListGUI() {
        setTitle("Linked List Visualization");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);

        linkedListPanel = new LinkedListPanel();
        add(linkedListPanel, BorderLayout.CENTER);

        // Tạo danh sách liên kết mẫu
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Đặt danh sách liên kết vào panel
        linkedListPanel.setNodes(head);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LinkedListGUI gui = new LinkedListGUI();
            gui.setVisible(true);
        });
    }
}
