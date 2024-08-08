/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {

    // if negative number it return false 
    if (x < 0) return false

    originalNum = x
    reversedNum = 0

    // reversing number
    while (x > 0) {
        reversedNum = (reversedNum * 10) + (x % 10)
        x = Math.floor(x / 10)
    }
    
    // check equal if not return false 
    return originalNum === reversedNum
};