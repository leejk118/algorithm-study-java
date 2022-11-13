package main.day1114;

import java.util.Stack;

class Coord {
    int r, c;

    public Coord(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class leetcode_200_jklee {
    private int r, c;
    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        boolean[][] isVisited = new boolean[r][c];
        int isLandCount = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (isVisited[i][j] || grid[i][j] == '0') continue;
                bfs(new Coord(i, j), grid, isVisited);
                isLandCount++;
            }
        }
        return isLandCount;
    }
    private void bfs(Coord start, char[][] grid, boolean[][] isVisited) {
        Stack<Coord> st = new Stack<>();
        st.add(start);

        while (!st.empty()) {
            Coord coord = st.pop();
            isVisited[coord.r][coord.c] = true;

            for (int i = 0; i < 4; ++i) {
                int nr = coord.r + dir[i][0];
                int nc = coord.c + dir[i][1];
                if (0 <= nr && nr < r && 0 <= nc && nc < c) {
                    if (isVisited[nr][nc] || grid[nr][nc] == '0') continue;
                    st.push(new Coord(nr, nc));
                }
            }
        }
    }


    public static void main(String[] args) {
        char[][][] grids = {
                {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}},
                {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}
        };
        for (char[][] grid : grids) {
            System.out.println(new leetcode_200_jklee().numIslands(grid));
        }
    }
}
