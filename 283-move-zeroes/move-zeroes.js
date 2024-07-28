/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
    let k = -1

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            k = i
            break
        }
    }
    if (k == -1) return;

    for (let i = k + 1; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[k] = nums[i]
            nums[i] = 0;
            k++
        }
    }

};