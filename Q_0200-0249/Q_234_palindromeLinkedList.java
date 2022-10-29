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

    // rightMiddle is the node next of the middle node;
    ListNode rightMiddle = null;

    public boolean isPalindrome(ListNode head) {
        // If list has 0/1 node, return true;
        if (head == null || head.next==null){
            return true;
        }

        // Find the rightMiddle node, using quick/slow pointers;
        findRightMiddle(head);

        // Reverse the list after rightMiddle node, and return the new head;
        rightMiddle = reverse(rightMiddle);

        // Compare two list
        while (rightMiddle != null){
            if (head.val != rightMiddle.val){
                return false;
            } else {
                head = head.next;
                rightMiddle = rightMiddle.next;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode cur=head, pre=null, nxt= null;
        while (cur != null ){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private void findRightMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        rightMiddle = slow.next;
        while (fast.next!=null && fast.next.next!=null){
            slow = rightMiddle;
            rightMiddle = slow.next;
            fast = fast.next.next;
        }
    }
}