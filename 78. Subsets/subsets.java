class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    void backtracking(int nums[], int startIndex) {
        // Add the current subset to the result
        result.add(new ArrayList<>(list));

        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // Choose the element
            list.add(nums[i]);
            // Explore next elements
            backtracking(nums, i + 1);
            // Backtrack to try another possibility
            list.removeLast();
        }
        return;
    }
}
