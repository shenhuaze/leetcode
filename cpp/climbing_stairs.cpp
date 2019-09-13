#include <iostream>

using namespace std;

int ClimbStairs(int n) {
    if (n == 1) {
        return 1;
    }
    int a = 1;
    int b = 2;
    for (int i = 3; i <= n; i++) {
        b += a;
        a = b - a;
    }
    return b;
}

int main() {
    cout << ClimbStairs(3);
    return 0;
}