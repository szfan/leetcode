/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package linearTable.arrays;

/**
 * 类SingleNumber.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月6日 下午5:10:56
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = 0;
        for(int i = 0; i < A.length; ++i) {
            result = result ^ A[i];
        }
        return result;
    }
    public static void main(String... args) {
        int[] A = {1, 2, 2, 3, 4, 3, 1};
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(A));
    }
}
