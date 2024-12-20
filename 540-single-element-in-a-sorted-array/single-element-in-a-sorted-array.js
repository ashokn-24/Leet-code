/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function (nums) {
    let n = nums.length
    let low = 1;
    let high = n - 2;

    if(n ==2) return nums[0];
    if (nums[0] != nums[1]) return nums[0];
    if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

    while (low <= high) {
        let mid = Math.floor((low + high) / 2);

        if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
            return nums[mid];
        } else if (mid % 2 == 1 && nums[mid - 1] == nums[mid] || mid % 2 == 0 && nums[mid] == nums[mid+1]) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
};