package strings;

/**
 * 类LongestCommonPrefix.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月26日 下午7:34:49
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        int len = strs[0].length();
        
        for(int i = 1; i < strs.length; ++i) {
            int index = 0;
            for(; index <= strs[0].length()-1 && index <= strs[i].length()-1; ++index) {
                if(strs[0].charAt(index) != strs[i].charAt(index)) {
                    break;
                }
            }
            if(index < len) {
                len = index;
            }
        }
        return strs[0].substring(0, 0+len);
    }
    public static void main(String... args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"c","c"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
