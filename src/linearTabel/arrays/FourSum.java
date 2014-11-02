package linearTabel.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类FourSum.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年10月27日 下午4:56:18
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Set<List<Integer>> tmpset = new HashSet<List<Integer>>();
        
        for(int i = 0; i < num.length-3; ++i) {
            if(i > 0 && num[i] == num[i-1]) {
                continue;
            }
            for(int j = i+1; j < num.length; ++j) {
                if(j != i+1 && num[j] == num[j-1]) {
                    continue;
                }
                int tmptarget = target - num[i] - num[j];
                int k = j+1, l = num.length-1;
                while(k < l) {                    
//                    while(k < l && k != j+1 && num[k] == num[k+1]) {
//                        ++k;
//                    }
//                    while(k < l && l != num.length-1 && num[l] == num[l-1]) {
//                        --l;
//                    }
                    if(num[k]+num[l] == tmptarget) {
                        List<Integer> tmplist = new ArrayList<Integer>();
                        tmplist.add(num[i]);
                        tmplist.add(num[j]);
                        tmplist.add(num[k]);
                        tmplist.add(num[l]);
                        ++k;
                        --l;
                        if(!tmpset.contains(tmplist)) {
                            tmpset.add(tmplist);
                            results.add(tmplist);
                        }
                    }else if(num[k]+num[l] < tmptarget) {
                        ++k;
                    }else {
                        --l;
                    }
                }
            }
        }
        return results;
    } 
    public static void main(String... args) {
        int[] num = {0,1,5,0,1,5,5,-4};
        int target = 11;
        FourSum fs = new FourSum();
        List<List<Integer>> results = fs.fourSum(num, target);
        for(List<Integer> a : results) {
            for(int aa : a) {
                System.out.print(aa + "\t");
            }
            System.out.println();
        }
    }
}
