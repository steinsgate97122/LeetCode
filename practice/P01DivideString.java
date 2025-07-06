package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01DivideString {
    /*
    No.2318 divide-a-string-into-groups-of-size-k
    k个一组拆分s，不足的部分用fill字符来补齐
    abcdefg 拆成 abc def gxx, k为3时, 索引为2 5 8时进行切分
    什么情况下需要补齐？ 出循环时索引i为k的整数倍，那么就不需要补齐，否则补上相应缺失的字符
     */
    public static String[] divideString(String s, int k, char fill) {
        List<String> tmpResult = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < s.length(); i++) {
            if ((i + 1) % k == 0) {
                sb.append(s.charAt(i));
                tmpResult.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (i % k != 0) {
            int count = k - (i % k);
            for (int j = 0; j < count; j++) {
                sb.append(fill);
            }
            tmpResult.add(sb.toString());
        }
        String[] res = new String[tmpResult.size()];
        tmpResult.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        String[] res = divideString("abcdefg", 3, 'x');
        System.out.println(Arrays.toString(res));
    }
}
