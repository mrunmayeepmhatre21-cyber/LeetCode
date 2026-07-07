class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left=0;
        int maxlen=0;
        int count=0;

        for(int right=0;right<n;right++){
            if(nums[right]==0){
                count++;
                while(count>k){
                 if(nums[left]==0){
                   count--;
                 }
                 left++;
                }
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}