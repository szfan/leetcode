package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LongestConsecutiveSequence.java:
 *
 * @author zefan.szf on 2016-07-10 15:28
 */
public class LongestConsecutiveSequence {

    public static void main(String... args) {
        LongestConsecutiveSequence lo = new LongestConsecutiveSequence();
        int[] nums = {200, 4, 400, 1, 3, 2};
        System.out.println(lo.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = 0;

        Map<Integer, Boolean> numberMap = new HashMap<>();
        for(int num : nums) {
            numberMap.put(num, false);
        }

        Set<Integer> visitedNumber = new HashSet<>();

        for(Map.Entry<Integer, Boolean> entry : numberMap.entrySet()) {
            int cnt = 1;
            int value = entry.getKey();
            if (visitedNumber.contains(value)) {
                continue;
            }

            int tmp = value;
            while (true) {
                if (numberMap.containsKey(--tmp)) {
                    visitedNumber.add(tmp);
                    cnt++;
                } else {
                    break;
                }
            }
            tmp = value;
            while (true) {
                if (numberMap.containsKey(++tmp)) {
                    visitedNumber.add(tmp);
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt > length) {
                length = cnt;
            }
        }
        return length;
    }
}
