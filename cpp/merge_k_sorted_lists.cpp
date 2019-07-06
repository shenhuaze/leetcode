#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* MergeTwoLists(ListNode* l1, ListNode* l2) {
    ListNode* dummy = new ListNode(0);
    ListNode* cur = dummy;
    while (l1 && l2) {
        if (l1->val < l2->val) {
            cur->next = l1;
            l1 = l1->next;
        } else {
            cur->next = l2;
            l2 = l2->next;
        }
        cur = cur->next;
    }
    if (l1) {
        cur->next = l1;
    } else {
        cur->next = l2;
    }
    return dummy->next;
}

// Solution 1
ListNode* MergeKLists(vector<ListNode*>& lists) {
    if (lists.empty()) {
        return nullptr;
    }
    int n = lists.size();
    while (n > 1) {
        int k = (n + 1) / 2;
        for (int i = 0; i < n / 2; i++) {
            lists[i] = MergeTwoLists(lists[i], lists[i + k]);
        }
        n = k;
    }
    return lists[0];
}

// Solution 2
struct comparator{
    bool operator() (ListNode*& a, ListNode*& b) {
        return a->val > b->val;
    }
};

ListNode* MergeKLists2(vector<ListNode*>& lists) {
    if (lists.empty()) {
        return nullptr;
    }
    priority_queue<ListNode*, vector<ListNode*>, comparator> heap;
    for (ListNode* node : lists) {
        if (node) {
            heap.push(node);
        }
    }
    ListNode* dummy = new ListNode(0);
    ListNode* cur = dummy;
    while (!heap.empty()) {
        ListNode* node = heap.top();
        heap.pop();
        cur->next = node;
        cur = cur->next;
        if (node->next) {
            heap.push(node->next);
        }
    }
    return dummy->next;
}

int main() {
    ListNode* l1 = new ListNode(1);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(5);
    ListNode* l2 = new ListNode(1);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(4);
    ListNode* l3 = new ListNode(2);
    l3->next = new ListNode(6);
    vector<ListNode*> lists = {l1, l2, l3};
    //ListNode* result = MergeKLists(lists);
    ListNode* result = MergeKLists2(lists);
    while (result) {
        cout << result->val << " -> ";
        result = result->next;
    }
    return 0;
}