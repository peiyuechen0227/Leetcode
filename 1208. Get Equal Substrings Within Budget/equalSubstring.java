class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int cost = 0;
        int maxLength = 0;
        while (right < s.length()) {
            // Calculate the cost to change s[right] to t[right]
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            // If the cost is greater than maxCount, shrink window from left
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++; // Move left pointer forward
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
// tc: O(n)
// sc: O(1)
