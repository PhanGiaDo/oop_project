package anima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation_shell extends JPanel implements ActionListener{
    private Timer timer;
    private int n;
    private String a[];
    private int gap;
    private int i;
    private int j;
    private String temp;

    private Boolean xuong = true;
    private Boolean len = false;
    private Boolean sang = true;
    private int x = 0;
    private int yxuong = 0;

    private Boolean to = false;
    private int dto = 0;

    private Boolean swap = false;
    private Boolean xuongswap = true;
    private Boolean sangswap = false;
    private Boolean lenswap = false;
    private int xswap = 0;
    private int yswap = 0;

    public Animation_shell(int n, String src[]) {
        a = new String[n];
        for(int ii = 0; ii < n ; ii++)
            this.a[ii] = src[ii];
        this.n = n;
        this.gap = n/2;
        this.i = gap;
        this.temp = a[this.i];
        this.j = i;
        this.timer = new Timer(20, this);
        this.timer.start();
    }

    public void settimeanima(int n){
        this.timer.setDelay(n);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int ii = 0; ii < n ; ii++){
            if(this.j == ii) continue;
            g.setColor(Color.WHITE);
            g.fillRect(getWidth()/2 - n*30 + ii*60, 35, 50, 50);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(this.a[ii], getWidth()/2 - n*30 + 17 + ii*60, 67);
        }
        if(j != i){
            g.setColor(Color.MAGENTA);
            g.fillRect(getWidth()/2 - n*30 + (j + gap)*60, 35, 50, 50);
        }

        //2 o duoi
        g.setColor(Color.GRAY);
        g.fillRect(10, getHeight() - 60, 25, 25);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 17));
        g.drawString("comparison", 40, getHeight() - 60 + 17);
        g.setColor(Color.YELLOW);
        g.fillRect(10, getHeight() - 30, 25, 25);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 17));
        g.drawString("item to insert", 40, getHeight() - 30 + 17);
        //2 o duoi

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 26));
        g.drawString("cur gap = " + this.gap, 10, getHeight() - 90);

        g.setColor(Color.WHITE);
        g.fillRect(getWidth()/2 - n*30 + this.i*60 + x, 35 + yxuong, 50, 50);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("\\/", getWidth()/2 - n*30 + 20 + this.i*60, 20);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString(this.temp, getWidth()/2 - n*30 + 17 + this.i*60 + x, 67 + yxuong);

        if(this.len && i != j){
            g.setColor(Color.WHITE);
            g.fillRect(getWidth()/2 - n*30 + (j + gap)*60, 35, 50, 50);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(this.a[(j + gap)], getWidth()/2 - n*30 + 17 + (j + gap)*60, 67);
        }

        if(this.to){
            if(i == j){
                g.setColor(Color.GRAY);
                g.fillRect(getWidth()/2 - n*30 + (j-gap)*60 - dto/2, 35 - dto/2, 50 + dto, 50 + dto);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString(this.a[(j-gap)], getWidth()/2 - n*30 + 17 + (j-gap)*60, 67);

                g.setColor(Color.GRAY);
                g.fillRect(getWidth()/2 - n*30 + this.i*60 - dto/2, 205 - dto/2, 50 + dto, 50 + dto);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString(this.temp, getWidth()/2 - n*30 + 17 + this.i*60, 237);
            }
            else{
                g.setColor(Color.GRAY);
                g.fillRect(getWidth()/2 - n*30 + j*60 - dto/2, 35 - dto/2, 50 + dto, 50 + dto);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString(this.a[j], getWidth()/2 - n*30 + 17 + j*60, 67);

                g.setColor(Color.GRAY);
                g.fillRect(getWidth()/2 - n*30 + this.i*60 - dto/2, 205 - dto/2, 50 + dto, 50 + dto);

                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString(this.temp, getWidth()/2 - n*30 + 17 + this.i*60, 237);
            }
        }
        else if(this.swap){
            g.setColor(Color.YELLOW);
            g.fillRect(getWidth()/2 - n*30 + j*60 + xswap, 35 + yswap, 50, 50);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(this.a[j], getWidth()/2 - n*30 + 17 + j*60 + xswap, 67 + yswap);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(this.xuong){
            this.yxuong += 4;

            if(yxuong == 172){
                this.xuong = false;
            }
        }
        else if(this.to){
            this.dto += 1;
            if(this.dto == 20){
                this.dto = 0;
                this.to = false;
            }
        }
        else if(this.len){
            if(this.sang){
                this.x -= 4;
                if(this.x <= -(i-j)*60) this.sang = false;
            }
            else{
                this.yxuong -= 4;
                if(this.yxuong == 0){
                    this.xuong = true;
                    this.x = 0;
                    this.len = false;
                    this.sang = true;
                    this.a[j] = temp;
                    this.i++;
                    if(this.i == n){
                        this.gap/=2;
                        this.i = gap;
                        this.temp = a[i];
                        this.j = i;
                    }else {
                        this.temp = a[i];
                        this.j = i;
                    }
                }
            }
        }
        else if(this.swap){
            if(this.xuongswap){
                this.yswap += 4;
                if(this.yswap == 100){
                    this.xuongswap = false;
                    this.sangswap = true;
                }
            }
            if(this.sangswap){
                this.xswap += 4;
                if(this.xswap == this.gap*60){
                    this.sangswap = false;
                    this.lenswap = true;
                }
            }
            if(this.lenswap){
                this.yswap -= 4;
                if(this.yswap == 0){
                    this.swap = false;
                    this.lenswap = false;
                    this.xuongswap = true;
                    this.yswap = 0;
                    this.xswap = 0;
                }
            }
        }
        else if(this.j >= gap && Integer.parseInt(this.temp) < Integer.parseInt(this.a[j-gap])){
            this.a[j] = a[j-gap];
            this.j -= gap;
            this.swap = true;
            this.to = true;
        }
        else if(this.j < gap || Integer.parseInt(this.temp) >= Integer.parseInt(this.a[j-gap])){
            this.len = true;
            if(i == j) this.to = true;

        }
        else {this.j -= gap; this.to = true;}

        if(this.gap == 0) this.timer.stop();
        repaint();
    }
}