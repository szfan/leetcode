package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum.java:
 *
 * @author zefan.szf on 2016-07-10 15:43
 */
public class TwoSum {

    public static void main(String... args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println(result[0] + "\t" + result[1]);
    }

    // notice that the target may equals a num times 2 in that array
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = numMap.get(target-nums[i]);
                if (numMap.get(target-nums[i]) != i) {
                    return result;
                }
            }
        }
        return result;
    }

}
