#include <iostream>
#include <vector>

using namespace std;

void Dfs(vector<string>& results, string prefix, int index, vector<string>& digit_letter, string digits) {
    if (index == digits.size()) {
        results.push_back(prefix);
        return;
    }
    int digit = digits[index] - '0';
    string letters = digit_letter[digit];
    for (char letter: letters) {
        Dfs(results, prefix + letter, index + 1, digit_letter, digits);
    }
}

vector<string> LetterCombinations(string digits) {
    vector<string> results;
    if (digits.empty()) {
        return results;
    }
    vector<string> digit_letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    Dfs(results, "", 0, digit_letter, digits);
    return results;
}

int main() {
    string digits = "23";
    vector<string> results = LetterCombinations(digits);
    for (int i = 0; i < results.size(); i++) {
        cout << results[i] << " ";
    }
    return 0;
}