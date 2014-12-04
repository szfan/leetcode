package strings;

/**
 * 类ImplementStrStr.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月16日 下午5:04:18
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) { // time limit exceed, try KMP
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            }else {
                i = i - j + 1;
            }
        }
        if(j == needle.length()) {
            return i-j;
        }else {
            return -1;
        }
    }
    
    public int sundaySearch(String haystack, String needle) { // sunday algorithms
        int[] next = new int[26];
        for(int i = 0; i < next.length; ++i) {
            next[i] = needle.length()+1;
        }
        for(int i = 0; i < needle.length(); ++i) {
            next[needle.charAt(i)-'a'] = needle.length()-i;
        }
        
        int pos = 0;
        while(pos < (haystack.length()-needle.length()+1)) {
            int i = pos, j;
            for(j = 0; j < needle.length(); ++j, ++i) {
                if(needle.charAt(j) != haystack.charAt(i)) {
                    pos = pos + next[haystack.charAt(pos+needle.length())-'a'];
                    break;
                }
            }
            if(j == needle.length()) {
                return pos;
            }
        }
        return -1;
    }
    public static void main(String... args) {
        String haystack = "baaa";
        String needle = "aaa";
        ImplementStrStr iss = new ImplementStrStr();
        System.out.println(iss.sundaySearch(haystack, needle));
    }
}
