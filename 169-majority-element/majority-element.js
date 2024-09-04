/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
    const elementCount = new Map()

    for (let i = 0; i < nums.length; i++) {

        if(elementCount.has(nums[i])){
            elementCount.set(nums[i],elementCount.get(nums[i]) + 1)
        }else{
            elementCount.set(nums[i], 1)
        }

    if(elementCount.get(nums[i])> nums.length/2){
        return nums[i]
    }

    }



};