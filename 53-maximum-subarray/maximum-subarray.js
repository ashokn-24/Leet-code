/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
    let maxi = -Infinity
    let sum = 0

    for (let i = 0; i < nums.length; i++) {
        if(nums.length == 0){
            return nums[i]
        }
        sum = sum + nums[i]

        if(sum > maxi){
            maxi = sum
        }

        if(sum < 0 ){
            sum = 0
        }
    }

    return maxi
};