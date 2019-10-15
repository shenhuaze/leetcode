#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* Partition(ListNode* head, int x) {
    ListNode* dummy = new ListNode(0);
    dummy->next = head;
    ListNode* pre = dummy;
    while (pre->next && pre->next->val < x) {
        pre = pre->next;
    }
    ListNode* cur = pre;
    while (cur->next) {
        if (cur->next->val < x) {
            ListNode* temp = cur->next;
            cur->next = temp->next;
            temp->next = pre->next;
            pre->next = temp;
            pre = pre->next;
        } else {
            cur = cur->next;
        }
    }
    return dummy->next;
}

int main() {
    ListNode* head = new ListNode(1);
    head->next = new ListNode(4);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(2);
    head->next->next->next->next = new ListNode(5);
    head->next->next->next->next->next = new ListNode(2);
    int x = 3;
    ListNode* result = Partition(head, x);
    while (result) {
        cout << result->val << " -> ";
        result = result->next;
    }
    return 0;
}