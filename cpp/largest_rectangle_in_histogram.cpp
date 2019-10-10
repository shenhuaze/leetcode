#include <iostream>
#include <vector>

using namespace std;

int LargestRectangleArea(vector<int>& heights) {
    int result = 0;
    for (int i = 0; i < heights.size(); i++) {
        if (i < heights.size() - 1 && heights[i] <= heights[i + 1]) {
            continue;
        }
        int min_h = heights[i];
        for (int j = i; j >= 0; j--) {
            min_h = min(min_h, heights[j]);
            int area = min_h * (i - j + 1);
            result = max(area, result);
        }
    }
    return result;
}

int main() {
    vector<int> heights = {2, 1, 5, 6, 2, 3};
    cout << LargestRectangleArea(heights);
    return 0;
}