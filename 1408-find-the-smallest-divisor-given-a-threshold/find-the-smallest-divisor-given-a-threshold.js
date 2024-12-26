/**
 * @param {number[]} nums
 * @param {number} threshold
 * @return {number}
 */
var smallestDivisor = function (nums, threshold) {

    let max = Math.max(...nums);

    let low = 1;
    let high = max;
    let ans = -1;

    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        
        if (calAns(mid, nums) <= threshold) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }


    function calAns(mid, nums) {
        let sum = 0;
        for (let j = 0; j < nums.length; j++) {
            sum = sum + Math.ceil(nums[j] / mid);
        }
        return sum;
    }

    return ans;

};