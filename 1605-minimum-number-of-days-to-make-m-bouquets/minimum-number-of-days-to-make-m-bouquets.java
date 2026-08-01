class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         if((long)m*k > bloomDay.length)return -1;
        int low=min(bloomDay);
        int high=max(bloomDay);

        while(low<high){
            int mid = low+(high-low)/2;
            if(canMake(bloomDay,m,k,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private int min(int[]bloomDay){
        int min=0;
        for(int d : bloomDay){
            min = Math.min(d,min);
        }
        return min;
    }
     private int max(int[]bloomDay){
        int max=0;
        for(int d : bloomDay){
            max = Math.max(d,max);
        }
        return max;
    }
    private boolean canMake(int[]bloomDay,int m, int k, int day){
        int bouquets=0;
        int flowers=0;

        for(int bloom :bloomDay){
            if(bloom <= day){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;
                }
            }else{
                flowers=0;
            }
        }
       return bouquets>=m;
    }
}