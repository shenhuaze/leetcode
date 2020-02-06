#include <iostream>
#include <vector>

using namespace std;

int MaxProfit(vector<int>& prices) {
    if (prices.empty()) {
        return 0;
    }
    int result = 0;
    for (int i = 0; i < prices.size() - 1; i++) {
        if (prices[i] < prices[i + 1]) {
            result += prices[i + 1] - prices[i];
        }
    }
    return result;
}

int main() {
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << MaxProfit(prices);
    return 0;
}