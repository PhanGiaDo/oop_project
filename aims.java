import javax.swing.UIManager;
import view.Menuview;
public class aims{
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Menuview();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
