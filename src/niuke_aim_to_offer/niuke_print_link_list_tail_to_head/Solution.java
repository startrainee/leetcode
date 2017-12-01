package niuke_aim_to_offer.niuke_print_link_list_tail_to_head;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 倒序输出链表，不可以破坏链表结构
 * */
public class Solution {

    public static void main(String[] args) {

        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(printListFromTailToHead(node0).toString());
        System.out.println(printListFromTailToHead2(node0).toString());

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        getListNode(listNode, arrayList);
        return arrayList;

    }

    private static void getListNode(ListNode node, ArrayList<Integer> arrayList) {
        if (node.next != null) {
            getListNode(node.next, arrayList);
        }
        arrayList.add(node.value);
    }

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        int value;
        ListNode nextNode = listNode;

        while (nextNode != null) {
            value = nextNode.value;
            stack.push(value);
            nextNode = nextNode.next;
        }

        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }

        return arrayList;

    }


}
