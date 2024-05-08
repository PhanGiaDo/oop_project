package type_sort;
import view.Menuview;
import anima.Animation_merge;
public class Merge_Sort {
    public Merge_Sort(Menuview menuview){
        menuview.setJLable("Merge");
    }
    public Merge_Sort(Menuview menuview, String src){
        int n = Integer.parseInt(src);
        menuview.setJPanel2_merge(new Animation_merge(n));
        System.err.println("Merge");
    }
}
