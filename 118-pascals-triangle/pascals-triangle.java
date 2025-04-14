class Solution {
  List<Integer> row(int r) {
    List<Integer> row = new ArrayList<>();
    int ans = 1;
    row.add(ans); 

    for (int i = 1; i <= r; i++) {
      ans = ans * (r - i + 1);
      ans = ans / i;
      row.add(ans); 
    }

    return row;
  }

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();

    for(int i = 0;  i < numRows;i++){
      List<Integer> r = row(i);
      res.add(r);
    }
    return res;

  }
}