package anima;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Animation_selec extends JPanel implements ActionListener{
    private Timer timer;
    private int n;
    private String a[];
    private Boolean visible_selection = true;
    private Boolean visible_swapping = false;
    private Boolean visible_shift = false;
    private int counter_shift = 0;
    private int i = counter_shift-1;
    private int mini = counter_shift;
    private int x = -2;
    private int y = 0;
    private int xs = 0;
    private int xc = 0;
    private int yx = 1;
    private Boolean xuong = true;
    private Boolean xuongmax = false;
    private int d = 2;
    private int dswap = 4;

///////////////////////////////////////////////////////////////////////////


    public Animation_selec(int n, String src[]) {
        a = new String[n];
        this.n = n;
        for(int i = 0; i < n ; i++)
            this.a[i] = src[i];
        this.timer = new Timer(30, this);
        this.timer.start();
    }
    public void settimeanima(int n){
        this.timer.setDelay(n);
    }

/////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int ii = 0; ii < n ; ii++){
            g.setColor(Color.RED);
            g.fillRect(200 + ii*60, 35, 50, 50);

            if(ii == counter_shift || ii == mini){
                g.setColor(Color.GRAY);
                g.fillRect(200 + ii*60, 35, 50, 50);
            }

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(this.a[ii], 217 + ii*60, 67);
        }

        g.setColor(Color.WHITE);
        g.fillRect(193+xc, 10, 5, 80);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString("SORTED ARRAY", 65+xc, 17);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString("UNSORTED ARRAY", 205+xc, 17);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("LOGIC:", 5, 70);
    
        if(visible_selection){
            g.setColor(Color.GREEN);
            g.fillRect(0, 105, 135, 40);
        }
        else if(visible_swapping){
            g.setColor(Color.GREEN);
            g.fillRect(0, 155, 135, 40);
        }
        else if(visible_shift){
            g.setColor(Color.GREEN);
            g.fillRect(0, 205, 135, 40);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("SELECTION", 5, 130);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("SWAPPING", 5, 180);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("COUNTER SHIFT", 5, 230);
        
        if(this.visible_selection){
            if(this.xuong){
                g.setColor(Color.GRAY);
                g.fillRect(200 + mini*60, 100, 50, 50);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString(this.a[this.mini], 217 + mini*60, 67 + yx);
            }
            else{
                g.setColor(Color.GRAY);
                g.fillRect(200 + counter_shift*60 + x, 100, 50, 50);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString(this.a[this.mini], 217 + counter_shift*60 + x, 132);
                if(this.i == n-1) {
                    visible_selection = false; 
                    visible_swapping = true;
                }
            }
        }
        else if(this.visible_swapping){
            g.setColor(Color.GRAY);
            g.fillRect(200 + counter_shift*60, 35, 50, 50);
            g.setColor(Color.GRAY);
            g.fillRect(200 + mini*60, 35, 50, 50);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(this.a[counter_shift], 217 + counter_shift*60 + xs, 67 + y);

            if(this.counter_shift != this.mini){
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString(this.a[mini], 217 + mini*60 - xs, 67 + y);
            }
        }
        g.setColor(Color.WHITE);
        g.fillRect(135, 30, 5, 500);
    } 


/////////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent e) {
        if(this.visible_selection){
            if(this.xuong){
                yx += d;
                if(yx == 65){
                    yx = 1;
                    this.xuong = false;
                }
            }
            else
                this.x += d;
        }
        if(this.visible_selection && (this.x%60 == 0)){
            this.i++;
            if(Integer.parseInt(this.a[mini]) > Integer.parseInt(this.a[i])){
                x += d;
                this.xuong = true;
                this.mini = this.i; 
            }
        }
        else if(this.visible_swapping){
            if(!xuongmax){
                y += dswap;
                if(y == 60) xuongmax = true;
            }
            else if(xs <= (mini - counter_shift)*60)
                xs += dswap;
            else if( y >= 0) y -= d;
            else{
                swap(counter_shift, mini);
                this.visible_swapping = false;
                this.visible_shift = true;
            }
        }
        else if(this.visible_shift){
            this.xc += d;
                if(this.xc%60 == 0){
                this.counter_shift++;
                this.i = counter_shift-1;
                this.mini = counter_shift;
                this.x = -2;
                this.y = 0;
                this.xs = 0;
                this.xuong = true;
                this.xuongmax = false;
                this.visible_selection = true;
                this.visible_shift = false;
            }
        }
        if(this.counter_shift == this.n){
            this.visible_selection = false;
            this.visible_shift = false;
            this.visible_swapping = false;
        }
        repaint();
    }
    private void swap(int a1, int a2){
        String temp = a[a1];
        setstring(a1, a[a2]);
        setstring(a2, temp);
    }
    private void setstring(int ii, String src){
        this.a[ii] = src;
    }
}