#include <iostream>

using namespace std;

template <class T>
class S {
private:
    T* arr;
    int topIndex;
    int capacity;

public:
    S(int size) {
        capacity = size;
        arr = new T[capacity];
        topIndex = -1;
    }

    bool isEmpty() {
        return topIndex == -1;
    }

    bool isFull() {
        return topIndex == capacity - 1;
    }

    void push(T item) {
        if (!isFull()) {
            arr[++topIndex] = item;
            cout << "Pushed: " << item << endl;
        } else {
            cout << "Stack is full. Cannot push." << endl;
        }
    }

    void pop() {
        if (!isEmpty()) {
            cout << "Popped: " << arr[topIndex--] << endl;
        } else {
            cout << "Stack is empty. Cannot pop." << endl;
        }
    }

    T top() {
        if (!isEmpty()) {
            return arr[topIndex];
        } else {
            cerr << "Stack is empty. No top element." << endl;
            exit(1);
        }
    }

    ~S() {
        delete[] arr;
    }
};

int main() {
    S<int> intStack(5);

    cout << "Is stack empty? " << (intStack.isEmpty() ? "Yes" : "No") << endl;
    cout << "Is stack full? " << (intStack.isFull() ? "Yes" : "No") << endl;

    intStack.push(7);
    intStack.push(12);
    intStack.push(27);

    cout << "Top element: " << intStack.top() << endl;

    intStack.pop();
    cout << "Top element after pop: " << intStack.top() << endl;

    cout << "Is stack empty? " << (intStack.isEmpty() ? "Yes" : "No") << endl;
    intStack.push(5);
    cout << "Is stack full? " << (intStack.isFull() ? "Yes" : "No") << endl;
    intStack.push(18);
    intStack.push(13);
    cout << "Is stack full? " << (intStack.isFull() ? "Yes" : "No") << endl;

    return 0;
}
