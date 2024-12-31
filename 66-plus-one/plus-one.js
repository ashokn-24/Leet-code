/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (nums) {
    let carry = 1;

    for (let i = nums.length - 1; i >= 0; i--) {
        let digit = nums[i] + carry;

        if (digit < 10) {
            nums[i] = digit;
            carry = 0;
            break;
        } else {
            nums[i] = 0;
            carry = 1;
        }
    }

    if (carry == 1) {
        nums.unshift(1)
    }

    return nums;
};