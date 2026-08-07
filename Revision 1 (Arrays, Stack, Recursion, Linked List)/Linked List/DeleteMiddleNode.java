public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int mid = length / 2;
        temp = head;
        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
