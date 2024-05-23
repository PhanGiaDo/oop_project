package z.animation;

import java.awt.*;
import javax.swing.*;

import z.model.Node;
import z.model.Stack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StackAnimation extends JPanel implements ActionListener {
    private Timer timer;
    private Stack stack;
    private int size;
    private int value;
    private int nodeSize = 40;
    private int alpha;
    private int beta;
    private boolean begin;
    private boolean end;
    private boolean push;
    private boolean pop;
    private boolean peek;

    public void StackAnimationPush(Stack stack, int value) {
        this.stack = stack;
        this.value = value;
        this.size = stack.size();
        alpha = 0;
        beta = 0;
        end = false;
        pop = false;
        peek = false;

        if (size == 0) {
            begin = true;
        } else {
            begin = false;
        }

        if (size != 0) {
            push = true;
        } else {
            push = false;
        }

        timer = new Timer(25, this);
        timer.start();
    }
  
    public void StackAnimationPop(Stack stack) {
        this.stack = stack;
        this.size = stack.size();
        alpha = 0;
        beta = 0;
        push = false;
        peek = false;
        begin = false;
        pop = true;
        end = false;
        
        timer = new Timer(25, this);
        timer.start();
    }

    public void StackAnimationPeek(Stack stack) {
        this.stack = stack;
        this.size = stack.size();
        alpha = 0;
        beta = 0;
        push = false;
        pop = false;
        begin = false;
        peek = true;
        end = false;

        timer = new Timer(1500, this);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (peek) {
            Node p = stack.getTop();
            int i = 1;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(40, i * 80, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", 55, i * 80 + 25);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 1) {
                g.drawString("top [" + i + "]" , 0, i * 80 + 25);
                } else {
                g.drawString("[" + i + "]" , 15, i * 80 + 25);
                }
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = 60;
                int y1 = (i + 1) * 80 - 40;
                int x2 = 60;
                int y2 = (i + 1) * 80;
                g.drawLine(x1, y1, x2, y2);
                // Vẽ đầu mũi tên
                double angle = Math.atan2(y2 - y1, x2 - x1);
                int dx = (int) (10 * Math.cos(angle));
                int dy = (int) (10 * Math.sin(angle));
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                //nextNode
                p = p.getNext();
                i++;
            }
            //null
            g.drawString("null", 55, i * 80 + 25);

            g.setFont(new Font("TIME NEW ROMAN", Font.BOLD, 20));
            g.drawString("value at the top : " + stack.getTop().getData(), 0, 500);
            g.setFont(this.getFont());

        }

        if (pop) {
            Node p = stack.getTop();
            int i = 1;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(40, i * 80, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", 55, i * 80 + 25);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 1) {
                g.drawString("top [" + i + "]" , 0, i * 80 + 25 + alpha);
                } 
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = 60;
                int y1 = (i + 1) * 80 - 40;
                int x2 = 60;
                int y2 = (i + 1) * 80;
                g.drawLine(x1, y1, x2, y2);
                // Vẽ đầu mũi tên
                double angle = Math.atan2(y2 - y1, x2 - x1);
                int dx = (int) (10 * Math.cos(angle));
                int dy = (int) (10 * Math.sin(angle));
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                //nextNode
                p = p.getNext();
                i++;
            }
            //null
            g.drawString("null", 55, i * 80 + 25);
 
        }

        if (push) {
            Node p = stack.getTop();
            int i = 1;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(40, i * 80, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", 55, i * 80 + 25);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 1) {
                g.drawString("top [" + i + "]" , 0, i * 80 + 25 - beta);
                } else {
                g.drawString("[" + i + "]" , 15, i * 80 + 25);
                }
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = 60;
                int y1 = (i + 1) * 80 - 40;
                int x2 = 60;
                int y2 = (i + 1) * 80;
                g.drawLine(x1, y1, x2, y2);
                // Vẽ đầu mũi tên
                double angle = Math.atan2(y2 - y1, x2 - x1);
                int dx = (int) (10 * Math.cos(angle));
                int dy = (int) (10 * Math.sin(angle));
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                //nextNode
                p = p.getNext();
                i++;
            }
            //null
            g.drawString("null", 55, i * 80 + 25);
  
            //Ve newNode
            g.setColor(Color.GRAY);
            g.fillRect(40, 0, nodeSize, nodeSize);
            g.setColor(Color.WHITE);
            g.drawString(this.value + "", 40 + nodeSize / 2 - 5, nodeSize / 2 + 5);
            // Ve mui ten
            g.setColor(Color.BLACK);
            // Vẽ đường thẳng
            int x1 = 60;
            int y1 = 40;
            int x2 = 60;
            int y2 = 40 + alpha; 
            g.drawLine(x1, y1, x2, y2);
            if (alpha >= 40) {
                // Vẽ đầu mũi tên
                double angle = Math.atan2(y2 - y1, x2 - x1);
                int dx = (int) (10 * Math.cos(angle));
                int dy = (int) (10 * Math.sin(angle));
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
            }      
        }

        if (end) {
            Node p = stack.getTop();
            int i = 1;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(40, i * 80, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", 55, i * 80 + 25);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 1) {
                g.drawString("top [" + i + "]" , 0, i * 80 + 25);
                } else {
                g.drawString("[" + i + "]" , 15, i * 80 + 25);
                }
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = 60;
                int y1 = (i + 1) * 80 - 40;
                int x2 = 60;
                int y2 = (i + 1) * 80;
                g.drawLine(x1, y1, x2, y2);
                // Vẽ đầu mũi tên
                double angle = Math.atan2(y2 - y1, x2 - x1);
                int dx = (int) (10 * Math.cos(angle));
                int dy = (int) (10 * Math.sin(angle));
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                //nextNode
                p = p.getNext();
                i++;
            }
            //null
            g.drawString("null", 55, i * 80 + 25);
        }
            
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (peek) {
            end = true;
            peek = false;
        }
      
        else if (pop) {
            if (alpha < 76) {
                alpha += 2;
            } else if (alpha == 76 || alpha == 78) {
                timer.setDelay(1000);
                alpha += 2;
            } else if (alpha == 80) {
                timer.setDelay(25);
                stack.pop();
                pop = false;
                end = true;
            }
  
        }
        
        else if (push) {
            if (alpha < 38) {
                alpha++;
            } else if (alpha == 38 || alpha == 39) {
                timer.setDelay(1000);
                alpha++;
            } else if (alpha == 40 && beta < 78) {
                timer.setDelay(25);
                beta += 2;
            } else if (beta == 78 || beta == 80) {
                timer.setDelay(1000);
                beta += 2;
            } else if (beta == 82) {
                timer.setDelay(25);
                stack.push(value);
                end = true;
                push = false;
            }
 
        }
    
        else if (begin) {
            stack.push(value);
            end = true;
            begin = false;
        }

        else if (end) {
            timer.stop();
        }

        repaint();
    }
    
}
