class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int n = numbers.length;
        int index1 = 0;
        int index2 = n - 1;

        while (index1 < n && index2 >= 0) {
            if (numbers[index1] + numbers[index2] == target) {
                return new int[]{index1 + 1, index2 + 1};
            } else if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else index2--;
        }
        return new int[]{};
    }
}