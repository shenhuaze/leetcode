#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


ListNode* AddTwoNumbers(ListNode* l1, ListNode* l2) {
    ListNode *dummy = new ListNode(-1);
    ListNode *cur = dummy;
    int carry = 0;
    int sum;
    int val1;
    int val2;
    while (l1 || l2) {
        if (l1) {
            val1 = l1->val;
        } else {
            val1 = 0;
        }
        if (l2) {
            val2 = l2->val;
        } else {
            val2 = 0;
        }
        sum = carry + val1 + val2;
        if (sum < 10) {
            carry = 0;
        } else {
            carry = 1;
        }
        cur->next = new ListNode(sum % 10);
        cur = cur->next;
        if (l1) {
            l1 = l1->next;
        }
        if (l2) {
            l2 = l2->next;
        }
    }
    if (carry == 1) {
        cur->next = new ListNode(1);
    }
    return dummy->next;
}

int main() {
    ListNode* l1 = new ListNode(2);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(3);
    ListNode* l2 = new ListNode(5);
    l2->next = new ListNode(6);
    l2->next->next = new ListNode(4);
    ListNode* result = AddTwoNumbers(l1, l2);
    while (result) {
        cout << result->val << " -> ";
        result = result->next;
    }
    cout << "null";
    return 0;
}