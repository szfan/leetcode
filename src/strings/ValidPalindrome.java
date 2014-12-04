package strings;

/**
 * 类ValidPalindrome.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月16日 下午4:44:58
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        String ss = s.toLowerCase();
        int prev = 0, last = ss.length()-1;
        while(prev < last) {
            while(prev < last && !Character.isLetter(ss.charAt(prev)) && !Character.isDigit(ss.charAt(prev))) {
                ++prev;
            }
            while(prev < last && !Character.isLetter(ss.charAt(last)) && !Character.isDigit(ss.charAt(last))) {
                --last;
            }
            if(ss.charAt(prev) != ss.charAt(last)) {
                return false;
            }
            ++prev;
            --last;
        }
        return true;
    }
    public static void main(String... args) {
        String str = "1a2";
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome(str));
    }
}
