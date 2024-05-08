package type_sort;
import view.Menuview;
import anima.Animation_shell;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.util.Random;
public class Shell_Sort {
    public Animation_shell animation_shell;
    private String a[];
    public Shell_Sort(Menuview menuview){
        menuview.setJLable("Shell");
    }
    public Shell_Sort(Menuview menuview, String src){
        int n = Integer.parseInt(src);
        Random rand = new Random();
        this.a = new String[n];
        for(int i = 0; i < n ; i++){
            int randInt = rand.nextInt(100);
            String in = Integer.toString(randInt);
            this.a[i] = in;
        }
        this.animation_shell = new Animation_shell(n, a);
        this.animation_shell.setBackground(Color.MAGENTA);

        BorderLayout layout = (BorderLayout) menuview.getLayout();
        Component comp = layout.getLayoutComponent(BorderLayout.CENTER);
        if (comp != null){
            menuview.getContentPane().remove(comp);
            menuview.revalidate();
            menuview.repaint();
        }
        menuview.add(this.animation_shell, BorderLayout.CENTER);
        menuview.revalidate();
        menuview.repaint();
        System.out.println("Shell");
    }
    public void settime(int n, Animation_shell animation_shell){
        animation_shell.settimeanima(n);
    }
}
