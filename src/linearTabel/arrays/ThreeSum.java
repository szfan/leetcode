package linearTabel.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类ThreeSum.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年10月24日 上午11:28:26
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        if(num.length < 3)
            return null;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int target = 0;
        
        for(int i = 0; i < num.length-2; ++i) {
            
        }
        return results;
    }
    public static void main(String... args) {
        int[] a = {-1, 0, 1, 2, -1, -4,};
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> results = ts.threeSum(a);
        for(List<Integer> outer : results) {
            for(int inner : outer) {
                System.out.print(inner + "\t");
            }
            System.out.println();
        }
    }
}
