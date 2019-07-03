
def four_sum(nums, target):
    results = []
    if nums is None or len(nums) < 4:
        return results
    nums = sorted(nums)
    for i in range(len(nums) - 3):
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        for j in range(i + 1, len(nums) - 2):
            if j > i + 1 and nums[j] == nums[j - 1]:
                continue
            left = j + 1
            right = len(nums) - 1
            while left < right:
                sum_ = nums[i] + nums[j] + nums[left] + nums[right]
                if sum_ == target:
                    results.append([nums[i], nums[j], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                elif sum_ < target:
                    left += 1
                else:
                    right -= 1
    return results


if __name__ == "__main__":
    # nums_ = [1, 0, -1, 0, -2, 2]
    nums_ = [0, 0, 0, 0]
    target_ = 0
    print(four_sum(nums_, target_))
