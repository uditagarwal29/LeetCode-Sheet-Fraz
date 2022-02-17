class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
    int n = board[0].size();

    vector<vector<int>> nbrs(m, vector<int>(n));
      
     //pre calculating the neighbours of each cell
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            int nc = j + 1;
            int pc = j - 1;
            int nr = i + 1;
            int pr = i - 1;
            // top-left
            if (pc >= 0 && pr >= 0 && board[pr][pc] == 1)
            {
                nbrs[i][j] += 1;
            }
            // top
            if (pr >= 0 && board[pr][j] == 1)
            {
                nbrs[i][j] += 1;
            }
            // top-right
            if (pr >= 0 && nc < n && board[pr][nc] == 1)
            {
                nbrs[i][j] += 1;
            }

            // left
            if (pc >= 0 && board[i][pc] == 1)
            {
                nbrs[i][j] += 1;
            }
            // right
            if (nc < n && board[i][nc] == 1)
            {
                nbrs[i][j] += 1;
            }

            // bottom-left
            if (nr < m && pc >= 0 && board[nr][pc] == 1)
            {
                nbrs[i][j] += 1;
            }
            // bottom
            if (nr < m && board[nr][j] == 1)
            {
                nbrs[i][j] += 1;
            }
            // bottom-right
            if (nr < m && nc < n && board[nr][nc] == 1)
            {
                nbrs[i][j] += 1;
            }
        }
    }

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        { 
            if (board[i][j] == 0)
            {
                //DEAD CELL CONDITION
                if (nbrs[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
            else
            {
                //LIVE CELL CONDITION
                if (nbrs[i][j] < 2 or nbrs[i][j] > 3)
                {
                    board[i][j] = 0;
                }
            }
        }
    }
        
    }
};
