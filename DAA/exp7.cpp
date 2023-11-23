// 0-1 knapshack problem

#include <iostream>
using namespace std;

int knapshack(int wt[], int val[], int n, int W)
{
    int dp[n + 1][W + 1];

    for (int i = 0; i <= n; i++)
        dp[i][0] = 0;
    
    for (int i = 1; i <= W; i++)
        dp[0][i] = 0;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j <= W; j++)
        {
            if (wt[i - 1] <= j)
                dp[i][j] = max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
            else
                dp[i][j] = dp[i - 1][j];
            
        }
    }

    return dp[n][W];
}

int main(void)
{

    int wt[] = {2, 3, 4, 5};
    int val[] = {1, 2, 5, 6};

    int n = sizeof(wt) / sizeof(wt[0]);
    int W = 9;

    cout << knapshack(wt, val, n, W);

    return 0;
}
