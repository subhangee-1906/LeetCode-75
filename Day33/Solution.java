class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, int current, boolean[] visited) {
        visited[current] = true;
        for (int key : rooms.get(current)) {
            if (!visited[key]) {
                dfs(rooms, key, visited);
            }
        }
    }
}