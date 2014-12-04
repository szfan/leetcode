package strings;

/**
 * 类LongestPalindromicSubstring.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月25日 下午7:29:50
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(null == s || s.length() <= 1) {
            return s;
        }

        int start = -1, maxLen = -1;
        for(int i = 1; i < s.length(); ++i) {
            
            // 偶数长度
            int low = i-1, high = i;
            while(low >= 0 && high <= s.length()-1 && s.charAt(low) == s.charAt(high)) {
                --low;
                ++high;
            }
            if(high-low-1 > maxLen) {
                maxLen = high-low-1;
                start = low+1;
            }
            
            // 奇数长度
            low = i-1; high = i+1;
            while(low >= 0 && high <= s.length()-1 && s.charAt(low) == s.charAt(high)) {
                --low;
                ++high;
            }
            if(high-low-1 > maxLen) {
                maxLen = high-low-1;
                start = low+1;
            }
        }
        return s.substring(start, start+maxLen);
    }
    
    public static void main(String... args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String str = "asdcddcba";
        System.out.println(lps.longestPalindrome(str));
    }
}
