package linearTable.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类ThreeSum.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年10月24日 上午11:28:26
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(num.length < 3)
            return results;
        Arrays.sort(num);
        
        for(int i = 0; i < num.length-2; ++i) {
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            int prev = i+1, last = num.length-1;
            int target =  0 - num[i];
            while(prev < last) {
                if(num[prev] + num[last] == target) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[prev]);
                    tmp.add(num[last]);
                    results.add(tmp);
                    prev++; last--;
                    while(prev < last && num[prev] == num[prev-1]) {
                        prev++;
                    }
                    while(prev < last && last < num.length && num[last] == num[last+1]) {
                        last--;
                    }
                }else if(num[prev] + num[last] < target) {
                    prev++;
                }else {
                    last--;
                }
            }
        }
        return results;
    }
    public static void main(String... args) {
        int[] a = {-2,0,1,1,2};
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
