//Develop  a  program and analyze complexity  to find all occurrences of a pattern P in a given string S.
#include <iostream>
#include <string>
using namespace std;

void search(string pat, string txt)
{
    int M = pat.length();
    int N = txt.length();

    /* A loop to slide pat[] one by one */
    for (int i = 0; i <= N - M; i++)
    {
        int j;

        /* For current index i, check for pattern match */
        for (j = 0; j < M; j++)
            if (txt[i + j] != pat[j])
                break;

        if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            cout << "Pattern found at index "
                 << i << endl;
    }
}

int main()
{
    string txt = "AABAACAADAABAAABAA";
    string pat = "AABA";
    search(pat, txt);
    return 0;
}