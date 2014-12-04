package linearTable.List;

/**
 * 类LinkedListCycle.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月15日 下午9:16:54
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode os = head, ts = head.next;
        while(os != null && ts != null) {
            if(os == ts) {
                return true;
            }else {
                os = os.next;
                ts = ts.next;
                ts = ts == null ? null : ts.next;
            }
        }
        return false;
    }
    public static void main(String... args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        LinkedListCycle llc = new LinkedListCycle();
        System.out.println(llc.hasCycle(head));
        
    }
}
