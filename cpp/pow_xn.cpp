#include <iostream>

using namespace std;

double MyPow(double x, int n) {
    if (n == 0) {
        return 1;
    }
    double half = MyPow(x, n / 2);
    if (n % 2 == 0) {
        return half * half;
    }
    if (n > 0) {
        return half * half * x;
    } else {
        return half * half / x;
    }
}

int main() {
    double x = 2;
    int n = -2;
    cout << MyPow(x, n);
    return 0;
}