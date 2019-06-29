
def three_sum(nums):
    if nums is None or len(nums) < 3:
        return []
    nums = sorted(nums)
    results = []
    for i in range(len(nums) - 2):
        if nums[i] > 0:
            break
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        target = -nums[i]
        start = i + 1
        end = len(nums) - 1
        while start < end:
            if nums[start] + nums[end] == target:
                results.append([-target, nums[start], nums[end]])
                start += 1
                end -= 1
                while start < end and nums[start] == nums[start - 1]:
                    start += 1
                while start < end and nums[end] == nums[end + 1]:
                    end -= 1
            elif nums[start] + nums[end] < target:
                start += 1
            else:
                end -= 1
    return results


if __name__ == "__main__":
    nums_ = [-1, 0, 1, 2, -1, -4]
    print(three_sum(nums_))
