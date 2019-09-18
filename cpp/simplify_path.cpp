#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

string SimplifyPath(string path) {
    string result;
    string part;
    stringstream ss(path);
    vector<string> v;
    while (getline(ss, part, '/')) {
        if (part == "" || part == ".") {
            continue;
        }
        if (part == "..") {
            if (!v.empty()) {
                v.pop_back();
            }
        } else {
            v.push_back(part);
        }
    }
    for (string s: v) {
        result += "/" + s;
    }
    if (result.empty()) {
        return "/";
    } else {
        return result;
    }
}

int main() {
    string path = "/a//b////c/d//././/..";
    cout << SimplifyPath(path);
    return 0;
}