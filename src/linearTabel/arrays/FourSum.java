package linearTabel.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类FourSum.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年10月27日 下午4:56:18
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Map<Integer, List<Map<Integer, Integer>>> sumMap = new HashMap<Integer, List<Map<Integer,Integer>>>();
        for(int i = 0; i < num.length-1; ++i) {
            if(i > 0 && num[i] == num[i-1]) {
                continue;
            }
            for(int j = i+1; j < num.length; ++j) {
//                if(num[j] == num[j-1]) {
//                    continue;
//                }
                int value = num[i] + num[j];
                Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
                tmp.put(i, j);
                List<Map<Integer, Integer>> tmpList;
                if(sumMap.containsKey(value)) {
                    tmpList = sumMap.get(value);
                    sumMap.remove(value);
                }else {
                    tmpList = new ArrayList<Map<Integer,Integer>>();
                }
                tmpList.add(tmp);
                sumMap.put(value, tmpList);
            }
        }
        
        Set<Integer> keyset = sumMap.keySet();
        int[] keysetArray = new int[keyset.size()];
        int index = 0;
        for(int key : keyset) {
            keysetArray[index++] = key;
        }
        Arrays.sort(keysetArray);
        for(int i = 0; i < keysetArray.length; ++i) {
            if(i > 0 && keysetArray[i] + keysetArray[i-1] > target) {
                break;
            }
            if(sumMap.containsKey(target-keysetArray[i])) {
                List<Map<Integer, Integer>> list1 = sumMap.get(keysetArray[i]);
                List<Map<Integer, Integer>> list2 = sumMap.get(target-keysetArray[i]);
                for(Map<Integer, Integer> it1 : list1) {
                    int index1_1 = 0, index1_2 = 0;
                    for(Map.Entry<Integer, Integer> entry : it1.entrySet()) {
                        index1_1 = entry.getKey();
                        index1_2 = entry.getValue();
                    }
                    for(Map<Integer, Integer> it2 : list2) {
                        int index2_1 = 0, index2_2 = 0;
                        for(Map.Entry<Integer, Integer> entry : it2.entrySet()) {
                            index2_1 = entry.getKey();
                            index2_2 = entry.getValue();
                        }
                        if(index1_1 == index2_1 || index1_1 == index2_2 || index1_2 == index2_1 || index1_2 == index2_2) {
                            continue;
                        }
                        List<Integer> tmplist = new ArrayList<Integer>();
                        int[] aa = {num[index1_1], num[index1_2], num[index2_1], num[index2_2]};
                        Arrays.sort(aa);
                        for(int a : aa) {
                            tmplist.add(a);
                        }
                        if(!results.contains(tmplist)) {
                            results.add(tmplist);
                        }
                    }
                }
            }
        }
        return results;
    } 
    public static void main(String... args) {
        int[] num = {0,0,0,0};
        int target = 0;
        FourSum fs = new FourSum();
        for(List<Integer> a : fs.fourSum(num, target)) {
            for(int aa : a) {
                System.out.print(aa + "\t");
            }
            System.out.println();
        }
    }
}
