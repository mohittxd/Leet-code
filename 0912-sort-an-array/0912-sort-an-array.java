class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Step 1: Build a max heap (in-place)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Step 2: Repeatedly extract the max, move it to the end
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);      // move current max to the end
            heapify(nums, i, 0);   // re-heapify the reduced heap
        }

        return nums;
    }

    // Sift down: maintain max-heap property for subtree rooted at index i
    private void heapify(int[] nums, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, heapSize, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}