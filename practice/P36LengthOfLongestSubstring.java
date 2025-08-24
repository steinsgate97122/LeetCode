package practice;

import java.util.HashSet;
import java.util.Set;

public class P36LengthOfLongestSubstring {
    /*
    No.3 longest-substring-without-repeating-characters
    求无重复最长字串的长度，例如pwwkew的最长无重复字串是wke，字串是需要连续的
    也是滑动窗口的经典题目，滑动时保证窗口内的元素都不重复，窗口内元素用一个HashSet维护即可
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, length = 0;
        Set<Character> window = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            Character rightCharacter = s.charAt(right);
            while (window.contains(rightCharacter)) {
                Character leftCharacter = s.charAt(left);
                window.remove(leftCharacter);
                left++;
            }
            window.add(rightCharacter);
            length = Math.max(right - left + 1, length);
        }
        return length;
    }

    public static void main(String[] args) {
        int r = new P36LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew");
        System.out.println(r);
    }
}
