/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    let n = nums.length
    k = k % n
    let temp = []

    for(let i = n-k; i <= n; i++){
        temp.push(nums[i])
    }

    for (let i = n - 1; i >= k; i--) {
      nums[i] = nums[i - k];
     
    }
    

    
    for (let i = 0; i < k; i++) {
        nums[i] = temp[i];
        }
};