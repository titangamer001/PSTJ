class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int half = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ("aeiouAEIOU".indexOf(c) != -1) {
                if (i < half) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return count == 0;
    }
}
