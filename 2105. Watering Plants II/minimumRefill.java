class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;
        int left = 0;
        int right = plants.length - 1;
        int canA = capacityA;
        int canB = capacityB;

        while (left < right) {
            if (canA < plants[left]) {
                canA = capacityA;
                count += 1;
            }
            canA -= plants[left];
            left++;

            if (canB < plants[right]) {
                canB = capacityB;
                count += 1;
            }
            canB -= plants[right];
            right--;
        }

        if (left == right) {
            if (Math.max(canA, canB) < plants[left]) {
                count++;
            }
        }
        return count;
    }
}
