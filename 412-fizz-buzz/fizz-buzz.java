class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            boolean div3=(i%3==0);
            boolean div5=(i%5==0);
            if(div3 && div5)
            {
                ans.add("FizzBuzz");
            }
            else if(div3)
            {
                ans.add("Fizz");
            }
            else if(div5)
            {
                ans.add("Buzz");
            }
            else
            {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}