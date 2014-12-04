package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类Anagrams.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月28日 下午4:29:50
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        if(null == strs || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; ++i) {
            char[] tmpStr = strs[i].toCharArray();
            Arrays.sort(tmpStr);
            String sortedStr = new String(tmpStr);
            if(!result.containsKey(sortedStr)) {
                List<String> tmplist = new ArrayList<String>();
                tmplist.add(strs[i]);
                result.put(sortedStr, tmplist);
            }else {
                List<String> tmpList = result.get(sortedStr);
                tmpList.add(strs[i]);
            }
        }
        
        List<String> re = new ArrayList<String>();
        for(Map.Entry<String, List<String>> entry : result.entrySet()) {
            if(entry.getValue().size() > 1) {
                for(String str : entry.getValue()) {
                    re.add(str);
                }
            }
        }
        return re;
    }
    
}
