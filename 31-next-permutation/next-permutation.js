/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function (a) {
    let ind = -1;
    let n = a.length;

    for (i = n - 2; i >= 0; i--) {
        if (a[i] < a[i + 1]) {
            ind = i;
            break;
        }
    }

    if(ind == -1 ){
        return a.reverse(); 
    }

    for (i = n - 1 ; i >= ind; i--) {
        if(a[i]>a[ind]){
            let temp = a[i]
            a[i] = a[ind]
            a[ind] = temp;

            break;
        }
    }

    a.splice(ind + 1, n - ind - 1, ...a.slice(ind + 1).reverse());

    return a
};