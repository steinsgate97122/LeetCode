package practice;

public class P06LongestCommonSubsequence {
    /*
    No.1143 longest-common-subsequence
    abcde和ace的最长公共字串为ace，顺序敏感
    dp[i][j]表示text1[0..i]与text2[0..j]的最长公共字串长度
    dp[i][j]与dp[i-1][j-1]存在联系，text1.charAt(i)与text2.charAt(j)相等时，长度就能+1
    不相等时，可以取dp[i-1][j]与dp[i][j-1]的较大值，dp[0][0]先填入，从小到大递推即可
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i - 1 < 0 || j - 1 < 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    if (i - 1 < 0 && j - 1 < 0) {
                        dp[i][j] = 0;
                    } else if (i - 1 < 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j - 1 < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }

    public static void main(String[] args) {
        int res = new P06LongestCommonSubsequence().longestCommonSubsequence("abcde", "edcba");
        System.out.println(res);
    }
}
