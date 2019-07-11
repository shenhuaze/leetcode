#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> FindSubstring(string s, vector<string>& words) {
    vector<int> result;
    if (s.empty() || words.empty()) {
        return result;
    }
    unordered_map<string, int> word_count;
    for (string word : words) {
        word_count[word] += 1;
    }
    int num_words = words.size();
    int word_length = words[0].size();
    for (int i = 0; i <= (int)s.size() - num_words * word_length; i++) {
        unordered_map<string, int> temp_word_count;
        int j = 0;
        while (j < num_words) {
            string temp_word = s.substr(i + j * word_length, word_length);
            if (!word_count.count(temp_word)) {
                break;
            }
            temp_word_count[temp_word] += 1;
            if (temp_word_count[temp_word] > word_count[temp_word]) {
                break;
            }
            j += 1;
        }
        if (j == num_words) {
            result.push_back(i);
        }
    }
    return result;
}

int main() {
    string s = "barfoothefoobarman";
    vector<string> words = {"foo", "bar"};
    vector<int> result = FindSubstring(s, words);
    for (int index : result) {
        cout << index << " ";
    }
    return 0;
}