class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1,temp=0;
        int num=n;
        while(n>0)
        {
            temp=n%10;
            sum+=temp;
            prod=prod*temp;
            n=n/10;
        }
        sum=sum+prod;
        if(num%sum==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}