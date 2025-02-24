class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // HashSet to store the used element in the same level
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Skip if element is used
            if (used[i] == true || set.contains(nums[i])) continue;
            // Add nums[i] to HashSet to avoid duplicate
            set.add(nums[i]);
            // Add nums[i] to path
            path.add(nums[i]);
            // Set nums[i] to used
            used[i] = true;
            backtracking(nums, used);
            path.removeLast();
            used[i] = false;
        }
        return;
    }
}
