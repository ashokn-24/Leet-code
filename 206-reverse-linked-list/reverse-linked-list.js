/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    let current = head;

    pre = null
    while (current != null) {
        let temp = current.next;
        current.next = pre;
        pre = current;

        current = temp;
    }

    return pre;
};