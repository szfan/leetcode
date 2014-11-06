/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package linearTabel.arrays;

/**
 * 类Candy.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月6日 下午4:54:38
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings.length <= 0) {
            return 0;
        }
        
        int[] candyes = new int[ratings.length];
        for(int i = 0; i < candyes.length; ++i) {
            candyes[i] = 1;
        }
        
        for(int i = 1, inc = 1; i < ratings.length; ++i) {
            if(ratings[i] > ratings[i-1]) {
                candyes[i] = ++inc > candyes[i] ? inc : candyes[i];
            }else {
                inc = 1;
            }
        }
        
        for(int i = ratings.length-2, inc = 1; i >= 0; --i) {
            if(ratings[i] > ratings[i+1]) {
                candyes[i] = ++inc > candyes[i] ? inc : candyes[i];
            }else {
                inc = 1;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < candyes.length; ++i) {
            sum += candyes[i];
        }
        return sum;
    }
    public static void main(String... args) {
        int[] ratings = {1, 2, 2};
        Candy candy = new Candy();
        System.out.println(candy.candy(ratings));
    }
}
