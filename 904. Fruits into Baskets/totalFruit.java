class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        for (right = 0; right < fruits.length; right++) {
            map.put(fruits[right], right);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                map.remove(fruits[minIndex]);
                left = minIndex + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}