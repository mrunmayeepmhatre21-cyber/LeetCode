class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack = new Stack<>();

        for(int num:asteroids){
            boolean alive=true;

            while(alive && !stack.isEmpty() && stack.peek()>0 && num<0){
                if(stack.peek()<-num){
                    stack.pop();
                }else if(stack.peek()==-num){
                    stack.pop();
                    alive=false;
                }else{
                    alive=false;
                }
            }
            if(alive) stack.push(num);
        }
        int[]res = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
    }
}