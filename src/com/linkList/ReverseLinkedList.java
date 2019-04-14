package com.linkList;

import java.util.List;

public class ReverseLinkedList {



    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    //1->2->3->4
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode preCur = head;
        while(preCur.next != null){
            ListNode cur = preCur.next;
            preCur.next = cur.next;
            cur.next = head;
            head = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.build(new int[]{1,2,3,4,5});
        ListNode listNode = new ReverseLinkedList().reverseList2(node);
        ListNode.printLink(listNode);
    }
}
