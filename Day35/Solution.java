import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];

        
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0}); 
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && !visited[newRow][newCol] && maze[newRow][newCol] == '.') {
                    
                    if ((newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1) 
                        && !(newRow == entrance[0] && newCol == entrance[1])) {
                        return dist + 1; 
                    }
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                }
            }
        }
        return -1; 
    }
}