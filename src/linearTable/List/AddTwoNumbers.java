package linearTable.List;

/**
 * 类AddTwoNumbers.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月7日 上午10:58:50
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result, head1 = l1, head2 = l2;
        int carryBit = 0;
        while(head1 != null && head2 != null) {
            int tmpvalue = head1.val + head2.val + carryBit;
            carryBit = tmpvalue / 10;
            tmpvalue = tmpvalue % 10;
            head.next = new ListNode(tmpvalue);
            head = head.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        head1 = head1 == null ? head2 : head1;
        while(head1 != null) {
            int tmpvalue = head1.val + carryBit;
            carryBit = tmpvalue / 10;
            tmpvalue = tmpvalue % 10;
            head.next = new ListNode(tmpvalue);
            head = head.next;
            head1 = head1.next;
        }
        if(carryBit == 1) {
            head.next = new ListNode(1);
        }
        ListNode headd = result.next;
        while(headd != null) {
            System.out.println(headd.val);
            headd = headd.next;
        }
        return result.next;
    }
    
    public static void main(String... args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(5);
        AddTwoNumbers atn = new AddTwoNumbers();
        atn.addTwoNumbers(l1, l2);
    }
}
