package linearTable.arrays;

/**
 * 类MedianOfTwoSortedArrays.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年8月17日 下午5:07:53
 */
public class MedianOfTwoSortedArrays {
    
    private int findKTh(int A[], int beginA, int B[], int beginB, int k) {
        if( (A.length-beginA) < (B.length-beginB) ) {
            return findKTh(B, beginB, A, beginA, k);
        }
        
        if(beginB == B.length) {
            return A[beginA+k-1];
        }
        
        if(k == 1) {
            return A[beginA] > B[beginB] ? B[beginB] : A[beginA];
        }
    
        int kb = Math.min(k/2, B.length-beginB);
        int ka = k - kb;
        if(A[beginA+ka-1] == B[beginB+kb-1]) {
            return A[beginA+ka-1];
        }else if(A[beginA+ka-1] < B[beginB+kb-1]) {
            return findKTh(A, beginA+ka, B, beginB, k-ka);
        }else {
            return findKTh(A, beginA, B, beginB+kb, k-kb);
        }
    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int totalLen = A.length + B.length;
        if(totalLen%2 == 0) {
            return (findKTh(A, 0, B, 0, totalLen/2) + 
                    findKTh(A, 0, B, 0, totalLen/2+1))/2.0;
        }else {
            return findKTh(A, 0, B, 0, totalLen/2+1);
        }
    }
    
    public static void main(String... args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {2, 3, 5, 8, 10, 12, 15, 18};
//        int[] a = {100000}, b = {100001};
        MedianOfTwoSortedArrays md = new MedianOfTwoSortedArrays();
        System.out.println(md.findMedianSortedArrays(a, b));
    }
}
