//Develop  a  program and analyze complexity to  implement subset-sum problem using Dynamic Programming.

#include <iostream>
using namespace std;

int subsetSum(int arr[], int n, int sum){
    bool dp[n + 1][sum + 1];

    for (int i = 0; i <= n; i++) {
        dp[i][0] = true;
    }

    for (int i = 1; i <= sum; i++) {
        dp[0][i] = false;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sum; j++) {
            if (arr[i - 1] <= j) {
                dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
            }
            else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return dp[n][sum];
}

int main(void)
{

    int arr[] = { 2, 3, 7, 8, 10 };

    int n = sizeof(arr) / sizeof(arr[0]);
    int sum = 0;

    int subsetToFind;

    cout << "Array" << endl;
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
        sum += arr[i];
    }

    cout << endl << "Enter subset to find: ";
    cin >> subsetToFind;

    if (sum < subsetToFind) {
        cout << endl << "No subset found";
        return 0;
    }
    if (subsetSum(arr, n, subsetToFind)) {
        cout << endl << "Subset found";
    }
    else {
        cout << endl << "No subset found";
    }

    return 0;
}