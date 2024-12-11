/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function (a) {
    let n = a.length;
    let st = new Set();
    let longest = 1;

    if (n === 0)
        return 0;

    for (let i = 0; i < n; i++) {
        st.add(a[i])
    }

    for (let it of st) {
        if (!st.has(it - 1)) {
            let count = 1
            let x = it
            while (st.has(x + 1)) {
                x += 1;
                count += 1;
            }
            longest = Math.max(longest, count)
        }
    }

    return longest;
};