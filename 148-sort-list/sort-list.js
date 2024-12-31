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

const findMiddle = (head) => {
    let slow = head;
    let fast = head.next;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow
}

var merge = function (list1, list2) {
    let dummy = new ListNode(-1);
    let curr = dummy;

    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            curr.next = list1;
            list1 = list1.next;
        } else {
            curr.next = list2;
            list2 = list2.next;
        }
        curr = curr.next;
    }

    if (list1) {
        curr.next = list1
    } else {
        curr.next = list2
    }

    return dummy.next;
};

var sortList = function (head) {
    if (head == null || head.next == null) {
        return head;
    }

    let mid = findMiddle(head);
    let leftHead = head;
    let rightHead = mid.next;
    mid.next = null;

    leftHead = sortList(leftHead);
    rightHead = sortList(rightHead);

    return merge(leftHead, rightHead);

};