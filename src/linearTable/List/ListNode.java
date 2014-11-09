package linearTable.List;

/**
 * 类ListNode.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月7日 下午9:45:24
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    
    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
