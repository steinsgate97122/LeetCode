package practice;

import java.util.ArrayList;
import java.util.List;

public class P10PartitionLabels {
    /*
    No.763 partition-labels
    ababcbacadefegdehijhklij，拆分成"ababcbaca"、"defegde"、"hijhklij"
    要求同一个字母只能在一个片段中出现，返回拆分后的长度[9, 7, 8]
    根据同一个字母只能在片段中出现一次的规则，如果在上面的示例字符串最后加上a，那么就只有1段
    所以如何判断一段在哪里结束？比如对字符a，最后出现的索引位置是8，看上去直接符合要求
    不过对字符d来说最后出现的索引不是切分点，切分点实际上是e
    即片段内出现的所有字母的最后出现点的最大值，就是切分点
     */
    public List<Integer> partitionLabels(String s) {
        int partition = -1, prevPartition = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int maxIndexOfC = findMaxIndex(s, c);
            partition = Math.max(partition, maxIndexOfC);
            if (i == partition) {
                result.add(partition + 1 - prevPartition);
                prevPartition = partition + 1;
            }
        }
        return result;
    }

    private int findMaxIndex(String s, char c) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "caedbdedda";
        List<Integer> res = new P10PartitionLabels().partitionLabels(s);
        System.out.println(res);
    }
}
