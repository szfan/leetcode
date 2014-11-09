package linearTable.List;

/**
 * 类RemoveNthNodeFromEndofList.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月8日 上午11:30:33
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newList = new ListNode(-1),  prev = newList, nextn = head;
        prev.next = head;
        for(int i = 0; i < n - 1; ++i) {
            nextn = nextn.next;
        }
        while(nextn != null && nextn.next != null) {
            prev = prev.next;
            nextn = nextn.next;
        }
        prev.next = prev.next.next;
        ListNode.printList(newList.next);
        return newList.next;
    }
    public static void main(String... args) {
        ListNode head = new ListNode(1);
        ListNode h = head;
        h.next = new ListNode(2);
        h = h.next; h.next = new ListNode(3);
        h = h.next; h.next = new ListNode(4);
        h = h.next; h.next = new ListNode(5);
        RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();
        r.removeNthFromEnd(head, 1);
    }
}
