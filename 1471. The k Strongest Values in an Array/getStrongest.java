class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int[] result = new int[k];
        int mid = left + (right - left) / 2;

        for (int i = 0; i < result.length; i++) {
            int leftDistance = Math.abs(arr[left] - arr[mid]);
            int rightDistance = Math.abs(arr[right] - arr[mid]);
            if (leftDistance > rightDistance) {
                result[i] = arr[left];
                left++;
            } else {
                result[i] = arr[right];
                right--;
            }
        }
        return result;
    }
}