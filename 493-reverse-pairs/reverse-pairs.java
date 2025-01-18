class Solution {

    public int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low >= high)
            return count;

        int mid = (low + high) / 2;

        // divide array
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        // count reverse pairs
        count += countReversePairs(nums, low, mid, high);

        // merge two sorted subarrays
        merge(nums, low, mid, high);

        return count;

    }

    public void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public int countReversePairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }

        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}