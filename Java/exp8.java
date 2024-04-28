import java.util.Scanner;

public class exp8 {

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // Create a boolean table to store results of subproblems

        String res = "";
        for (int len = 1; len <= n; len++) {
            // for substrings of length len
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;

                // if length is 1 or chars at start and end are same and dp[i + 1][j - 1] is true
                if (len == 1 || s.charAt(i) == s.charAt(j) && (len == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    if (len > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str;

        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter a string: ");
        str = scanner.nextLine();
        scanner.close();
        System.out.println("Longest palindrome is: " + longestPalindrome(str));
    }
}
