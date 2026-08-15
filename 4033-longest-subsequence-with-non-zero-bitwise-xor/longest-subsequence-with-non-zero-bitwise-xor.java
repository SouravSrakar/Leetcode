class Solution {
    public int longestSubsequence(int[] nums) {
        int count=0;
        boolean hasNonzero=false;
        for(int num:nums)
        {
            count=count^num;
            if(num!=0)
            {
                hasNonzero=true;
            }
        }
        if(count!=0)
        {
            return nums.length;
        }
        if(hasNonzero)
        {
            return nums.length-1;
        }
        return 0;
    }
}