/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package linearTable.List;

/**
 * 类CopyListWithRandomPointer.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月9日 下午8:22:23
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode newList = new RandomListNode(0);
        RandomListNode cur = head, prev = null, newCur = newList;
        while(cur != null) {
            prev = cur;
            newCur.next = new RandomListNode(cur.label);
            cur = cur.next;
            newCur.next.random = prev;
            prev.next = newCur.next;
        }
        
        newCur = newList.next;
        while(newCur != null) {
            newCur.random = newCur.random.random.next;
        }
        return newList.next;
    }
    public static void main(String... args) {
        
    }
}
