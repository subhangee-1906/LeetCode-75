class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        int left = 0;
        int right = costs.length - 1;
        long totalCost = 0;
        
        while (k > 0) {
            
            while (leftHeap.size() < candidates && left <= right) {
                leftHeap.offer(costs[left++]);
            }

            while (rightHeap.size() < candidates && right >= left) {
                rightHeap.offer(costs[right--]);
            }
            
            int leftMin = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();
            int rightMin = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();
            
            if (leftMin <= rightMin) {
                totalCost += leftMin;
                leftHeap.poll();
            } else {
                totalCost += rightMin;
                rightHeap.poll();
            }
            k--;
        }
        
        return totalCost;
    }
}