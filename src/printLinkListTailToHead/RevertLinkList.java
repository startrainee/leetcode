package printLinkListTailToHead;

/**
 * 倒序输出链表，不可以破坏链表结构
 * */
public class RevertLinkList {
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

        printListNode(node0);

    }

    private static void printListNode(ListNode node) {
        int value = node.value;
        if(node.next !=null){
            printListNode(node.next);
        }
        System.out.println(value);
    }
}
