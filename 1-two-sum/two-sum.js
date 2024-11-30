/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, k) {
    let mp = new Map();
    let ans = []

    for (let i = 0; i < nums.length; i++) {
        let complement = k - nums[i] 

        if (mp.has(complement)) {
            ans = [mp.get(complement),i]
        }

        if(!mp.has(nums[i])){
            mp.set(nums[i],i)
        }
    }
    return ans;
};