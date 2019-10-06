#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* DeleteDuplicates(ListNode* head) {
    if (!head || !head->next) {
        return head;
    }
    ListNode* dummy = new ListNode(0);
    ListNode* pre = dummy;
    dummy->next = head;
    while (pre->next) {
        ListNode* cur = pre->next;
        while (cur->next && cur->val == cur->next->val) {
            cur = cur->next;
        }
        if (cur == pre->next) {
            pre = pre->next;
        } else {
            pre->next = cur->next;
        }
    }
    return dummy->next;
}

int main() {
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(3);
    head->next->next->next->next = new ListNode(4);
    head->next->next->next->next->next = new ListNode(4);
    head->next->next->next->next->next->next = new ListNode(5);
    ListNode* result = DeleteDuplicates(head);
    while (result) {
        cout << result->val << "->";
        result = result->next;
    }
    return 0;
}