/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package strings;

/**
 * 类AddBinary.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月25日 上午9:57:41
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int len = a.length() > b.length() ? a.length()+1 : b.length()+1;
        char[] result = new char[len];
        for(int i = 0; i < len; ++i) {
            result[i] = '0';
        }
        
        int ia = a.length()-1;
        int ib = b.length()-1;
        int ir = len-1;
        int carryBit = 0;
        while(ia >= 0 && ib >= 0) {
            int tmpBit = (a.charAt(ia)-'0') + (b.charAt(ib)-'0') + carryBit;
            carryBit = tmpBit > 1 ? 1 : 0;
            tmpBit = tmpBit % 2;
            result[ir] = (char) (tmpBit + '0');
            --ia; --ib; --ir;
        }
        
        String tmpStr = ia < 0 ? b : a;
        int it = ia < 0 ? ib : ia;
        for(; it >= 0; --it) {
            int tmpBit = (tmpStr.charAt(it)-'0') + carryBit;
            carryBit = tmpBit > 1 ? 1 : 0;
            tmpBit = tmpBit % 2;
            result[ir] = (char) (tmpBit + '0');
            --ir;
        }
        // note that first bit should be carryBit
        result[ir] = (char) (carryBit + '0');
        if(result[0] == '0') {
            return new String(result, 1, len-1);
        }else {
            return new String(result);
        }
    }
    
    public static void main(String... args) {
        AddBinary ab = new AddBinary();
        String s1 = "111";
        String s2 = "1";
        System.out.println(ab.addBinary(s1, s2));
    }
}
