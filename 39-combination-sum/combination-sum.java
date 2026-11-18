class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(0,target,candidates,new ArrayList<>(),result);

        return result;
    }
    private void backtrack(int start,int target,int[]candidates,List<Integer>current,List<List<Integer>>result){

        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target){
                break;
            }
            //choose
            current.add(candidates[i]);
            
            backtrack(i,target-candidates[i],candidates,current,result);

            current.remove(current.size()-1);
        }
    }
}