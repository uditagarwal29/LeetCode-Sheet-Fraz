package Matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 2, 5, 8 }, { 4, 0, -1 } };
        // We take 4 pointers
        int sr = 0; // --> topmost row
        int ec = matrix[0].length - 1;// --> leftmost column
        int er = matrix.length - 1;// --> bottom row
        int sc = 0;// --> first column
        List<Integer> ans = new ArrayList<Integer>();

        while (sr <= er && sc <= ec) {

            // topmost row
            for (int i = sc; i <= ec; i++) {
                System.out.print(matrix[sr][i] + " ");
                ans.add(matrix[sr][i]);
            }
            sr++;
            System.out.println();

            // rightmost column
            for (int i = sr; i <= er; i++) {
                System.out.print(matrix[i][ec] + " ");
                ans.add(matrix[i][ec]);
            }
            ec--;
            System.out.println();

            if (er > sr) { // this condition is to dont the last row again(reversed) in case of even
                           // columns
                // bottom row
                for (int i = ec; i >= sc; i--) {
                    System.out.print(matrix[er][i] + " ");
                    ans.add(matrix[er][i]);
                }
                er--;
                System.out.println();

            }

            if (ec > sc) {// this condition is to dont the last column again(reversed) in case of even
                          // rows
                // leftmost column
                for (int i = er; i >= sr; i--) {
                    System.err.print(matrix[i][sc] + " ");
                    ans.add(matrix[i][sc]);
                }
                sc++;
                System.out.println();
            }
            System.out.println("=--------------");
        }
        System.out.println(ans);

    }
}
