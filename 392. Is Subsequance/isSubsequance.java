class Solution {
    // public boolean isSubsequence(String s, String t) {
    //     int j = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         Character cur = s.charAt(i);
    //         while (j <= t.length()) {
    //             if (j == t.length()) {
    //                 return false;
    //             }
    //             if (t.charAt(j) == cur) {
    //                 j++;
    //                 break;
    //             }
    //             j++;
    //         }
    //     }
    //     return true;
    // }

    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }
        return p1 == n;
    }
}
