import java.util.*;
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Edge case
        if (nums.length == 1) {
            return nums;
        }

        // the length of the result array
        int len = nums.length - k + 1;

        // Use an array to store the max sliding window
        int[] res = new int[len];
        // index of the result array
        int num = 0;

        // Use a queue to keep the max number at the front
        MyQueue queue = new MyQueue();

        // put the first k elements in the queue
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[num++] = queue.getMaxValue();

        // put the rest of the elements in the queue
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            res[num++] = queue.getMaxValue();
        }

        return res;
    }

    class MyQueue {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // If the value is the first element in the queue, then poll it
        void poll(int value) {
            if (!deque.isEmpty() && value == deque.peek()) {
                deque.pollFirst();
            }
        }

        // Add a new value to the queue and maintain descending order
        void add(int value) {
            // If the value is larger than the last element in the queue, then poll the last element
            while (!deque.isEmpty() && value > deque.getLast()) {
                deque.pollLast();
            }
            deque.addLast(value);
        }

        // Get the maximum value from the queue (always the first element)
        int getMaxValue() {
            return deque.peekFirst();
        }
    }

    //time complexity: O(n)
    //space complexity: O(k)

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = swm.maxSlidingWindow(nums, k);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }



    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     // Use an array to store the max sliding window, the array size is nums.length - k + 1
    //     int n = nums.length;
    //     int[] result = new int[n - k + 1];

    //     // Two pointers, l represents the left side of the sliding window and r represents the right side of the sliding window
    //     int l = 0;
    //     int r = k - 1;
    //     // index of the result array;
    //     int i = 0;

    //     // Iterate through nums until r equals to nums.length
    //     while (r < n) {
    //         int cur = l;
    //         int max = nums[l];
    //         while (cur <= r) {
    //             // find the max element
    //             max = Math.max(nums[cur], max);
    //             cur++;
    //         }
    //         // put the max element into the array
    //         result[i++] = max;

    //         l++;
    //         r++;
    //     }

    //     // return the result
    //     return result;
    // }
    // // time complexity: O(n*k)
    // // space comlexity: O(n)

}
