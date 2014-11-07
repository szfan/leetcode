package linearTable.arrays;

/**
 * 类RotateImage.java的实现描述：TODO 类实现描述 
 * @author zefan.szf 2014年11月5日 下午3:23:25
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        // horizontal rotate
        int rowStart = 0, rowEnd = rowLen-1;
        while(rowStart < rowEnd) {
            int tmp = 0;
            for(int j = 0; j < colLen; ++j) {
                tmp                 = matrix[rowStart][j];
                matrix[rowStart][j] = matrix[rowEnd][j];
                matrix[rowEnd][j]   = tmp;
            }
            rowStart++;
            rowEnd--;
        }
        
        // opposite angle rotate
        for(int i = 1; i < rowLen; ++i) {
            for(int j = 0; j < i; ++j) {
                int tmp      = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i = 0; i < rowLen; ++i) {
            for(int j = 0; j < colLen; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String... args) {
        int[][] matrix = { {1, 2, 3},
                           {4, 5, 6},
                           {7, 8, 9}};
        RotateImage ri = new RotateImage();
        ri.rotate(matrix);
    }
}
