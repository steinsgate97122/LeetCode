package practice;

import java.util.*;

public class P18TopKFrequent {
    /*
    No.347 top-k-frequent-elements
    1,1,1,2,2,3 k=2  出现频率前k高的元素为2 保证答案唯一
    涉及到出现频率，那么所有元素的出现频率首先都要统计到一个map里面
    然后维护一个minHeap，用频率排序，heap内维护k个元素，多余的元素用min踢掉，留下的就是maxK
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numsFreq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsFreq.put(nums[i], numsFreq.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });
        for (Map.Entry<Integer, Integer> entry : numsFreq.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] res = new P18TopKFrequent().topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));
    }
}
