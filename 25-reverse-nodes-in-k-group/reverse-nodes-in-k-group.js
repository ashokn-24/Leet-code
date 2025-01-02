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

const reverse = (head) => {
    let pre = null;
    let curr = head;

    while (curr != null) {
        let temp = curr.next;
        curr.next = pre;
        pre = curr;
        curr = temp
    }

    return pre;
}

var reverseKGroup = function (head, k) {
    let dnode = new ListNode(-1);
    dnode.next = head;
    let dummy = dnode;
    let temp = head;
    count = 0;

    while (temp != null) {
        count++;
        if (count % k == 0) {
            let nxt = temp.next;
            let start = dummy.next;
            temp.next = null;

            let rev = reverse(start);

            dummy.next = rev;
            start.next = nxt;

            dummy = start;
            temp = nxt;


        } else {
            temp = temp.next;
        }
    }

    return dnode.next;
};