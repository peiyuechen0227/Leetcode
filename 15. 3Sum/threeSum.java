class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//        // Solution 1: HashMap-based approach
//        // Initialize a set to store unique triplets (to avoid duplicates)
//        Set<List<Integer>> set = new HashSet<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        // Outer loop: Iterate through the array for the first element in the triplet
//        for (int i = 0; i < nums.length - 2; i++) {
//            map.clear(); // Clear the HashMap for each new first element
//            int target = 0 - nums[i]; // Define the target as the negation of the current element
//
//            // Inner loop: Use HashMap to find pairs whose sum equals the target
//            for (int j = i + 1; j < nums.length; j++) {
//                // Check if the complement (target - nums[j]) exists in the map
//                if (map.containsKey(target - nums[j])) {
//                    // If found, create a triplet and sort it to ensure uniqueness
//                    List<Integer> list = Arrays.asList(nums[i], nums[j], target - nums[j]);
//                    Collections.sort(list); // Sorting ensures consistent order
//                    set.add(list); // Add the triplet to the set
//                }
//                // Add the current element to the map
//                map.put(nums[j], j);
//            }
//        }
//
//        // Convert the set of unique triplets to a list and return
//        List<List<Integer>> resultList = new ArrayList<>(set);
//        return resultList;

        // Solution 2: Two-pointer approach
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to simplify two-pointer logic

        // Outer loop: Iterate through the array for the first element in the triplet
        for (int i = 0; i < nums.length - 2; i++) {

            // Optimization: If the current number is positive, the sum cannot be zero
            if (nums[i] > 0) {
                return list; // Since the array is sorted, no further triplets are possible
            }

            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Move to the next unique element
            }

            // Define two pointers: one starting from the next element, one from the end
            int left = i + 1;
            int right = nums.length - 1;

            // Inner loop: Adjust the two pointers to find valid triplets
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right]; // Calculate the sum of the triplet

                if (sum > 0) {
                    right--; // If the sum is too large, move the right pointer leftward
                } else if (sum < 0) {
                    left++; // If the sum is too small, move the left pointer rightward
                } else {
                    // If the sum is zero, add the triplet to the result list
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second and third elements
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--; // Move the right pointer leftward past duplicates
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++; // Move the left pointer rightward past duplicates
                    }

                    // Move both pointers to continue searching
                    left++;
                    right--;
                }
            }
        }
        return list; // Return the list of unique triplets
    }
}