#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>

using namespace std;

// 参考：https://leetcode.com/problems/word-ladder-ii/discuss/40434/C%2B%2B-solution-using-standard-BFS-method-no-DFS-or-backtracking
// 这个帖子项目的qq710467272的解法。没看懂，先存疑
vector<vector<string>> FindLadders(string beginWord, string endWord, vector<string>& wordList) {
    unordered_map<string,int> um; // 记录 到达这个string需要的转换数目
    vector<vector<string>> res;
    for(const auto w:wordList) um.insert({w,INT_MAX});
    um[beginWord]=0;
    queue<pair<string,vector<string>>> q;
    q.push({beginWord,{beginWord}});
    while(!q.empty()){
        auto n=q.front();
        q.pop();
        string w=n.first;
        auto v=n.second;
        if(w==endWord){
            res.push_back(v);
            continue;
        }
        for(int i=0;i<w.size();i++){
            string t=w;
            for(char c='a';c<='z';c++){
                t[i]=c;
                if(t==w) continue;
                if(um.find(t)==um.end()) continue;
                if(um[t]<(int)v.size()) continue;
                um[t]=(int)v.size();
                v.push_back(t);
                q.push({t,v});
                v.pop_back();
            }
        }
    }
    return res;
}

int main() {
    vector<string> wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
    vector<vector<string>> res = FindLadders("hit", "cog", wordList);
    for (vector<string> path: res) {
        for (string word: path) {
            cout << word << " ";
        }
        cout << "\n";
    }
    return 0;
}