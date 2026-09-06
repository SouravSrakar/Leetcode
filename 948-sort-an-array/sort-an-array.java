class Solution {

    public int[] sortArray(int[] nums) {

        int n = nums.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {

            // Move maximum element to the end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Restore max heap
            heapify(nums, i, 0);
        }

        return nums;
    }

    private void heapify(int[] nums, int n, int i) {

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        // If parent is not largest
        if (largest != i) {

            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;

            heapify(nums, n, largest);
        }
    }
}