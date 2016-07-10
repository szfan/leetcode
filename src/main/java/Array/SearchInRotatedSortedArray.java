package Array;

/**
 * SearchInRotatedSortedArray.java:
 *
 * @author zefan.szf on 2016-07-08 23:17
 */
public class SearchInRotatedSortedArray {
    public static void main(String... args) {
        int[] nums = {4,5,6,7,0,1,2};
        SearchInRotatedSortedArray se = new SearchInRotatedSortedArray();
        System.out.println(se.search(nums, 3));
    }

    // it's hard to determine the bounds
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
