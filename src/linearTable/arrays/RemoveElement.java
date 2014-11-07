package linearTable.arrays;

/**
 * 类RemoveElement.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年7月31日 上午11:56:29
 */
public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] != elem) {
                A[index++] = A[i];
            }
        }
        return index;
    }
    
    public static void main(String... args) {
        int[] A = {1,2,3,4,5,6,4,5,6,5};
        System.out.println(removeElement(A, 0));
    }
}
