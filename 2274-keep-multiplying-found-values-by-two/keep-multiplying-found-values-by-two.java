class Solution {
    public int findFinalValue(int[] nums, int original) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums)
        {
            pq.offer(num);
        }
        while(!pq.isEmpty())
        {
            int x=pq.poll();
            if(x==original)
            {
                original*=2;
            }
        }
        return original;
    }
}