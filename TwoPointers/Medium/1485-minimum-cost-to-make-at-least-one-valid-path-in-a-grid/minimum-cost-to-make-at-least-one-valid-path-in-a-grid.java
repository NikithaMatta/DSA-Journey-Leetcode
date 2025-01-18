import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            int x = cell[0], y = cell[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];
                int cost = (grid[x][y] == i + 1) ? 0 : 1;

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && dist[x][y] + cost < dist[newX][newY]) {
                    dist[newX][newY] = dist[x][y] + cost;
                    if (cost == 0) {
                        deque.addFirst(new int[]{newX, newY});
                    } else {
                        deque.addLast(new int[]{newX, newY});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}