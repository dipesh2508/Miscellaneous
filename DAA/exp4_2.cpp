#include <iostream>

struct Node {
    int data;
    Node* prev;
    Node* next;
};


class LinkedList {
private:
    Node* head;
    Node* tail;

public:
    LinkedList() {
        head = nullptr;
        tail = nullptr;
    }

    void insertAtBeginning(int val) {
        Node* newNode = new Node();
        newNode->data = val;
        newNode->prev = nullptr;
        newNode->next = head;

        if (head != nullptr) {
            head->prev = newNode;
        } else {
            tail = newNode;
        }

        head = newNode;
    }

    void insertAtEnd(int val) {
        Node* newNode = new Node();
        newNode->data = val;
        newNode->prev = tail;
        newNode->next = nullptr;

        if (tail != nullptr) {
            tail->next = newNode;
        } else {
            head = newNode;
        }

        tail = newNode;
    }

    void deleteFromBeginning() {
        if (head == nullptr) {
            std::cout << "List is empty, cannot delete.\n";
            return;
        }

        Node* temp = head;
        head = head->next;

        if (head != nullptr) {
            head->prev = nullptr;
        } else {
            tail = nullptr;
        }

        delete temp;
    }

    void deleteFromEnd() {
        if (tail == nullptr) {
            std::cout << "List is empty, cannot delete.\n";
            return;
        }

        Node* temp = tail;
        tail = tail->prev;

        if (tail != nullptr) {
            tail->next = nullptr;
        } else {
            head = nullptr;
        }

        delete temp;
    }

    void printList() {
        Node* curr = head;
        while (curr != nullptr) {
            std::cout << curr->data << " ";
            curr = curr->next;
        }
        std::cout << "\n";
    }
};

int main(void) {
    LinkedList list;

    list.insertAtBeginning(30);
    list.insertAtEnd(50);
    list.insertAtBeginning(10);
    list.printList();

    list.deleteFromBeginning();
    list.deleteFromEnd();
    list.printList();

    return 0;
}