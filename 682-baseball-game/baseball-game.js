/**
 * @param {string[]} operations
 * @return {number}
 */
var calPoints = function(ops) {
    let sum =[]
    for(let i =0;i< ops.length ;i++){
        if(!isNaN(ops[i])){
            sum.push(Number(ops[i]))
        }else if(ops[i]==="C"){
            sum.pop()
        }else if(ops[i]==="D"){
           sum.push(sum[sum.length - 1] * 2);
        }else if(ops[i]==="+"){
            sum.push(sum[sum.length - 1] + sum[sum.length - 2])
        }
    }

    let totalSum = 0
    for(let i= 0;i<sum.length;i++){
        totalSum += sum[i]
    }

    return totalSum
};