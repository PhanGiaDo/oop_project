package z.test;

import javax.swing.UIManager;
import z.view.Menuview;

public class Test {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Menuview();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
