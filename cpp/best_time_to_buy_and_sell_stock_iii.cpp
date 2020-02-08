#include <iostream>
#include <vector>

using namespace std;

int MaxProfit(vector<int>& prices) {
    if (prices.empty()) {
        return 0;
    }
    vector<int> local(3);
    vector<int> global(3);
    for (int i = 0; i < prices.size() - 1; i++) {
        int diff = prices[i + 1] - prices[i];
        for (int j = 2; j >= 1; j--) {
            if (diff > 0) {
                local[j] = max(local[j] + diff, global[j - 1] + diff);
            } else {
                local[j] = max(local[j] + diff, global[j - 1]);
            }
            global[j] = max(local[j], global[j]);
        }
    }
    return global[2];
}

int main() {
    vector<int> prices = {3, 3, 5, 0, 0, 3, 1, 4};
    cout << MaxProfit(prices);
    return 0;
}