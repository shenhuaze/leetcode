#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-27
 */
bool IsValid(vector<int>& cols, int column) {
    int current_size = (int)cols.size();
    for (int i = 0; i < current_size; i++) {
        if (cols[i] == column) {
            return false;
        }
        if (i + cols[i] == current_size + column) {
            return false;
        }
        if (i - cols[i] == current_size - column) {
            return false;
        }
    }
    return true;
}

void Search(vector<int>& cols, vector<int>& count_list, int n) {
    if (cols.size() == n) {
        count_list.push_back(1);
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!IsValid(cols, i)) {
            continue;
        }
        cols.push_back(i);
        Search(cols, count_list, n);
        cols.pop_back();
    }
}

int TotalNQueens(int n) {
    if (n <= 0) {
        return 0;
    }
    vector<int> cols;
    vector<int> count_list;
    Search(cols, count_list, n);
    return (int)count_list.size();
}

int main() {
    cout << TotalNQueens(4);
    return 0;
}