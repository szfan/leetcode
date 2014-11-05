package linearTabel.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 类GrayCode.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月5日 下午8:02:11
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < size; ++i) {
            result.add(i ^ (i>>1));
        }
        return result;
    }
    public static void main(String... args) {
        
    }
}
