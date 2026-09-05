class Solution {
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.offer(1L);
        set.add(1L);

        long ugly = 1;

        for (int i = 0; i < n; i++) {

            ugly = pq.poll();

            if (set.add(ugly * 2)) {
                pq.offer(ugly * 2);
            }

            if (set.add(ugly * 3)) {
                pq.offer(ugly * 3);
            }

            if (set.add(ugly * 5)) {
                pq.offer(ugly * 5);
            }
        }

        return (int) ugly;
    }
}