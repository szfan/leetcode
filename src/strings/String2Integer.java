package strings;

import org.omg.CORBA.INTERNAL;

/**
 * 类String2Integer.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月25日 上午9:27:36
 */
public class String2Integer {
    public int atoi(String str) {
        if(null == str || "".equals(str)) {
            return 0;
        }
        
        int sign = 1;
        boolean signSignal = false;
        
        char[] cs = str.toCharArray();
        int i = 0;
        while(i < cs.length && !('0' <= cs[i] && cs[i] <= '9')) {
            if(signSignal) {
                return 0;
            }
            
            if(cs[i] == '-'){
                sign *= -1;
                signSignal = true;
            }else if(cs[i] == '+') {
                signSignal = true;
            }else if(cs[i] != ' ') {
                return 0;
            }
            ++i;
        }
        
        int sum = 0;
        boolean isOverFlow = false;
        for(int j = i; j < cs.length && '0' <= cs[j] && cs[j] <= '9'; ++j) {
            if(sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE / 10 && cs[j] - '0' > Integer.MAX_VALUE % 10 )) {
                isOverFlow = true;
            }
            sum = sum*10 + (cs[j]-'0');
        }
        
        if(isOverFlow) {
            if(sign == 1) {
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }
        return sign*sum;
    }
    
    public static void main(String... args) {
        String a = "2147483648";
        String2Integer si = new String2Integer();
        System.out.println(si.atoi(a));
    }
}
