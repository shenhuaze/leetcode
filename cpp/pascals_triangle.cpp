#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> Generate(int num_rows) {
    vector<vector<int>> results(num_rows, vector<int>());
    for (int i = 0; i < num_rows; i++) {
        if (i == 0) {
            results[0].push_back(1);
        }
        if (i == 1) {
            results[1].push_back(1);
            results[1].push_back(1);
        }
        if (i >= 2) {
            results[i].push_back(1);
            for (int j = 0; j < i - 1; j++) {
                results[i].push_back(results[i - 1][j] + results[i - 1][j + 1]);
            }
            results[i].push_back(1);
        }
    }
    return results;
}

int main() {
    auto results = Generate(5);
    for (vector<int> row: results) {
        for (int i: row) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}