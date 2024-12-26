/**
 * @param {number[]} weights
 * @param {number} days
 * @return {number}
 */
var shipWithinDays = function (weights, days) {
    let max = Math.max(...weights)

    let sum = 0;
    for (let i = 0; i < weights.length; i++) {
        sum += weights[i]
    }

    function calWt(wt, cap) {
        let days = 1;
        let load = 0;
        for (let i = 0; i < wt.length; i++) {
            if (load + wt[i] <= cap) {
                load += wt[i]
            } else {
                days += 1;
                load = wt[i]
            }
        }

        return days;
    }

    let low = max;
    let high = sum;
    let ans = 0;

    while (low <= high) {
        let mid = Math.floor((low + high) / 2);

        if (calWt(weights, mid) <= days) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1
        }
    }

    return ans
};