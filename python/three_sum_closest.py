
def three_sum_closest(nums, target):
    closest = nums[0] + nums[1] + nums[2]
    diff = abs(closest - target)
    nums = sorted(nums)
    for i in range(len(nums) - 2):
        left = i + 1
        right = len(nums) - 1
        while left < right:
            sum_ = nums[i] + nums[left] + nums[right]
            new_diff = abs(sum_ - target)
            if new_diff < diff:
                diff = new_diff
                closest = sum_
            if sum_ < target:
                left += 1
            else:
                right -= 1
    return closest


if __name__ == "__main__":
    # nums_ = [-1, 2, 1, -4]
    nums_ = [-3, -2, -5, 3, -4]
    # target_ = 1
    target_ = -1
    print(three_sum_closest(nums_, target_))
