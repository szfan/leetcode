package strings;

/**
 * 类Roman2Integer.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月27日 上午11:35:10
 */
public class Roman2Integer {
    public int map(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default:return 0;
        }
    }
    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(i > 0 && map(s.charAt(i)) > map(s.charAt(i-1))) {
                result += map(s.charAt(i)) - 2*map(s.charAt(i-1));
            }else {
                result += map(s.charAt(i));
            }
        }
        return result;
    }
    
    public static void main(String... args) {
        
    }
}
