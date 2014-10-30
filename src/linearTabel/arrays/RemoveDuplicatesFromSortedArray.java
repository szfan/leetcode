package linearTabel.arrays;

/**
 * 类RemoveDuplicatesFromSortedArray.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年7月31日 上午9:09:47
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int index = 0;
        for ( int i = 0; i < A.length; ++i) {
            if (A[i] != A[index]) {
                A[++index] = A[i];
            }
        }
        return index+1;
    }
    
    public static void main(String... args) {
        int[] a = {1,2,2,3,4,5,5,6,6};
        System.out.println(removeDuplicates(a));
    }
}
