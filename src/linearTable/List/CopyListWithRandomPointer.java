/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package linearTable.List;

import java.util.HashMap;
import java.util.Map;

/**
 * 类CopyListWithRandomPointer.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月9日 下午8:22:23
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) { // two times scan
        if(head == null) {
            return null;
        }
        
        Map<RandomListNode, RandomListNode> rpMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;       
        RandomListNode newList = new RandomListNode(-1);
        RandomListNode newCur = newList;
        // save random pointers
        while(cur != null) {
            newCur.next = new RandomListNode(cur.label);
            rpMap.put(cur, newCur.next);
            cur = cur.next;
            newCur = newCur.next;
        }
        
        cur = head; newCur = newList.next;
        while(cur != null) {
            newCur.random = rpMap.get(cur.random);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newList.next;
    }
    
    
    /*public RandomListNode copyRandomList(RandomListNode head) { // time limit exceed
        if(head == null) {
            return null;
        }
       
        // first scan, create new node 
        RandomListNode cur = head;
        while(cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        // second scan, assign new node's random point
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
                cur = cur.next.next;
            } 
        }
        
        // third scan, cut the list into two
        RandomListNode newList = head.next;
        cur = head; 
        while(cur != null) {
            RandomListNode newCur = cur.next;
            cur.next = newCur.next;
            if(cur.next != null) {
                newCur.next = cur.next;
                cur = cur.next;
                newCur = newCur.next;
            }
        }
        return newList;
    }*/
    public static void main(String... args) {
        
    }
}
