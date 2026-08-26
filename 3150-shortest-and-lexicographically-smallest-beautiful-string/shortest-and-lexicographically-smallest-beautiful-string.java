class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String ans = "";
        int left = 0, ones = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') ones++;

            
            while (ones > k) {
                if (s.charAt(left) == '1') ones--;
                left++;
            }

            
            if (ones == k) {
                int l = left;
                while (s.charAt(l) == '0') l++;
                String candidate = s.substring(l, right + 1);

                if (ans.isEmpty() 
                    || candidate.length() < ans.length() 
                    || (candidate.length() == ans.length() && candidate.compareTo(ans) < 0)) {
                    ans = candidate;
                }
            }
        }

        return ans;
    }
}