class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int ast: asteroids)
        {
            while(!st.isEmpty() && st.peek()>0 && ast<0)
            {
                if(Math.abs(ast)>st.peek())
                {
                    st.pop();
                }
                else if(Math.abs(ast)==st.peek())
                {
                    st.pop();
                    ast=0;
                    break;
                }
                else
                {
                    ast=0;
                    break;
                }
            }
            if(ast!=0)
            {
                st.push(ast);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--)
        {
            ans[i]=st.pop();
        }
        return ans;
    }
}