package round2;

public class Problem3 {
    public static void main(String[] args) {
        int[][] matrix = {{9,8,7,6,5}, {9,9,8,7,6}, {9,9,9,8,7}, {9,9,9,8,8}};
        System.out.println(isToeplitz(matrix));
    }

    static boolean isToeplitz(int[][] matrix) {
        int candidate = matrix[0][0];
        int row = 0, col = 0;
        while (row < matrix.length) {
            if (matrix[row][col] != candidate) return false;
            row++; col++;
        }
        return true;
    }
}
