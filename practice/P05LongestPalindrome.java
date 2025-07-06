package practice;

public class P05LongestPalindrome {
    /*
    No.5 longest-palindromic-substring
    substring是要求连续的，所以cbbac的最长回文子串只能是bb，不能是cbbc，因为不连续
    最简单的思路是遍历每个字符，将遍历到的字符假定为回文子串的中心，之后向外拓展到不满足要求为止，例如cabad，以b为中心最长可以拓展到aba
    不过回文子串可以包含偶数个字符，这种情况下中心就不是字符，而是两个字符中间的空挡，例如aabb，所以还要遍历每个中间的空挡，下面的实现就是这个思路
    除了遍历中心之外，另一个常见的解法是用动态规划，注意到aba和cabac之间存在联系，如果aba是回文串，那么前后加上同一个字符后还是回文串
    所以dp[i][j]可以表示原字符串中索引i到j的子串是否为回文串，那么递推的时候dp[i][j]依赖dp[i+1][j-1]，即依赖当前元素的右上角元素，遍历时注意顺序
     */
    public String longestPalindrome(String s) {
        String longest = s.substring(0, 1);
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; ; j++) {
                if (i - j < 0 || i + j >= s.length()) {
                    break;
                }
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    int length = 2 * j + 1;
                    if (length > maxLength) {
                        maxLength = length;
                        longest = s.substring(i - j, i + j + 1);
                    }
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; ; j++) {
                if (i - j < 0 || i + j - 1 >= s.length()) {
                    break;
                }
                if (s.charAt(i - j) == s.charAt(i + j - 1)) {
                    int length = 2 * j;
                    if (length > maxLength) {
                        maxLength = length;
                        longest = s.substring(i - j, i + j);
                    }
                } else {
                    break;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String res = new P05LongestPalindrome().longestPalindrome("aacabdkacaa");
        System.out.println(res);
    }
}
