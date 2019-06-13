
def two_sum(nums, target):
    dic = {}
    for i in range(len(nums)):
        if nums[i] in dic:
            return [dic[nums[i]], i]
        dic[target - nums[i]] = i
    return []


if __name__ == "__main__":
    nums_ = [2, 7, 11, 15]
    target_ = 9
    result_ = two_sum(nums_, target_)
    print(result_)
