package linearTable.List;

/**
 * 类ReversedLinkedList.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月7日 下午9:44:42
 */
public class ReversedLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n || head.next == null) {
            return head;
        }
        ListNode prev = head, next = null, hold = null;
        for(int i = 0; i < m-1; ++i) {
            hold = prev;
            prev = prev.next;
        }//System.out.println(hold.val + " " + prev.val);
        
        ListNode headNew = prev;
        for(int i = m; i < n; ++i) {
            next = prev.next;
            prev.next = next.next;
            next.next = headNew;
            headNew = next;
//            printList(headNew);
        }
        if(hold == null){
            return headNew;
        }else {
            hold.next = headNew;
            return head;
        }
    }
    
    public void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String... args) {
        ListNode head1 = new ListNode(1), 
        head = head1;
        head.next = new ListNode(2); 
        head = head.next;
        head.next = new ListNode(3); head = head.next;
        head.next = new ListNode(4); head = head.next;
        head.next = new ListNode(5); head = head.next;
        ReversedLinkedList rll = new ReversedLinkedList();
        
        ListNode ll = rll.reverseBetween(head1, 2, 4);;
        while(ll != null) {
            System.out.println(ll.val);
            ll = ll.next;
        }
    }
}
