package linearTable.List;

/**
 * 类RotateList.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月8日 上午11:04:20
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        int count = 1;
        ListNode prev = head, next = prev.next, newHead = null;
        while(prev != null && next != null) {
            count++;
            prev = prev.next;
            next = next.next;
        }
        prev.next = head;
        n = n % count;
        prev = head;
        
        int index = count - n;
        prev = head;
        while(index > 1) {
            prev = prev.next;
            index--;
        }
        newHead = prev.next;
        prev.next = null;
        ListNode.printList(newHead);
        return newHead;
    }
    
    public static void main(String... args) {
        ListNode list = new ListNode(1), prev = list;
        prev.next = new ListNode(2);
        prev = prev.next; prev.next = new ListNode(3);
        prev = prev.next; prev.next = new ListNode(4);
        prev = prev.next; prev.next = new ListNode(5);
        RotateList rl = new RotateList();
        rl.rotateRight(list, 2);
        
    }
}
