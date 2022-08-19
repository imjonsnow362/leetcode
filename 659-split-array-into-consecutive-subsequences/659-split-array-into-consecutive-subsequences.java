class Solution {
    public boolean isPossible(int[] nums) {
  // Build map <num, minPQ of length>
  Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
  
  for (int val : nums) {
    if (map.containsKey(val - 1) && map.get(val - 1).size() > 0) { // minPQ size > 0
      // (num - 1) sequence exists
      PriorityQueue<Integer> pq = map.get(val - 1);
      int len = pq.poll();
      if (map.get(val) == null) {
        map.put(val, new PriorityQueue<>());
      }
      map.get(val).add(len + 1);
    } else {
      // (num - 1) sequence does not exist
      if (map.get(val) == null) {
        map.put(val, new PriorityQueue<>());
      }
      map.get(val).add(1);
    }
  }
  
  // Check each non-empty priority queue
  for (PriorityQueue<Integer> pq : map.values()) {
    while (pq.size() > 0) {
      if (pq.poll() < 3) {
        return false;
      }
    }
  }
  
  return true;
}
}