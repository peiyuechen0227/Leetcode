class Solution {
    // Store the final list of valid IP addresses
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // Edge case: The length of a valid IP address must be between 4 and 12
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>(); // Return empty list instead of null
        }
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return result;
    }

    /**
     * Backtracking function to generate valid IP addresses
     * @param s: The current modified string with inserted dots
     * @param startIndex: The starting index to consider for the next segment
     * @param dot: The count of inserted dots (should be exactly 3 for a valid IP)
     */
    void backtracking(StringBuilder s, int startIndex, int dot) {
        // Base case: If we have placed 3 dots, check if the remaining part is valid
        if (dot == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s.toString());
            }
            return;
        }

        // Iterate through possible segment lengths
        for (int i = startIndex; i < s.length(); i++) {
            // Validate the segment before inserting a dot
            if (isValid(s, startIndex, i)) {
                // Insert a dot after the current segment
                s.insert(i + 1, '.');
                // Recur for the next segment, starting after the inserted dot
                backtracking(s, i + 2, dot + 1);
                // Backtrack by removing the inserted dot
                s.deleteCharAt(i + 1);
            } else {
                break; // If the segment is invalid, stop further checks
            }
        }
    }

    /**
     * Function to check if a given segment is a valid IP address component
     * @param s: The string containing the segment
     * @param start: The starting index of the segment
     * @param end: The ending index of the segment
     * @return true if the segment is valid, false otherwise
     */
    boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) return false;

        // If the segment has a leading zero but is not a single "0", it's invalid
        if (s.charAt(start) == '0' && start < end) {
            return false;
        }

        int num = 0;
        // Convert the substring into an integer and validate
        for (int i = start; i <= end; i++) {
            // Ensure the character is a digit
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            // Ensure the integer value is within the valid IP range (0-255)
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
