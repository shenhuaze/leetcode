#include <iostream>
#include <vector>

using namespace std;

int ComputeArea(int left, int right, vector<int>& height) {
    int width = right - left;
    int left_height = height[left];
    int right_height = height[right];
    int min_height = min(left_height, right_height);
    return width * min_height;
}

int MaxArea(vector<int>& height) {
    int left = 0;
    int right = height.size() - 1;
    int max_area = 0;
    while (left < height.size() && right > left) {
        int area = ComputeArea(left, right, height);
        if (area > max_area) {
            max_area = area;
        }
        if (height[left] < height[right]) {
            left += 1;
        } else {
            right -= 1;
        }
    }
    return max_area;
}

int main() {
    vector<int> height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    cout << MaxArea(height);
    return 0;
}