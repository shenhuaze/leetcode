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
    ListNode* pre = head;
    while (pre) {
        ListNode* cur = pre;
        while (cur->next && cur->val == cur->next->val) {
            cur = cur->next;
        }
        pre->next = cur->next;
        pre = pre->next;
    }
    return head;
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