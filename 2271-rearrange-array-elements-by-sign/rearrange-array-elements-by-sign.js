/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function (arr) {
    let pos = []
    let neg = []
    let n = arr.length

    for (let i = 0; i < n; i++) {
        if (arr[i] < 0) {
            neg.push(arr[i])
        } else {
            pos.push(arr[i])
        }
    }

    for (let i = 0; i < n / 2; i++) {
        arr[2 * i] = pos[i];
        arr[2 * i + 1] = neg[i]
    }

    return arr;
};