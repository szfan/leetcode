package linearTabel.arrays;

/**
 * 类ClimbingStairs.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月5日 下午5:09:55
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 0) {
            return 0;
        }
        double sqrt5 = Math.sqrt(5);
        return (int) Math.floor(1/sqrt5 * ( Math.pow((1+sqrt5)/2, n+1) - Math.pow((1-sqrt5)/2, n+1)));
    }
    public static void main(String... args) {
        int n = 2;
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(n));
    }
}
