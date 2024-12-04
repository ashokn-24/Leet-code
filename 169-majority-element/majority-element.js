/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (a) {
    let count = 0;
    let mp = new Map()



    for (let i = 0; i < a.length; i++) {
        if (mp.has(a[i])) {
            mp.set(a[i], mp.get(a[i]) + 1)
        }

        if (!mp.has(a[i])) {
            mp.set(a[i], 1)
        }

    }

    for (const [key, value] of mp) {
        if (value > a.length / 2) {
            count = key
        }
    }

    return count;
};