import java.util.PriorityQueue;

class Solution {

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) return 0; // Cannot trap water if dimensions are too small.

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Add boundary cells to the priority queue and mark them as visited.
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        // Directions for moving up, down, left, and right.
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int waterVolume = 0;

        // Process cells using BFS with a priority queue.
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currHeight = current[0];
            int row = current[1];
            int col = current[2];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries and if the cell is already visited.
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;

                    // Calculate trapped water and add the new cell to the priority queue.
                    waterVolume += Math.max(0, currHeight - heightMap[newRow][newCol]);
                    pq.offer(new int[]{Math.max(currHeight, heightMap[newRow][newCol]), newRow, newCol});
                }
            }
        }

        return waterVolume;
    }
}
