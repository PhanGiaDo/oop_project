package z.animation;

import javax.swing.*;
import java.awt.*;

import z.model.Queue;
import z.model.Node;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QueueAnimation extends JPanel implements ActionListener{
    private Timer timer;
    private Queue queue;
    private int size;
    private int value;
    private int alpha;
    private int beta;
    private int tail;
    private int nodeSize = 40;
    private boolean begin;
    private boolean end;
    private boolean enqueue;
    private boolean dequeue;
    private boolean peek_front;
    private boolean peek_back;

    public void QueueAnimationEnqueue(Queue queue, int value) {
        this.queue = queue;
        this.value = value;
        this.size = queue.size();
        alpha = 0;
        beta = 0;
        end = false;
        if (size == 0) {
            begin = true;
        } else {
            begin = false;
        }

        if (size != 0) {
            enqueue = true;
        } else {
            enqueue = false;
        }

        timer = new Timer(25, this);
        timer.start();
    }

    public void QueueAnimationDequeue(Queue queue) {
        this.queue = queue;
        this.size = queue.size();
        alpha = 0;
        end = false;
        dequeue = true;
        timer = new Timer(25, this);
        timer.start();
    }

    public void QueueAnimationPeekFront(Queue queue) {
        this.queue = queue;
        this.size = queue.size();
        end = false;
        peek_front = true;
        timer = new Timer(1500, this);
        timer.start();

    }

    public void QueueAnimationPeekBack(Queue queue) {
        this.queue = queue;
        this.size = queue.size();
        tail = 0;
        end = false;
        peek_back = true;
        timer = new Timer(1500, this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (peek_back) {
            Node p = queue.getHead();
            int i = 0;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(i * 80, 40, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + (i+1) + "]" , i * 80, 90);
                }
                if (i == queue.size() - 1) {
                tail = p.getData();
                g.drawString("tail [" + (i+1) + "]" , i * 80 + 5, 35);
                } 
                if (i != 0 && i != queue.size() - 1) {
                g.drawString("[" + (i+1) + "]" , i * 80 + 15, 90);
                }
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = (i + 1) * 80 - 40;
                int y1 = 60;
                int x2 = (i + 1) * 80;
                int y2 = 60;
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
            g.drawString("null", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);

            g.setFont(new Font("TIME NEW ROMAN", Font.BOLD, 40));
            g.drawString("value at the tail: " + tail , 10, 300);
            g.setFont(this.getFont());

        }

        if (peek_front) {
            Node p = queue.getHead();
            int i = 0;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(i * 80, 40, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + (i+1) + "]" , i * 80, 90);
                }
                if (i == queue.size() - 1) {
                tail = p.getData();
                g.drawString("tail [" + (i+1) + "]" , i * 80 + 5, 35);
                } 
                if (i != 0 && i != queue.size() - 1) {
                g.drawString("[" + (i+1) + "]" , i * 80 + 15, 90);
                }
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = (i + 1) * 80 - 40;
                int y1 = 60;
                int x2 = (i + 1) * 80;
                int y2 = 60;
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
            g.drawString("null", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);

            g.setFont(new Font("TIME NEW ROMAN", Font.BOLD, 40));
            g.drawString("value at the head: " + queue.getHead().getData() , 10, 300);
            g.setFont(this.getFont());
        }

        if (dequeue) {
            Node p = queue.getHead();
            int i = 0;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(i * 80, 40, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + (i+1) + "]" , i * 80 + alpha, 90);
                }
                if (i == queue.size() - 1) {
                g.drawString("tail [" + (i+1) + "]" , i * 80 + 5, 35);
                } 
                
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = (i + 1) * 80 - 40;
                int y1 = 60;
                int x2 = (i + 1) * 80;
                int y2 = 60;
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
            g.drawString("null", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);
        }

        if (enqueue) {
            Node p = queue.getHead();
            int i = 0;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(i * 80, 40, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + (i+1) + "]" , i * 80, 90);
                } 
                if (i == queue.size() - 1) {
                g.drawString("tail [" + (i+1) + "]" , i * 80 + 5 + beta, 35);
                }
                if (i != 0 && i != queue.size() - 1) {
                g.drawString("[" + (i+1) + "]" , i * 80 + 15, 90);
                }
                if (p.getNext() != null) {
                    //Ve mui ten
                    g.setColor(Color.BLACK);
                    // Vẽ đường thẳng
                    int x1 = (i + 1) * 80 - 40;
                    int y1 = 60;
                    int x2 = (i + 1) * 80;
                    int y2 = 60;
                    g.drawLine(x1, y1, x2, y2);
                    // Vẽ đầu mũi tên
                    double angle = Math.atan2(y2 - y1, x2 - x1);
                    int dx = (int) (10 * Math.cos(angle));
                    int dy = (int) (10 * Math.sin(angle));
                    g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                    g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                }
                //nextNode
                p = p.getNext();
                i++;
            }
            //Ve newNode
            g.setColor(Color.GRAY);
            g.fillRect(80 * size, 40, nodeSize, nodeSize);
            g.setColor(Color.WHITE);
            g.drawString(this.value + "", 80 * size + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);
            // Ve mui ten
            g.setColor(Color.BLACK);
            // Vẽ đường thẳng
            int x1 = size * 80 - 40;
            int y1 = 60;
            int x2 = size * 80 - 40 + alpha;
            int y2 = 60; 
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
            Node p = queue.getHead();
            int i = 0;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(i * 80, 40, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + (i+1) + "]" , i * 80, 90);
                }
                if (i == queue.size() - 1) {
                g.drawString("tail [" + (i+1) + "]" , i * 80 + 5, 35);
                } 
                if (i != 0 && i != queue.size() - 1) {
                g.drawString("[" + (i+1) + "]" , i * 80 + 15, 90);
                }
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = (i + 1) * 80 - 40;
                int y1 = 60;
                int x2 = (i + 1) * 80;
                int y2 = 60;
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
            g.drawString("null", i * 80 + nodeSize / 2 - 5, 40 + nodeSize / 2 + 5);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (peek_back) {
            end = true;
            peek_back = false;
        }

        else if (peek_front) {
            end = true;
            peek_front = false;
        }

        else if (dequeue) {
            if (alpha < 76) {
                alpha += 2;
            } else if (alpha == 76 || alpha == 78) {
                timer.setDelay(1000);
                alpha += 2;
            } else if (alpha == 80) {
                timer.setDelay(25);
                queue.dequeue();
                end = true;
                dequeue = false;
            }

        }

        else if (enqueue) {
            if (alpha < 38) {
                alpha++;
            } else if (alpha == 38 || alpha == 39) {
                timer.setDelay(1000);
                alpha++;
            } else if (alpha == 40 && beta < 76) {
                timer.setDelay(25);
                beta += 2;
            } else if (beta == 76 || beta == 78) {
                timer.setDelay(1000);
                beta += 2;
            } else if (beta == 80) {
                timer.setDelay(25);
                queue.enqueue(value);
                end = true;
                enqueue = false;
            }
        }

        else if (begin) {
            queue.enqueue(value);
            end = true;
            begin = false;
        }

        else if (end) {
            timer.stop();
        }

        repaint();
    }

}
