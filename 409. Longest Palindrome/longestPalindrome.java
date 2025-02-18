class Solution {
    // public int longestPalindrome(String s) {
    //     if (s.length() == 1) return 1;
    //     if (s.length() == 0 || s == null) return 0;
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (!map.containsKey(c)) {
    //             map.put(c, 1);
    //         } else map.put(c, map.get(c) + 1);
    //     }

    //     int sum = 0;
    //     boolean hasOdd = false;

    //     for (int num: map.values()) {
    //         if (num % 2 == 0) {
    //             sum += num;
    //         } else {
    //             sum += num - 1;
    //             hasOdd = true;
    //         }
    //     }

    //     if (hasOdd) {
    //         sum += 1;
    //     }

    //     return sum;
    // }

    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c: s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int frequency: count) {
            if (frequency % 2 == 0) {
                length += frequency;
            } else {
                length += frequency - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length += 1;
        }
        return length;
    }
}
