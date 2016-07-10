package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThreeSum.java:
 *
 * @author zefan.szf on 2016-07-10 20:14
 */
public class ThreeSum {

    public static void main(String... args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(nums).stream().forEach(System.out::print);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int begin = i+1, end = nums.length-1;
            while (begin < end) {
                if (nums[i] + nums[begin] + nums[end] == 0) {
                    ArrayList<Integer> tmpSol = new ArrayList<>();
                    tmpSol.add(nums[i]);
                    tmpSol.add(nums[begin]);
                    tmpSol.add(nums[end]);
                    result.add(tmpSol);
                    while (begin < end && nums[begin] == nums[begin+1]) {
                        begin++;
                    }
                    while (end > begin && nums[end] == nums[end-1]) {
                        end--;
                    }
                    begin++; end--;
                } else if (nums[i] + nums[begin] + nums[end] < 0) {
                    while (begin < end && nums[begin] == nums[begin+1]) {
                        begin++;
                    }
                    begin++;
                } else {
                    while (end > begin && nums[end] == nums[end-1]) {
                        end--;
                    }
                    end--;
                }
            }
        }
        return result;
    }
}
