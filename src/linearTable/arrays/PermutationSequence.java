package linearTable.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 类PermutationSequence.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月4日 下午8:52:08
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        String result = "";
        
        int[] nf = new int[n];
        List<Integer> list = new ArrayList<Integer>();
        nf[0] = 1;
        list.add(1);
        for(int i = 1; i < n; ++i) {
            nf[i] = nf[i-1] * i;
            list.add(i+1);
        }
        int index = 0;
        while(n > 0) {
            index = k/nf[n-1];
            if(index*nf[n-1] != k) {
                index += 1;
            }
            int tmp = list.get(index-1);
            result += tmp;
            list.remove(index-1); 
            k -= nf[n-1]*(index-1);
            --n;
        }
        return result;
    }
    public static void main(String... args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(6, 4));
    }
}
