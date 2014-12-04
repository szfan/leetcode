package strings;

/**
 * 类ValidNumber.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月27日 上午9:14:03
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') {
            ++i;
        }
        if(s.charAt(i) == '+' || s.charAt(i) == '-') {
            ++i;
        }
        
//        while(i < s.length() && s.charAt(index))
        return true;
    }
    
    public static void main(String... args) {
        String str = "  +.03e10";
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber(str));
    }
}
