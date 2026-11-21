class Solution {
    public int tribonacci(int n) {
        if(n==0)
        {
            return 0;
        }
        else if(n==1 || n==2)
        {
            return 1;
        }
        else
        {
            int ft=0,st=1,tt=1;
            for(int i=1;i<=n;i++)
            {
                int ftt=ft+st+tt;
                ft=st;
                st=tt;
                tt=ftt;
            }
            return ft;
        }
    }
}