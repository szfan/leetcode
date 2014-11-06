package linearTabel.arrays;

/**
 * 类SetMatrixZeros.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月6日 上午11:22:13
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        // check first row and first column
        for(int j = 0; j < colLen; ++j) {
            if(matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        for(int i = 0; i < rowLen; ++i) {
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        
        for(int i = 1; i < rowLen; ++i) {
            for(int j = 1; j < colLen; ++j) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < rowLen; ++i) {
            for(int j = 1; j < colLen; ++j) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow == true) {
            for(int j = 0; j < colLen; ++j) {
                matrix[0][j] = 0;
            }
        }
        if(firstCol == true) {
            for(int i = 0; i < rowLen; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String... args) {
        int[][] matrix = { {1,0,3} };
        SetMatrixZeros smz = new SetMatrixZeros();
        smz.setZeroes(matrix);
    }
}
