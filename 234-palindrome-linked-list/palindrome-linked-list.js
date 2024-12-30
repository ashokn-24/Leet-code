/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function (head) {
    let slow = head;
    let fast = head;

    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    function reverse(head) {
        let pre = null;
        let current = head;
        while (current != null) {
            let temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

    const newHead = reverse(slow.next);

    let first = head;
    let second = newHead;

    while (second != null) {
        if (first.val != second.val) {
            reverse(newHead)
            return false;
        }
        first = first.next;
        second = second.next;
    }
    reverse(newHead)
    return true;
};