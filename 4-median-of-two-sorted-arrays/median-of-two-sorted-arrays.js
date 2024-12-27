/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    arr = [];
    let i = 0;
    let j = 0;

    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
            arr.push(nums1[i])
            i++;
        } else {
            arr.push(nums2[j]);
            j++;
        }
    }

    while (j < nums2.length) {
        arr.push(nums2[j]);
        j++;
    }

    while (i < nums1.length) {
        arr.push(nums1[i]);
        i++;
    }

console.log(arr)

    let n = arr.length
    if (n % 2 != 0) {
        return arr[Math.floor(n / 2)];
    } else {
        return (arr[n / 2] + arr[n / 2 - 1]) / 2.0; 
    }
};