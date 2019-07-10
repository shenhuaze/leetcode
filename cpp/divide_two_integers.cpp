#include <iostream>

using namespace std;

int Divide(int dividend, int divisor) {
    if (dividend == INT_MIN && divisor == -1) {
        return INT_MAX;
    }
    long dvd = labs(dividend), dvs = labs(divisor), ans = 0;
    bool is_same_sign = (dividend > 0) == (divisor > 0);
    while (dvd >= dvs) {
        long temp = dvs, m = 1;
        while (temp << 1 <= dvd) {
            temp <<= 1;
            m <<= 1;
        }
        dvd -= temp;
        ans += m;
    }
    return is_same_sign ? ans : -ans;
}

int main() {
    int dividend = 10;
    int divisor = 3;
    cout << Divide(dividend, divisor) << "\n";
    return 0;
}