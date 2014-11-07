/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package linearTable.arrays;

/**
 * 类SingleNumberOOII.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月6日 下午5:43:24
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for(int i = 0; i < A.length; ++i) {
            two |= one & A[i];
            one ^= A[i];
            three = ~(one & two);
            one &= three;
            two &= three;
        }
        return one;
    }
    public static void main(String... args) {
        
    }
}
