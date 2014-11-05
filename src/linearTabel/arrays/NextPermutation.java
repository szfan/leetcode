package linearTabel.arrays;

/**
 * 类NextPermutation.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月4日 下午8:27:55
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int index = num.length-2;
        while(index >= 0 && (num[index] >= num[index+1])) {
            --index;
        }
        
        if(index < 0) {
            int prev = 0, last = num.length-1;
            while(prev < last) {
                int tmp = num[prev];
                num[prev] = num[last];
                num[last] = tmp;
                prev++;
                last--;
            }
        }else {
            int tmp = num[index];
            int swapIndex = num.length-1;
            while(swapIndex > index && num[swapIndex] <= tmp){
                swapIndex--;
            }
            num[index] = num[swapIndex];
            num[swapIndex] = tmp;
            int prev = index+1;
            int last = num.length-1;
            while(prev < last) {
                int tmp2 = num[prev];
                num[prev] = num[last];
                num[last] = tmp2;
                prev++;
                last--;
            }
            
        }
        print(num);
    }
    
    public void print(int[] num) {
        for(int i = 0; i < num.length; ++i) {
            System.out.println(num[i]);
        }
    }
    public static void main(String... args) {
        int[] num = {1, 3, 2};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(num);
    }
}
