import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int time = 0;
       
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
 
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
   
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    
                    if (r >= 0 && r < rows && c >=0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        freshOranges--;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            time++;
        }
        
        return freshOranges == 0 ? time : -1;
    }
}
