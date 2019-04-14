package com.linkList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static ListNode build(int[] arr){
        ListNode preHead = new ListNode(0);
        ListNode preCur = preHead;
        for (int val : arr){
            preCur.next = new ListNode(val);
            preCur = preCur.next;
        }
        return preHead.next;
    }

    public static void printLink(ListNode node){
        StringBuffer sb = new StringBuffer();
        while (node != null) {
            sb.append(node.val).append("->");
            node = node.next;
        }
        System.out.println(sb);
    }

}
