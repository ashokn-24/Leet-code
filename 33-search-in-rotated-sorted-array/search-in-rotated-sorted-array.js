/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let low = 0;
    let high = nums.length - 1;
    let ans = -1;

    while(low <= high){
        let mid = Math.floor((low + high)/2);

        if(nums[mid]=== target){
            return mid;
        }else if(nums[low] <= nums[mid]){
            if(nums[low] <= target && target <= nums[mid]){
                high = mid - 1;
            }else{
                low = mid +1;
            }
        }else{
            if(target <= nums[high] && nums[mid]<= target){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
    }

    return -1;
};