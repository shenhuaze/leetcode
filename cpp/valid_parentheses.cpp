#include <iostream>
#include <stack>

using namespace std;

bool IsValid(string s) {
    stack<char> parentheses;
    for (char ch : s) {
        if (ch == '(' || ch == '[' || ch == '{') {
            parentheses.push(ch);
        } else {
            if (parentheses.empty()) {
                return false;
            }
            if (ch == ')' && parentheses.top() != '(') {
                return false;
            }
            if (ch == ']' && parentheses.top() != '[') {
                return false;
            }
            if (ch == '}' && parentheses.top() != '{') {
                return false;
            }
            parentheses.pop();
        }
    }
    return parentheses.empty();
}

int main() {
    string s = "()[]{}";
    cout << IsValid(s);
    return 0;
}