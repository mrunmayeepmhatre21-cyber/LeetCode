class Solution {
    public int splitArray(int[] nums, int k) {
        int low =start(nums);
        int high =end(nums);

        while(low<high){
            int mid = low+(high-low)/2;
            if(canSplit(nums,k,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private int start(int[]nums){
        int start1 = 0;
        for(int num: nums){
            start1 = Math.max(num, start1);
        }
        return start1;
    }
    private int end(int[]nums){
        int end1 =0;
        for(int num:nums){
            end1 += num;
        }
        return end1;
    }
    private boolean canSplit(int[]nums,int k,int limit){
        int sum =0;
        int part=1;
        for(int num:nums){
            if(sum + num > limit){
                part++;
                sum = num;
            }else{
                sum += num;
            }
        }
        return part<=k;
    }
}