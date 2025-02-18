class Solution {

    class Pair {
        int len;
        String word;

        public Pair(String s, int l) {
            len = l;
            word = s;
        }
    }

    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> st = new HashSet<>();

        for (String word : wordList) {
            st.add(word);
        }
        st.remove(startWord);
        q.add(new Pair(startWord, 1));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            String s = temp.word;
            int len = temp.len;

            if (s.equals(targetWord)) {
                return len;
            }

            for (int i = 0; i < s.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = s.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord) == true) {
                        q.add(new Pair(replacedWord, len + 1));
                        st.remove(replacedWord);
                    }
                }
            }
        }

        return 0;
    }
}