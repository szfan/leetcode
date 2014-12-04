package strings;

/**
 * 类CountAndSay.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月28日 上午9:18:31
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if( 1 == n) {
            return "1";
        }
        String result = "1";
        StringBuffer sb = new StringBuffer();
        int count = 0;
        int cnt = 0;
        int i;
        while(++cnt < n) {
            count = 1;
            sb.setLength(0);
            for(i = 1; i < result.length(); ++i) {
                if(result.charAt(i) == result.charAt(i-1)) {
                    count++;
                }else {
                    sb.append(count).append(result.charAt(i-1));
                }
            }
            sb.append(count).append(result.charAt(result.length()-1));
            result = sb.toString();
        }
        return result;
    }
    public static void main(String... args) {
        CountAndSay cas = new CountAndSay();
        for(int i = 0; i < 10; ++i) {
            System.out.println(cas.countAndSay(i));
        }
    }
}
