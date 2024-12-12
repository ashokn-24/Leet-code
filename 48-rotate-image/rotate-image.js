/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function (matrix) {
    let n = matrix.length
    let m = matrix[0].length;

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < m; j++) {
            let temp = 0;
            temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

    for (let i = 0; i < n; i++) {
        matrix[i].reverse();
    }

    return matrix;
};