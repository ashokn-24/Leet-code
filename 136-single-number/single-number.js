/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
    const mp = new Map()
    for (let i = 0; i < nums.length; i++) {
        if (mp.has(nums[i])) {
            mp.set(nums[i], mp.get(nums[i]) + 1)
        } else {
            mp.set(nums[i], 1)
        }
    }
    for (const [key, value] of mp) {
        if (value === 1) {
            return key
        }
    }
};