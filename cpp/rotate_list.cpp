#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* RotateRight(ListNode* head, int k) {
    if (head == nullptr) {
        return nullptr;
    }
    int n = 1;
    ListNode* tail = head;
    while (tail->next != nullptr) {
        tail = tail->next;
        n += 1;
    }
    tail->next = head;
    ListNode* new_tail = head;
    for (int i = 0; i < (n - k % n - 1); i++) {
        new_tail = new_tail->next;
    }
    ListNode* new_head = new_tail->next;
    new_tail->next = nullptr;
    return new_head;
}

int main() {
    auto head = new ListNode(0);
    head->next = new ListNode(1);
    head->next->next = new ListNode(2);
    head->next->next->next = new ListNode(3);
    head->next->next->next->next = new ListNode(4);
    auto new_head = RotateRight(head, 2);
    while (new_head != nullptr) {
        cout << new_head->val;
        new_head = new_head->next;
    }
    return 0;
}