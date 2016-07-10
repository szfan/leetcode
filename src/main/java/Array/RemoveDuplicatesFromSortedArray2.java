package Array;

import java.util.Arrays;

/**
 * RemoveDuplicatesFromSortedArray2.java:
 *
 * @author zefan.szf on 2016-07-08 22:38
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String... args) {
        RemoveDuplicatesFromSortedArray2 re = new RemoveDuplicatesFromSortedArray2();
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        System.out.println(re.removeDuplicates(nums));
        Arrays.stream(nums).forEach(System.out::print);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int idx = 0, tmpcnt = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[idx] && tmpcnt == 1) {
                idx++;
                tmpcnt++;
                nums[idx] = nums[i];
            } else if (nums[i] == nums[idx] && tmpcnt == 2) {
                continue;
            } else {
                idx++;
                tmpcnt = 1;
                nums[idx] = nums[i];
            }
        }
        return idx+1;
    }
}
