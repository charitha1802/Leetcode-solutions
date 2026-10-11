
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp;
        ListNode prev = null;
        head = head.next;
        while (fast != null && fast.next != null) {
            temp = fast.next;
            fast.next = temp.next;
            temp.next = fast;

            if (prev != null) {
                prev.next = temp;
            }
            prev = fast;
            fast = fast.next;
        }
        return head;
    }
}