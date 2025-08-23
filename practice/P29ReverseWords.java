package practice;

public class P29ReverseWords {
    /*
    No.151 reverse-words-in-a-string
    input:  "the  sky is blue "
    output: "blue is sky the"
    要求输出的字符串前后不能有空格，并且单词中间的空格仅保留1个
    比较明显的思路就是分别记录每个单词的首尾索引，从后向前遍历，然后构建新字符串
     */
    public String reverseWords(String s) {
        int start = s.length(), end = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char currChar = s.charAt(i);
            if (currChar != ' ' && end == s.length()) {
                end = i;
                start = i;
            } else if (currChar != ' ' && end != s.length()) {
                start = i;
            } else if (currChar == ' ' && end != s.length()) {
                sb.append(s, start, end + 1);
                sb.append(' ');
                start = s.length();
                end = s.length();
            }
        }
        if (end != s.length()) {
            sb.append(s, start, end + 1);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String res = new P29ReverseWords().reverseWords(s);
        System.out.println(res);
    }
}
