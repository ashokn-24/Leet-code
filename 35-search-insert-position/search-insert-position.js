/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, k) {
    let low = 0;
    let high = nums.length - 1;
    let ans = nums.length;

    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        if (nums[mid] === k) {
            return mid
        } else if (nums[mid] < k) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return low;
};
