package arc;

public class Q498 {
    public static int[] findDiagonalOrder(int[][] matrix) {
        Boolean direct = true;
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int size = matrix.length * matrix[0].length;
        int[] result = new int[size];
        int x = 0, y = 0;
        for (int i = 0; i < size; i++) {
            result[i] = matrix[x][y];
            if (direct) {
                if (x - 1 >= 0 && y + 1 < matrix[0].length) {
                    x--;
                    y++;
                } else {
                    direct = !direct;
                    if (y + 1 >= matrix[0].length) {
                        x++;
                    } else {
                        y++;
                    }
                }
            } else {
                if (x + 1 < matrix.length && y - 1 >= 0) {
                    x++;
                    y--;
                } else {
                    direct = !direct;
                    if (x + 1 >= matrix.length) {
                        y++;
                    } else {
                        x++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result1 = findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {99,57,68}
        });

        System.out.println(result1);
    }
}
