class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        res = []

        for i in range(n):
            # Skip duplicate values for i
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            # Early termination/pruning
            if nums[i] * 4 > target and nums[i] > 0:
                break

            for j in range(i + 1, n):
                # Skip duplicate values for j
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
                if nums[i] + nums[j] * 3 > target and nums[j] > 0:
                    break

                left, right = j + 1, n - 1
                while left < right:
                    total = nums[i] + nums[j] + nums[left] + nums[right]
                    if total < target:
                        left += 1
                    elif total > target:
                        right -= 1
                    else:
                        res.append([nums[i], nums[j], nums[left], nums[right]])
                        left += 1
                        right -= 1
                        # Skip duplicates for left and right
                        while left < right and nums[left] == nums[left - 1]:
                            left += 1
                        while left < right and nums[right] == nums[right + 1]:
                            right -= 1

        return res