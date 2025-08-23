package practice;

public class P30LongestCommonPrefix {
    /*
    No.14 longest-common-prefix
    input:  ["flower","flow","flight"]
    output: "fl"
    贪心，如果只有1个单词那么本身就是最长公共前缀，第2个单词加入后变成这两个单词的最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = longestCommonPrefix(result, strs[i]);
            if (result.isEmpty()) {
                return result;
            }
        }
        return result;
    }

    private String longestCommonPrefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length()) - 1;
        int longest = 0;
        for (; longest <= length; longest++) {
            if (s1.charAt(longest) != s2.charAt(longest)) {
                return s1.substring(0, longest);
            }
        }
        return s1.substring(0, longest);
    }

    public static void main(String[] args) {
        String[] strs = {"ab","a"};
        String res = new P30LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(res);
    }
}
