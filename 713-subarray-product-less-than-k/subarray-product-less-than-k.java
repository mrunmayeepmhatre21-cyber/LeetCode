class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count=0;
        int product=1;

        int i=0;
        int j=0;

        while(j<n){
             product *= nums[j];

            while(product>=k && i<=j){
                product /= nums[i];
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }
}