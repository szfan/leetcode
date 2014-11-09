package linearTable.List;

/**
 * 类ReverseNodesInKGroup.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月8日 下午12:46:19
 */
public class ReverseNodesInKGroup {
    public ListNode reverseList(ListNode head, ListNode tail) {
        ListNode last = head.next;
        ListNode cur = last.next;
        while(cur != null) {
            last.next = cur.next;
            cur.next  = head.next;
            head.next = cur;
            cur = last.next;
        }
        return last;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while(head != null) {
            i++;
            if(i % k == 0){
                pre = reverseList(pre, head.next);
                head = pre.next;
            }else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    public static void main(String... args) {
        ListNode head = new ListNode(1);
        ListNode h = head;
        h.next = new ListNode(2);
        h = h.next; h.next = new ListNode(3);
        h = h.next; h.next = new ListNode(4);
        h = h.next; h.next = new ListNode(5);
        ReverseNodesInKGroup r = new ReverseNodesInKGroup();
        r.reverseKGroup(head, 3);
    }
}
