#include <iostream>
#include <map>
using namespace std;

void findFrequency(int arr[], int n) {
    map<int, int> freq;

    for (int i = 0; i < n; ++i) {
        freq[arr[i]]++;
    }

    cout << "Frequency of elements:" << endl;
    for (auto it = freq.begin(); it != freq.end(); ++it) {
        cout << it->first << ": " << it->second << endl;
    }
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    int arr[n];
    cout << "Enter the elements:" << endl;
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    findFrequency(arr, n);

    return 0;
}
