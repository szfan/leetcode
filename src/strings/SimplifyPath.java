package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 类SimplifyPath.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月28日 下午4:44:40
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path.length() <= 0) {
            return path;
        }
        
        String[] list = path.split("/");
        List<String> midResult = new ArrayList<String>();
        
        for(String s : list) {
            if("".equals(s) || ".".equals(s)) {
                continue;
            }else if("..".equals(s)) {
                if(midResult.isEmpty() == false) {
                    midResult.remove(midResult.size()-1);
                }
            }else {
                midResult.add(s);
            }
        }
        StringBuffer sb = new StringBuffer();
        
        for(String s : midResult) {
            sb.append("/"); 
            sb.append(s);
        }
        if(sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
    
    public static void main(String... args) {
        SimplifyPath sp = new SimplifyPath();
        String path = "/";
        System.out.println(sp.simplifyPath(path));
    }
}
