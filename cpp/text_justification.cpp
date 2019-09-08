#include <iostream>
#include <vector>

using namespace std;

vector<string> FullJustify(vector<string>& words, int max_width) {
    vector<string> results;
    if (words.empty()) {
        return results;
    }
    int i = 0;
    while (i < words.size()) {
        int j = i;
        int len = 0;
        while (j < words.size() && len + words[j].size() + j - i <= max_width) {
            len += words[j].size();
            j += 1;
        }
        string line;
        int remaining_space = max_width - len;
        for (int k = i; k < j; k++) {
            line += words[k];
            if (remaining_space > 0) {
                int current_space;
                if (j == words.size()) {
                    if (j - k > 1) {
                        current_space = 1;
                    } else {
                        current_space = remaining_space;
                    }
                } else {
                    if (j - k > 1) {
                        if (remaining_space % (j - k - 1) == 0) {
                            current_space = remaining_space / (j - k - 1);
                        } else {
                            current_space = remaining_space / (j - k - 1) + 1;
                        }
                    } else {
                        current_space = remaining_space;
                    }
                }
                for (int m = 0; m < current_space; m++) {
                    line += " ";
                }
                remaining_space -= current_space;
            }
        }
        results.push_back(line);
        i = j;
    }
    return results;
}

int main() {
    //vector<string> words = {"This", "is", "an", "example", "of", "text", "justification."};
    //vector<string> words = {"What", "must", "be", "acknowledgment", "shall", "be"};
    vector<string> words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                            "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
    //int max_width = 16;
    int max_width = 20;
    vector<string> results = FullJustify(words, max_width);
    for (string line: results) {
        cout << "\"" + line + "\"\n";
    }
    return 0;
}