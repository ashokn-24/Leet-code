/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

var splitArray = function (nums, k) {
    let max = Math.max(...nums);
    let sum = 0;
    let n = nums.length

    for (let i = 0; i < n; i++) {
        sum += nums[i]
    }

    function check(max, arr, k) {
        let sub = 1;
        let sum = 0;

        for (let i = 0; i < n; i++) {
            if (arr[i] + sum <= max) {
                sum += arr[i]
            } else {
                sub++;
                sum = arr[i];
            }
        }


        return sub
    }


    let low = max;
    let high = sum;

    let ans = -1;
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);

        if (check(mid, nums, k) <= k) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return low;
};