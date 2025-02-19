class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(list));

        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }
        return;
    }
}
