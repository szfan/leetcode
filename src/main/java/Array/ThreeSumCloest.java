package Array;

import java.util.Arrays;

/**
 * ThreeSumCloest.java:
 *
 * @author zefan.szf on 2016-07-10 20:57
 */
public class ThreeSumCloest {

    public static void main(String... args) {
        ThreeSumCloest t = new ThreeSumCloest();
        int[] nums = {1,1,1,0};
        int target = -100;
        System.out.println(t.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int gap = -1;

        for(int i = 0; i < nums.length-2; i++) {
            int begin = i+1, end = nums.length-1;

            int newgap, tmpresult;
            while (begin < end) {
                if (target == nums[i] + nums[begin] + nums[end]) {
                    return target;
                } else if (nums[i] + nums[begin] + nums[end] < target) {
                    newgap = target - (nums[i] + nums[begin] + nums[end]);
                    tmpresult = target - newgap;
                    begin++;
                } else {
                    newgap = nums[i] + nums[begin] + nums[end] - target;
                    tmpresult = target + newgap;
                    end--;
                }
                result = ((newgap < gap) || (gap == -1)) ? tmpresult : result;
                gap = ((newgap < gap) || (gap == -1)) ? newgap : gap;
            }
        }
        return result;
    }

}
