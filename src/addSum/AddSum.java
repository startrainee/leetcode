package addSum;

import java.util.Arrays;


public class AddSum {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!11");
        ListNode listNode0 = new ListNode(5);
        listNode0.next = new ListNode(2);
        //listNode0.next.next = new ListNode(6);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(5);
        listNode1.next.next = new ListNode(6);

        printListNode(listNode0);
        printListNode(listNode1);
        ListNode listNode = addTwoNumbers(listNode0, listNode1);
        printListNode(listNode);
    }

    private static void printListNode(ListNode listNode) {
        while (true) {
            System.out.print(listNode.val + " ");
            if (listNode.next == null) {
                System.out.println();
                return;
            }
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newListNode = null;
        ListNode curListNode = null;
        int nextCarry = 0;
        int newVal;
        while (true) {

            int i1 = l1 != null ? l1.val : 0;
            int i2 = l2 != null ? l2.val : 0;

            newVal = (i1 + i2 + nextCarry) % 10;
            nextCarry = (i1 + i2 + nextCarry) / 10;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;


            if(newListNode == null){
                newListNode = new ListNode(newVal);
                curListNode = newListNode;
            }else{
                curListNode.next = new ListNode(newVal);
                curListNode = curListNode.next;
            }
            if (l1 == null && l2 == null) {

                if(nextCarry > 0){
                    curListNode.next = new ListNode(nextCarry);
                }
                break;
            }
        }
        return newListNode;

    }

}

