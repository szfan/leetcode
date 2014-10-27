package linearTabel.arrays;

import java.util.Arrays;

/**
 * 类ThreeSumCloest.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年10月27日 下午3:33:10
 */
public class ThreeSumCloest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = num[0]+num[1]+num[2];
        int minMargin = Math.abs(target-result);
        
        for(int i = 0; i < num.length-1; ++i) {
            int tmpTarget = target - num[i];
            int prev = i+1, last = num.length-1;
            while(prev < last) {
                if(num[prev] + num[last] == tmpTarget) {
                    return target;
                }else if(num[prev]+num[last] < tmpTarget) {
                    if(Math.abs(tmpTarget-num[prev]-num[last]) < minMargin) {
                        minMargin = Math.abs(tmpTarget-num[prev]-num[last]);
                        result = num[i]+num[prev]+num[last];
                    }
                    prev++;
                }else {
                    if(Math.abs(tmpTarget-num[prev]-num[last]) < minMargin) {
                        minMargin = Math.abs(tmpTarget-num[prev]-num[last]);
                        result = num[i]+num[prev]+num[last];
                    }
                    last--;
                }
                while(prev < last && num[prev] == num[prev-1]) {
                    prev++;
                }
                while(prev < last && last < num.length-1 && num[last] == num[last+1]) {
                    last--;
                }
            }
        }
        return result;
    }
    public static void main(String... args) {
        int[] num = {-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
        int target = 18;
        ThreeSumCloest ts = new ThreeSumCloest();
        System.out.println(ts.threeSumClosest(num, target));
    }
}
