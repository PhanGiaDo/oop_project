package controll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.Menuview;
import type_sort.*;

public class Controller implements ActionListener{
    private Menuview menuview;
    private Selection_Sort selection_Sort;
    private Merge_Sort merge_Sort;
    private Shell_Sort shell_Sort;

    public Controller(Menuview menuview) {
        this.menuview = menuview;
    }
    
    public void actionPerformed(ActionEvent e) {
        String choose = e.getActionCommand();
        switch (choose) {
            case "usage":
                try {
                    Runtime.getRuntime().exec(new String[] { "notepad.exe", "help/usage.txt" });
                } catch (Exception a) {
                    a.printStackTrace();
                }
                break;
            case "aim":
                try {
                    Runtime.getRuntime().exec(new String[] { "notepad.exe", "help/aims.txt" });
                } catch (Exception a) {
                    a.printStackTrace();
                }
                break;
            case "Quit":
                int response = JOptionPane.showConfirmDialog(
                        this.menuview,
                        "Are you sure you want to quit?",
                        "Quit Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon("warning.png")
                );
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
            case "Merge Sort":
                this.merge_Sort = new Merge_Sort(menuview);
                this.shell_Sort = null;
                this.selection_Sort = null;
                break;
            case "Selection Sort":
                this.selection_Sort = new Selection_Sort(menuview);
                this.merge_Sort = null;
                this.shell_Sort = null;
                break;
            case "Shell Sort":
                this.shell_Sort = new Shell_Sort(menuview);
                this.merge_Sort = null;
                this.selection_Sort = null;
                break;
            case "start":
                if(checktext(this.menuview.boxn.getText()) == 0){
                    this.menuview.setTEST("Wrong input");
                }
                else{
                    if(this.selection_Sort != null){
                        this.selection_Sort = new Selection_Sort(menuview, this.menuview.boxn.getText());
                    }
                    if(this.merge_Sort != null){
                        this.merge_Sort = new Merge_Sort(menuview, this.menuview.boxn.getText());
                    }
                    if(this.shell_Sort != null){
                        this.shell_Sort = new Shell_Sort(menuview, this.menuview.boxn.getText());
                    }
                }
            break;
            case "continue":
                if(this.selection_Sort != null){
                    this.selection_Sort.settime(30, this.selection_Sort.animation_selec);
                    System.out.println("continue");
                }
                if(this.merge_Sort != null){
                    new Merge_Sort(menuview, this.menuview.boxn.getText());
                }
                if(this.shell_Sort != null){
                    this.shell_Sort.settime(20, this.shell_Sort.animation_shell);
                    System.out.println("continue");
                }
            break;
            case "stop":
                if(this.selection_Sort != null){
                    this.selection_Sort.settime(1000, this.selection_Sort.animation_selec);
                    System.out.println("stop");
                }
                if(this.merge_Sort != null){
                    new Merge_Sort(menuview, this.menuview.boxn.getText());
                }
                if(this.shell_Sort != null){
                    this.shell_Sort.settime(5000, this.shell_Sort.animation_shell);
                    System.out.println("stop");
                }
            break;
            default:
                break;
        }
    }
    private int checktext(String n){
        if(n.isEmpty()) return 0;
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) < '0' || n.charAt(i) > '9') return 0;
        }
        return 1;
    }
}