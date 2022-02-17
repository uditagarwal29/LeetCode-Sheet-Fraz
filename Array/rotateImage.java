package Matrix;

//clockwise rotates
public class rotateImage {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int sr = 0, er = matrix.length - 1;
        /*
         * clockwise rotate
         * first reverse up to down, then swap the symmetry
         * 1 2 3    7 8 9    7 4 1
         * 4 5 6 => 4 5 6 => 8 5 2
         * 7 8 9    1 2 3    9 6 3
         */
        for (int j = 0; j < matrix[0].length; j++) {
            while (sr <= er) {
                int temp = matrix[er][j];
                matrix[er][j] = matrix[sr][j];
                matrix[sr][j] = temp;
                sr++;
                er--;
            }
            sr = 0;
            er = matrix.length - 1;
        }

        // swap elements symmetrically, i. [0,1] ->[1,0], [1,2]->[2,1]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }

        // ANTICLOCKWISE
                /*
        * anticlockwise rotate
        * first reverse left to right, then swap the symmetry
        * 1 2 3     3 2 1     3 6 9
        * 4 5 6  => 6 5 4  => 2 5 8
        * 7 8 9     9 8 7     1 4 7
        */
    }

}
