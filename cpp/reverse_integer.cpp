#include <iostream>

using namespace std;

int reverse(int x) {
    int result = 0;
    while (x != 0) {
        if (abs(result) > INT_MAX / 10) {
            return 0;
        }
        result = result * 10 + x % 10;
        x = x / 10;
    }
    return result;
}

int main() {
    int x = 123;
    int result = reverse(x);
    cout << result << endl;
    return 0;
}