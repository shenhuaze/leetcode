#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

// Solution 1
ListNode* SwapPairs(ListNode* head) {
    ListNode* dummy = new ListNode(0);
    ListNode* pre = dummy;
    pre->next = head;
    while (pre->next && pre->next->next) {
        ListNode* temp = pre->next->next;
        pre->next->next = temp->next;
        temp->next = pre->next;
        pre->next = temp;
        pre = temp->next;
    }
    return dummy->next;
}

// Solution 2
ListNode* SwapPairsRecursion(ListNode* head) {
    if (!head or !head->next) {
        return head;
    }
    ListNode* new_head = head->next;
    head->next = SwapPairsRecursion(new_head->next);
    new_head->next = head;
    return new_head;
}

int main() {
    ListNode* head = new ListNode(1);
    //auto head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    //ListNode* result = SwapPairs(head);
    ListNode* result = SwapPairsRecursion(head);
    while (result) {
        cout << result->val << " -> ";
        result = result->next;
    }
    return 0;
}