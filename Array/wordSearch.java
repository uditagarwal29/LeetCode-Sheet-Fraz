package Matrix;
// java wordSearch.java
//SIMILAR TO RAT IN A MAZE

public class wordSearch {

    public static boolean wordSearch(char[][] board, int[][] visited, String s, int s_ptr, int m, int n, int x, int y) {
        // base case
        if (s_ptr == s.length()) {
            return true;
        }
        // Boundary checks, already visited checks, not = char in word check
        if ((x < 0 || x >= m) || (y < 0 || y >= n) || visited[x][y] == 1 || board[x][y] != s.charAt(s_ptr)) {
            return false;
        }

        visited[x][y] = 1;

        // Going Down
        // X = x + 1;
        // Y = y;
        // // Going Left
        // X = x;
        // Y = y - 1;
        // // Going Right
        // X = x;
        // Y = y + 1;
        // // Going Up
        // X = x - 1;
        // Y = y;
        
        boolean downSuccess = wordSearch(board, visited, s, s_ptr + 1, m, n, x + 1, y); /// going down
        boolean leftSuccess = wordSearch(board, visited, s, s_ptr + 1, m, n, x, y - 1); // going left
        boolean rightSucess = wordSearch(board, visited, s, s_ptr + 1, m, n, x, y + 1); // going right
        boolean upSuccess = wordSearch(board, visited, s, s_ptr + 1, m, n, x - 1, y); // going up

        if (downSuccess || leftSuccess || rightSucess || upSuccess){
            return true;
        }

        visited[x][y] = 0; // Backtrack

        return false;
    }

    public static void main(String[] args) {
        char board[][] = { { 'X', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        int m = board.length;
        int n = board[0].length;
        int visited[][] = new int[m][n];
        String s = "BC";
        boolean ans = false;
        int s_ptr = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == s.charAt(0)) {
                    if (wordSearch(board, visited, s, 0, m, n, i, j)) { // since we have to find word in sequence, we
                                                                        // first find the first char of word
                        ans = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
