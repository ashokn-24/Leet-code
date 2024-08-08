/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
    let sign = true
    if (x < 0) sign = false

    x = Math.abs(x)

    let rev = 0

    while (x > 0) {
        rev = (rev * 10) + (x % 10)
        x = Math.floor(x / 10)
        if (rev > 2 ** 31 || rev < (-2)** 31) return 0
    }

    if (!sign) return  -rev

    return rev
};