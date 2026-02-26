class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || t.length() == 0) return "";
        
        int[] count = new int[128];
        
        // store frequency of t
        for(char c : t.toCharArray()) {
            count[c]++;
        }
        
        int left = 0;
        int right = 0;
        int required = t.length();
        
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        
        while(right < s.length()) {
            
            char r = s.charAt(right);
            
            if(count[r] > 0) {
                required--;
            }
            
            count[r]--;
            right++;
            
            while(required == 0) {
                
                if(right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }
                
                char l = s.charAt(left);
                
                count[l]++;
                
                if(count[l] > 0) {
                    required++;
                }
                
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE 
            ? "" 
            : s.substring(start, start + minLength);
    }
}