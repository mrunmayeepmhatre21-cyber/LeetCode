class Solution {
    public int[] searchRange(int[] nums, int target) {
        int First = firstbound(nums,target,true);
        int Last = firstbound(nums,target,false);
        return new int[] {First,Last};
    }
    private int firstbound (int[]nums,int target, boolean isFirst){
        int n= nums.length;
        int low =0;
        int high = n-1;
        int bound = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                bound = mid;

                if(isFirst){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return bound;
    }
}