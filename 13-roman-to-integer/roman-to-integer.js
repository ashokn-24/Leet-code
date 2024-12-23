/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
    let n = s.length;
    let mp = new Map();
    mp.set("I", 1);
    mp.set("V", 5);
    mp.set("X", 10);
    mp.set("L", 50);
    mp.set("C", 100);
    mp.set("D", 500);
    mp.set("M", 1000);

    let sum = 0;

    for (let i = n - 1; i >= 0; i--) {
        if (s[i] == "V" || s[i] == "X") {
            if (s[i - 1] === "I") {
                sum = sum + mp.get(s[i]) - mp.get(s[i - 1])
                i--;
            } else {
                sum = sum + mp.get(s[i]);
            }
        } else if (s[i] == "L" || s[i] == "C") {
            if (s[i - 1] === "X") {
                sum = sum + mp.get(s[i]) - mp.get(s[i - 1])
                i--;
            } else {
                sum = sum + mp.get(s[i]);
            }
        } else if (s[i] == "D" || s[i] == "M") {
            if (s[i - 1] === "C") {
                sum = sum + mp.get(s[i]) - mp.get(s[i - 1]);
                i--;
            } else {
                sum = sum + mp.get(s[i]);
            }
        } else {
            sum = sum + mp.get(s[i]);
        }
    }

    return sum;
};