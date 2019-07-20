#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-19
 */

// Solution 1: Brute force
int Trap(vector<int>& height) {
    if (height.empty()) {
        return 0;
    }
    int result = 0;
    for (int i = 0; i < height.size(); i++) {
        int max_left = 0;
        int max_right = 0;
        for (int j = 0; j <= i; j++) {
            max_left = max(max_left, height[j]);
        }
        for (int j = i; j < height.size(); j++) {
            max_right = max(max_right, height[j]);
        }
        result += min(max_left, max_right) - height[i];
    }
    return result;
}

// Solution 2: Dynamic programming
int Trap2(vector<int>& height) {
    if (height.empty()) {
        return 0;
    }
    int size = height.size();
    int result = 0;
    vector<int> max_left(size);
    max_left[0] = height[0];
    for (int i = 1; i < size; i++) {
        max_left[i] = max(max_left[i - 1], height[i]);
    }
    vector<int> max_right(size);
    max_right[size - 1] = height[size - 1];
    for (int i = size - 2; i >= 0; i--) {
        max_right[i] = max(max_right[i + 1], height[i]);
    }
    for (int i = 0; i < size; i++) {
        result += min(max_left[i], max_right[i]) - height[i];
    }
    return result;
}

int main() {
    vector<int> height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    //cout << Trap(height);
    cout << Trap2(height);
    return 0;
}