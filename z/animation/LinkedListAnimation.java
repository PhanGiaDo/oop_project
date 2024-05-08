package z.animation;

import javax.swing.*;
import z.model.LinkedList;
import z.model.Node;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LinkedListAnimation extends JPanel implements ActionListener {
    private Timer timer;
    private LinkedList linkedList;
    private int index;
    private int size;
    private int value;
    private int nodeSize = 40;
    private int startX = 0;
    private int startY = 0;
    private int arrowLength = 0;
    private int stage;

    private int i;

    public LinkedListAnimation(LinkedList linkedList, int index, int value) {
        this.linkedList = linkedList;
        this.index = index;
        this.value = value;
        this.stage = 1;
        timer = new Timer(1500, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (stage == 1 || stage == 3) {
            Node p = linkedList.head;
            int i = 0;
            while (p != null) {
                g.setColor(Color.BLUE);
                g.fillRect(startX + i * 100, startY, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.data + "", startX + i * 100 + nodeSize / 2 - 5, startY + nodeSize / 2 + 5);
                if (p.next != null) {
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
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + i + "]" , startX + i * 100, startY + nodeSize + 10);
                } else {
                g.drawString("[" + i + "]" , startX + i * 100 + 15, startY + nodeSize + 10);
                }
                p = p.next;
                i++;
            }

            
        } else if (stage == 2) {
            Node p = linkedList.head;
            int i = 0;
            while (p != null) {
                g.setColor(Color.BLUE);
                g.fillRect(startX + i * 100, startY, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.data + "", startX + i * 100 + nodeSize / 2 - 5, startY + nodeSize / 2 + 5);
                if (p.next != null) {
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
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + i + "]" , startX + i * 100, startY + nodeSize + 10);
                } else {
                g.drawString("[" + i + "]" , startX + i * 100 + 15, startY + nodeSize + 10);
                }
                p = p.next;
                i++;
            }
            g.setColor(Color.BLUE);
            g.fillRect(startX + (index-1) * 100, startY + nodeSize*2, nodeSize, nodeSize);
            g.setColor(Color.WHITE);
            g.drawString(this.value + "", startX + (index-1) * 100 + nodeSize / 2 - 5, startY + nodeSize*2 + nodeSize / 2 + 5);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (stage == 3) {
            this.timer.stop(); 
            }
        if (stage == 2) {
            linkedList.insertMid(value, index);
            stage = 3;
            repaint();
        }
        if (stage == 1) {
            stage = 2;
            repaint();
        }
    }   
}
