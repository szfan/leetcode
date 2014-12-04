package strings;

/**
 * 类Integer2Roman.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月27日 上午9:23:32
 */
public class Integer2Roman {
    public String intToRoman(int num) {
        int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; num > 0; ++i) {
            int count = num / radix[i];
            num %= radix[i];
            for(; count > 0; --count) {
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
    
    public static void main(String... args) {
        int i = 3453;
        Integer2Roman ir = new Integer2Roman();
        System.out.println(ir.intToRoman(i));
    }
}
