/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */

var rotateRight = function (head, k) {
    if (!head || !head.next || k === 0) return head;

    let temp = head;
    let len = 1;

    while (temp.next != null) {
        len++;
        temp = temp.next;
    }

    let tail = temp;
    k = k % len;
    if (k == 0) return head;

    temp = head;
    let steps = len - k;

    while (steps > 1) {
        temp = temp.next;
        steps--;
    }

    let newHead = temp.next;
    temp.next = null
    tail.next = head;

    return newHead;
}; 