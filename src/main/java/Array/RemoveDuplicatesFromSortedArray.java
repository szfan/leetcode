package Array;

import java.util.Arrays;

/**
 * RemoveDuplicatesFromSortedArray.java:
 *
 * @author zefan.szf on 2016-07-08 22:24
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String... args) {
        RemoveDuplicatesFromSortedArray re = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        System.out.println(re.removeDuplicates(nums));
        Arrays.stream(nums).forEach(System.out::print);
    }

    // after optimize, the function use only one addtional variable
    // notice that we should return idx+1 as new length of array
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[idx]) {
                continue;
            } else {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx+1;
    }

}
