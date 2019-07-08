#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* ReverseEachGroup(ListNode* pre, ListNode* next) {
    ListNode* last = pre->next;
    ListNode* cur = last->next;
    while (cur != next) {
        last->next = cur->next;
        cur->next = pre->next;
        pre->next = cur;
        cur = last->next;
    }
    return last;
}

ListNode* ReverseKGroup(ListNode* head, int k) {
    if (!head || k == 1) {
        return head;
    }
    ListNode* dummy = new ListNode(0);
    ListNode* pre = dummy;
    ListNode* cur = head;
    pre->next = cur;
    int i = 1;
    while (cur) {
        if (i % k == 0) {
            pre = ReverseEachGroup(pre, cur->next);
            cur = pre->next;
        } else {
            cur = cur->next;
        }
        i += 1;
    }
    return dummy->next;
}

int main() {
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);
    int k = 3;
    ListNode* result = ReverseKGroup(head, k);
    while (result) {
        cout << result->val << " -> ";
        result = result->next;
    }
    return 0;
}