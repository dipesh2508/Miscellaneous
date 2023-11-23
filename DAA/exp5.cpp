#include <iostream>
#include <stdlib.h>
#include <ctime>
#include <iomanip>
using namespace std;

int partition(int arr[], int low, int high)
{
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; ++j)
    {
        if (arr[j] < pivot)
        {
            ++i;
            swap(arr[i], arr[j]);
        }
    }

    swap(arr[i + 1], arr[high]);

    return i + 1;
}

int merge(int arr[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);

        merge(arr, low, pi - 1);
        merge(arr, pi + 1, high);
    }
}

int main(void)
{

    clock_t start, end;
    int n = 10;
    int arr[n];

    for (int i = 0; i < n; i++)
    {
        arr[i] = rand() % 100;
    }

    cout << "before sorting " << endl;
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    start = clock();

    merge(arr, 0, n - 1);

    end = clock();

    cout << endl
         << "after sorting " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
    double time_taken = double(end - start) / double(CLOCKS_PER_SEC);
    cout << "time taken " << time_taken << setprecision(5) << endl;
}