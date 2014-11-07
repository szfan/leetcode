package linearTable.arrays;

/**
 * 类SearchInRotatedSortedArrayII.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年8月3日 下午4:48:29
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return false;
        }
        int low = 0, high = A.length-1, mid;
        while(low <= high) {
            mid = (low+high)/2;
            if(target == A[mid]) {
                return true;
            }
            else if(A[low] < A[mid]) {
                if(target >= A[low] && target < A[mid]) {
                    high = mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else if(A[low] > A[mid]){
                if(target > A[mid] && target <= A[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            else{
                low = low + 1;
            }
        }
        return false;
    }
    
    public static void main(String... args) {
        SearchInRotatedSortedArray se = new SearchInRotatedSortedArray();
        int[] A = {1};
        System.out.println(se.search(A, 1));
    }
}
