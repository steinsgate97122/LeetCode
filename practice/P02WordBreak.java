package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P02WordBreak {
    /*
    No.139 word-break
    给定字符串s和字符串列表wordDict，判断是否可以使用wordDict组装出s
    例如 catsandog 和 ["cats", "dog", "sand", "and", "cat"], cats and og, cat sand og, 都不行所以false
    由于cat和cats都有可能在字典里面，所以不能直接贪心匹配，可以考虑用递归，假设有一个helper函数可以判断s是否满足要求
    那么只要从前往后能匹配上单词，那么只要剩余部分也返回true，就符合要求
    不过直接使用这个思路的效率较差，所以额外维护一个HashMap，如果一个字符串已经进行过判断就直接返回结果，提升效率
     */
    Map<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreakHelper(s, wordSet);
    }

    private boolean wordBreakHelper(String s, Set<String> wordSet) {
        if (s.isEmpty()) return true;
        if (memo.containsKey(s)) return memo.get(s);

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix) && wordBreakHelper(s.substring(i), wordSet)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        boolean res = new P02WordBreak().wordBreak("catsandog", wordDict);
        System.out.println(res);
    }
}
