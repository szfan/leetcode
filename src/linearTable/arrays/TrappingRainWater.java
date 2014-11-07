package linearTable.arrays;

/**
 * 类TrappingRainWater.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月5日 上午11:41:44
 */
public class TrappingRainWater {
    public int max(int a, int b) {
        return a > b ? a : b;
    }
    public int min(int a, int b) {
        return a > b ? b : a;
    }
    public int trap(int[] A) {
        if(A.length <= 0) {
            return 0;
        }
        int result = 0;
        int[] maxLeft  = new int[A.length];
        int[] maxRight = new int[A.length];
        maxLeft[0]     = 0;
        for(int i = 1; i < A.length; ++i) {
            maxLeft[i] = max(A[i-1], maxLeft[i-1]);
        }
        maxRight[A.length-1] = 0;
        for(int i = A.length-2; i >= 0; --i) {
            maxRight[i] = max(A[i+1], maxRight[i+1]);
        }
        
        for(int i = 1; i < A.length-1; ++i) {
            result += max(min(maxLeft[i], maxRight[i])-A[i], 0);
        }
        return result;
    }
    public static void main(String... args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trw = new TrappingRainWater();
        System.out.println(trw.trap(A));
    }
}
