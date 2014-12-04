package strings;

/**
 * 类LengthOfLastWord.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年12月1日 下午2:59:56
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 ) {
            return 0;
        }
        int len = s.length(), count = 0;
        for (int i = len-1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                count++;
            }
            else if(s.charAt(i) == ' ' && count != 0){
                return count;
            }
        }
        return count;
    }
}
