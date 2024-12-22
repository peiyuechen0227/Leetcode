class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sChar = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;

        for (int i = 0; i < sChar.length; i++) {
            if (map.containsKey(sChar[i]) && map.get(sChar[i]) >= left) {
                int j = map.get(sChar[i]);
                left = j + 1;
            }
            map.put(sChar[i], i);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}