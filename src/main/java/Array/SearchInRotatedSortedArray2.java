package Array;

/**
 * SearchInRotatedSortedArray2.java:
 *
 * @author zefan.szf on 2016-07-09 12:11
 */
public class SearchInRotatedSortedArray2 {
    public static void main(String... args) {
        SearchInRotatedSortedArray2 se = new SearchInRotatedSortedArray2();
        int[] nums = {1,3,1,1,1};
        System.out.println(se.search(nums, 2));
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[low] || target == nums[mid] || target == nums[high]) {
                return true;
            }
            if (nums[low] < nums[mid]) {
                if (nums[low] < target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[low] > nums[mid]) {
                if (nums[mid] < target && target < nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low++;
            }
        }
        return false;
    }
}
