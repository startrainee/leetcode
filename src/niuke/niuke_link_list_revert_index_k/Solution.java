package niuke.niuke_link_list_revert_index_k;


import java.util.Stack;

/**
 *输入一个链表，输出该链表中倒数第k个结点。
 *
 *
 * */
/*
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
*/
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        printListCode(new Solution().FindKthToTail2(head,4));
        System.out.println((new Solution().FindKthToTail(head,2).val));

    }

    private static void printListCode(ListNode listNode) {
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {

        Stack<ListNode> stack = new Stack<>();
        ListNode listNode = head;
        while (listNode!= null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        if(k < 0){
            return null;
        }

        while(--k>0){
            stack.pop();
        }
        return stack.peek();
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail2(ListNode head,int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (k < 0) {
            return null;
        }

        while (--k > 0) {
            stack.pop();
        }
        return stack.peek();
    }

}

