
def max_area(height):
    left = 0
    right = len(height) - 1
    max_area_ = 0
    while left < len(height) and right > left:
        area = compute_area(left, right, height)
        if area > max_area_:
            max_area_ = area
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1
    return max_area_


def compute_area(left, right, height):
    width = right - left
    left_height = height[left]
    right_height = height[right]
    min_height = min(left_height, right_height)
    return width * min_height


if __name__ == "__main__":
    height_ = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print(max_area(height_))
