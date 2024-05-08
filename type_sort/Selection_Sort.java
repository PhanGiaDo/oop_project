package type_sort;
import view.Menuview;
import anima.Animation_selec;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.util.Random;

public class Selection_Sort {

    public Animation_selec animation_selec;
    private String a[];

    public Selection_Sort(Menuview menuview){
        menuview.setJLable("Selection Sort: n = ");
    }


    public Selection_Sort(Menuview menuview, String src){
        int n = Integer.parseInt(src);
        Random rand = new Random();
        a = new String[n];
        for(int i = 0; i < n ; i++){
            int randInt = rand.nextInt(100);
            String in = Integer.toString(randInt);
            a[i] = in;
        }
        this.animation_selec = new Animation_selec(n, a);
        this.animation_selec.setBackground(Color.MAGENTA);

        BorderLayout layout = (BorderLayout) menuview.getLayout();
        Component comp = layout.getLayoutComponent(BorderLayout.CENTER);
        if (comp != null){
            menuview.getContentPane().remove(comp);
            menuview.revalidate();
            menuview.repaint();
        }
        menuview.add(this.animation_selec, BorderLayout.CENTER);
        menuview.revalidate();
        menuview.repaint();
        System.out.println("Selec");
    }
    
    public void settime(int n, Animation_selec animation_selec){
            animation_selec.settimeanima(n);
    }
}
