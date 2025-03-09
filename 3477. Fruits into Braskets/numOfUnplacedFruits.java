class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int length = fruits.length;
        boolean[] flag = new boolean[length];
        boolean[] placed = new boolean[length];
        int unplaced = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (fruits[i] <= baskets[j] && !flag[j]) {
                    flag[j] = true;
                    placed[i] = true;
                    break;
                }
            }
            if (placed[i] == false) {
                unplaced++;
            }
        }
        return unplaced;
    }
}
