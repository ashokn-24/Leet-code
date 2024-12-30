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
var middleNode = function (head) {
    let temp = head;
    let count = 0;
    let x = null;
    while (temp != null) {
        count++
        temp = temp.next;
    }

    temp = head;

    if (count % 2 == 0) {
        x = (count / 2) + 1;
    } else {
        x = Math.ceil(count / 2);
    }

    count = 0;

    while (temp != null) {
        count++
        if (count == x) break;
        temp = temp.next;
    }

    return temp;
};