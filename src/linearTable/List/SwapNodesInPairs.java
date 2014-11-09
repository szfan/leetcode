package linearTable.List;

/**
 * 类SwapNodesInPairs.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月8日 上午11:52:07
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newList = new ListNode(-1);
        ListNode nh = newList;
        nh.next = head;
        
        ListNode prev = nh, next = nh.next;
        while(next != null) {
            if(next.next == null) {
                break;
            }else {
                prev.next = next.next;
                next.next = prev.next.next;
                prev.next.next = next;
                prev = next;
                next = prev.next == null ? null : prev.next;
            }
            ListNode.printList(newList.next);
        }
        return newList.next;
    }
    public static void main(String... args) {
        ListNode head = new ListNode(1);
        ListNode h = head;
        h.next = new ListNode(2);
        h = h.next; h.next = new ListNode(3);
        h = h.next; h.next = new ListNode(4);
        h = h.next; h.next = new ListNode(5);
//        h = h.next; h.next = new ListNode(2);
        
        SwapNodesInPairs sn = new SwapNodesInPairs();
        sn.swapPairs(head);
    }
}
