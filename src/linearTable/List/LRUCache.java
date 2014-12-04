package linearTable.List;

import java.util.HashMap;
import java.util.Map;

/**
 * 类LruCache.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月20日 下午5:39:46
 */
public class LRUCache {
    private ListNodes head;
    private Map<Integer, Integer> keyValueMap = new HashMap<Integer, Integer>();
    
    public class ListNodes {
        int key;
        int value;
        ListNode pre, next;
        
        public ListNodes(){
            
        }
        public ListNodes(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
    
    public LRUCache(int capacity) {
        
    }
    
//    public int get(int key) {
//        
//    }
    
    public void set(int key, int value) {
        
    }
}