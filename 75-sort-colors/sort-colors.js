/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
    let n = nums.length;
    let low = 0;
    let mid = 0;
    let high = n - 1;

    while (mid <= high) {
        if (nums[mid] == 0) {
            let temp = nums[mid]
            nums[mid] = nums[low]
            nums[low] = temp

            low++;
            mid++
        } else if (nums[mid] == 1) {
            mid++;
        } else if (nums[mid] == 2) {
            let temp = nums[mid]
            nums[mid] = nums[high]
            nums[high] = temp

            high--;
        }
    }
    return nums
};