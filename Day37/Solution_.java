package Day37;

import java.util.PriorityQueue;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private int current;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        current = 1; 
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            return minHeap.poll();
        }
        return current++; 
    }

    public void addBack(int num) {
        if (num < current && !minHeap.contains(num)) {
            minHeap.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
