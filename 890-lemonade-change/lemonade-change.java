class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] balance = new int[3];

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                balance[0]++;
            } else if (bills[i] == 10) {
                if (balance[0] > 0) {
                    balance[1]++;
                    balance[0]--;
                } else {
                    return false;
                }
            }else{
                if(balance[1] > 0 && balance[0] > 0){
                    balance[2]++;
                    balance[1]--;
                    balance[0]--;
                }else if(balance[0] >= 3){
                    balance[2]++;
                    balance[0] -=3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}