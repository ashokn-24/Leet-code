/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function (num) {
    let low = 1;
    let high = num;
    let ans = false;

    while (low <= high) {
        let mid = Math.floor((low + high) / 2);

        if(mid * mid == num){
            ans = true;
            break;
        }else if(mid * mid > num){
            high = mid - 1;
        }else{
            low = mid + 1
        }
    }
    return ans;
};