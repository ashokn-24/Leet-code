/**
 * // Definition for a _Node.
 * function _Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {_Node} head
 * @return {_Node}
 */
var copyRandomList = function (head) {
    let temp = head;

    while (temp != null) {
        let cp = new Node(temp.val);
        let nxt = temp.next;
        temp.next = cp;
        cp.next = nxt;
        temp = temp.next.next;
    }

    temp = head;
    while (temp != null) {
        let cp = temp.next;
        if (temp.random != null) {
            cp.random = temp.random.next;
        } else {
            cp.random = null;
        }

        temp = temp.next.next;
    }

    let dummy = new Node(-1);
    let res = dummy;
    temp = head;

    while (temp != null) {
        let cp = temp.next;
        let nxt = cp.next;
        res.next = cp;
        temp.next = nxt;
        
        res = res.next;
        temp = temp.next;
    }

    return dummy.next;
};