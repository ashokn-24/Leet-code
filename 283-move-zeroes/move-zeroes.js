/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
    let temp = []
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            temp.push(nums[i])
        }
    }
    for (let i = 0; i < temp.length; i++) {
        nums[i] = temp[i]
    }

    for (let i = temp.length; i < nums.length; i++) {
        nums[i] = 0
    }
};