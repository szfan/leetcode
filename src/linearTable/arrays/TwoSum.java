package linearTable.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 类TwoSum.java的实现描述：leetcode Two Sum
 * @author zefan.szf 2014年10月24日 上午9:03:26
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numberIndex = new HashMap<Integer, Integer>();
        int[] index = new int[2];
        
        for(int i = 0; i < numbers.length; ++i) {
            if(numberIndex.containsKey(target-numbers[i])) {
                if(numberIndex.get(target-numbers[i]) < i+1) {
                    index[0]  = numberIndex.get(target-numbers[i]);
                    index[1] = i+1;
                }
            }else {
                numberIndex.put(numbers[i], i+1);
            }
        }
        return index;
    }

    public static void main(String... args) {
        int[] numbers = {0, 1, 2, 0};
        int target = 0;
        TwoSum ts = new TwoSum();
        int[] index = new int[2];
        index = ts.twoSum(numbers, target);
        System.out.println(index[0] + " " + index[1]);
    }
}
