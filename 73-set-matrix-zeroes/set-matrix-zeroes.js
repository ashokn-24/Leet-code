/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function (matrix) {
    let n = matrix.length;
    let m = matrix[0].length;

    const markRow = (matrix, m, n, i) => {
        for (let j = 0; j < m; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -10;
            }
        }
    }

    const markCol = (matrix, m, n, j) => {
        for (let i = 0; i < n; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -10
            }
        }
    }

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (matrix[i][j] == 0) {
                markRow(matrix, m, n, i)
                markCol(matrix, m, n, j)
            }
        }
    }

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (matrix[i][j] == -10) {
                matrix[i][j] = 0;
            }
        }
    }

    return matrix;
};