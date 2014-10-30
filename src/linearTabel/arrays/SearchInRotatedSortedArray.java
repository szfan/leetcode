package linearTabel.arrays;

/**
 * 类SearchInRotatedSortedArray.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年8月3日 上午10:31:37
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int low = 0, high = A.length-1, mid;
        while(low <= high) {
            mid  = (low+high)/2;
            if(target == A[mid]) {
                return mid;
            }
            else if(A[low] <= A[mid]) {
                if(target >= A[low] && target < A[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if(target > A[mid] && target <= A[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String... args) {
        SearchInRotatedSortedArray se = new SearchInRotatedSortedArray();
        int[] A = {4,5,6,7,8,1,2,3};
        System.out.println(se.search(A, 8));
    }
}
