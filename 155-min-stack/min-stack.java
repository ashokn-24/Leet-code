class MinStack {

    private Stack<Pair<Integer, Integer>> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.add(new Pair<>(val, val));
        } else {
            int pre = st.peek().getValue();
            int max = Math.min(val, pre);
            st.add(new Pair<>(val,max));
        }
    }

    public void pop() {
        if(st.isEmpty()){
            return ;
        }
        
        st.pop();
    }

    public int top() {
        return st.peek().getKey();
    }

    public int getMin() {
        int min = st.peek().getValue();
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */