class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        int s1=0;
        int s2=0;
        arr1[s1++]=nums[0];
        arr2[s2++]=nums[1];
        for(int i=2;i<n;i++)
        {
            if(arr1[s1-1]>arr2[s2-1])
            {
                arr1[s1++]=nums[i];
            }
            else
            {
                arr2[s2++]=nums[i];
            }
        }
        int[] ans=new int[n];
        int index=0;
        for(int i=0;i<s1;i++)
        {
            ans[index++]=arr1[i];
        }
        for(int i=0;i<s2;i++)
        {
            ans[index++]=arr2[i];
        }
        return ans;
    }
}