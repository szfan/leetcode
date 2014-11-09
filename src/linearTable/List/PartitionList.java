package linearTable.List;

/**
 * 类PartitionList.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月8日 上午9:40:14
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1), h1 = l1;
        ListNode l2 = new ListNode(-2), h2 = l2;
        
        while(head != null) {
            if(head.val < x) {
                h1.next = new ListNode(head.val);
                h1 = h1.next;
            }else {
                h2.next = new ListNode(head.val);
                h2 = h2.next;
            }
            head = head.next;
        }
        
        h1.next = l2.next;
        return l1.next;
    }
    public static void main(String... args) {
        ListNode head = new ListNode(1);
        ListNode h = head;
        h.next = new ListNode(4);
        h = h.next; h.next = new ListNode(3);
        h = h.next; h.next = new ListNode(2);
        h = h.next; h.next = new ListNode(5);
        h = h.next; h.next = new ListNode(2);
        
        PartitionList pl = new PartitionList();
        pl.partition(head, 3);
    }
}
