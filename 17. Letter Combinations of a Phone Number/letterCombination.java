class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        // If digits is empty or invaild return empty list
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtracking(phoneMap, digits, 0);
        return result;
    }

    private void backtracking(Map<Character, String> phoneMap, String digits, int index) {
        // Base case: if traverse to the end of the digits, add path to result, return
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // Get the current digit at the given index
        char digit = digits.charAt(index);
        // If digit is '1', skip it as it does not map to any letters
        if (digit == '1') {
            return;
        }

        // Get the corresponding letters for the current digit
        String letter = phoneMap.get(digit);

        // Iterate through each letter and explore all possible combinations using backtracking
        for (int j = 0; j < letter.length(); j++) {
            char ch = letter.charAt(j);
            path.append(ch); // Append the current letter
            backtracking(phoneMap, digits, index + 1); // Move to the next digit
            path.deleteCharAt(path.length() - 1); // Backtrack by removing the last added letter
        }
    }
}
