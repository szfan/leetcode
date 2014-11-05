/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package linearTabel.arrays;

/**
 * 类ValidSudoku.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月5日 上午9:40:24
 */
public class ValidSudoku {
    
    public boolean check(char[] num) {
        boolean[] isVisitid = new boolean[num.length];
        for(int i = 0; i < num.length; ++i) {
            if(num[i] != '.' && isVisitid[num[i]-'1'] == true) {
                return false;
            }else if(num[i] != '.'){
                isVisitid[num[i]-'1'] = true;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        char[] used = new char[9];
        
        // check rows 
        for(int i = 0; i < 9; ++i) {
             for(int j = 0; j < 9; ++j) {
                 used[j] = board[i][j];
             }
             if(check(used) == false) {
                 return false;
             }
        }
        
        //check cloumns
        for(int j = 0; j < 9; ++j) {
            for(int i = 0; i < 9; ++i) {
                used[i] = board[i][j];
            }
            if(check(used) == false) {
                return false;
            }
        }
        
        // check others
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j){
                int index = 0;
                for(int k = 0; k < 3; ++k) {
                    for(int l = 0; l < 3; ++l) {
                        used[index++] = board[3*i+k][3*j+l]; 
                    }
                }
                if(check(used) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String... args) {
        char[][] board = { {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                           {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                           {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                           {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                           {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                           {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                           {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                           {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                           {'9', '.', '.', '.', '.', '.', '.', '.', '.'} };
        ValidSudoku vs = new ValidSudoku();
        System.out.println(vs.isValidSudoku(board));
    }
}
