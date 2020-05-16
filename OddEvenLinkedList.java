/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode evenNode = new ListNode(-1);
        ListNode oddNode = head;
        ListNode oddCur = oddNode
        ListNode evenCur = evenNode;

        while (oddCur.next != null) {

            evenCur.next = oddCur.next;
            oddCur.next = oddCur.next.next;
            evenCur = evenCur.next;
            evenCur.next = null;

            if (oddCur.next != null) {
                oddCur = oddCur.next;
            }
        }

        oddCur.next = evenNode.next;
        return oddNode;
    }
}
