class Solution {
    public int longestSubstring(String s, int k) {
        int maxLength = 0;

        // Iterate over the possible number of unique characters (1 to 26)
        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            int left = 0, right = 0;
            int countUnique = 0; // Number of unique characters in the current window
            int countAtLeastK = 0; // Number of characters that appear at least k times
            int[] charCount = new int[26]; // Frequency array for characters

            while (right < s.length()) {
                if (countUnique <= uniqueTarget) {
                    // Expand the window by moving the right pointer
                    int index = s.charAt(right) - 'a';
                    if (charCount[index] == 0) {
                        countUnique++; // New unique character in the window
                    }
                    charCount[index]++;
                    if (charCount[index] == k) {
                        countAtLeastK++; // Character count reaches k
                    }
                    right++;
                } else {
                    // Shrink the window by moving the left pointer
                    int index = s.charAt(left) - 'a';
                    if (charCount[index] == k) {
                        countAtLeastK--; // Character count drops below k
                    }
                    charCount[index]--;
                    if (charCount[index] == 0) {
                        countUnique--; // A character is completely removed from the window
                    }
                    left++;
                }
                // Update the maximum valid substring length
                // The window is valid when all unique characters appear at least k times
                if (countUnique == countAtLeastK) {
                    maxLength = Math.max(maxLength, right - left);
                }
            }
        }
        return maxLength;
    }
}
