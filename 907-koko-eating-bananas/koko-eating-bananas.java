class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int end =maxrange(piles);

        while(low<end){
            int mid = low+(end-low)/2;
            if(caneat(piles,h,mid)){
                end = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private int maxrange(int[]piles){
        int max =0;
        for(int pile : piles){
            max = Math.max(max,pile);
        }
        return max;
    }
    private boolean caneat (int[]piles,int h,int speed){
        int hour =0;
        for(int pile:piles){
            hour += (pile+speed-1)/speed;
        }
        return hour<=h;
    }
}