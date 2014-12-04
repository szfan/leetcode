package linearTable.List;

/**
 * 类ReorderList.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月15日 下午9:45:36
 */
public class ReorderList {
    
    public ListNode reverList(ListNode head) {
        ListNode last = head.next;
        ListNode cur = last.next;
        while(cur != null) {
            last.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = last.next;
        }
        return head.next;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) { 
            return;
        }
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        
        ListNode tmphead = new ListNode(-1);
        cur = head;
        for(int i = 1; i < (int) Math.ceil(count/2.0); ++i) {
            cur = cur.next;
        }
        tmphead.next = cur.next;
        cur.next = null;
        tmphead.next = reverList(tmphead);
        
        cur = head;
        ListNode newCur = tmphead.next;
        while(cur != null && newCur != null) {
            ListNode tmp = newCur.next;
            newCur.next = cur.next;
            cur.next = newCur;
            cur = newCur.next;
            newCur = tmp;
        }
    }
    
    public static void main(String... args) {
        System.out.println(Math.ceil(2.5));
        ListNode list = new ListNode(1);
        ListNode head = list;
        head.next = new ListNode(2);
        head = head.next; head.next = new ListNode(3);
        head = head.next; head.next = new ListNode(4);
        head = head.next; head.next = new ListNode(5);
        ReorderList rl = new ReorderList();
        rl.reorderList(list);
        ListNode.printList(list);
    }
}
