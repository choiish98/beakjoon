public class MatrixTest {
    public static void main(String[] args) {
      // 행렬 x, y의 곱을 구하여 출력
      int[][] x = { { 1, 2, 3 }, 
                    { 4, 5, 6 }, 
                    { 7, 8, 9 } };
      int[][] y = { { 1, 4, 7 }, 
                    { 2, 5, 8 }, 
                    { 3, 6, 9 } };
      int[][] z = MyMatrix.multiply(x, y);
      MyMatrix.print(z);
      System.out.println();
      // 행렬 a, b의 곱을 구하여 출력
      int[][] a = { { 1, 1, 1 }, 
                    { 2, 2, 2 }, 
                    { 3, 3, 3 }, 
                    { 4, 4, 4 } };
      int[][] b = { { 1, 1 }, 
                    { 2, 2 }, 
                    { 3, 3 } };
      int[][] c = MyMatrix.multiply(a, b);
      MyMatrix.print(c);
    }
  }
  class MyMatrix {
    /* static 메소드 multiply를 작성하시오. */
    public static int[][] multiply(int[][] x, int[][] y) {
      int i = x.length; int j = y[0].length;
      int[][] mul = new int[i][j];

      for(int k = 0; k < i; k++){
        for(int l = 0; l < j; l++){
          mul[k][l] = x[k][0] * y[0][l] + x[k][1] * y[1][l] + x[k][2] * y[2][l];
        }
      }

      return mul;
    }
    public static void print(int[][] matrix) {
      int iMax = matrix.length;
      int jMax = matrix[0].length;
      for (int i = 0; i < iMax; i++) {
        for (int j = 0; j < jMax; j++) {
          System.out.printf("%3d ", matrix[i][j]);
        }
        System.out.println();
      }
    }
  }