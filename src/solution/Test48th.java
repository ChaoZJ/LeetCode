package solution;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * @author ZhangChao
 * @since 2020/7/7
 */
public class Test48th {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int width = matrix[0].length;
        int height = matrix.length;
        if (width != height){
            return;
        }
        exchange(matrix, 0, 0, width);
    }
    private void exchange(int[][] matrix, int top, int left, int len){
        if (len > 1) {
            int mid = len / 2;
            if (len % 2 == 0) {
                exchange(matrix, top, left, mid);
                exchange(matrix, top, left + mid, mid);
                exchange(matrix, top + mid, left, mid);
                exchange(matrix, top + mid, left + mid, mid);
                for (int i = top; i < top + mid; i++) {
                    for (int j = left; j < left + mid; j++) {
                        int temp = matrix[i][j + mid];
                        matrix[i][j + mid] = matrix[i][j];
                        int temp2 = matrix[i + mid][j + mid];
                        matrix[i + mid][j + mid] = temp;
                        temp = temp2;
                        temp2 = matrix[i + mid][j];
                        matrix[i + mid][j] = temp;
                        matrix[i][j] = temp2;
                    }
                }
            } else {
                exchange(matrix, top, left, mid);
                exchange(matrix, top, left + mid + 1, mid);
                exchange(matrix, top + mid + 1, left, mid);
                exchange(matrix, top + mid + 1, left + mid + 1, mid );
                for (int i = top; i < top + mid; i++) {
                    for (int j = left; j < left + mid; j++) {
                        int temp = matrix[i][j + mid + 1];
                        matrix[i][j + mid + 1] = matrix[i][j];
                        int temp2 = matrix[i + mid + 1][j + mid + 1];
                        matrix[i + mid + 1][j + mid + 1] = temp;
                        temp = temp2;
                        temp2 = matrix[i + mid + 1][j];
                        matrix[i + mid + 1][j] = temp;
                        matrix[i][j] = temp2;
                    }
                }
                //旋转中轴
                for (int i = 0; i < mid; i++) {
                    int temp = matrix[top + mid][left + len - 1 - i];
                    matrix[top + mid][left + len - 1 - i] = matrix[top + i][left + mid];
                    int temp2 = matrix[top + len - 1 - i][left + mid];
                    matrix[top + len - 1 - i][left + mid] = temp;
                    temp = temp2;
                    temp2 = matrix[top + mid][left + i];
                    matrix[top + mid][left + i] = temp;
                    matrix[top + i][left + mid] = temp2;
                }
            }
        }
    }

    public static void main(String[] args) {
        Test48th test48th = new Test48th();
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        test48th.rotate(m);
        ArrUtil.print2Array(m);
    }
}
