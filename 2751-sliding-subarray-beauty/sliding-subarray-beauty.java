class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        int[] freq = new int[101];
        
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            
            freq[nums[right] + 50]++;
            
            if (right - left + 1 == k) {
                
                int count = 0;
                int beauty = 0;

                for (int i = 0; i < 50; i++) {
                    count += freq[i];
                    
                    if (count >= x) {
                        beauty = i - 50;
                        break;
                    }
                }
                
                result[left] = beauty;
                
                freq[nums[left] + 50]--;
                
                left++;
            }
        }
        
        return result;
    }
}