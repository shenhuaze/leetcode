#include <iostream>
#include <vector>

using namespace std;

int MaxProfit(vector<int>& prices) {
    int result = 0;
    int min_price = INT_MAX;
    for (int price: prices) {
        min_price = min(price, min_price);
        result = max(price - min_price, result);
    }
    return result;
}

int main() {
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << MaxProfit(prices);
    return 0;
}