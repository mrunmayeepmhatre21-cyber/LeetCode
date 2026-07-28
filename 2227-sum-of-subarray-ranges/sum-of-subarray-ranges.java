class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res=0;

        int[]leftMax = new int[n];
        int[]rightMax = new int[n];
        int[]leftMin = new int[n];
        int[]rightMin = new int[n];

        Stack<Integer>stack = new Stack<>();

        //Max
        //left
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            leftMax[i] = stack.isEmpty() ?i+1:i-stack.peek();
            stack.push(i);
        }
        stack.clear();

        //right
        for(int i=n-1;i>=0;i--){
             while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            rightMax[i] = stack.isEmpty() ?n-i:stack.peek()-i;
            stack.push(i);
        }
        stack.clear();

        //Min
        //left
        for(int i=0;i<n;i++){
             while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            leftMin[i] = stack.isEmpty() ?i+1:i-stack.peek();
            stack.push(i);
        }
        stack.clear();

        //right
        for(int i=n-1;i>=0;i--){
         while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            rightMin[i] = stack.isEmpty() ?n-i:stack.peek()-i;
            stack.push(i);
        }
        //final 
        for(int i=0;i<n;i++){
            long maxcontri = (long) nums[i]*leftMax[i]*rightMax[i];
            long mincontri = (long) nums[i]*leftMin[i]*rightMin[i];
            res += maxcontri - mincontri;
        }
        return res;
    }
}