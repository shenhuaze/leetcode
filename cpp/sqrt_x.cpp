#include <iostream>

using namespace std;

int MySqrt(int x) {
    if (x <= 1) {
        return x;
    }
    int left = 0;
    int right = x;
    int mid;
    while (left + 1 < right) {
        mid = left + (right - left) / 2;
        if (x / mid > mid) {
            left = mid;
        } else if (x / mid < mid) {
            right = mid;
        } else {
            return mid;
        }
    }
    return left;
}

int main() {
    cout << MySqrt(2147395599);
    return 0;
}