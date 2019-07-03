#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* RemoveNthFromEnd(ListNode* head, int n) {
    if (!head) {
        return nullptr;
    }
    ListNode* pre = head;
    ListNode* cur = head;
    for (int i = 0; i < n; i++) {
        cur = cur->next;
    }
    if (!cur) {
        return head->next;
    }
    while (cur->next) {
        pre = pre->next;
        cur = cur->next;
    }
    pre->next = pre->next->next;
    return head;
}

int main() {
    ListNode node1 = {1};
    ListNode node2 = {2};
    ListNode node3 = {3};
    ListNode node4 = {4};
    ListNode node5 = {5};
    node1.next = &node2;
    node2.next = &node3;
    node3.next = &node4;
    node4.next = &node5;
    int n = 2;
    ListNode* result = RemoveNthFromEnd(&node1, n);
    while (result) {
        cout << result->val << " ";
        result = result->next;
    }
    return 0;
}