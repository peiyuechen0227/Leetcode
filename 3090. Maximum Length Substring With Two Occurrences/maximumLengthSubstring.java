class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (left <= right && map.get(s.charAt(right)) > 2) {
                int frequency = map.get(s.charAt(left));
                map.put(s.charAt(left), frequency - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}