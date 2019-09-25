

def sort_colors(nums):
    red = 0
    blue = len(nums) - 1
    i = 0
    while i <= blue:
        if nums[i] == 0:
            swap(nums, i, red)
            i += 1
            red += 1
        elif nums[i] == 2:
            swap(nums, i, blue)
            blue -= 1
        else:
            i += 1


def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp


if __name__ == '__main__':
    nums_ = [2, 0, 2, 1, 1, 0]
    sort_colors(nums_)
    print(nums_)
