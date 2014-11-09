package linearTable.List;

/**
 * 类RemoveDuplicatesFromSortedListII.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月8日 上午9:59:41
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmpList = new ListNode(-1), tmphead = tmpList;
        ListNode prev = head, next = null;
        while(prev != null) {
            tmphead.next = null;
            next = prev.next;
            if(next == null) {
                tmphead.next = prev;
                break;
            }
            while(next != null && next.val == prev.val) {
                next = next.next;
            }
            if(prev.next != next) {
                prev = next;
            }else {
                tmphead.next = prev;
                tmphead = tmphead.next;
                prev = next;
            }
        }
        ListNode testhead = tmpList.next;
        while(testhead != null) {
            System.out.println(testhead.val);
            testhead = testhead.next;
        }
        return tmpList.next;
    }
    public static void main(String... args) {
        ListNode head = new ListNode(1);
        ListNode h = head;
        h.next = new ListNode(2);
        h = h.next; h.next = new ListNode(2);
//        h = h.next; h.next = new ListNode(2);
//        h = h.next; h.next = new ListNode(2);
//        h = h.next; h.next = new ListNode(4);
        RemoveDuplicatesFromSortedListII rdfsl = new RemoveDuplicatesFromSortedListII();
        rdfsl.deleteDuplicates(head);
    }
}
