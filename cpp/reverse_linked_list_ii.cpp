#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* ReverseBetween(ListNode* head, int m, int n) {
    auto dummy = new ListNode(-1);
    dummy->next = head;
    ListNode* pre = dummy;
    ListNode* cur = head;
    for (int i = 0; i < m - 1; i++) {
        pre = pre->next;
        cur = cur->next;
    }
    for (int i = m; i < n; i++) {
        ListNode* temp = cur->next;
        cur->next = temp->next;
        temp->next = pre->next;
        pre->next = temp;
    }
    return dummy->next;
}

int main() {
    auto head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);
    int m = 2;
    int n = 4;
    ListNode* result = ReverseBetween(head, m, n);
    while (result) {
        cout << result->val << " ";
        result = result->next;
    }
    return 0;
}