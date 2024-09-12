/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function (arr) {
    let positive = []
    let negative = []
    let nums = []
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            negative.push([arr[i]])
        } else {
            positive.push([arr[i]])
        }
    }
    for (let i = 0; i < arr.length / 2; i++) {
        arr[2 * i] = positive[i]
        arr[2 * i + 1] = negative[i]
    }
    return arr
};