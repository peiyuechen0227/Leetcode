class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int i = s.length() - 2;
        int previous = map.get(s.charAt(s.length() - 1));
        int result = previous;
        while (i >= 0) {
            int current = map.get(s.charAt(i));

            if (previous > current) {
                result -= current;
            } else {
                result += current;
            }
            previous = current;
            i--;
        }
        return result;
    }
}
