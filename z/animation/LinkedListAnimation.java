package z.animation;

import javax.swing.*;
import java.awt.*;

import z.model.LinkedList;
import z.model.Node;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkedListAnimation extends JPanel implements ActionListener {
    private Timer timer;
    private LinkedList linkedList;
    private int index;
    private int indexCurrent;
    private int size;
    private int value;
    private int nodeSize = 40;
    private int delta;
    private int beta;
    private int alpha;
    private int stage;
    private int delay;
    private boolean insertFirst;
    private boolean insertMid;
    private boolean begin;
    private boolean end;
    private boolean removeFirst;
    private boolean removeMid;
    private boolean search;
    private boolean found;

    public void LinkedListAnimationInsert(LinkedList linkedList, int index, int value) {
        this.linkedList = linkedList;
        this.index = index;
        this.value = value;
        this.size = linkedList.size();
        removeFirst = false;
        removeMid = false;
        search = false;
        found = false;
        stage = 1;
        delta = 0;
        beta = 0;
        alpha = 0;
        indexCurrent = -1;
        end = false; 

        if (size == 0) {
            begin = true;
            delay = 25;
        } else {
            begin = false;
        }

        if (size != 0 && index == 1) {
            insertFirst = true;
            delay = 25;
        } else {
            insertFirst = false;
        }

        if (size != 0 && index != 1) {
            insertMid = true;
            delay = 1000;
        } else {
            insertMid = false;
        }
        timer = new Timer(delay, this);
        timer.start();
    }

    public void LinkedListAnimationRemove(LinkedList linkedList, int index) {
        this.linkedList = linkedList;
        this.index = index;
        this.size = linkedList.size();
        insertFirst = false;
        insertFirst = false;
        search = false;
        found = false;
        indexCurrent = -1;
        delta = 0;
        beta = 0;
        alpha = 0;
        stage = 1;
        end = false;
        delta = 0;

        if (index == 1) {
            removeFirst = true;
            removeMid = false;
            delay = 25;
        } else if (index != 1) {
            removeFirst = false;
            removeMid = true;
            delay = 1000;
        }
        timer = new Timer(delay, this);
        timer.start();
    }

    public void LinkedListAnimationSearch(LinkedList linkedList, int value) {
        this.linkedList = linkedList;
        this.value = value;
        this.size = linkedList.size();
        stage = 1;
        indexCurrent = -1;
        end = false;
        search = true;
        found = false;
        delay = 1000;
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (search) {
            if (stage >= 1) {
                Node p = linkedList.getHead();
                int i = 0;
                while (p != null) {
                    //Ve node
                    if (i == indexCurrent && p.getData() == value) {
                        found = true;
                        g.setColor(Color.GREEN);
                    } else if (i == indexCurrent) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLUE);
                    }
                    g.fillRect(i * 80, 0, nodeSize, nodeSize);
                    g.setColor(Color.WHITE);
                    g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, nodeSize / 2 + 5);
                    //ve chi so
                    g.setColor(Color.BLACK);
                    if (i == 0) {
                    g.drawString("head [" + (i+1) + "]" , i * 80, 50);
                    } else {
                    g.drawString("[" + (i+1) + "]" , i * 80 + 15, nodeSize + 10);
                    }
                    //Ve mui ten
                    g.setColor(Color.BLACK);
                    // Vẽ đường thẳng
                    int x1 = (i + 1) * 80 - 40;
                    int y1 = 20;
                    int x2 = (i + 1) * 80;
                    int y2 = 20;
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
                g.drawString("null", i * 80 + nodeSize / 2 - 5, nodeSize / 2 + 5);
            }

            if (stage == 2) {
                g.setFont(new Font("TIME NEW ROMAN", Font.BOLD, 40));
                g.drawString("found in index: " + linkedList.find(value), 10, 300);
                g.setFont(this.getFont());
            }
            if (stage == 3) {
                g.setFont(new Font("TIME NEW ROMAN", Font.BOLD, 40));
                g.drawString("NOT FOUND!", 10, 300);
                g.setFont(this.getFont());
            }
        }

        if (removeMid) {
            if (stage >= 1) {
                Node p = linkedList.getHead();
                int i = 0;
                while (p != null) {
                    //Ve node
                    if (i == indexCurrent && i == index - 2) {
                        g.setColor(Color.GREEN);
                    } else if (i == indexCurrent) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLUE);
                    }
                    g.fillRect(i * 80, 0, nodeSize, nodeSize);
                    g.setColor(Color.WHITE);
                    g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, nodeSize / 2 + 5);
                    //ve chi so
                    g.setColor(Color.BLACK);
                    if (i == 0) {
                    g.drawString("head [" + (i+1) + "]" , i * 80, 50);
                    } else {
                    g.drawString("[" + (i+1) + "]" , i * 80 + 15, nodeSize + 10);
                    }
                    //Ve mui ten
                    g.setColor(Color.BLACK);
                    // Vẽ đường thẳng
                    int x1 = (i + 1) * 80 - 40;
                    int y1 = 20;
                    int x2 = (i + 1) * 80;
                    int y2 = 20;
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
                g.drawString("null", i * 80 + nodeSize / 2 - 5, nodeSize / 2 + 5);
            }

            if (stage >= 2) {
                // Xoa mui ten 1
                g.setColor(this.getBackground());
                // Vẽ đường thẳng
                int x1 = (index - 1) * 80 - 40;
                int y1 = 20;
                int x2 = (index - 1) * 80;
                int y2 = 20;
                g.drawLine(x1, y1, x2, y2);
                // Vẽ đầu mũi tên
                double angle = Math.atan2(y2 - y1, x2 - x1);
                int dx = (int) (10 * Math.cos(angle));
                int dy = (int) (10 * Math.sin(angle));
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);


                // Xoa mui ten 2
                g.setColor(this.getBackground());
                // Vẽ đường thẳng
                x1 = index * 80 - 40;
                y1 = 20;
                x2 = index * 80;
                y2 = 20;
                g.drawLine(x1, y1, x2, y2);
                // Vẽ đầu mũi tên
                angle = Math.atan2(y2 - y1, x2 - x1);
                dx = (int) (10 * Math.cos(angle));
                dy = (int) (10 * Math.sin(angle));
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);

                // Ve mui ten 1
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                x1 = (index - 1) * 80 - 60;
                y1 = 40;
                x2 = (index - 1) * 80 - 60;
                y2 = 40 + beta;
                g.drawLine(x1, y1, x2, y2);
                if (beta >= 30) {
                    // Ve mui ten 2
                    g.setColor(Color.BLACK);
                    // Vẽ đường thẳng
                    x1 = (index - 1) * 80 - 60;
                    y1 = 70;
                    x2 = (index - 1) * 80 - 60 + alpha;
                    y2 = 70;
                    g.drawLine(x1, y1, x2, y2);
                }
                if (alpha >= 160) {
                    // Ve mui ten 3
                    g.setColor(Color.BLACK);
                    // Vẽ đường thẳng
                    x1 = index * 80 + 20;
                    y1 = 70;
                    x2 = index * 80 + 20;
                    y2 = 70 - delta;
                    g.drawLine(x1, y1, x2, y2);
                    if (delta >= 30) {
                        // Vẽ đầu mũi tên
                        angle = Math.atan2(y2 - y1, x2 - x1);
                        dx = (int) (10 * Math.cos(angle));
                        dy = (int) (10 * Math.sin(angle));
                        g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                        g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                    }
                }

            }
        }
     
        if (removeFirst) {
            Node p = linkedList.getHead();
            int i = 0;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(0 + i * 80, 0, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, nodeSize / 2 + 5);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + (i+1) + "]" , i * 80 + delta, nodeSize + 10);
                }
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = (i + 1) * 80 - 40;
                int y1 = 20;
                int x2 = (i + 1) * 80;
                int y2 = 20;
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
            g.drawString("null", 0 + i * 80 + nodeSize / 2 - 5, 0 + nodeSize / 2 + 5);

        }
       
        if (insertFirst) { 
            if (stage >= 1) {
                Node p = linkedList.getHead();
                int i = 0;
                while (p != null) {
                    //Ve node
                    g.setColor(Color.BLUE);
                    g.fillRect(i * 80, 0, nodeSize, nodeSize);
                    g.setColor(Color.WHITE);
                    g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, nodeSize / 2 + 5);
                    //ve chi so
                    g.setColor(Color.BLACK);
                    if (i == 0) {
                    g.drawString("head [" + (i+1) + "]" , i * 80, 50 + alpha);
                    } else {
                    g.drawString("[" + (i+1) + "]" , i * 80 + 15, nodeSize + 10);
                    }
                    //Ve mui ten
                    g.setColor(Color.BLACK);
                    // Vẽ đường thẳng
                    int x1 = (i + 1) * 80 - 40;
                    int y1 = 20;
                    int x2 = (i + 1) * 80;
                    int y2 = 20;
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
                g.drawString("null", 0 + i * 80 + nodeSize / 2 - 5, 0 + nodeSize / 2 + 5);
    
                //Ve newNode
                g.setColor(Color.GRAY);
                g.fillRect(0, nodeSize*2, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(this.value + "", (index-1) * 80 + nodeSize / 2 - 5, 0 + nodeSize*2 + nodeSize / 2 + 5);
    
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = (index-1) * 80 + 20;
                int y1 = 80;
                int x2 = (index-1) * 80 + 20;
                int y2 = 80 - delta;
                g.drawLine(x1, y1, x2, y2);
                if (delta >= 40) {
                    // Vẽ đầu mũi tên
                    double angle = Math.atan2(y2 - y1, x2 - x1);
                    int dx = (int) (10 * Math.cos(angle));
                    int dy = (int) (10 * Math.sin(angle));
                    g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                    g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                }
            } 
        }

        if (insertMid) {
            if (stage >= 1) {
                Node p = linkedList.getHead();
                int i = 0;
                while (p != null) {
                    //Ve node
                    if (i == indexCurrent && i == index - 2) {
                        g.setColor(Color.GREEN);
                    } else if (i == indexCurrent) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLUE);
                    }
                    g.fillRect(i * 80, 0, nodeSize, nodeSize);
                    g.setColor(Color.WHITE);
                    g.drawString(p.getData() + "", i * 80 + nodeSize / 2 - 5, nodeSize / 2 + 5);
                    //ve chi so
                    g.setColor(Color.BLACK);
                    if (i == 0) {
                    g.drawString("head [" + (i+1) + "]" , i * 80, 50);
                    } else {
                    g.drawString("[" + (i+1) + "]" , i * 80 + 15, nodeSize + 10);
                    }
                    //Ve mui ten
                    g.setColor(Color.BLACK);
                    // Vẽ đường thẳng
                    int x1 = (i + 1) * 80 - 40;
                    int y1 = 20;
                    int x2 = (i + 1) * 80;
                    int y2 = 20;
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
                g.drawString("null", i * 80 + nodeSize / 2 - 5, nodeSize / 2 + 5);
            }

            if (stage >= 2) {
                //Ve newNode
                g.setColor(Color.GRAY);
                g.fillRect((index-1) * 80, 0 + nodeSize*2, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(this.value + "", 0 + (index-1) * 80 + nodeSize / 2 - 5, 0 + nodeSize*2 + nodeSize / 2 + 5);
                // Ve mui ten 1
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = (index-1) * 80 + 20;
                int y1 = 80;
                int x2 = (index-1) * 80 + 20;
                int y2 = 80 - delta;
                g.drawLine(x1, y1, x2, y2);
                if (delta >= 40) {
                    // Vẽ đầu mũi tên
                    double angle = Math.atan2(y2 - y1, x2 - x1);
                    int dx = (int) (10 * Math.cos(angle));
                    int dy = (int) (10 * Math.sin(angle));
                    g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                    g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                } 
            }

            if (stage >= 3) {
                // Xoa mui ten
                g.setColor(this.getBackground());
                // Vẽ đường thẳng
                int x1 = (index - 1) * 80 - 40;
                int y1 = 20;
                int x2 = (index - 1) * 80;
                int y2 = 20;
                g.drawLine(x1, y1, x2, y2);
                // Vẽ đầu mũi tên
                double angle = Math.atan2(y2 - y1, x2 - x1);
                int dx = (int) (10 * Math.cos(angle));
                int dy = (int) (10 * Math.sin(angle));
                g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);

                // Ve mui ten 2
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                x1 = (index - 1) * 80 - 40;
                y1 = 40;
                x2 = (index - 1) * 80 - 40 + beta;
                y2 = 40 + beta;
                g.drawLine(x1, y1, x2, y2);
                if (beta >= 40) {
                    // Vẽ đầu mũi tên
                    angle = Math.atan2(y2 - y1, x2 - x1);
                    dx = (int) (10 * Math.cos(angle));
                    dy = (int) (10 * Math.sin(angle));
                    g.drawLine(x2, y2, x2 - dx - dy, y2 - dy + dx);
                    g.drawLine(x2, y2, x2 - dx + dy, y2 - dy - dx);
                }

            }

        }
     
        if (end) {
            Node p = linkedList.getHead();
            int i = 0;
            while (p != null) {
                //Ve node
                g.setColor(Color.BLUE);
                g.fillRect(0 + i * 80, 0, nodeSize, nodeSize);
                g.setColor(Color.WHITE);
                g.drawString(p.getData() + "", 0 + i * 80 + nodeSize / 2 - 5, 0 + nodeSize / 2 + 5);
                //ve chi so
                g.setColor(Color.BLACK);
                if (i == 0) {
                g.drawString("head [" + (i+1) + "]" , 0 + i * 80, 0 + nodeSize + 10);
                } else {
                g.drawString("[" + (i+1) + "]" , 0 + i * 80 + 15, 0 + nodeSize + 10);
                }
                //Ve mui ten
                g.setColor(Color.BLACK);
                // Vẽ đường thẳng
                int x1 = (i + 1) * 80 - 40;
                int y1 = 20;
                int x2 = (i + 1) * 80;
                int y2 = 20;
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
            g.drawString("null", 0 + i * 80 + nodeSize / 2 - 5, 0 + nodeSize / 2 + 5);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (search) {
            if (stage == 2 || stage == 3) {
                end = true;
                search = false;
            }
            else if (indexCurrent >= size) {
                stage = 3;
            } else if (stage == 1) {
                if (found) {
                    stage = 2;
                } else {
                    indexCurrent++;
                } 
            }
        }

        else if (removeMid) {
            if (stage == 1) {
                timer.setDelay(1000);
                if (indexCurrent == index - 2) {
                    stage = 2;
                }
                if (indexCurrent < index - 2) {
                    indexCurrent++;
                } 
            }

            if (stage == 2) {
                timer.setDelay(25);
                if (beta < 30) {
                    beta++;
                } else if (beta == 30 && alpha < 160) {
                    alpha += 5;
                } else if (alpha == 160 && delta < 28) {
                    delta++;
                } else if (delta == 28 || delta == 29) {
                    timer.setDelay(1000);
                    delta++;
                } else if (delta == 30) {
                    timer.setDelay(25);
                    linkedList.remove(index);
                    end = true;
                    removeMid = false;
                }
            }
        }

        else if (removeFirst) {
    
            if (delta < 78) {
                delta++;
            } else if (delta == 78 || delta == 79) {
                timer.setDelay(1000);
                delta++;
            } else if (delta == 80) {
                timer.setDelay(25);
                linkedList.remove(index);
                removeFirst = false;
                end = true;
            }
        }
   
        else if (begin) {
            linkedList.insertMid(value, index);
            end = true;
            begin = false;
        }

        else if (insertFirst) {
            if (delta < 38) {
                delta++;
            } else if (delta == 38 || delta == 39) {
                timer.setDelay(1000);
                delta++;
            } else if (delta == 40 && alpha < 78) {
                timer.setDelay(25);
                alpha += 2;
            } else if (alpha == 78 || alpha == 80) {
                timer.setDelay(1000);
                alpha += 2;
            } else if (alpha == 82) {
                timer.setDelay(25);
                linkedList.insertMid(value, index);
                end = true;
                insertFirst = false;
            }
        }

        else if (insertMid) {
            if (stage == 1) {
                if (indexCurrent == index - 2) {
                    stage = 2;
                }
                if (indexCurrent < index - 2) {
                    indexCurrent++;
                } 
            }

            if (stage == 2) {
                timer.setDelay(25);
                if (delta < 38) {
                    delta++;
                } else if (delta == 38 || delta == 39) {
                    timer.setDelay(1000);
                    delta++;
                } else if (delta == 40) {
                    stage = 3;
                }
            }

            if (stage == 3) {
                if (beta < 38) {
                    beta++;
                } else if (beta == 38 || beta == 39) {
                    timer.setDelay(1000);
                    beta++;
                } else if (beta == 40) {
                    linkedList.insertMid(value, index);
                    end = true;
                    insertMid = false;
                }
            }
        }

        else if (end) {
            timer.stop();
        }

        repaint();
    }   
}
