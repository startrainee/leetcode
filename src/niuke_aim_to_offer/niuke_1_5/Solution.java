package niuke_aim_to_offer.niuke_1_5;
/**

 输入两个单调递增的链表，输出两个链表合成后的链表，
 当然我们需要合成后的链表满足单调不减规则。

 */

public class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;

        printListNode(listNode1);
        System.out.println();
        printListNode(listNode6);
        System.out.println();
        printListNode(new Solution().Merge(listNode1,listNode6));
    }

    private static void printListNode(ListNode listNode1) {
        if (listNode1!=null){
            System.out.print(listNode1.val + " ");
            if (listNode1.next!=null)
                printListNode(listNode1.next);
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode list1Node = list1;
        ListNode list2Node = list2;
        ListNode temp = null;
        ListNode head = null;

        while (list1Node != null && list2Node != null){
            System.out.println(" " + list1Node.val + " " + list2Node.val);
            if(list1Node.val > list2Node.val){
                if (temp  == null) {
                    temp = list2Node;
                    head = temp;
                }else {
                    temp.next = list2Node;
                    temp = temp.next;
                }
                list2Node = list2Node.next;
            }else{
                if (temp == null) {
                    temp = list1Node;
                    head = temp;
                }else {
                    temp .next = list1Node;
                    temp = temp.next;
                }
                list1Node = list1Node.next;
            }
        }
        if(list1Node==null){
            if (temp != null) {
                temp.next = list2Node;
            }else {
                temp = list2Node;
                head = temp;
            }
        }
        if(list2Node == null){
            if (temp != null) {
                temp.next = list1Node;
            }else {
                temp = list1Node;
                head = temp;
            }
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}